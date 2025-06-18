package com.leimu.mallcoupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallcoupon.dao.CouponSpuRelationDao;
import com.leimu.mallcoupon.dto.CouponSpuRelationDTO;
import com.leimu.mallcoupon.entity.CouponSpuRelationEntity;
import com.leimu.mallcoupon.service.CouponSpuRelationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class CouponSpuRelationServiceImpl extends CrudServiceImpl<CouponSpuRelationDao, CouponSpuRelationEntity, CouponSpuRelationDTO> implements CouponSpuRelationService {

    @Override
    public QueryWrapper<CouponSpuRelationEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<CouponSpuRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}