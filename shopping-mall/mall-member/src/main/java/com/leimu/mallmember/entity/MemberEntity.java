package com.leimu.mallmember.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 会员
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@TableName("ums_member")
public class MemberEntity {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
	private Long id;
    /**
     * 会员等级id
     */
	private Long levelId;
    /**
     * 用户名
     */
	private String username;
    /**
     * 密码
     */
	private String password;
    /**
     * 昵称
     */
	private String nickname;
    /**
     * 手机号码
     */
	private String mobile;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 头像
     */
	private String header;
    /**
     * 性别
     */
	private Integer gender;
    /**
     * 生日
     */
	private Date birth;
    /**
     * 所在城市
     */
	private String city;
    /**
     * 职业
     */
	private String job;
    /**
     * 个性签名
     */
	private String sign;
    /**
     * 用户来源
     */
	private Integer sourceType;
    /**
     * 积分
     */
	private Integer integration;
    /**
     * 成长值
     */
	private Integer growth;
    /**
     * 启用状态
     */
	private Integer status;
    /**
     * 注册时间
     */
	private Date createTime;
    /**
     * 微博社交账户uid（应该建立关联表）
     */
	private String weiboUid;
    /**
     * 访问令牌
     */
	private String accessToken;
    /**
     * 访问令牌的过期时间
     */
	private String expiresIn;
}