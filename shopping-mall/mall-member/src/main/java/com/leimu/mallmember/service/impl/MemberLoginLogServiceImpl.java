package com.leimu.mallmember.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallmember.dao.MemberLoginLogDao;
import com.leimu.mallmember.dto.MemberLoginLogDTO;
import com.leimu.mallmember.entity.MemberLoginLogEntity;
import com.leimu.mallmember.service.MemberLoginLogService;
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
public class MemberLoginLogServiceImpl extends CrudServiceImpl<MemberLoginLogDao, MemberLoginLogEntity, MemberLoginLogDTO> implements MemberLoginLogService {

    @Override
    public QueryWrapper<MemberLoginLogEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<MemberLoginLogEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}