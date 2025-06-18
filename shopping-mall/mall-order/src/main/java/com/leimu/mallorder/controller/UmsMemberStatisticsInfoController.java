package com.leimu.mallorder.controller;

import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallorder.dto.UmsMemberStatisticsInfoDTO;
import com.leimu.mallorder.service.UmsMemberStatisticsInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 会员统计信息
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@RestController
@RequestMapping("order/umsmemberstatisticsinfo")
@Tag(name = "会员统计信息")
public class UmsMemberStatisticsInfoController {

    private final UmsMemberStatisticsInfoService umsMemberStatisticsInfoService;

    public UmsMemberStatisticsInfoController(UmsMemberStatisticsInfoService umsMemberStatisticsInfoService) {
        this.umsMemberStatisticsInfoService = umsMemberStatisticsInfoService;
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({
            @Parameter(name = Constant.PAGE, description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.LIMIT, description = "每页显示记录数", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.ORDER_FIELD, description = "排序字段", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY, ref = "String")
    })
    public Result<PageData<UmsMemberStatisticsInfoDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        PageData<UmsMemberStatisticsInfoDTO> page = umsMemberStatisticsInfoService.page(params);

        return new Result<PageData<UmsMemberStatisticsInfoDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<UmsMemberStatisticsInfoDTO> get(@PathVariable("id") Long id) {
            UmsMemberStatisticsInfoDTO data = umsMemberStatisticsInfoService.get(id);

        return new Result<UmsMemberStatisticsInfoDTO>().ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result save(@RequestBody UmsMemberStatisticsInfoDTO dto) {
            umsMemberStatisticsInfoService.save(dto);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result update(@RequestBody UmsMemberStatisticsInfoDTO dto) {
            umsMemberStatisticsInfoService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result delete(@RequestBody Long[] ids) {
            umsMemberStatisticsInfoService.delete(ids);
        return new Result();
    }

}
