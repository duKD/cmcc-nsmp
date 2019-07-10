package com.ultrapower.pojo;

import java.io.Serializable;
import java.util.Date;

public class AdcAssetCheckQueue implements Serializable {
    private String pkAssetCheckQueue;

    private String provCode;

    private String pkAsset;

    private Date pullTime;

    private Short state;

    private Date handleTime;

    private Integer handleTimes;

    private String dataInfo;

    private static final long serialVersionUID = 1L;

    public String getPkAssetCheckQueue() {
        return pkAssetCheckQueue;
    }

    public void setPkAssetCheckQueue(String pkAssetCheckQueue) {
        this.pkAssetCheckQueue = pkAssetCheckQueue == null ? null : pkAssetCheckQueue.trim();
    }

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode == null ? null : provCode.trim();
    }

    public String getPkAsset() {
        return pkAsset;
    }

    public void setPkAsset(String pkAsset) {
        this.pkAsset = pkAsset == null ? null : pkAsset.trim();
    }

    public Date getPullTime() {
        return pullTime;
    }

    public void setPullTime(Date pullTime) {
        this.pullTime = pullTime;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Integer getHandleTimes() {
        return handleTimes;
    }

    public void setHandleTimes(Integer handleTimes) {
        this.handleTimes = handleTimes;
    }

    public String getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(String dataInfo) {
        this.dataInfo = dataInfo == null ? null : dataInfo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkAssetCheckQueue=").append(pkAssetCheckQueue);
        sb.append(", provCode=").append(provCode);
        sb.append(", pkAsset=").append(pkAsset);
        sb.append(", pullTime=").append(pullTime);
        sb.append(", state=").append(state);
        sb.append(", handleTime=").append(handleTime);
        sb.append(", handleTimes=").append(handleTimes);
        sb.append(", dataInfo=").append(dataInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}