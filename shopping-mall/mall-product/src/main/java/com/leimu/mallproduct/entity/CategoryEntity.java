package com.leimu.mallproduct.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leimu.mallproduct.post.CategoryPost;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

/**
 * 商品三级分类
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Data
@TableName("pms_category")
@NoArgsConstructor
public class CategoryEntity {

    /**
     * 分类id
     */
    @TableId(type = IdType.ASSIGN_ID)
	private Long catId;
    /**
     * 分类名称
     */
	private String name;
    /**
     * 父分类id
     */
	private Long parentCid;
    /**
     * 层级
     */
	private Integer catLevel;
    /**
     * 是否显示[0-不显示，1显示]
     */
    @TableLogic(value = "1", delval = "0")
	private Integer showStatus;
    /**
     * 排序
     */
	private Integer sort;
    /**
     * 图标地址
     */
	private String icon;
    /**
     * 计量单位
     */
	private String productUnit;
    /**
     * 商品数量
     */
	private Integer productCount;

    private Date createTime;

    public CategoryEntity(CategoryPost categoryPost) {
        this.name = categoryPost.getName();
        if (Objects.isNull(categoryPost.getParentCid())) {
            this.parentCid = 0L;
        } else {
            this.parentCid = Long.valueOf(categoryPost.getParentCid());
        }
        this.catLevel = categoryPost.getCatLevel();
        this.showStatus = categoryPost.getShowStatus();
        this.sort = categoryPost.getSort();
        this.icon = categoryPost.getIcon();
        this.productUnit = null;
        this.productCount = 0;
        this.createTime = new Date();
    }

}