package com.example.demo.controller;

import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.pojo.Employee;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ZhanG_b1nG
 * @Date 2021/8/31 16:32
 * @Version 1.0
 **/
@RestController
public class MybatisController {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private EmployeeMapper deptMapper;

    /**
     * http://localhost:8080/zhangbingbing/list/all
     * 
     * @param 
     * @return java.lang.Object
     * @Author ZhanG_b1nG 
     * @Date 2021/8/31 17:20
     */
    @RequestMapping("/list/all")
    public Object listAll() {
//        sqlSessionTemplate.selectList(toString())
        return deptMapper.list();
    }

    /**
     * http://localhost:8080/zhangbingbing/find/2
     * 
     * @param id
     * @return java.lang.Object
     * @Author ZhanG_b1nG 
     * @Date 2021/8/31 17:20
     */
    @RequestMapping("/find/{id}")
    public Object listAll(@PathVariable("id") String id) {
        return deptMapper.findOne(Integer.valueOf(id));
    }

    /**
     * http://localhost:8080/zhangbingbing/insert/wangwu
     * 
     * @param name
     * @return java.lang.Object
     * @Author ZhanG_b1nG 
     * @Date 2021/8/31 17:21
     */
    @RequestMapping("/insert/{name}")
    public Object insert(@PathVariable("name") String name) {
        Employee employee = new Employee();
        employee.setLastName(name);
        employee.setDeptId(6);
        employee.setEmail(name + "@163.com");
        return deptMapper.save(employee);
    }
}
