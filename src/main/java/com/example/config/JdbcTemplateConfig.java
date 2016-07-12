package com.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2016/7/6.
 */
@Configuration
public class JdbcTemplateConfig {

    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean(name = "slaveDataSource")
//    @ConfigurationProperties(prefix = "datasource.slave")
//    public DataSource slaveDataSource() {
//        return DataSourceBuilder.create().build();
//    }

    @Bean(name = "masterJdbcTemplate")
    public JdbcTemplate masterJdbcTemplate(@Qualifier("masterDataSource") DataSource masterDataSource) {
        return new JdbcTemplate(masterDataSource);
    }

//    @Bean(name = "slaveJdbcTemplate")
//    public JdbcTemplate slaveJdbcTemplate(@Qualifier("slaveDataSource") DataSource slaveDataSource) {
//        return new JdbcTemplate(slaveDataSource);
//    }
}
