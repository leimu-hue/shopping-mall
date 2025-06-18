package com.leimu.mallproduct.dao;

import com.leimu.mallcommon.dao.BaseDao;
import com.leimu.mallproduct.entity.CommentReplayEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Mapper
public interface CommentReplayDao extends BaseDao<CommentReplayEntity> {
	
}