package com.huoranger.gmall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huoranger.gmall.common.result.Result;
import com.huoranger.gmall.model.product.BaseTrademark;
import com.huoranger.gmall.product.service.BaseTrademarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/product/base_trademark")
@Api(value = "品牌Controller", tags = {"品牌操作接口"})
public class BaseTrademarkController {

    @Resource
    private BaseTrademarkService baseTrademarkService;

    @GetMapping("/{page}/{limit}")
    @ApiOperation("分页获取品牌数据列表")
    public Result getBaseTrademarkList(@ApiParam("页码") @PathVariable Long page,
                                       @ApiParam("每页几条数据") @PathVariable Long limit) {
        Page<BaseTrademark> trademarkPage = new Page<>(page, limit);

        return Result.ok(baseTrademarkService.getBaseTrademarkList(trademarkPage));
    }

    @PostMapping("/save")
    @ApiOperation("添加品牌数据")
    public Result save(@ApiParam("需要添加的品牌数据") @RequestBody BaseTrademark baseTrademark) {
        baseTrademarkService.save(baseTrademark);
        return Result.ok();
    }

    @PutMapping("/update")
    @ApiOperation("修改品牌数据")
    public Result update(@ApiParam("需要修改的品牌数据") @RequestBody BaseTrademark baseTrademark) {
        baseTrademarkService.updateById(baseTrademark);
        return Result.ok();
    }

    @DeleteMapping("/remove/{id}")
    @ApiOperation("根据ID删除品牌数据")
    public Result remove(@ApiParam("品牌ID") @PathVariable Long id) {
        baseTrademarkService.removeById(id);
        return Result.ok();
    }

    @GetMapping("/get/{id}")
    @ApiOperation("根据ID查询品牌数据")
    public Result getBaseTrademark(@ApiParam("品牌ID") @PathVariable Long id) {
        return Result.ok(baseTrademarkService.getById(id));
    }

}
