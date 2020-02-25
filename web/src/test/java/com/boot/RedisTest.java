package com.boot;

import com.boot.support.RedisRepository;
import com.support.AbstractSpringbootTest;
import org.junit.Assert;
import org.junit.Test;
import javax.annotation.Resource;

/**
 * @author jinjunzhu
 * @date 2020/2/25
 */
public class RedisTest extends AbstractSpringbootTest {

    @Resource
    private RedisRepository redisRepository;

    @Test
    public void testRedis(){
        redisRepository.set("testKey", "testValue");
        Assert.assertEquals("testValue", (String) redisRepository.get("testKey"));
    }
}
