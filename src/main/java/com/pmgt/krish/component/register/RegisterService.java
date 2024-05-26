package com.pmgt.krish.component.register;


import com.pmgt.krish.common.ResultData;
import com.pmgt.krish.entity.User;
import com.pmgt.krish.enums.ResultState;
import com.pmgt.krish.repository.UserRepository;
import com.pmgt.krish.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    public ResultData<User> register(RegisterParam registerParam) {
        log.info("register param: {}", registerParam);
        ResultData<User> resultData = new ResultData<>();
        User result = new User();
        User user = new User();
        user.setEmail(registerParam.getEmail());
        user.setPassword(registerParam.getPassword());
        user.setDisplayName(registerParam.getFirstName()+" "+registerParam.getLastName());
        user.setUserId(UUID.randomUUID().toString());
        user.setPublic(true);
        result = userRepository.save(user);
        log.info(result.toString());
        resultData.setStatus(ResultState.SUCCESS.getResultCode());
        resultData.setMessage(ResultState.SUCCESS.getResultMessage());
        resultData.setData(result);
        resultData.setProp(JwtTokenUtil.generateToken(result.getUserId()));
        return resultData;
    }

}