package com.leimu.mallorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallorder.dao.UmsMemberCollectSubjectDao;
import com.leimu.mallorder.dto.UmsMemberCollectSubjectDTO;
import com.leimu.mallorder.entity.UmsMemberCollectSubjectEntity;
import com.leimu.mallorder.service.UmsMemberCollectSubjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Service
public class UmsMemberCollectSubjectServiceImpl extends CrudServiceImpl<UmsMemberCollectSubjectDao, UmsMemberCollectSubjectEntity, UmsMemberCollectSubjectDTO> implements UmsMemberCollectSubjectService {

    @Override
    public QueryWrapper<UmsMemberCollectSubjectEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UmsMemberCollectSubjectEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}