package com.leimu.mallmember.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 会员收藏的商品
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@TableName("ums_member_collect_spu")
public class MemberCollectSpuEntity {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
	private Long id;
    /**
     * 会员id
     */
	private Long memberId;
    /**
     * spu_id
     */
	private Long spuId;
    /**
     * spu_name
     */
	private String spuName;
    /**
     * spu_img
     */
	private String spuImg;
    /**
     * create_time
     */
	private Date createTime;
}