package com.leimu.mallware.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购单
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@Schema(name = "采购单")
public class PurchaseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "")
    private Long id;

    @SchemaProperty(name = "")
    private Long assigneeId;

    @SchemaProperty(name = "")
    private String assigneeName;

    @SchemaProperty(name = "")
    private String phone;

    @SchemaProperty(name = "")
    private Integer priority;

    @SchemaProperty(name = "")
    private Integer status;

    @SchemaProperty(name = "")
    private Long wareId;

    @SchemaProperty(name = "")
    private BigDecimal amount;

    @SchemaProperty(name = "")
    private Date createTime;

    @SchemaProperty(name = "")
    private Date updateTime;


}
