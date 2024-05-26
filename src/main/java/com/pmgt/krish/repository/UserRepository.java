package com.pmgt.krish.repository;

import com.pmgt.krish.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 这里可以添加自定义的查询方法，Spring Data JPA 将会根据方法名自动生成 SQL 查询
    Optional<User> findByEmail(String email);

    User save(User user);
}