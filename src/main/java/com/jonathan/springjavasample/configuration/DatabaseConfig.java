package com.jonathan.springjavasample.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Setter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    private final ApplicationContext applicationContext;

    public DatabaseConfig(@Autowired ApplicationContext context){
        applicationContext = context;
    }

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.hikari")
    public HikariConfig hikariConfig(){
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() throws Exception{
        //simply check if data source is successfully created
        DataSource ds = new HikariDataSource(hikariConfig());
        System.out.println(ds);
        return ds;
    }

    //for MyBatis
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds, org.apache.ibatis.session.Configuration config) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        bean.setMapperLocations(
                applicationContext.getResources("classpath:/mapper/**/sql-*.xml")
        );
        bean.setConfiguration(config);
        return bean.getObject();
    }

    //for MyBatis
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }

    @Bean
    @ConfigurationProperties(prefix="mybatis.configuration")
    public org.apache.ibatis.session.Configuration mybatisConfig(){
        return new org.apache.ibatis.session.Configuration();
    }
}
