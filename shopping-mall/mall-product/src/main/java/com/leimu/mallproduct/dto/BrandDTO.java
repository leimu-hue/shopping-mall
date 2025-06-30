package com.leimu.mallproduct.dto;

import com.leimu.mallproduct.entity.BrandEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;


/**
 * 品牌
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Data
@Schema(name = "品牌")
@NoArgsConstructor
public class BrandDTO implements Serializable {
    @Serial
	private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "品牌id")
	private String brandId;

	@SchemaProperty(name = "品牌名")
	private String name;

	@SchemaProperty(name = "品牌logo地址")
	private String logo;

	@SchemaProperty(name = "介绍")
	private String descript;

	@SchemaProperty(name = "显示状态[0-不显示；1-显示]")
	private Integer showStatus;

	@SchemaProperty(name = "检索首字母")
	private String firstLetter;

	@SchemaProperty(name = "排序")
	private Integer sort;

	public BrandDTO(BrandEntity brand) {
		BeanUtils.copyProperties(brand, this);
		this.brandId = String.valueOf(brand.getBrandId());
	}

}
