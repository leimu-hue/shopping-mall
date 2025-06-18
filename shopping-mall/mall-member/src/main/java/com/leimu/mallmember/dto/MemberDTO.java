package com.leimu.mallmember.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 会员
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@Schema(name = "会员")
public class MemberDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "id")
	private Long id;

	@SchemaProperty(name = "会员等级id")
	private Long levelId;

	@SchemaProperty(name = "用户名")
	private String username;

	@SchemaProperty(name = "密码")
	private String password;

	@SchemaProperty(name = "昵称")
	private String nickname;

	@SchemaProperty(name = "手机号码")
	private String mobile;

	@SchemaProperty(name = "邮箱")
	private String email;

	@SchemaProperty(name = "头像")
	private String header;

	@SchemaProperty(name = "性别")
	private Integer gender;

	@SchemaProperty(name = "生日")
	private Date birth;

	@SchemaProperty(name = "所在城市")
	private String city;

	@SchemaProperty(name = "职业")
	private String job;

	@SchemaProperty(name = "个性签名")
	private String sign;

	@SchemaProperty(name = "用户来源")
	private Integer sourceType;

	@SchemaProperty(name = "积分")
	private Integer integration;

	@SchemaProperty(name = "成长值")
	private Integer growth;

	@SchemaProperty(name = "启用状态")
	private Integer status;

	@SchemaProperty(name = "注册时间")
	private Date createTime;

	@SchemaProperty(name = "微博社交账户uid（应该建立关联表）")
	private String weiboUid;

	@SchemaProperty(name = "访问令牌")
	private String accessToken;

	@SchemaProperty(name = "访问令牌的过期时间")
	private String expiresIn;


}
