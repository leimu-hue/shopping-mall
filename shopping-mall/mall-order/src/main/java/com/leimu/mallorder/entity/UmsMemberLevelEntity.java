package com.leimu.mallorder.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 会员等级
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@TableName("ums_member_level")
public class UmsMemberLevelEntity {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
	private Long id;
    /**
     * 等级名称
     */
	private String name;
    /**
     * 等级需要的成长值
     */
	private Integer growthPoint;
    /**
     * 是否为默认等级[0->不是；1->是]
     */
	private Integer defaultStatus;
    /**
     * 免运费标准
     */
	private BigDecimal freeFreightPoint;
    /**
     * 每次评价获取的成长值
     */
	private Integer commentGrowthPoint;
    /**
     * 是否有免邮特权
     */
	private Integer priviledgeFreeFreight;
    /**
     * 是否有会员价格特权
     */
	private Integer priviledgeMemberPrice;
    /**
     * 是否有生日特权
     */
	private Integer priviledgeBirthday;
    /**
     * 备注
     */
	private String note;
}