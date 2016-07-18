package com.example.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisTemplateProxyConfig
{

    @Value("${spring.redis.shard}")
    private String redisShard;

    @Value("${spring.redis.repo.num}")
    private int numberOfReplicas;

    @Value("${spring.redis.pool.max-active}")
    private int maxTotal;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.pool.max-wait}")
    private int maxWaitMillis;

    @Bean
    public RedisTemplateProxy redisTemplateProxy()
    {
        RedisTemplateProxy proxy = new RedisTemplateProxy();
        proxy.setRedisShard(this.redisShard);
        proxy.setNumberOfReplicas(this.numberOfReplicas);
        proxy.setMaxTotal(this.maxTotal);
        proxy.setMaxIdle(this.maxIdle);
        proxy.setMinIdle(this.minIdle);
        proxy.setMaxWaitMillis(this.maxWaitMillis);
        proxy.init();
        return proxy;
    }
}