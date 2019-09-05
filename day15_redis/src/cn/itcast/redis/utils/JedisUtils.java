package cn.itcast.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: badbad
 * @Date: 2019/9/5 18:59
 * @Version 1.0
 */
public class JedisUtils {

    private static JedisPool pool;

    static {
        Properties prop = new Properties();
        try {
            //1.加载配置文件
            prop.load(JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties"));

            //2.创建连接池配置对象
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
            config.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
            //3.new 连接池
            pool = new JedisPool(config,prop.getProperty("host"),
                         Integer.parseInt(prop.getProperty("port"))
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     */
    public static Jedis getJedis(){
        return  pool.getResource();
    }
}
