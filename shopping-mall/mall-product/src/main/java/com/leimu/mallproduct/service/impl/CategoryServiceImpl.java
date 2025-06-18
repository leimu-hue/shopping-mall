package com.leimu.mallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallproduct.dao.CategoryDao;
import com.leimu.mallproduct.dto.CategoryDTO;
import com.leimu.mallproduct.entity.CategoryEntity;
import com.leimu.mallproduct.enums.CategoryShowStatusEnum;
import com.leimu.mallproduct.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 商品三级分类
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Service
public class CategoryServiceImpl extends CrudServiceImpl<CategoryDao, CategoryEntity, CategoryDTO> implements CategoryService {

    @Override
    public List<CategoryDTO> getAllListByTree() {
        // 首先查出商品分类
        List<CategoryEntity> categoryEntities = baseDao.selectList(new QueryWrapper<>());
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
        return parentValue;
    }

    @Override
    public QueryWrapper<CategoryEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}