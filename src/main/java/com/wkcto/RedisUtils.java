package com.wkcto;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 鹅鹅鹅
 * 2020/1/31
 */
public class RedisUtils {
    //定义连接池对象
    private static JedisPool pool = null;

    //创建连接池
    public static JedisPool open(String host, int port) {

        if (pool == null) {
            //创建连接池对象
            JedisPoolConfig config = new JedisPoolConfig();

            //最大jedis实例数(默认值为8)
            config.setMaxTotal(10);

            //最大空闲连接数, 设置这个可以保留足够的连接, 快速获取连接
            config.setMaxIdle(3);

            //提前检查jedis连接, 取值true表示获取的jedis连接一定是可用的
            config.setTestOnBorrow(true);

            //创建jedis连接池, Redis有访问密码时的使用方式
            pool = new JedisPool(config, host, port);
            //创建jedis连接池, Redis有访问密码时的使用方式
            //参数: jedis配置对象, ip, 端口号,连接超时时间, 访问密码
            //pool = new JedisPool(config, host, port, 6*1000,"123456");


        }

        return pool;

    }

    //关闭连接池
    public static void close() {

        if (pool != null) {

            pool.close();

        }


    }


}
