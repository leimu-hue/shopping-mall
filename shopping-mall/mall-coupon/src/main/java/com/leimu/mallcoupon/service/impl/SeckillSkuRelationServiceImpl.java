package com.leimu.mallcoupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallcoupon.dao.SeckillSkuRelationDao;
import com.leimu.mallcoupon.dto.SeckillSkuRelationDTO;
import com.leimu.mallcoupon.entity.SeckillSkuRelationEntity;
import com.leimu.mallcoupon.service.SeckillSkuRelationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 秒杀活动商品关联
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class SeckillSkuRelationServiceImpl extends CrudServiceImpl<SeckillSkuRelationDao, SeckillSkuRelationEntity, SeckillSkuRelationDTO> implements SeckillSkuRelationService {

    @Override
    public QueryWrapper<SeckillSkuRelationEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<SeckillSkuRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}