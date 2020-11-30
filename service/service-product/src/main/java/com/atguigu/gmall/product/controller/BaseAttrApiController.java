package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.Result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;

import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.service.BaseAttrValueService;
import com.atguigu.gmall.product.service.BaseSaleAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-29 17:18
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class BaseAttrApiController {
    @Autowired
    private BaseAttrInfoService baseAttrInfoService;
    @Autowired
    private BaseAttrValueService baseAttrValueService;
    @Autowired
    private BaseSaleAttrService baseSaleAttrService;

    /**
     * 根据分类id查询平台属性列表
     * @param category3Id
     * @return
     */
    @GetMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result attrInfoList(@PathVariable("category3Id") Long category3Id){
        List<BaseAttrInfo> baseAttrInfos = baseAttrInfoService.attrInfoList(category3Id);
        return Result.ok(baseAttrInfos);
    }

    /**
     *添加/修改平台属性
     * @param baseAttrInfo
     * @return
     */
    @PostMapping("saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        baseAttrInfoService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }

    /**
     * 根据平台属性ID获取平台属性
     * @param attrId
     * @return
     */
    @GetMapping("getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable("attrId")Long attrId){
        List<BaseAttrValue> baseAttrValues = baseAttrValueService.getAttrValueList(attrId);
        return Result.ok(baseAttrValues);
    }

    /**
     * 获取销售属性
     * @return
     */
   @GetMapping("baseSaleAttrList")
    public Result baseSaleAttrList(){
        List<BaseSaleAttr> baseSaleAttrs =baseSaleAttrService.baseSaleAttrList();
        return Result.ok(baseSaleAttrs);
   }
}
