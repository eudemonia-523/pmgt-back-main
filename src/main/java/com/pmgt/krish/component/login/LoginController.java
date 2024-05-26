package com.pmgt.krish.component.login;

import com.pmgt.krish.common.ResultData;
import com.pmgt.krish.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResultData<User> LoginUser(@RequestBody User user) {

        return loginService.login(user);

    }

}