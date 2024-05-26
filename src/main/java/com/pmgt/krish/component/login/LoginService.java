package com.pmgt.krish.component.login;

import com.pmgt.krish.common.ResultData;
import com.pmgt.krish.entity.User;
import com.pmgt.krish.enums.ResultState;
import com.pmgt.krish.exception.LoginException;
import com.pmgt.krish.repository.UserRepository;
import com.pmgt.krish.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public ResultData<User> login(User user) {
        log.info("login param: {}",user);
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        ResultData<User> resultData = new ResultData<>();
        if (userOptional.isPresent()) {
            User searchUser = userOptional.get();
            if (searchUser.getPassword().equals(user.getPassword())) {
                resultData.setData(searchUser);
                resultData.setProp(JwtTokenUtil.generateToken(searchUser.getUserId()));
                resultData.setMessage(ResultState.SUCCESS.getResultMessage());
                resultData.setStatus(ResultState.SUCCESS.getResultCode());
                return resultData;
            } else {
                throw new LoginException("Wrong Password");
            }
        } else {
            throw new LoginException("User not found");
        }
    }
}
