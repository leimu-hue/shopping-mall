package com.leimu.mallcoupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallcoupon.dao.SeckillPromotionDao;
import com.leimu.mallcoupon.dto.SeckillPromotionDTO;
import com.leimu.mallcoupon.entity.SeckillPromotionEntity;
import com.leimu.mallcoupon.service.SeckillPromotionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class SeckillPromotionServiceImpl extends CrudServiceImpl<SeckillPromotionDao, SeckillPromotionEntity, SeckillPromotionDTO> implements SeckillPromotionService {

    @Override
    public QueryWrapper<SeckillPromotionEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<SeckillPromotionEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}