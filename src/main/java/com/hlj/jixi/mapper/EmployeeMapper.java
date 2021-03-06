package com.hlj.jixi.mapper;

import com.hlj.jixi.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * 配置版本mapper
 *
 * @Mapper将接口扫描装配到容器中
 * @Author zc217
 * @Date 2020/10/14
 */
@Mapper
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);

    void updateEmp(Employee employee);

    void deleteEmp(Integer id);
}
