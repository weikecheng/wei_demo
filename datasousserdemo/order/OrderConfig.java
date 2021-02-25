package com.example.datasousserdemo.order;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component

//@EnableConfigurationProperties(OrderConfig.class)
@ConfigurationProperties(prefix = "spring.datasource.order")
//@ConfigurationProperties(prefix = OrderConfig.PREFIX, ignoreInvalidFields = true)
@Data
public class OrderConfig {
//    public static final String PREFIX = "spring.datasource.order"; // 这里对应配置文件中的mail前缀

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