package com.lms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = ConfigManager.class.getClassLoader().getResourceAsStream("config/config.properties")) {
            if (in != null) {
                props.load(in);
            } else {
                throw new RuntimeException("config.properties not found in classpath under config/");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    public static String get(String key) {
        String sys = System.getProperty(key);
        if (sys != null && !sys.isBlank()) return sys;
        String env = System.getenv(key);
        if (env != null && !env.isBlank()) return env;
        return props.getProperty(key);
    }

    public static String getBaseUrl() {
        return get("baseUrl");
    }
}
