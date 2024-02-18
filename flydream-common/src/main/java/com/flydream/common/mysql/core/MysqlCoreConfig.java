package com.flydream.common.mysql.core;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Getter
@Setter
/*
@Configuration是Spring框架中的一个注解，用于标记一个类作为配置类。配置类通常包含一些Bean的创建和配置信息，这些Bean可以在其他地方通过依赖注入的方式使用。
 */
@Configuration
/**
 *@ConfigurationProperties(prefix = "mysql.core")是Spring Boot中的一个注解，用于将配置文件中的属性绑定到Java类上。
 * 在这个例子中，它将配置文件中以"mysql.core"为前缀的属性绑定到Java类上。
 */
@ConfigurationProperties(prefix = "mysql.core")
/**
 * 是Spring Boot中的一个注解，用于指定配置文件的位置。在这个例子中，它将在类路径下查找名为"mysql-core-jdbc.properties"的配置文件。
 */
@PropertySource("classpath:mysql-core-jdbc.properties")
/**
 * 是Spring Boot中的一个注解，用于扫描指定包下的接口并自动创建对应的实现类。通常与MyBatis框架一起使用。
 */
@MapperScan(basePackages = "com.flydream.model.mappers",sqlSessionFactoryRef = "mysqlCoreSessionFactory")
public class MysqlCoreConfig {

    String jdbcUrl;
    String jdbcUserName;
    String jdbcPassword;
    String jdbcDriver;
    String rootMapper;//mapper文件在classpath下存放的根路径
    String aliasesPackage;//别名包

    /**
     * 设置一个数据库的连接池
     * 是Spring框架中的一个注解，用于定义一个Bean。
     */
    @Bean("mysqlCoreDataSource")
    public DataSource mysqlCoreDataSource(){
        //HikariDataSource是一个高性能的JDBC连接池，用于管理数据库连接。
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(this.getJdbcUserName());
        dataSource.setPassword(this.getRealPassword());
        dataSource.setJdbcUrl(this.getJdbcUrl());
        dataSource.setDriverClassName(this.getJdbcDriver());
        //最大连接数
        dataSource.setMaximumPoolSize(50);
        //最小连接数
        dataSource.setMinimumIdle(5);
        return dataSource;
    }

    /**
     * 密码反转操作
     */
    public String getRealPassword(){
        String jdbcPassword = this.getJdbcPassword();//123456
        String reverse = StringUtils.reverse(jdbcPassword);//654321
        return  reverse;
    }

    /**
     * 整合mybatis  SqlSessionFactoryBean
     * 用于指定要注入的Bean的名称。在这个例子中，它指定了要注入名为 "mysqlCoreDataSource" 的Bean。
     */
    @Bean("mysqlCoreSessionFactory")
    public SqlSessionFactoryBean mysqlCoreSessionFactory(@Qualifier("mysqlCoreDataSource") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //数据源
        factoryBean.setDataSource(dataSource);
        //别名
//        factoryBean.setTypeAliasesPackage(this.getAliasesPackage());
        //mapper文件存储的位置
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(this.getMapperFilePath());
        factoryBean.setMapperLocations(resources);
        //开启驼峰标识  user_name  --  》 userName
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        return factoryBean;
    }
    /**
     * 拼接mapper.xml文件的存储位置
     */
    public String getMapperFilePath(){
        return new StringBuffer("classpath:").append(this.getRootMapper()).append("/**/*.xml").toString();
    }
}
