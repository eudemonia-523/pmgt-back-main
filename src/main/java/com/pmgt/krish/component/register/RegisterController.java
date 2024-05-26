package com.pmgt.krish.component.register;

import com.pmgt.krish.common.ResultData;
import com.pmgt.krish.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResultData<User> registerUser(@RequestBody RegisterParam registerParam) {

        return registerService.register(registerParam);

    }

}