package com.leimu.mallproduct.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 商品属性
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Data
@Schema(name = "商品属性")
public class AttrDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "属性id")
    private Long attrId;

    @SchemaProperty(name = "属性名")
    private String attrName;

    @SchemaProperty(name = "是否需要检索[0-不需要，1-需要]")
    private Integer searchType;

    @SchemaProperty(name = "值类型[0-为单个值，1-可以选择多个值]")
    private Integer valueType;

    @SchemaProperty(name = "属性图标")
    private String icon;

    @SchemaProperty(name = "可选值列表[用逗号分隔]")
    private String valueSelect;

    @SchemaProperty(name = "属性类型[0-销售属性，1-基本属性")
    private Integer attrType;

    @SchemaProperty(name = "启用状态[0 - 禁用，1 - 启用]")
    private Long enable;

    @SchemaProperty(name = "所属分类")
    private Long catelogId;

    @SchemaProperty(name = "快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整")
    private Integer showDesc;


}
