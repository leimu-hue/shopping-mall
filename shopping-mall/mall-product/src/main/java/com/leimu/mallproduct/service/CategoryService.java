package com.leimu.mallproduct.service;

import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.service.CrudService;
import com.leimu.mallproduct.dto.CategoryDTO;
import com.leimu.mallproduct.dto.CategoryMergeParentDTO;
import com.leimu.mallproduct.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
public interface CategoryService extends CrudService<CategoryEntity, CategoryDTO> {

    List<CategoryDTO> getAllListByTree();

    PageData<CategoryMergeParentDTO> getAllListByPage(Map<String, Object> params);

    Map<Long, String> queryCatIdToNameMap();

}