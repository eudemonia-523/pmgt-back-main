package com.pmgt.krish.controller;


import com.pmgt.krish.entity.User;
import com.pmgt.krish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 可以根据需要添加其他控制器方法，比如根据 ID 获取用户等
}
