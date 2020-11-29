package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseAttrInfo;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-29 17:31
 */
public interface BaseAttrInfoService {
    List<BaseAttrInfo> attrInfoList(Long category3Id);

    void saveAttrInfo(BaseAttrInfo baseAttrInfo);
}
