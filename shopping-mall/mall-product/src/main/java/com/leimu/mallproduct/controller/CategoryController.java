package com.leimu.mallproduct.controller;

import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallproduct.dto.CategoryDTO;
import com.leimu.mallproduct.dto.CategoryMergeParentDTO;
import com.leimu.mallproduct.post.CategoryPost;
import com.leimu.mallproduct.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 商品三级分类
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({@Parameter(name = Constant.PAGE, description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true,
            ref = "int"), @Parameter(name = Constant.LIMIT, description = "每页显示记录数", in = ParameterIn.QUERY, required = true,
            ref = "int"), @Parameter(name = Constant.ORDER_FIELD, description = "排序字段", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = "categoryName", description = "商品名称信息", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY, ref = "String")})
    public Result<PageData<CategoryMergeParentDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        return new Result<PageData<CategoryMergeParentDTO>>().ok(categoryService.getAllListByPage(params));
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<CategoryDTO> get(@PathVariable("id") Long id) {
        CategoryDTO data = categoryService.get(id);
        return new Result<CategoryDTO>().ok(data);
    }

    @GetMapping("/list/tree")
    public Result<List<CategoryDTO>> queryAllListByTree() {
        return new Result<List<CategoryDTO>>().ok(categoryService.getAllListByTree());
    }

    @DeleteMapping("/delete")
    public Result<Integer> deleteByIds(@RequestBody List<Long> ids) {
        return new Result<Integer>().ok(categoryService.deleteByIds(ids));
    }

    @PostMapping("/add")
    public Result<String> addCategory(@RequestBody CategoryPost categoryPost) {
        return categoryService.addCategory(categoryPost);
    }

    @PutMapping("update")
    public Result<String> updateCategory(@RequestBody CategoryPost categoryPost) {
        return categoryService.updateCategory(categoryPost);
    }

}
