package com.hlj.jixi.control;

import com.hlj.jixi.entities.User;
import com.hlj.jixi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @Author zc217
 * @Date 2020/10/14
 */
@RestController
public class UserControl {

    @Autowired
    UserRepository userRepository;

    // http://localhost:8080/user/1
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new User();
        }
        return optionalUser.get();
    }

    // http://localhost:8080/user/insert?lastName=zlk&email=123
    @GetMapping("/user/insert")
    public User insertUser(User user) {
        return userRepository.save(user);
    }
}
