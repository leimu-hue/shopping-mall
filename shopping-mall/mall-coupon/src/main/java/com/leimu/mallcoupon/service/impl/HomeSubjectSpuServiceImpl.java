package com.leimu.mallcoupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallcoupon.dao.HomeSubjectSpuDao;
import com.leimu.mallcoupon.dto.HomeSubjectSpuDTO;
import com.leimu.mallcoupon.entity.HomeSubjectSpuEntity;
import com.leimu.mallcoupon.service.HomeSubjectSpuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 专题商品
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class HomeSubjectSpuServiceImpl extends CrudServiceImpl<HomeSubjectSpuDao, HomeSubjectSpuEntity, HomeSubjectSpuDTO> implements HomeSubjectSpuService {

    @Override
    public QueryWrapper<HomeSubjectSpuEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<HomeSubjectSpuEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}