package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseAttrValue;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-29 19:03
 */
public interface BaseAttrValueService {
    List<BaseAttrValue> getAttrValueList(Long attrId);
}
