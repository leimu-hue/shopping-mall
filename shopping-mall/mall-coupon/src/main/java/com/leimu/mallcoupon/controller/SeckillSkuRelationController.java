package com.leimu.mallcoupon.controller;

import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallcoupon.dto.SeckillSkuRelationDTO;
import com.leimu.mallcoupon.service.SeckillSkuRelationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 秒杀活动商品关联
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@RestController
@RequestMapping("coupon/seckillskurelation")
@Tag(name = "秒杀活动商品关联")
public class SeckillSkuRelationController {

    private final SeckillSkuRelationService seckillSkuRelationService;

    public SeckillSkuRelationController(SeckillSkuRelationService seckillSkuRelationService) {
        this.seckillSkuRelationService = seckillSkuRelationService;
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({
            @Parameter(name = Constant.PAGE, description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.LIMIT, description = "每页显示记录数", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.ORDER_FIELD, description = "排序字段", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY, ref = "String")
    })
    public Result<PageData<SeckillSkuRelationDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        PageData<SeckillSkuRelationDTO> page = seckillSkuRelationService.page(params);

        return new Result<PageData<SeckillSkuRelationDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<SeckillSkuRelationDTO> get(@PathVariable("id") Long id) {
        SeckillSkuRelationDTO data = seckillSkuRelationService.get(id);

        return new Result<SeckillSkuRelationDTO>().ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result save(@RequestBody SeckillSkuRelationDTO dto) {
        seckillSkuRelationService.save(dto);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result update(@RequestBody SeckillSkuRelationDTO dto) {
        seckillSkuRelationService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result delete(@RequestBody Long[] ids) {
        seckillSkuRelationService.delete(ids);
        return new Result();
    }

}
