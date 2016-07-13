package com.example.config;

/**
 * Created by Administrator on 2016/7/13.
 */
import java.util.Arrays;
import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DynamicDataSourceConfig {
    @Value("${datasource.default.name}")
    private String dataSourceDefaultName;
    @Value("${datasource.master.name}")
    private String dataSourceMasterName;
    @Value("${datasource.slaves.name}")
    private String dataSourceSlavesName;

    public DynamicDataSourceConfig() {
    }

    @Bean(
            name = {"masterDataSource"}
    )
    @ConfigurationProperties(
            prefix = "datasource.master"
    )
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(
            name = {"slave1DataSource"}
    )
    @ConfigurationProperties(
            prefix = "datasource.slave1"
    )
    public DataSource slave1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(
            name = {"dynamicDataSource"}
    )
    @Primary
    public DataSource dynamicDataSource(@Qualifier("masterDataSource") DataSource masterDataSource, @Qualifier("slave1DataSource") DataSource slave1DataSource) {
        DynamicDataSource ds = new DynamicDataSource();
        HashMap targetDataSources = new HashMap();
        targetDataSources.put("master", masterDataSource);
        targetDataSources.put("slave1", slave1DataSource);
        ds.setTargetDataSources(targetDataSources);
        ds.setDefaultTargetDataSource(targetDataSources.get(this.dataSourceDefaultName));
        DynamicDataSource.setMasterDataSourceName(this.dataSourceMasterName);
        DynamicDataSource.setSlaveDataSourceNames(Arrays.asList(this.dataSourceSlavesName.split(",")));
        DynamicDataSource.setDefaultDataSourceName(this.dataSourceDefaultName);
        return ds;
    }
}

