package com.wkcto;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Hello world!
 *
 */
public class App01 {
    public static void main( String[] args ) {


        //创建jedis对象, 通过ip及端口号连接服务器(Linux需要先关闭防火墙)
        //Jedis jedis = new Jedis("192.168.159.128",6379);

        JedisPool pool = RedisUtils.open("192.168.159.128",6379 );

        Jedis jedis = pool.getResource();

        jedis.flushAll();//清空数据库

        jedis.set("str1", "aaa");

        String str1 = jedis.get("str1");

        System.out.println(str1);

        jedis.append("str1", "bbb");//追加3个b

        String str2 = jedis.get("str1");

        System.out.println(str2);

        pool.close();


    }
}
