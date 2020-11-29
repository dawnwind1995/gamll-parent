package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.common.Result.Result;
import com.atguigu.gmall.model.product.BaseCategory1;

import com.atguigu.gmall.product.service.BaseCategory1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-27 23:36
 */
@RequestMapping("admin/product")
@RestController
@CrossOrigin
public class CategoryApiController {
    @Autowired
    private BaseCategory1Service baseCategory1Service;
    @GetMapping("getCategory1")
    public Result getCategory1(){
        List<BaseCategory1> baseCategory1List =baseCategory1Service.getCategory1();
        return Result.ok(baseCategory1List);
    }
}
