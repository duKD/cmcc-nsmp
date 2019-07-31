package com.ultrapower.controller;

import com.ultrapower.pojo.AmUser;
import com.ultrapower.pojo.UserVO;
import com.ultrapower.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserAccount(),user.getUserPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            UserVO userVO = new UserVO();
            userVO.setCode("0");
            userVO.setMsg("登录失败");
            return userVO;
        }
        UserVO userVO=null;
        boolean b = subject.isAuthenticated();
        if(b){
             userVO = userService.login(user,response);
        }
        return userVO;
    }
    @RequiresRoles(value={"0","1"},logical = Logical.OR )
    @GetMapping("test0001")
    public String test(){
        return "哈哈哈，洒家又回来了";
    }
    @GetMapping("seeAgain")
    public String seeAgain(){
        return "seeAgain";
    }
}
