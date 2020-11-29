package com.atguigu.gmall.model.product;


import com.atguigu.gmall.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author huyilong
 * @create 2020-11-28 13:07
 */
@Data
@ApiModel(description = "一级分类")
@TableName(value = "base_category1")
public class BaseCategory1 extends BaseEntity {
        @ApiModelProperty(value = "分类名称")
        @TableField("name")
        private String name;
}
