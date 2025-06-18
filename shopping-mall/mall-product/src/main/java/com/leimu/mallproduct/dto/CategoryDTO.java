package com.leimu.mallproduct.dto;

import com.leimu.mallproduct.entity.CategoryEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 商品三级分类
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Data
@Schema(name = "商品三级分类")
public class CategoryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "分类id")
    private Long catId;

    @SchemaProperty(name = "分类名称")
    private String name;

    @SchemaProperty(name = "父分类id")
    private Long parentCid;

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

    @SchemaProperty(name = "二级商品列表")
    private List<CategoryDTO> children = new ArrayList<>();

    public CategoryDTO(CategoryEntity categoryEntity) {
        BeanUtils.copyProperties(categoryEntity, this);
    }

}
