package com.leimu.mallorder.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 积分变化历史记录
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@Schema(name = "积分变化历史记录")
public class UmsIntegrationChangeHistoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "id")
	private Long id;

	@SchemaProperty(name = "member_id")
	private Long memberId;

	@SchemaProperty(name = "create_time")
	private Date createTime;

	@SchemaProperty(name = "变化的值")
	private Integer changeCount;

	@SchemaProperty(name = "备注")
	private String note;

	@SchemaProperty(name = "来源[0->购物；1->管理员修改;2->活动]")
	private Integer sourceTyoe;


}
