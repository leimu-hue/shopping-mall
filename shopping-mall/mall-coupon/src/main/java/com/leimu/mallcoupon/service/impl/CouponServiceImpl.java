package com.leimu.mallcoupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallcoupon.dao.CouponDao;
import com.leimu.mallcoupon.dto.CouponDTO;
import com.leimu.mallcoupon.entity.CouponEntity;
import com.leimu.mallcoupon.service.CouponService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class CouponServiceImpl extends CrudServiceImpl<CouponDao, CouponEntity, CouponDTO> implements CouponService {

    @Override
    public QueryWrapper<CouponEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<CouponEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}