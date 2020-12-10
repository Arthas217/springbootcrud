package com.hlj.jixi.control;

import com.hlj.jixi.bean.Department;
import com.hlj.jixi.bean.Employee;
import com.hlj.jixi.mapper.DepartmentMapper;
import com.hlj.jixi.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 注解版mapper及配置文件版本实现的control
 * DB-mybatis-两张表
 *
 * @Author zc217
 * @Date 2020/10/14
 */
@RestController
public class DepartmentAndEmployeeControl {

    // 注解版本
    @Autowired
    DepartmentMapper departmentMapper;
    // 配置文件版本
    @Autowired
    EmployeeMapper employeeMapper;

    //http://localhost:8080/department/1
    @GetMapping("/department/{id}")
    public Department getDept(@PathVariable("id") Integer id) {
        System.out.println("-------------------全注解版本-查询部门" + id);
        return departmentMapper.getDeptById(id);
    }

    // http://localhost:8080/departmentinsert?departmentName=AA
    @GetMapping("/departmentinsert")
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }

    // http://localhost:8080/employee/1
    @GetMapping("/employee/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id) {
        System.out.println("-------------------配置文件版本-查询雇员" + id);
        return employeeMapper.getEmpById(id);
    }
}
