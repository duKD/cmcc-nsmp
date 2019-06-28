package com.ultrapower.pojo;

import java.io.Serializable;

public class UserVO implements Serializable {
    String code;
    String msg;
    AmUser user;

    public UserVO() {
    }

    public UserVO(String code, String msg, AmUser user) {
        this.code = code;
        this.msg = msg;
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public AmUser getUser() {
        return user;
    }

    public void setUser(AmUser user) {
        this.user = user;
    }
}
