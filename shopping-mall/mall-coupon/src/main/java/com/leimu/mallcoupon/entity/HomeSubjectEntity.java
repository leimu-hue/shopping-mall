package com.leimu.mallcoupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@TableName("sms_home_subject")
public class HomeSubjectEntity {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 专题名字
     */
    private String name;
    /**
     * 专题标题
     */
    private String title;
    /**
     * 专题副标题
     */
    private String subTitle;
    /**
     * 显示状态
     */
    private Integer status;
    /**
     * 详情连接
     */
    private String url;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 专题图片地址
     */
    private String img;
}