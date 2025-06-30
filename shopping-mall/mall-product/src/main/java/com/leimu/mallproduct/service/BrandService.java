package com.leimu.mallproduct.service;

import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.service.CrudService;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallproduct.dto.BrandDTO;
import com.leimu.mallproduct.entity.BrandEntity;
import com.leimu.mallproduct.post.BrandPost;

import java.util.List;
import java.util.Map;

/**
 * 品牌
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
public interface BrandService extends CrudService<BrandEntity, BrandDTO> {

    PageData<BrandDTO> getAllListByPage(Map<String, Object> params);

    Integer deleteByIds(List<Long> ids);

    Result<String> addBrand(BrandPost brandPost);

    Result<String> updateBrand(BrandPost brandPost);
}