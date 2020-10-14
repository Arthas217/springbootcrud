package com.hlj.jixi.control;

import com.hlj.jixi.bean.Department;
import com.hlj.jixi.bean.Employee;
import com.hlj.jixi.mapper.DepartmentMapper;
import com.hlj.jixi.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zc217
 * @Date 2020/10/14
 */
@RestController
public class DepartmentAndEmployeeControl {

    @Autowired
    DepartmentMapper departmentMapper;

    //http://localhost:8080/department/1
    @GetMapping("/department/{id}")
    public Department getDept(@PathVariable("id") Integer id) {
        return departmentMapper.getDeptById(id);
    }

    // http://localhost:8080/departmentinsert?departmentName=AA
    @GetMapping("/departmentinsert")
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/employee/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id) {
        return employeeMapper.getEmpById(id);
    }
}
