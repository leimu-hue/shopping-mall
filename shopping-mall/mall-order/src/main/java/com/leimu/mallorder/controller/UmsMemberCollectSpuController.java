package com.leimu.mallorder.controller;

import com.leimu.mallcommon.constant.Constant;
import com.leimu.mallcommon.page.PageData;
import com.leimu.mallcommon.show.Result;
import com.leimu.mallorder.dto.UmsMemberCollectSpuDTO;
import com.leimu.mallorder.service.UmsMemberCollectSpuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 会员收藏的商品
 *
 * @author hhq 2627492139@qq.com
 * @since 1.0.0 2025-06-16
 */
@RestController
@RequestMapping("order/umsmembercollectspu")
@Tag(name = "会员收藏的商品")
public class UmsMemberCollectSpuController {

    private final UmsMemberCollectSpuService umsMemberCollectSpuService;

    public UmsMemberCollectSpuController(UmsMemberCollectSpuService umsMemberCollectSpuService) {
        this.umsMemberCollectSpuService = umsMemberCollectSpuService;
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({
            @Parameter(name = Constant.PAGE, description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.LIMIT, description = "每页显示记录数", in = ParameterIn.QUERY, required = true, ref = "int"),
            @Parameter(name = Constant.ORDER_FIELD, description = "排序字段", in = ParameterIn.QUERY, ref = "String"),
            @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY, ref = "String")
    })
    public Result<PageData<UmsMemberCollectSpuDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        PageData<UmsMemberCollectSpuDTO> page = umsMemberCollectSpuService.page(params);

        return new Result<PageData<UmsMemberCollectSpuDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<UmsMemberCollectSpuDTO> get(@PathVariable("id") Long id) {
            UmsMemberCollectSpuDTO data = umsMemberCollectSpuService.get(id);

        return new Result<UmsMemberCollectSpuDTO>().ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result save(@RequestBody UmsMemberCollectSpuDTO dto) {
            umsMemberCollectSpuService.save(dto);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result update(@RequestBody UmsMemberCollectSpuDTO dto) {
            umsMemberCollectSpuService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result delete(@RequestBody Long[] ids) {
            umsMemberCollectSpuService.delete(ids);
        return new Result();
    }

}
