package com.leimu.mallproduct.controller;

import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallproduct.dto.BrandDTO;
import com.leimu.mallproduct.dto.CategoryMergeParentDTO;
import com.leimu.mallproduct.post.BrandPost;
import com.leimu.mallproduct.post.CategoryPost;
import com.leimu.mallproduct.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({@Parameter(name = Constant.PAGE, description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true,
            ref = "int"), @Parameter(name = Constant.LIMIT, description = "每页显示记录数", in = ParameterIn.QUERY, required = true,
            ref = "int"), @Parameter(name = Constant.ORDER_FIELD, description = "排序字段", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = "categoryName", description = "商品名称信息", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY, ref = "String")})
    public Result<PageData<BrandDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        return new Result<PageData<BrandDTO>>().ok(brandService.getAllListByPage(params));
    }

    @DeleteMapping("/delete")
    public Result<Integer> deleteByIds(@RequestBody List<Long> ids) {
        return new Result<Integer>().ok(brandService.deleteByIds(ids));
    }

    @PostMapping("/add")
    public Result<String> addBrand(@RequestBody BrandPost brandPost) {
        return brandService.addBrand(brandPost);
    }

    @PutMapping("update")
    public Result<String> updateBrand(@RequestBody BrandPost brandPost) {
        return brandService.updateBrand(brandPost);
    }

}
