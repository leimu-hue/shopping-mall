package com.leimu.mallware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购单
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@TableName("wms_purchase")
public class PurchaseEntity {

    /**
     *
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     *
     */
    private Long assigneeId;
    /**
     *
     */
    private String assigneeName;
    /**
     *
     */
    private String phone;
    /**
     *
     */
    private Integer priority;
    /**
     *
     */
    private Integer status;
    /**
     *
     */
    private Long wareId;
    /**
     *
     */
    private BigDecimal amount;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;
}