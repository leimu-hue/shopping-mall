package com.leimu.mallmember.controller;

import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallmember.dto.GrowthChangeHistoryDTO;
import com.leimu.mallmember.service.GrowthChangeHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 成长值变化历史记录
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@RestController
@RequestMapping("member/growthchangehistory")
@Tag(name = "成长值变化历史记录")
public class GrowthChangeHistoryController {

    private final GrowthChangeHistoryService growthChangeHistoryService;

    public GrowthChangeHistoryController(GrowthChangeHistoryService growthChangeHistoryService) {
        this.growthChangeHistoryService = growthChangeHistoryService;
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({
            @Parameter(name = Constant.PAGE, description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.LIMIT, description = "每页显示记录数", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.ORDER_FIELD, description = "排序字段", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY, ref = "String")
    })
    public Result<PageData<GrowthChangeHistoryDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        PageData<GrowthChangeHistoryDTO> page = growthChangeHistoryService.page(params);

        return new Result<PageData<GrowthChangeHistoryDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<GrowthChangeHistoryDTO> get(@PathVariable("id") Long id) {
        GrowthChangeHistoryDTO data = growthChangeHistoryService.get(id);

        return new Result<GrowthChangeHistoryDTO>().ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result save(@RequestBody GrowthChangeHistoryDTO dto) {
        growthChangeHistoryService.save(dto);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result update(@RequestBody GrowthChangeHistoryDTO dto) {
        growthChangeHistoryService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result delete(@RequestBody Long[] ids) {
        growthChangeHistoryService.delete(ids);
        return new Result();
    }

}
