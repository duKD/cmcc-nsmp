package com.ultrapower.pojo;

public class QueryVO {
    String beginTime;
    String endTime;
    String keywords;

    public QueryVO() {
    }

    public QueryVO(String beginTime, String endTime, String keywords) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.keywords = keywords;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
