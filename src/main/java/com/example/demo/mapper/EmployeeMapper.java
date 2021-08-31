package com.example.demo.mapper;

import com.example.demo.pojo.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author ZhanG_b1nG
 * @Date 2021/8/31 16:15
 * @Version 1.0
 **/
@Mapper
public interface EmployeeMapper {
    @Select("select * from employee")
    List<Employee> list();

    @Select("select * from employee where id=#{id}")
    Employee findOne(Integer id);

    @Options(useGeneratedKeys =true,keyProperty = "id")
    @Insert("insert into employee(last_name,email,gender,dept_id)values(#{lastName},#{email},#{gender},#{deptId})")
    int save(Employee employee);

}
