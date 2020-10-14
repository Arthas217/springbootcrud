package com.hlj.jixi.repository;

import com.hlj.jixi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 继承JpaRepository完成DB操作
 *
 * @Author zc217
 * @Date 2020/10/14
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
