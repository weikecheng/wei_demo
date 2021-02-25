package com.example.datasousserdemo.user;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 用户数据源
 *      Config
 * @author yys
 */
@Configuration
@MapperScan(basePackages = "com.example.datasousserdemo.user.mapper", sqlSessionTemplateRef = "userSqlSessionTemplate")
public class UserDataSourceConfig {

    /**
     * 创建 XADataSource
     * @return
     */
    @Bean("userDataSource")
    public DataSource userDataSource(UserConfig userConfig) throws SQLException {
        // 1、创建Mysql XADataSource
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(userConfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(userConfig.getPassword());
        mysqlXaDataSource.setUser(userConfig.getUserName());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        // 2、将本地事务注册到 Atomikos 全局事务
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName(userConfig.getUniqueResourceName());
        xaDataSource.setMinPoolSize(userConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(userConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(userConfig.getMaxLifeTime());
        xaDataSource.setBorrowConnectionTimeout(userConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(userConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(userConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(userConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(userConfig.getTestQuery());

        return xaDataSource;
    }

    /**
     * 创建 SQL会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean("userSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 创建用户 SqlSession模板
     * @param sqlSessionFactory
     * @return
     */
    @Bean("userSqlSessionTemplate")
    public SqlSessionTemplate userSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}