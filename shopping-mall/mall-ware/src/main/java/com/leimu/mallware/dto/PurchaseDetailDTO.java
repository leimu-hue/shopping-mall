package com.leimu.mallware.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 采购需求
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@Schema(name = "采购需求")
public class PurchaseDetailDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "")
    private Long id;

    @SchemaProperty(name = "采购单id")
    private Long purchaseId;

    @SchemaProperty(name = "采购商品id")
    private Long skuId;

    @SchemaProperty(name = "采购数量")
    private Integer skuNum;

    @SchemaProperty(name = "采购金额")
    private BigDecimal skuPrice;

    @SchemaProperty(name = "仓库id")
    private Long wareId;

    @SchemaProperty(name = "状态[0新建，1已分配，2正在采购，3已完成，4采购失败]")
    private Integer status;


}
