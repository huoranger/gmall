package com.huoranger.gmall.product.controller;

import com.huoranger.gmall.common.result.Result;
import com.huoranger.gmall.model.product.*;
import com.huoranger.gmall.product.service.ManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class BaseManageController {

    @Resource
    private ManageService manageService;

    @GetMapping("/get-category1")
    public Result<List<BaseCategory1>> getCategory1() {
        return Result.ok(manageService.getBaseCategory1());
    }

    @GetMapping("/get-category2/{category1Id}")
    public Result<List<BaseCategory2>> getCategory2(@PathVariable Long category1Id) {
        return Result.ok(manageService.getBaseCategory2(category1Id));
    }

    @GetMapping("/get-category3/{category2Id}")
    public Result<List<BaseCategory3>> getCategory3(@PathVariable Long category2Id) {
        return Result.ok(manageService.getBaseCategory3(category2Id));
    }

    @GetMapping("/attr-info-list/{category1Id}/{category2Id}/{category3Id}")
    public Result<List<BaseAttrInfo>> attrInfoList(@PathVariable Long category1Id,
                                                   @PathVariable Long category2Id,
                                                   @PathVariable Long category3Id) {
        return Result.ok(manageService.getBaseAttrInfoList(category1Id, category2Id, category3Id));
    }

    @GetMapping("/get-attr-value-list/{attrId}")
    public Result<List<BaseAttrValue>> attrValueList(@PathVariable Long attrId) {
        return Result.ok(manageService.getBaseAttrValueList(attrId));
    }

    @PostMapping("/save-attr-info")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {
        manageService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }

}
