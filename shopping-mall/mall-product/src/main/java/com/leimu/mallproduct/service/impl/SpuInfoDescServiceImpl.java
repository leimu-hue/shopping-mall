package com.leimu.mallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallproduct.dao.SpuInfoDescDao;
import com.leimu.mallproduct.dto.SpuInfoDescDTO;
import com.leimu.mallproduct.entity.SpuInfoDescEntity;
import com.leimu.mallproduct.service.SpuInfoDescService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Service
public class SpuInfoDescServiceImpl extends CrudServiceImpl<SpuInfoDescDao, SpuInfoDescEntity, SpuInfoDescDTO> implements SpuInfoDescService {

    @Override
    public QueryWrapper<SpuInfoDescEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<SpuInfoDescEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}