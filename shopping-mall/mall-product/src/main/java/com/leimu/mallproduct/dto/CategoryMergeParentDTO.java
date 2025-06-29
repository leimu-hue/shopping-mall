package com.leimu.mallproduct.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Schema(name = "商品三级分类(包含上级商品信息)")
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryMergeParentDTO {

    @SchemaProperty(name = "分类id")
    private Long catId;

    @SchemaProperty(name = "分类名称")
    private String name;

    @SchemaProperty(name = "父分类id")
    private Long parentCid;

    @SchemaProperty(name = "父分类名称")
    private String parentName;

    @SchemaProperty(name = "层级")
    private Integer catLevel;

    @SchemaProperty(name = "是否显示[0-不显示，1显示]")
    private Integer showStatus;

    @SchemaProperty(name = "排序")
    private Integer sort;

    @SchemaProperty(name = "图标地址")
    private String icon;

    @SchemaProperty(name = "计量单位")
    private String productUnit;

    @SchemaProperty(name = "商品数量")
    private Integer productCount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}
