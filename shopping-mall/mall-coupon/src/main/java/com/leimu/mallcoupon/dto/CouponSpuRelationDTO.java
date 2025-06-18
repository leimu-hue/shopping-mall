package com.leimu.mallcoupon.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 优惠券与产品关联
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@Schema(name = "优惠券与产品关联")
public class CouponSpuRelationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "id")
    private Long id;

    @SchemaProperty(name = "优惠券id")
    private Long couponId;

    @SchemaProperty(name = "spu_id")
    private Long spuId;

    @SchemaProperty(name = "spu_name")
    private String spuName;


}
