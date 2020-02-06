package com.wkcto;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App02 {
    public static void main( String[] args ) {


        //创建jedis对象, 通过ip及端口号连接服务器(Linux需要先关闭防火墙)
        //Jedis jedis = new Jedis("192.168.159.128",6379);

        JedisPool pool = RedisUtils.open("192.168.159.128",6379 );

        Jedis jedis = pool.getResource();

        jedis.flushAll();//清空数据库

        /*jedis.hset("hset1", "str1", "abc");

        String str1 = jedis.hget("hset1", "str1");

        System.out.println(str1);*/

        Map<String, String> map = new HashMap<>();
        map.put("id", "A001");
        map.put("name", "zhangsan");
        map.put("age", "21");

        jedis.hmset("student", map);

        List<String> sList = jedis.hmget("student", "id", "name", "age");

        for (String s : sList) {
            System.out.println(s);
        }

        pool.close();

    }
}
