package com.leimu.mallproduct.controller;

import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallproduct.dto.ProductAttrValueDTO;
import com.leimu.mallproduct.service.ProductAttrValueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * spu属性值
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@RestController
@RequestMapping("product/productattrvalue")
public class ProductAttrValueController {

    private final ProductAttrValueService productAttrValueService;

    public ProductAttrValueController(ProductAttrValueService productAttrValueService) {
        this.productAttrValueService = productAttrValueService;
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({
            @Parameter(name = Constant.PAGE, description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.LIMIT, description = "每页显示记录数", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.ORDER_FIELD, description = "排序字段", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY, ref = "String")
    })
    public Result<PageData<ProductAttrValueDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        PageData<ProductAttrValueDTO> page = productAttrValueService.page(params);

        return new Result<PageData<ProductAttrValueDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<ProductAttrValueDTO> get(@PathVariable("id") Long id) {
        ProductAttrValueDTO data = productAttrValueService.get(id);

        return new Result<ProductAttrValueDTO>().ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result save(@RequestBody ProductAttrValueDTO dto) {
        productAttrValueService.save(dto);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result update(@RequestBody ProductAttrValueDTO dto) {
        productAttrValueService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result delete(@RequestBody Long[] ids) {
        productAttrValueService.delete(ids);
        return new Result();
    }

}
