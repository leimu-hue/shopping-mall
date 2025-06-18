package com.leimu.mallproduct.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * sku销售属性&值
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Data
@Schema(name = "sku销售属性&值")
public class SkuSaleAttrValueDTO implements Serializable {
    @Serial
	private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "id")
	private Long id;

	@SchemaProperty(name = "sku_id")
	private Long skuId;

	@SchemaProperty(name = "attr_id")
	private Long attrId;

	@SchemaProperty(name = "销售属性名")
	private String attrName;

	@SchemaProperty(name = "销售属性值")
	private String attrValue;

	@SchemaProperty(name = "顺序")
	private Integer attrSort;


}
