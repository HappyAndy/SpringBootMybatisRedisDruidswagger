package com.jiaqi.config.jedis;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @Title: RedisDataSourceImpl.java
 * @copyright
 * @Package com.cy.redis
 * @Description: 获取redis客户端实例，通过该实例操作redis数据源
 * @author
 * @date 2016-10-21 下午04:22:54
 */
public class RedisDataSourceImpl implements RedisDataSource{

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(RedisDataSourceImpl.class);

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    public ShardedJedisPool getShardedJedisPool() {
        return shardedJedisPool;
    }

    public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
        this.shardedJedisPool = shardedJedisPool;
    }

    /**
     * 获取redis客户端
     */
    public ShardedJedis getRedisClient() {
        try {
            ShardedJedis shardedJedis=shardedJedisPool.getResource();
            return shardedJedis;
        } catch (Exception e) {
            log.error("getRedisClient ,error",e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将资源返还给pool
     */
    @SuppressWarnings("deprecation")
    public void returnResource(ShardedJedis shardedJedis) {
        shardedJedisPool.returnResource(shardedJedis);

    }

    /**
     * 出现异常后返回资源给pool
     */
    @SuppressWarnings("deprecation")
    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
        if(broken){
            shardedJedisPool.returnBrokenResource(shardedJedis);
        }else{
            shardedJedisPool.returnResource(shardedJedis);
        }

    }

}
