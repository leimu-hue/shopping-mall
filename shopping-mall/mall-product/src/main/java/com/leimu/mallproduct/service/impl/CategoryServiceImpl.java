package com.leimu.mallproduct.service.impl;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.constant.ConstantRedis;
import com.leimu.mallcommon.exception.ErrorCode;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallproduct.dao.CategoryDao;
import com.leimu.mallproduct.dto.CategoryDTO;
import com.leimu.mallproduct.dto.CategoryMergeParentDTO;
import com.leimu.mallproduct.entity.CategoryEntity;
import com.leimu.mallproduct.enums.CategoryShowStatusEnum;
import com.leimu.mallproduct.post.CategoryPost;
import com.leimu.mallproduct.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 商品三级分类
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Service
public class CategoryServiceImpl extends CrudServiceImpl<CategoryDao, CategoryEntity, CategoryDTO> implements CategoryService {

    private final RedissonClient redissonClient;

    public CategoryServiceImpl(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public List<CategoryDTO> getAllListByTree() {
        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.select("cat_id", "name", "parent_cid", "sort", "show_status");
        // 首先查出商品分类
        List<CategoryEntity> categoryEntities = baseDao.selectList(wrapper);
        categoryEntities.sort((one, two) -> {
            int first = one.getSort() == null ? Integer.MAX_VALUE : one.getSort();
            int second = two.getSort() == null ? Integer.MAX_VALUE : two.getSort();
            return Integer.compare(first, second);
        });
        // 开始组装父子结构
        Map<Long, CategoryDTO> catIdToValue = categoryEntities.stream().map(CategoryDTO::new)
                .filter(t -> Objects.equals(t.getShowStatus(), CategoryShowStatusEnum.SHOW.getValue()))
                .collect(Collectors.toMap(CategoryDTO::getCatId, t -> t));

        List<CategoryDTO> parentValue = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntities) {
            // 说明是一级菜单
            if (Objects.equals(categoryEntity.getParentCid(), 0L)) {
                if (catIdToValue.containsKey(categoryEntity.getCatId())) {
                    parentValue.add(catIdToValue.get(categoryEntity.getCatId()));
                }
                continue;
            }
            CategoryDTO categoryDTO = catIdToValue.get(categoryEntity.getParentCid());
            if (Objects.nonNull(categoryDTO) && catIdToValue.containsKey(categoryDTO.getCatId())) {
                categoryDTO.getChildren().add(catIdToValue.get(categoryEntity.getCatId()));
            }
        }
        CategoryDTO parent = new CategoryDTO().createDefault();
        parent.getChildren().add(parent);
        return Collections.singletonList(parent);
    }

    @Override
    public PageData<CategoryMergeParentDTO> getAllListByPage(Map<String, Object> params) {
        int page = Integer.parseInt(Optional.ofNullable((String) params.get(Constant.PAGE)).orElse("1"));
        int limit = Integer.parseInt(Optional.ofNullable((String) params.get(Constant.LIMIT)).orElse("10"));
        String categoryName = Optional.ofNullable((String) params.get("categoryName")).orElse("");
        int status = Integer.parseInt(Optional.ofNullable((String) params.get("status")).orElse("-1"));
        // 开始查询数据信息
        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(categoryName)) {
            wrapper.like("name", categoryName);
        }
        if (CategoryShowStatusEnum.SHOW.getValue() == status
                || CategoryShowStatusEnum.NO_SHOW.getValue() == status) {
            wrapper.eq("show_status", status);
        }
        IPage<CategoryEntity> pageData = new Page<>(page, limit);
        List<CategoryEntity> categoryEntities = baseDao.selectList(pageData, wrapper);
        // 获取id对应名称信息
        Map<Long, String> idToNameMap = queryCatIdToNameMap();
        List<CategoryMergeParentDTO> list = categoryEntities.stream().map(t -> {
            CategoryMergeParentDTO categoryMergeParentDTO = new CategoryMergeParentDTO();
            BeanUtils.copyProperties(t, categoryMergeParentDTO);
            categoryMergeParentDTO.setParentName(idToNameMap.getOrDefault(t.getParentCid(), StringUtils.EMPTY));
            return categoryMergeParentDTO;
        }).toList();
        return new PageData<>(pageData.getTotal(), page, limit, list);
    }

    @Override
    public Map<Long, String> queryCatIdToNameMap() {
        Map<Long, String> result = new HashMap<>();
        RMap<Long, String> map = redissonClient.getMap(ConstantRedis.PRODUCT_CATEGORY_ID_TO_NAME_MAP);
        map.readAllMapAsync().thenAcceptAsync(result::putAll);
        if (!result.isEmpty()) {
            return result;
        }
        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.select("cat_id", "name");
        // 首先查出商品分类
        List<CategoryEntity> categoryEntities = baseDao.selectList(wrapper);
        result = categoryEntities.stream().collect(Collectors.toMap(CategoryEntity::getCatId,
                CategoryEntity::getName));
        // 插入一个无效数据
        if (!result.containsKey(0L)) {
            result.put(0L, "顶级分类");
        }
        map.putAll(result);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        // 判断，如果父分类下存在子分类，就不允许删除
        // ...
        int result = baseDao.deleteByIds(ids);
        if (result > 0) {
            RMap<Long, String> map = redissonClient.getMap(ConstantRedis.PRODUCT_CATEGORY_ID_TO_NAME_MAP);
            map.fastRemove(ids.toArray(new Long[0]));
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<String> addCategory(CategoryPost categoryPost) {
        Map<Long, String> result = new HashMap<>();
        RMap<Long, String> map = redissonClient.getMap(ConstantRedis.PRODUCT_CATEGORY_ID_TO_NAME_MAP);
        map.readAllMapAsync().thenAcceptAsync(result::putAll);
        Set<String> names = new HashSet<>(result.values());
        if (names.contains(categoryPost.getName())) {
            return new Result<String>().error(ErrorCode.PARAMETER_ERROR, "重复名称");
        }
        if (!result.containsKey(categoryPost.getParentCid())) {
            return new Result<String>().error(ErrorCode.PARAMETER_ERROR, "无效父类信息");
        }
        CategoryEntity categoryEntity = new CategoryEntity(categoryPost);
        int insert = baseDao.insert(categoryEntity);
        if (insert > 0) {
            return new Result<String>().ok(null);
        } else {
            return new Result<String>().error("新增失败, 请稍后再试");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<String> updateCategory(CategoryPost categoryPost) {
        if (Objects.isNull(categoryPost.getCatId())) {
            return new Result<String>().error(ErrorCode.PARAMETER_ERROR, "无效信息");
        }
        Map<Long, String> result = new HashMap<>();
        RMap<Long, String> map = redissonClient.getMap(ConstantRedis.PRODUCT_CATEGORY_ID_TO_NAME_MAP);
        map.readAllMapAsync().thenAcceptAsync(result::putAll);
        Set<String> names = new HashSet<>(result.values());
        names.remove(result.get(categoryPost.getCatId()));
        if (names.contains(categoryPost.getName())) {
            return new Result<String>().error(ErrorCode.PARAMETER_ERROR, "重复名称");
        }
        if (!result.containsKey(categoryPost.getParentCid())) {
            return new Result<String>().error(ErrorCode.PARAMETER_ERROR, "无效父类信息");
        }
        CategoryEntity categoryEntity = new CategoryEntity(categoryPost);
        categoryEntity.setCatId(categoryPost.getCatId());
        int updateCount = baseDao.updateById(categoryEntity);
        if (updateCount > 0) {
            return new Result<String>().ok(null);
        } else {
            return new Result<String>().error("修改失败, 请稍后再试");
        }
    }

    @Override
    public QueryWrapper<CategoryEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");
        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        return wrapper;
    }

}