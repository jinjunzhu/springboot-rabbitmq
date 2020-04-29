package com.boot.support;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author jinjunzhu
 * @date 2020/2/25
 */
//@Repository
public class RedisRepository {

    @Resource
    private RedisTemplate redisTemplate;

    public void set(Object key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    public Object get(Object key){
        return redisTemplate.opsForValue().get(key);
    }
}
