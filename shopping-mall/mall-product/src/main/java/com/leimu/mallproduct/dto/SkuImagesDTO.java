package com.leimu.mallproduct.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * sku图片
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Data
@Schema(name = "sku图片")
public class SkuImagesDTO implements Serializable {
    @Serial
	private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "id")
	private Long id;

	@SchemaProperty(name = "sku_id")
	private Long skuId;

	@SchemaProperty(name = "图片地址")
	private String imgUrl;

	@SchemaProperty(name = "排序")
	private Integer imgSort;

	@SchemaProperty(name = "默认图[0 - 不是默认图，1 - 是默认图]")
	private Integer defaultImg;


}
