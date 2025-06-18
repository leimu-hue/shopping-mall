package com.leimu.mallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallproduct.dao.AttrAttrGroupRelationDao;
import com.leimu.mallproduct.dto.AttrAttrGroupRelationDTO;
import com.leimu.mallproduct.entity.AttrAttrgroupRelationEntity;
import com.leimu.mallproduct.service.AttrAttrGroupRelationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Service
public class AttrAttrGroupRelationServiceImpl extends CrudServiceImpl<AttrAttrGroupRelationDao, AttrAttrgroupRelationEntity,
        AttrAttrGroupRelationDTO> implements AttrAttrGroupRelationService {

    @Override
    public QueryWrapper<AttrAttrgroupRelationEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<AttrAttrgroupRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}