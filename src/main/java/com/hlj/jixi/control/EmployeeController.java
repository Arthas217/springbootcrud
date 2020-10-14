package com.hlj.jixi.control;

import com.hlj.jixi.dao.DepartmentDao;
import com.hlj.jixi.dao.EmployeeDao;
import com.hlj.jixi.entities.Department;
import com.hlj.jixi.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 查询所有员工emps GET
 * 查询某个员工(来到修改页面)emp/ 1GET
 * 来到添加页面emp GET
 * 添加员工emp POST
 * 来到修改页面（查出员工进行信息回显）emp/1 GET
 * 修改员工emp PUT
 * 删除员工emp/1 DELETE
 *
 * @Author zc217
 * @Date 2020/9/4
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    /**
     * 查询员工列表
     */
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "list";
    }


    @Autowired
    DepartmentDao departmentDao;

    /**
     * 添加页面
     */
    @GetMapping("/emp")
    public String addPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "add";
    }

    // springmvc 参数和对象绑定 （页面标签中的name和employyee对象中的属性名一致）
    @PostMapping("/emp")
    public String addEmployee(Employee employee) {
        //重定向到一个地址（员工列表页的请求地址）
        System.out.println("添加员工信息："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    /**
     * 修改页面
     */
    @GetMapping("/emp/{id}")
    public String updatePage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee );
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改员工信息"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
