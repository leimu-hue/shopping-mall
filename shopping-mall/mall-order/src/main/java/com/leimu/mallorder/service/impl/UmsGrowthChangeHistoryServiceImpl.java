package com.leimu.mallorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallorder.dao.UmsGrowthChangeHistoryDao;
import com.leimu.mallorder.dto.UmsGrowthChangeHistoryDTO;
import com.leimu.mallorder.entity.UmsGrowthChangeHistoryEntity;
import com.leimu.mallorder.service.UmsGrowthChangeHistoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class UmsGrowthChangeHistoryServiceImpl extends CrudServiceImpl<UmsGrowthChangeHistoryDao, UmsGrowthChangeHistoryEntity, UmsGrowthChangeHistoryDTO> implements UmsGrowthChangeHistoryService {

    @Override
    public QueryWrapper<UmsGrowthChangeHistoryEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UmsGrowthChangeHistoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}