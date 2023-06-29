package com.huoranger.gmall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huoranger.gmall.common.result.Result;
import com.huoranger.gmall.model.product.SpuInfo;
import com.huoranger.gmall.product.service.ManageService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/product")
@Api(value = "SPU管理Controller", tags = {"SPU操作接口"})
public class SpuManageController {

    @Resource
    private ManageService manageService;

    @GetMapping("/{page}/{limit}")
    public Result getSpuInfoList(@PathVariable Long page,
                                 @PathVariable Long limit,
                                 @RequestParam("category3_id") String category3Id) {
        Page<SpuInfo> spuInfoPage = new Page<>(page, limit);
        IPage<SpuInfo> iPage = manageService.getSpuInfoList(spuInfoPage, category3Id);
        return Result.ok(iPage);
    }

}
