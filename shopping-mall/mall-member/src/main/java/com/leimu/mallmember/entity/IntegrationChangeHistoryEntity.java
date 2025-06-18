package com.leimu.mallmember.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 积分变化历史记录
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@TableName("ums_integration_change_history")
public class IntegrationChangeHistoryEntity {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
	private Long id;
    /**
     * member_id
     */
	private Long memberId;
    /**
     * create_time
     */
	private Date createTime;
    /**
     * 变化的值
     */
	private Integer changeCount;
    /**
     * 备注
     */
	private String note;
    /**
     * 来源[0->购物；1->管理员修改;2->活动]
     */
	private Integer sourceTyoe;
}