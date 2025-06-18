package com.leimu.mallproduct.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 属性分组
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Data
@Schema(name = "属性分组")
public class AttrGroupDTO implements Serializable {
    @Serial
	private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "分组id")
	private Long attrGroupId;

	@SchemaProperty(name = "组名")
	private String attrGroupName;

	@SchemaProperty(name = "排序")
	private Integer sort;

	@SchemaProperty(name = "描述")
	private String descript;

	@SchemaProperty(name = "组图标")
	private String icon;

	@SchemaProperty(name = "所属分类id")
	private Long catelogId;


}
