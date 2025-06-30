package com.leimu.mallproduct.post;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(name = "商品新增信息")
@NoArgsConstructor
public class CategoryPost {

    @SchemaProperty(name = "分类id")
    private String catId;

    @SchemaProperty(name = "分类名称")
    @NotBlank(message = "分类名称不能为空")
    private String name;

    @SchemaProperty(name = "父分类id")
    @NotNull(message = "父分类id不能为空")
    private String parentCid;

    @SchemaProperty(name = "层级")
    private Integer catLevel;

    @SchemaProperty(name = "是否显示[0-不显示，1显示]")
    private Integer showStatus;

    @SchemaProperty(name = "排序")
    private Integer sort;

    @SchemaProperty(name = "图标地址")
    private String icon;
}
