package com.ultrapower.controller;

import com.ultrapower.dao.AmUserMapper;
import com.ultrapower.pojo.AmUser;
import com.ultrapower.pojo.AmUserExample;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerRealm extends AuthorizingRealm {
    @Autowired
   private AmUserMapper amUserMapper;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String  username = principalCollection.getPrimaryPrincipal()+"";
        //权限
        Set<String> permissionsByUserName = getPermissionsByUserName(username);
        //角色
        Set<String> rolesByUserName = getRolesByUserName(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(rolesByUserName);
        simpleAuthorizationInfo.setStringPermissions(permissionsByUserName);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String  username = authenticationToken.getPrincipal()+"";
        String password = getPasswordByUserName(username);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, "xxx");
        //info.setCredentialsSalt(ByteSource.Util.bytes("tom"));
        return info;
    }
    //从数据库根据name查询出权限
    private Set<String> getPermissionsByUserName(String username) {
        Set<String> sets = new HashSet<String>();
        sets.add("user:delete");
        sets.add("user:add");
        return sets;
    }

    //模拟从数据库或缓存中获取密码
    private String getPasswordByUserName(String username) {
        AmUserExample amUserExample = new AmUserExample();
        AmUserExample.Criteria criteria = amUserExample.createCriteria();
        criteria.andUserAccountEqualTo(username);
        List<AmUser> users = amUserMapper.selectByExample(amUserExample);
        String userPassword =null;
        if(users!=null&&users.size()>0){
            AmUser  user = users.get(0);
           userPassword = user.getUserPassword();
        }
        return userPassword;
    }
    //从数据库获得角色信息
    private Set<String> getRolesByUserName(String username) {
        Set<String> sets = new HashSet<String>();
        AmUserExample amUserExample = new AmUserExample();
        AmUserExample.Criteria criteria = amUserExample.createCriteria();
        criteria.andUserAccountEqualTo(username);
        List<AmUser> amUsers = amUserMapper.selectByExample(amUserExample);
        String identity=null;
        if(amUsers!=null&&amUsers.size()>0){
            AmUser  users = amUsers.get(0);
            identity = users.getIdentity().toString();
        }
        sets.add(identity);
        return  sets;
    }
}
