package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.product.mapper.BaseCategory1Mapper;
import com.atguigu.gmall.product.service.BaseCategory1Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-28 13:01
 */
@Service
public class BaseCategory1ServiceImpl implements BaseCategory1Service {
    @Autowired
    private BaseMapper baseMapper;
    @Override
    public List<BaseCategory1> getCategory1() {
        List baseCategory1List = baseMapper.selectList(null);
        return baseCategory1List;
    }
}
