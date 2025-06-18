package com.leimu.mallorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallorder.dao.UmsMemberLoginLogDao;
import com.leimu.mallorder.dto.UmsMemberLoginLogDTO;
import com.leimu.mallorder.entity.UmsMemberLoginLogEntity;
import com.leimu.mallorder.service.UmsMemberLoginLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class UmsMemberLoginLogServiceImpl extends CrudServiceImpl<UmsMemberLoginLogDao, UmsMemberLoginLogEntity, UmsMemberLoginLogDTO> implements UmsMemberLoginLogService {

    @Override
    public QueryWrapper<UmsMemberLoginLogEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UmsMemberLoginLogEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}