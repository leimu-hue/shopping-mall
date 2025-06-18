package com.leimu.mallorder.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 会员登录记录
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@TableName("ums_member_login_log")
public class UmsMemberLoginLogEntity {

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
     * 创建时间
     */
	private Date createTime;
    /**
     * ip
     */
	private String ip;
    /**
     * city
     */
	private String city;
    /**
     * 登录类型[1-web，2-app]
     */
	private Integer loginType;
}