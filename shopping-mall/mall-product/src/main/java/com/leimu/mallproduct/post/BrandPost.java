package com.leimu.mallproduct.post;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(name = "品牌修改类")
@NoArgsConstructor
public class BrandPost {

    @SchemaProperty(name = "品牌id")
    private String brandId;

    @SchemaProperty(name = "品牌名")
    private String name;

    @SchemaProperty(name = "品牌logo地址")
    private String logo;

    @SchemaProperty(name = "介绍")
    private String descript;

    @SchemaProperty(name = "显示状态[0-不显示；1-显示]")
    private Integer showStatus;

    @SchemaProperty(name = "检索首字母")
    private String firstLetter;

    @SchemaProperty(name = "排序")
    private Integer sort;

}
