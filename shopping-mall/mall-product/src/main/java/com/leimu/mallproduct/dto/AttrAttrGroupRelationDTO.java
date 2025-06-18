package com.leimu.mallproduct.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 属性&属性分组关联
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Data
@Schema(name = "属性&属性分组关联")
public class AttrAttrGroupRelationDTO implements Serializable {
    @Serial
	private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "id")
	private Long id;

	@SchemaProperty(name = "属性id")
	private Long attrId;

	@SchemaProperty(name = "属性分组id")
	private Long attrGroupId;

	@SchemaProperty(name = "属性组内排序")
	private Integer attrSort;


}
