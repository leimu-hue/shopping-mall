package com.leimu.mallcoupon.controller;

import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallcoupon.dto.SeckillSessionDTO;
import com.leimu.mallcoupon.service.SeckillSessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 秒杀活动场次
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@RestController
@RequestMapping("coupon/seckillsession")
@Tag(name = "秒杀活动场次")
public class SeckillSessionController {

    private final SeckillSessionService seckillSessionService;

    public SeckillSessionController(SeckillSessionService seckillSessionService) {
        this.seckillSessionService = seckillSessionService;
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({
            @Parameter(name = Constant.PAGE, description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.LIMIT, description = "每页显示记录数", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.ORDER_FIELD, description = "排序字段", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY, ref = "String")
    })
    public Result<PageData<SeckillSessionDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        PageData<SeckillSessionDTO> page = seckillSessionService.page(params);

        return new Result<PageData<SeckillSessionDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<SeckillSessionDTO> get(@PathVariable("id") Long id) {
        SeckillSessionDTO data = seckillSessionService.get(id);

        return new Result<SeckillSessionDTO>().ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result save(@RequestBody SeckillSessionDTO dto) {
        seckillSessionService.save(dto);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result update(@RequestBody SeckillSessionDTO dto) {
        seckillSessionService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result delete(@RequestBody Long[] ids) {
        seckillSessionService.delete(ids);
        return new Result();
    }

}
