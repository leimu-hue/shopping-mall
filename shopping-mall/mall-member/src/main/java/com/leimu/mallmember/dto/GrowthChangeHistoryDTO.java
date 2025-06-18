package com.leimu.mallmember.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 成长值变化历史记录
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@Schema(name = "成长值变化历史记录")
public class GrowthChangeHistoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "id")
	private Long id;

	@SchemaProperty(name = "member_id")
	private Long memberId;

	@SchemaProperty(name = "create_time")
	private Date createTime;

	@SchemaProperty(name = "改变的值（正负计数）")
	private Integer changeCount;

	@SchemaProperty(name = "备注")
	private String note;

	@SchemaProperty(name = "积分来源[0-购物，1-管理员修改]")
	private Integer sourceType;


}
