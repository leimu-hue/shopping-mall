package com.leimu.mallorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallorder.dao.UmsIntegrationChangeHistoryDao;
import com.leimu.mallorder.dto.UmsIntegrationChangeHistoryDTO;
import com.leimu.mallorder.entity.UmsIntegrationChangeHistoryEntity;
import com.leimu.mallorder.service.UmsIntegrationChangeHistoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class UmsIntegrationChangeHistoryServiceImpl extends CrudServiceImpl<UmsIntegrationChangeHistoryDao, UmsIntegrationChangeHistoryEntity, UmsIntegrationChangeHistoryDTO> implements UmsIntegrationChangeHistoryService {

    @Override
    public QueryWrapper<UmsIntegrationChangeHistoryEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UmsIntegrationChangeHistoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}