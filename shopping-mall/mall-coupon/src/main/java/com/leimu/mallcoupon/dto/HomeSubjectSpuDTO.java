package com.leimu.mallcoupon.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 专题商品
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@Schema(name = "专题商品")
public class HomeSubjectSpuDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "id")
    private Long id;

    @SchemaProperty(name = "专题名字")
    private String name;

    @SchemaProperty(name = "专题id")
    private Long subjectId;

    @SchemaProperty(name = "spu_id")
    private Long spuId;

    @SchemaProperty(name = "排序")
    private Integer sort;


}
