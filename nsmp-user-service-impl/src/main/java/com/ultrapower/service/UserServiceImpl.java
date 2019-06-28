package com.ultrapower.service;

import com.ultrapower.dao.AmUserMapper;
import com.ultrapower.pojo.AmUser;
import com.ultrapower.pojo.AmUserExample;
import com.ultrapower.pojo.UserVO;
import com.ultrapower.util.PkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AmUserMapper amUserMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    public UserVO login(AmUser user, HttpServletResponse response) {
        // 1,登录成功    2，用户名不存在   3，密码错误
        AmUserExample amUserExample = new AmUserExample();
        AmUserExample.Criteria criteria = amUserExample.createCriteria();
        criteria.andUserAccountEqualTo(user.getUserAccount());
        List<AmUser> users = amUserMapper.selectByExample(amUserExample);
        UserVO userVO = new UserVO();
        if(users==null||users.size()==0){
            //用户名不存在
            userVO.setCode(2+"");
            userVO.setMsg("用户名不存在");
            userVO.setUser(user);
        }else{
            //校验密码
            criteria.andUserPasswordEqualTo(user.getUserPassword());
            List<AmUser> amUsers = amUserMapper.selectByExample(amUserExample);
            if(amUsers.size()>0){
                //登录成功
                userVO.setCode(1+"");
                userVO.setMsg("登录成功");
                userVO.setUser(amUsers.get(0));
                //向Redis存数据，向浏览器存Cookie
                String uuid= PkUtils.getUUID();
                Cookie cookie = new Cookie("token",uuid);
                cookie.setPath("/");
                cookie.setMaxAge(-1);
                response.addCookie(cookie);
                String key="token_"+uuid;
                redisTemplate.boundHashOps("session").put(key,amUsers.get(0).getPkNsmpUser());
                //向浏览器存用户和Id,以及管理权限
                Cookie userAccount = new Cookie("userAccount",amUsers.get(0).getUserAccount());
                userAccount.setPath("/");
                userAccount.setMaxAge(-1);
                response.addCookie(userAccount);
                Cookie pkNsmpUser = new Cookie("pkNsmpUser",amUsers.get(0).getPkNsmpUser());
                pkNsmpUser.setPath("/");
                pkNsmpUser.setMaxAge(-1);
                response.addCookie(pkNsmpUser);
                Cookie identity = new Cookie("identity", amUsers.get(0).getIdentity() + "");
                identity.setPath("/");
                identity.setMaxAge(-1);
                response.addCookie(identity);
            }else{
                //密码不正确
                userVO.setCode(3+"");
                userVO.setMsg("密码不正确");
                userVO.setUser(user);
            }
        }
        return userVO;
    }
}
