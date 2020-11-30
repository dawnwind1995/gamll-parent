package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.Result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.product.service.SpuService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-30 11:55
 */
@RequestMapping("admin/product/")
@RestController
@CrossOrigin
public class SpuApiController {
    @Autowired
    SpuService spuService;

    /**
     * 获取spu分页列表
     * @param pageNo
     * @param size
     * @param category3Id
     * @return
     */
    @GetMapping("{pageNo}/{size}")
    public Result getSpuListPage(@PathVariable("pageNo")Long pageNo,
                             @PathVariable("size")Long size,
                             Long category3Id){
        Page<SpuInfo> page = new Page<>(pageNo, size);
        IPage<SpuInfo> spuListPage = spuService.getSpuListPage(page, category3Id);
        return Result.ok(spuListPage);
    }

    /**
     * 添加spu信息
     * @param spuInfo
     * @return
     */
    @PostMapping("saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfo  spuInfo){
        spuService.saveSpuInfo(spuInfo);
        return Result.ok();
    }


}
