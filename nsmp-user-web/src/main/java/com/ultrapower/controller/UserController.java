package com.ultrapower.controller;

import com.ultrapower.pojo.AmUser;
import com.ultrapower.pojo.UserVO;
import com.ultrapower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("userLogin")
    public UserVO userLogin(AmUser user, HttpServletResponse response){
        UserVO userVO = userService.login(user,response);
        return userVO;
    }
}
