package com.boot.mapper;

import com.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.DependsOn;

/**
 * @author jinjunzhu
 * @date 2020/1/9
 */
@Mapper
@DependsOn("mybatisConfig")
public interface UserMapper {

    User getUserById(Integer id);

}
