package cn.itcast.redis;

import cn.itcast.redis.utils.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Author: badbad
 * @Date: 2019/9/5 18:24
 * @Version 1.0
 */
public class RedisDemo1 {

    @Test
    public void demo1(){
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("username","leijun");

    }

    @Test
    public void demo2(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.set("name","mayun");
    }
}
