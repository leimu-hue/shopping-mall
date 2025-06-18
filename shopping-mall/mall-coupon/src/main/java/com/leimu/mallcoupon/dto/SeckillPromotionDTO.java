package com.leimu.mallcoupon.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 秒杀活动
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@Schema(name = "秒杀活动")
public class SeckillPromotionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "id")
    private Long id;

    @SchemaProperty(name = "活动标题")
    private String title;

    @SchemaProperty(name = "开始日期")
    private Date startTime;

    @SchemaProperty(name = "结束日期")
    private Date endTime;

    @SchemaProperty(name = "上下线状态")
    private Integer status;

    @SchemaProperty(name = "创建时间")
    private Date createTime;

    @SchemaProperty(name = "创建人")
    private Long userId;


}
