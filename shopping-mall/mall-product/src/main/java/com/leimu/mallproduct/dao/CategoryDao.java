package com.leimu.mallproduct.dao;

import com.leimu.mallcommon.dao.BaseDao;
import com.leimu.mallproduct.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Mapper
public interface CategoryDao extends BaseDao<CategoryEntity> {
	
}