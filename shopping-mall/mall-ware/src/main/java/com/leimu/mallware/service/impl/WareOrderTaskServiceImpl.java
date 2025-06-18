package com.leimu.mallware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallware.dao.WareOrderTaskDao;
import com.leimu.mallware.dto.WareOrderTaskDTO;
import com.leimu.mallware.entity.WareOrderTaskEntity;
import com.leimu.mallware.service.WareOrderTaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class WareOrderTaskServiceImpl extends CrudServiceImpl<WareOrderTaskDao, WareOrderTaskEntity, WareOrderTaskDTO> implements WareOrderTaskService {

    @Override
    public QueryWrapper<WareOrderTaskEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<WareOrderTaskEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}