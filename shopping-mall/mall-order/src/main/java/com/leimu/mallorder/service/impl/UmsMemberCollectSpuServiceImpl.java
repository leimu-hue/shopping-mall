package com.leimu.mallorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallorder.dao.UmsMemberCollectSpuDao;
import com.leimu.mallorder.dto.UmsMemberCollectSpuDTO;
import com.leimu.mallorder.entity.UmsMemberCollectSpuEntity;
import com.leimu.mallorder.service.UmsMemberCollectSpuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 会员收藏的商品
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class UmsMemberCollectSpuServiceImpl extends CrudServiceImpl<UmsMemberCollectSpuDao, UmsMemberCollectSpuEntity, UmsMemberCollectSpuDTO> implements UmsMemberCollectSpuService {

    @Override
    public QueryWrapper<UmsMemberCollectSpuEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UmsMemberCollectSpuEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}