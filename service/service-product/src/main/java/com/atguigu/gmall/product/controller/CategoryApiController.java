package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.common.Result.Result;
import com.atguigu.gmall.model.product.BaseCategory1;

import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.service.BaseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-27 23:36
 */
@RequestMapping("admin/product")
@RestController
@CrossOrigin
public class CategoryApiController
{
    @Autowired
    private BaseCategoryService baseCategoryService;
    //一级分类
    @GetMapping("getCategory1")
    public Result getCategory1(){
        List<BaseCategory1> baseCategory1List =baseCategoryService.getCategory1();
        return Result.ok(baseCategory1List);
    }
    //二级分类
    @GetMapping("getCategory2/{category1Id}")
    public Result getCategory2(@PathVariable("category1Id") Long  category1Id){
        List<BaseCategory2> baseCategory2List =baseCategoryService.getCategory2(category1Id);
        return Result.ok(baseCategory2List);
    }
    //三级分类
    @GetMapping("getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable("category2Id") Long  category2Id){
        List<BaseCategory3> baseCategory3List =baseCategoryService.getCategory3(category2Id);
        return Result.ok(baseCategory3List);
    }
}
