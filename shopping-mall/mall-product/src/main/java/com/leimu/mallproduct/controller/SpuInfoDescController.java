package com.leimu.mallproduct.controller;

import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallproduct.dto.SpuInfoDescDTO;
import com.leimu.mallproduct.service.SpuInfoDescService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * spu信息介绍
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@RestController
@RequestMapping("product/spuinfodesc")
public class SpuInfoDescController {

    private final SpuInfoDescService spuInfoDescService;

    public SpuInfoDescController(SpuInfoDescService spuInfoDescService) {
        this.spuInfoDescService = spuInfoDescService;
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({
            @Parameter(name = Constant.PAGE, description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.LIMIT, description = "每页显示记录数", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.ORDER_FIELD, description = "排序字段", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY, ref = "String")
    })
    public Result<PageData<SpuInfoDescDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        PageData<SpuInfoDescDTO> page = spuInfoDescService.page(params);

        return new Result<PageData<SpuInfoDescDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<SpuInfoDescDTO> get(@PathVariable("id") Long id) {
        SpuInfoDescDTO data = spuInfoDescService.get(id);

        return new Result<SpuInfoDescDTO>().ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result save(@RequestBody SpuInfoDescDTO dto) {
        spuInfoDescService.save(dto);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result update(@RequestBody SpuInfoDescDTO dto) {
        spuInfoDescService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result delete(@RequestBody Long[] ids) {
        spuInfoDescService.delete(ids);
        return new Result();
    }

}
