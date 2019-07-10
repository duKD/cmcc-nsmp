package com.ultrapower.pojo;

import java.util.Date;

public class QueryAssetVO extends AmAssetQuery {
    String pkOnlineUser;
    Date onlineTime;
    String assetCode;

    public String getPkOnlineUser() {
        return pkOnlineUser;
    }

    public void setPkOnlineUser(String pkOnlineUser) {
        this.pkOnlineUser = pkOnlineUser;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }
}
