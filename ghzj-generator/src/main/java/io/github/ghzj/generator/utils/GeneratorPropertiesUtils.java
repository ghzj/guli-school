package io.github.ghzj.generator.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
@Slf4j
public class GeneratorPropertiesUtils {

    private static final Configuration CONFIGURATION;

    static {
        try {
            CONFIGURATION = new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException("获取配置文件失败，", e);
        }
    }

    public static String getConfigurationString(String name) {
        return CONFIGURATION.getString(name);
    }

    public static String getConfigurationString(String name,String name1) {
        return CONFIGURATION.getString(name,name1);
    }

    public static int getConfigurationInt(String name) {
        return CONFIGURATION.getInt(name);
    }
}
