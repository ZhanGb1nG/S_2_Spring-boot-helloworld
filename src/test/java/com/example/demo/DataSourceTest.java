package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.List;
import java.util.Map;


/**
 * @Author ZhanG_b1nG
 * @Date 2021/8/22 10:42
 * @Version 1.0
 **/
//加上这两个注解，运行测试方法的时候就会启动SpringBoot
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDbType() {
        System.out.println("自动装配数据源类型：" + dataSource.getClass());
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbc() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from ums_role");
        System.out.println(maps.toString());
    }

}
