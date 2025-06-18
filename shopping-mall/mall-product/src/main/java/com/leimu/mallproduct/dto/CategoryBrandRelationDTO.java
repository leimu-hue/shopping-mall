package com.leimu.mallproduct.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 品牌分类关联
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Data
@Schema(name = "品牌分类关联")
public class CategoryBrandRelationDTO implements Serializable {
    @Serial
	private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "")
	private Long id;

	@SchemaProperty(name = "品牌id")
	private Long brandId;

	@SchemaProperty(name = "分类id")
	private Long catelogId;

	@SchemaProperty(name = "")
	private String brandName;

	@SchemaProperty(name = "")
	private String catelogName;


}
