package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.product.mapper.BaseAttrValueMapper;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-29 17:32
 */
@Service
public class BaseAttrInfoServiceImpl implements BaseAttrInfoService {
    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;
    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;
    @Override
    public List<BaseAttrInfo> attrInfoList(Long category3Id) {
        return baseAttrInfoMapper.selectAttrInfoList(3,category3Id);
//        QueryWrapper<BaseAttrInfo> wrapper = new QueryWrapper<>();
//        wrapper.eq("category_id",category3Id);
//        wrapper.eq("category_level",3);
//        List<BaseAttrInfo> baseAttrInfos = baseAttrInfoMapper.selectList(wrapper);
//        for (BaseAttrInfo baseAttrInfo: baseAttrInfos
//             ) {
//            Long attrId = baseAttrInfo.getId();
//            QueryWrapper<BaseAttrValue> attrValueWrapper = new QueryWrapper<>();
//            attrValueWrapper.eq("attr_id",attrId);
//            List<BaseAttrValue> baseAttrValues = baseAttrValueMapper.selectList(attrValueWrapper);
//            baseAttrInfo.setAttrValueList(baseAttrValues);
//        }
//        return baseAttrInfos;
    }

    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        Long id = baseAttrInfo.getId();
        if (null==id || id<=0){
            //保存
            int insert = baseAttrInfoMapper.insert(baseAttrInfo);
            id = baseAttrInfo.getId();
        }else{
            //更新
            baseAttrInfoMapper.updateById(baseAttrInfo);
            QueryWrapper<BaseAttrValue> wrapper = new QueryWrapper<>();
            wrapper.eq("attr_id",id);
            baseAttrValueMapper.delete(wrapper);
        }
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue baseAttrValue: attrValueList
        ) {
            baseAttrValue.setAttrId(id);
            baseAttrValueMapper.insert(baseAttrValue);
        }
    }


}
