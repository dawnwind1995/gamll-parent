package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-29 16:40
 */
public interface BaseCategoryService {
    List<BaseCategory1> getCategory1();
    List<BaseCategory2> getCategory2(Long category1Id);
    List<BaseCategory3> getCategory3(Long category2Id);
}
