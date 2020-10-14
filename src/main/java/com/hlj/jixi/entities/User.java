package com.hlj.jixi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * 使用JPA注解
 * 配置映射关系
 *
 * @Author zc217
 * @Date 2020/10/14
 */
@Entity //和数据表映射的类（不简单的是一个实体类了）
@Table(name = "tb_user") //默认不写，name= 表名
public class User {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增
    @NotFound(action = NotFoundAction.IGNORE)
    private Integer id;
    @Column(name = "last_name", length = 50) //对应数据表一个列
    private String lastName;
    @Column
    private String email;//省略列名就是属性名

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
