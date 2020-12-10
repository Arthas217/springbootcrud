package com.hlj.jixi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 测试springboot数据源
 * 注意测试时需要把DruidConfig类的注入去掉
 */
@SpringBootTest
class SpringbootcrudApplicationTests {

    @Autowired
    DataSource dataSource;


    /**
     *  jdbc自动配置原理就在org.springframework.boot.autoconfigure.jdbc包下
     *  1. DataSourceConfiguration：根据配置创建数据源 （tomcat jdbc 、hikari、dbcp2、及自定义Generic--反射)
     *  2. DataSourceInitializer： 执行脚本sql语句
     *          方法createSchema()  schema、initialization-mode
     *          方法runScripts()
     *  3.JdbcTemplateConfiguration  操作数据库
     */
    @Test
    void testDataSource() throws SQLException {
        // 在配置文件中添加 type: org.apache.tomcat.jdbc.pool.DataSource
        // springboot1.x 默认数据源class org.apache.tomcat.jdbc.pool.DataSource
        // springboot2.0 默认数据源class com.zaxxer.hikari.HikariDataSource
        System.out.println("------------------------" + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        // ProxyConnection[PooledConnection[com.mysql.cj.jdbc.ConnectionImpl@5d7d8613]]
        // HikariProxyConnection@1963943166 wrapping com.mysql.cj.jdbc.ConnectionImpl@996a546
        System.out.println("------------------------" + connection);
        connection.close();
    }

}
