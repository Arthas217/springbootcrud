package com.hlj.jixi.mapper;

import com.hlj.jixi.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * 全注解版本：定义一个操作DB的mapper
 * 由MybatisAutoConfiguration自动配置实现
 *
 * @Author zc217
 * @Date 2020/10/14
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    int deleteDept(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id ")
    @Insert("insert into department(department_name) values (#{departmentName})")
    int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    int updateDept(Department department);
}


