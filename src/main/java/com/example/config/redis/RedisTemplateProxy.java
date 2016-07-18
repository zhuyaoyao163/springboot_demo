package com.example.config.redis;

import com.bbtree.commons.core.hash.ConsistentHash;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

public class RedisTemplateProxy
{
    private String redisShard;
    private int numberOfReplicas;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;
    private int maxWaitMillis;
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisTemplateProxy.class);
    private Map<String, RedisTemplate<String, Object>> templateMap;
    private ConsistentHash<String> consistentHash;

    public RedisTemplateProxy()
    {
        this.templateMap = new HashMap();
    }

    public void init() {
        List shardInfos = initShardInfo();
        initTemplateMap(shardInfos);
        initConsistentHash(this.templateMap.keySet());
    }

    public BoundValueOperations<String, Object> boundValueOps(String key) {
        RedisTemplate redisTemplate = getRedisTemplate(key);
        return redisTemplate.boundValueOps(key);
    }

    public void delete(String key) {
        RedisTemplate redisTemplate = getRedisTemplate(key);
        redisTemplate.delete(key);
    }

    public List<RedisTemplate<String, Object>> listTemplate() {
        return (List)this.templateMap.values().stream().collect(Collectors.toList());
    }

    private List<JedisShardInfo> initShardInfo() {
        return ShardConfig.getShards(this.redisShard);
    }

    private void initTemplateMap(List<JedisShardInfo> shardInfos) {
        for (JedisShardInfo shardInfo : shardInfos) {
            JedisConnectionFactory factory = new JedisConnectionFactory(shardInfo);
            factory.setDatabase(shardInfo.getDb());
            factory.setPoolConfig(jedisPoolConfig());
            factory.afterPropertiesSet();
            RedisTemplate redisTemplate = new RedisTemplate();
            redisTemplate.setConnectionFactory(factory);
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
            redisTemplate.afterPropertiesSet();
            String hostPort = shardInfo.getHost() + ":" + shardInfo.getPort();
            this.templateMap.put(hostPort, redisTemplate);
        }
    }

    private void initConsistentHash(Set<String> nodes) {
        this.consistentHash = new ConsistentHash(this.numberOfReplicas, nodes);
    }

    public RedisTemplate<String, Object> getRedisTemplate(String key) {
        String hostPort = (String)this.consistentHash.get(key);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("redisTemplate boundValueOps key:{}, hostPort:{}", key, hostPort);
        }
        return (RedisTemplate)this.templateMap.get(hostPort);
    }

    private JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(this.maxTotal);
        config.setMaxIdle(this.maxIdle);
        config.setMinIdle(this.minIdle);
        config.setMaxWaitMillis(this.maxWaitMillis);

        return config;
    }

    public void setRedisShard(String redisShard) {
        this.redisShard = redisShard;
    }

    public void setNumberOfReplicas(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }
    private static class ShardConfig {
        private static final String HOST_SEPARATOR = ",";

        static List<JedisShardInfo> getShards(String props) {
            RedisTemplateProxy.LOGGER.debug("load redis shard config:" + props);
            List shardInfoList = new ArrayList();
            String[] propArr = props.split(",");
            for (String prop : propArr) {
                    JedisShardInfo shardInfo = new JedisShardInfo(prop);
                shardInfoList.add(shardInfo);
            }
            return shardInfoList;
        }
    }
}