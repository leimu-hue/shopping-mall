package com.leimu.mallware.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 商品库存
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@Schema(name = "商品库存")
public class WareSkuDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "id")
    private Long id;

    @SchemaProperty(name = "sku_id")
    private Long skuId;

    @SchemaProperty(name = "仓库id")
    private Long wareId;

    @SchemaProperty(name = "库存数")
    private Integer stock;

    @SchemaProperty(name = "sku_name")
    private String skuName;

    @SchemaProperty(name = "锁定库存")
    private Integer stockLocked;


}
