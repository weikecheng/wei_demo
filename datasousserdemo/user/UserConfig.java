package com.example.datasousserdemo.user;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@EnableConfigurationProperties(UserConfig.class)
@ConfigurationProperties(prefix = "spring.datasource.user")
//@ConfigurationProperties(prefix = UserConfig.PREFIX, ignoreInvalidFields = true)
@Data
public class UserConfig {

//    public static final String PREFIX = "spring.datasource.user"; // 这里对应配置文件中的mail前缀

    private String url;

    private String userName;

    private String password;

    private int minPoolSize;

    private int maxPoolSize;

    private int maxLifeTime;

    private int maxIdleTime;

    private int loginTimeout;

    private int maintenanceInterval;

    private int borrowConnectionTimeout;

    private String testQuery;

    private String uniqueResourceName;

}