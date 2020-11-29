package com.atguigu.gmall.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author huyilong
 * @create 2020-11-28 13:10
 */
@Data
public class BaseEntity implements Serializable {
    @Id
    @TableId(type = IdType.AUTO)
    private Long id;
}
