package com.hlj.jixi.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @Author zc217
 * @Date 2020/12/10
 */
@Controller
public class Template {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;

    /**
     * jdbc+druid 主要是测试druid中sql监控
     * http://localhost:8080/query
     */
    @GetMapping("/query")
    @ResponseBody
    public Map<String, Object> queryDep() {
        System.out.println("------------------------" + dataSource.getClass());
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
        return list.get(0);
    }

}
