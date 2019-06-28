package com.ultrapower.service;

import com.ultrapower.pojo.AmUser;
import com.ultrapower.pojo.UserVO;

import javax.servlet.http.HttpServletResponse;

public interface UserService {

    public UserVO login(AmUser user, HttpServletResponse response);


}
