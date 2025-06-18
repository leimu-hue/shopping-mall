package com.leimu.mallcoupon.dao;

import com.leimu.mallcommon.dao.BaseDao;
import com.leimu.mallcoupon.entity.HomeSubjectEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@Mapper
public interface HomeSubjectDao extends BaseDao<HomeSubjectEntity> {

}