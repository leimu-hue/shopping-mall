package com.leimu.mallproduct.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * spu信息
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Data
@Schema(name = "spu信息")
public class SpuInfoDTO implements Serializable {
    @Serial
	private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "商品id")
	private Long id;

	@SchemaProperty(name = "商品名称")
	private String spuName;

	@SchemaProperty(name = "商品描述")
	private String spuDescription;

	@SchemaProperty(name = "所属分类id")
	private Long catalogId;

	@SchemaProperty(name = "品牌id")
	private Long brandId;

	@SchemaProperty(name = "")
	private BigDecimal weight;

	@SchemaProperty(name = "上架状态[0 - 新建，1 - 上架，2 - 下架]")
	private Integer publishStatus;

	@SchemaProperty(name = "")
	private Date createTime;

	@SchemaProperty(name = "")
	private Date updateTime;


}
