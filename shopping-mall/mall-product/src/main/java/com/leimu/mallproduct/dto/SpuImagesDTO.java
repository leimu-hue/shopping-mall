package com.leimu.mallproduct.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * spu图片
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Data
@Schema(name = "spu图片")
public class SpuImagesDTO implements Serializable {
    @Serial
	private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "id")
	private Long id;

	@SchemaProperty(name = "spu_id")
	private Long spuId;

	@SchemaProperty(name = "图片名")
	private String imgName;

	@SchemaProperty(name = "图片地址")
	private String imgUrl;

	@SchemaProperty(name = "顺序")
	private Integer imgSort;

	@SchemaProperty(name = "是否默认图")
	private Integer defaultImg;


}
