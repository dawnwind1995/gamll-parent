package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.*;
import com.atguigu.gmall.product.mapper.*;
import com.atguigu.gmall.product.service.SpuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-30 12:19
 */
@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    SpuInfoMapper spuInfoMapper;
    @Autowired
    SpuPosterMapper spuPosterMapper;
    @Autowired
    SpuSaleAttrMapper spuSaleAttrMapper;
    @Autowired
    SpuSaleAttrValueMapper spuSaleAttrValueMapper;
    @Autowired
    SpuImageMapper spuImageMapper;


    @Override
    public IPage<SpuInfo> getSpuListPage(Page<SpuInfo> spuInfoPage, Long category3Id) {
        QueryWrapper<SpuInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("category3_id", category3Id);
        IPage<SpuInfo> spuInfoIPage = spuInfoMapper.selectPage(spuInfoPage, wrapper);
        return spuInfoIPage;
    }

    @Override
    public void saveSpuInfo(SpuInfo spuInfo) {
        //1.向spu_info表中存储spuName,description,category3Id,tmId信息
        if(spuInfo==null){
            return;
        }
        spuInfoMapper.insert(spuInfo);
        Long spuId = spuInfo.getId();
        //2.向spu_image表中添加spuId,spuImageList.imgName,spuImageList.imgUrl
        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        if(null!=spuImageList) {
            for (SpuImage spuImage : spuImageList
            ) {
                spuImage.setSpuId(spuId);
                spuImageMapper.insert(spuImage);
            }
        }
        //3.向spu_sale_attr表中添加spuId,spuSaleAttrList.baseSaleAttrId,spuSaleAttrList.saleAttrName
        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        if(null!=spuSaleAttrList) {
            for (SpuSaleAttr spuSaleAttr : spuSaleAttrList
            ) {
                spuSaleAttr.setSpuId(spuId);
                spuSaleAttrMapper.insert(spuSaleAttr);
                String saleAttrName = spuSaleAttr.getSaleAttrName();
                //4.向spu_sale_attr_value表中添加
                // spuId,
                //spuSaleAttrList.saleAttrName
                // spuSaleAttrList.spuSaleAttrValueList.baseSaleAttrId
                //spuSaleAttrList.spuSaleAttrValueList.saleAttrValueName
                List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
                if(null!=spuSaleAttrValueList) {
                    for (SpuSaleAttrValue spuSaleAttrValue : spuSaleAttrValueList
                    ) {
                        spuSaleAttrValue.setSpuId(spuId);
                        spuSaleAttrValue.setSaleAttrName(saleAttrName);
                        spuSaleAttrValueMapper.insert(spuSaleAttrValue);
                    }
                }
            }
        }

    }
}
