package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huyilong
 * @create 2020-11-29 17:34
 */
@Mapper
public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo>{

    List<BaseAttrInfo> selectAttrInfoList(@Param("category_level")int categoryLevel ,@Param("category_id") Long category3Id);
}
