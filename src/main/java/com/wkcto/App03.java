package com.wkcto;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App03 {
    public static void main( String[] args ) {


        //创建jedis对象, 通过ip及端口号连接服务器(Linux需要先关闭防火墙)
        //Jedis jedis = new Jedis("192.168.159.128",6379);

        JedisPool pool = RedisUtils.open("192.168.159.128",6379 );

        Jedis jedis = pool.getResource();

        jedis.flushAll();//清空数据库

        Transaction tran = jedis.multi();

        tran.set("str1", "aaa");
        tran.set("str2", "bbb");

        List<Object> oList= tran.exec();

        for (Object o : oList) {
            System.out.println(o);
        }



        pool.close();


    }
}
