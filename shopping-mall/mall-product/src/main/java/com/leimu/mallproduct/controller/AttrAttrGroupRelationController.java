package com.leimu.mallproduct.controller;

import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallproduct.dto.AttrAttrGroupRelationDTO;
import com.leimu.mallproduct.service.AttrAttrGroupRelationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 属性&属性分组关联
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@RestController
@RequestMapping("/product/aagr")
@Tag(name = "依赖关系数据")
@Slf4j
public class AttrAttrGroupRelationController {

    private final AttrAttrGroupRelationService attrAttrGroupRelationService;

    public AttrAttrGroupRelationController(AttrAttrGroupRelationService attrAttrGroupRelationService) {
        this.attrAttrGroupRelationService = attrAttrGroupRelationService;
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({
            @Parameter(name = Constant.PAGE, description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.LIMIT, description = "每页显示记录数", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.ORDER_FIELD, description = "排序字段", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY, ref = "String")
    })
    public Result<PageData<AttrAttrGroupRelationDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        log.info("this is a new");
        PageData<AttrAttrGroupRelationDTO> page = attrAttrGroupRelationService.page(params);

        return new Result<PageData<AttrAttrGroupRelationDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<AttrAttrGroupRelationDTO> get(@PathVariable("id") Long id) {
        AttrAttrGroupRelationDTO data = attrAttrGroupRelationService.get(id);

        return new Result<AttrAttrGroupRelationDTO>().ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result save(@RequestBody AttrAttrGroupRelationDTO dto) {
        attrAttrGroupRelationService.save(dto);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result update(@RequestBody AttrAttrGroupRelationDTO dto) {
        attrAttrGroupRelationService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result delete(@RequestBody Long[] ids) {
        attrAttrGroupRelationService.delete(ids);
        return new Result();
    }

}
