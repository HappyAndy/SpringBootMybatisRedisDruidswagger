package com.jiaqi.config.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/30.
 */

@Configuration
public class RedisConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${cluster.datasource.url}")
    private String dbUrl;


    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig createJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        // 可优化为读取配置文件，此处简化
        jedisPoolConfig.setMaxTotal(2048);
        jedisPoolConfig.setMaxIdle(200);
        jedisPoolConfig.setNumTestsPerEvictionRun(1024);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(30000);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(-1);
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(10000);
        jedisPoolConfig.setMaxWaitMillis(1500);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setTestOnReturn(true);
        jedisPoolConfig.setJmxEnabled(true);
        jedisPoolConfig.setBlockWhenExhausted(false);

        return jedisPoolConfig;
    }


    @Bean(name = "shardedJedisPool")
    public ShardedJedisPool createShardedJedisPool() {
        List jediInfos = new ArrayList();
        // 此处读取配置文件 ,  主机地址， 端口， 超时时间
        JedisShardInfo jedisShardInfo = new JedisShardInfo("127.0.0.1", 6379, 10000);
        jediInfos.add(jedisShardInfo);

        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(createJedisPoolConfig(), jediInfos);

        return shardedJedisPool;
    }

    @Bean(name = "redisDataSource")
    public RedisDataSourceImpl createRedisDataSource() {
        RedisDataSourceImpl redisDataSource = new RedisDataSourceImpl();
        redisDataSource.setShardedJedisPool(createShardedJedisPool());
        return redisDataSource;
    }


    @Bean(name = "redisClientTemplate")
    public RedisClientTemplate createClientTemplate() {
        RedisClientTemplate redisClientTemplate = new RedisClientTemplate();
        redisClientTemplate.setRedisDataSource(createRedisDataSource());
        return redisClientTemplate;
    }


}
