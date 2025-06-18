package com.leimu.mallorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallorder.dao.UmsMemberStatisticsInfoDao;
import com.leimu.mallorder.dto.UmsMemberStatisticsInfoDTO;
import com.leimu.mallorder.entity.UmsMemberStatisticsInfoEntity;
import com.leimu.mallorder.service.UmsMemberStatisticsInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 会员统计信息
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class UmsMemberStatisticsInfoServiceImpl extends CrudServiceImpl<UmsMemberStatisticsInfoDao, UmsMemberStatisticsInfoEntity, UmsMemberStatisticsInfoDTO> implements UmsMemberStatisticsInfoService {

    @Override
    public QueryWrapper<UmsMemberStatisticsInfoEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UmsMemberStatisticsInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}