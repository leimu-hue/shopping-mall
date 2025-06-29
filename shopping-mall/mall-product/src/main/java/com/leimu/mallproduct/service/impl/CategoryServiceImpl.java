package com.leimu.mallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.constant.ConstantRedis;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallcommon.utils.RedisUtil;
import com.leimu.mallproduct.dao.CategoryDao;
import com.leimu.mallproduct.dto.CategoryDTO;
import com.leimu.mallproduct.dto.CategoryMergeParentDTO;
import com.leimu.mallproduct.entity.CategoryEntity;
import com.leimu.mallproduct.enums.CategoryShowStatusEnum;
import com.leimu.mallproduct.service.CategoryService;
import jodd.bean.BeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

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

    private final RedisUtil redisUtil;

    public CategoryServiceImpl(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
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
        // 开始查询数据信息
        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(categoryName)) {
            wrapper.like("name", categoryName);
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
        Map<Long, String> catIdToName = (Map<Long, String>) redisUtil.get(ConstantRedis.PRODUCT_CATEGORY_ID_TO_NAME_MAP);
        if (Objects.nonNull(catIdToName)) {
            return catIdToName;
        }

        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.select("cat_id", "name");
        // 首先查出商品分类
        List<CategoryEntity> categoryEntities = baseDao.selectList(wrapper);
        catIdToName = categoryEntities.stream().collect(Collectors.toMap(CategoryEntity::getCatId,
                CategoryEntity::getName));
        redisUtil.set(ConstantRedis.PRODUCT_CATEGORY_ID_TO_NAME_MAP, catIdToName);
        return catIdToName;
    }

    @Override
    public QueryWrapper<CategoryEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}