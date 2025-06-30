package com.leimu.mallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.service.impl.CrudServiceImpl;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallproduct.dao.BrandDao;
import com.leimu.mallproduct.dto.BrandDTO;
import com.leimu.mallproduct.entity.BrandEntity;
import com.leimu.mallproduct.post.BrandPost;
import com.leimu.mallproduct.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 品牌
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-15
 */
@Service
public class BrandServiceImpl extends CrudServiceImpl<BrandDao, BrandEntity, BrandDTO> implements BrandService {

    @Override
    public PageData<BrandDTO> getAllListByPage(Map<String, Object> params) {
        int page = Integer.parseInt(Optional.ofNullable((String) params.get(Constant.PAGE)).orElse("1"));
        int limit = Integer.parseInt(Optional.ofNullable((String) params.get(Constant.LIMIT)).orElse("10"));
        String brandName = Optional.ofNullable((String) params.get("brandName")).orElse("");

        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(brandName)) {
            wrapper.like("name", brandName);
        }
        wrapper.orderByDesc("sort");
        wrapper.eq("show_status", 1);
        IPage<BrandEntity> pageData = new Page<>(page, limit);
        List<BrandEntity> brandEntities = baseDao.selectList(pageData, wrapper);
        return new PageData<>(pageData.getTotal(), page, limit, brandEntities.stream().map(BrandDTO::new).toList());
    }

    @Override
    public Integer deleteByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return baseDao.deleteByIds(ids);
    }

    @Override
    public Result<String> addBrand(BrandPost brandPost) {
        BrandEntity brandEntity = new BrandEntity();
        BeanUtils.copyProperties(brandPost, brandEntity);
        int insert = baseDao.insert(brandEntity);
        if (insert > 0) {
            return new Result<String>().ok(null);
        } else {
            return new Result<String>().error("新增失败, 请稍后再试");
        }
    }

    @Override
    public Result<String> updateBrand(BrandPost brandPost) {
        if (StringUtils.isBlank(brandPost.getBrandId())) {
            return new Result<String>().error("无效信息");
        }
        BrandEntity brandEntity = new BrandEntity();
        BeanUtils.copyProperties(brandPost, brandEntity);
        brandEntity.setBrandId(Long.valueOf(brandPost.getBrandId()));
        int insert = baseDao.updateById(brandEntity);
        if (insert > 0) {
            return new Result<String>().ok(null);
        } else {
            return new Result<String>().error("新增失败, 请稍后再试");
        }
    }

    @Override
    public QueryWrapper<BrandEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}