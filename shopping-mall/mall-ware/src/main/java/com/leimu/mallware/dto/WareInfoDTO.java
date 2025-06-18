package com.leimu.mallware.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 仓库信息
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Data
@Schema(name = "仓库信息")
public class WareInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "id")
    private Long id;

    @SchemaProperty(name = "仓库名")
    private String name;

    @SchemaProperty(name = "仓库地址")
    private String address;

    @SchemaProperty(name = "区域编码")
    private String areacode;


}
