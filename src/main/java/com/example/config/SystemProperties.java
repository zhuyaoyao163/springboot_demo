package com.example.config;

/**
 * Created by Administrator on 2016/7/13.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class SystemProperties {
    private static SystemProperties instance = new SystemProperties();
    private Properties properties = new Properties();

    public static SystemProperties getInstance() {
        return instance;
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    private SystemProperties() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("conf/system.properties");

        try {
            if(inputStream != null) {
                this.properties.load(new InputStreamReader(inputStream, "UTF-8"));
            }
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }
}

