package com.leimu.mallorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallorder.dao.UmsMemberReceiveAddressDao;
import com.leimu.mallorder.dto.UmsMemberReceiveAddressDTO;
import com.leimu.mallorder.entity.UmsMemberReceiveAddressEntity;
import com.leimu.mallorder.service.UmsMemberReceiveAddressService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 会员收货地址
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class UmsMemberReceiveAddressServiceImpl extends CrudServiceImpl<UmsMemberReceiveAddressDao, UmsMemberReceiveAddressEntity, UmsMemberReceiveAddressDTO> implements UmsMemberReceiveAddressService {

    @Override
    public QueryWrapper<UmsMemberReceiveAddressEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UmsMemberReceiveAddressEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}