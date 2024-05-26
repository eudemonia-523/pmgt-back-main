package com.pmgt.krish.service;

import com.pmgt.krish.entity.User;
import com.pmgt.krish.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 可以根据需要添加其他方法，比如根据 ID 获取用户、保存用户等
}