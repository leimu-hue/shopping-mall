package com.leimu.mallproduct.controller;

import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallproduct.dto.CategoryBrandRelationDTO;
import com.leimu.mallproduct.service.CategoryBrandRelationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;

import java.util.Map;


/**
 * 品牌分类关联
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@RestController
@RequestMapping("product/cbr")
public class CategoryBrandRelationController {

    private final CategoryBrandRelationService categoryBrandRelationService;

    public CategoryBrandRelationController(CategoryBrandRelationService categoryBrandRelationService) {
        this.categoryBrandRelationService = categoryBrandRelationService;
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({
            @Parameter(name = Constant.PAGE, description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.LIMIT, description = "每页显示记录数", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.ORDER_FIELD, description = "排序字段", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY, ref = "String")
    })
    public Result<PageData<CategoryBrandRelationDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        PageData<CategoryBrandRelationDTO> page = categoryBrandRelationService.page(params);

        return new Result<PageData<CategoryBrandRelationDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<CategoryBrandRelationDTO> get(@PathVariable("id") Long id) {
        CategoryBrandRelationDTO data = categoryBrandRelationService.get(id);

        return new Result<CategoryBrandRelationDTO>().ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result save(@RequestBody CategoryBrandRelationDTO dto) {
        categoryBrandRelationService.save(dto);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result update(@RequestBody CategoryBrandRelationDTO dto) {
        categoryBrandRelationService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result delete(@RequestBody Long[] ids) {
        categoryBrandRelationService.delete(ids);
        return new Result();
    }

}
