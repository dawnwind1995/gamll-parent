package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.Result.Result;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-30 14:22
 */
@RequestMapping("admin/product/")
@RestController
@CrossOrigin
public class TrademarkApiController {
    @Autowired
    BaseTrademarkService baseTrademarkService;

    /**
     * 获取品牌属性
     * @return
     */
    @GetMapping("baseTrademark/getTrademarkList")
    public Result getTrademarkList(){
        List<BaseTrademark> baseTrademarks =  baseTrademarkService.getTrademarkList();
        return Result.ok(baseTrademarks);
    }
}
