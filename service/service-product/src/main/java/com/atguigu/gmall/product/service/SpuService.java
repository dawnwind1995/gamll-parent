package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-30 12:18
 */
public interface SpuService {
    IPage<SpuInfo> getSpuListPage(Page<SpuInfo> spuInfoPage, Long category3Id);

    void saveSpuInfo(SpuInfo spuInfo);
}
