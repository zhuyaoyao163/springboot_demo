package com.example.config;

/**
 * Created by Administrator on 2016/7/13.
 */
import java.util.List;
import java.util.Random;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal();
    private static List<String> slaveDataSourceNames;
    private static String masterDataSourceName;
    private static String defaultDataSourceName;
    private static Random random = new Random();

    public DynamicDataSource() {
    }

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

    public static String getSlaveDataSource() {
        return (String)slaveDataSourceNames.get(random.nextInt(slaveDataSourceNames.size()));
    }

    public static void setSlaveDataSourceNames(List<String> slaveDataSourceNames) {
        slaveDataSourceNames = slaveDataSourceNames;
    }

    public static String getDefaultDataSourceName() {
        return defaultDataSourceName;
    }

    public static void setDefaultDataSourceName(String defaultDataSourceName) {
        defaultDataSourceName = defaultDataSourceName;
    }

    public static String getMasterDataSourceName() {
        return masterDataSourceName;
    }

    public static void setMasterDataSourceName(String masterDataSourceName) {
        masterDataSourceName = masterDataSourceName;
    }
}
