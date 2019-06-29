package com.ultrapower.pojo;

import java.util.Date;

public class AdcBmPortDTO {
    private String pkBmPort;

    private String version;

    private String provCode;

    private String portType;

    private String protocol;

    private String port;

    private String severityLevel;

    private Integer isDeleted;

    private String pkCreator;

    private Date createTime;

    private String pkMender;

    private Date mendTimeLast;

    public String getPkBmPort() {
        return pkBmPort;
    }

    public void setPkBmPort(String pkBmPort) {
        this.pkBmPort = pkBmPort;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode;
    }

    public String getPortType() {
        return portType;
    }

    public void setPortType(String portType) {
        this.portType = portType;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getPkCreator() {
        return pkCreator;
    }

    public void setPkCreator(String pkCreator) {
        this.pkCreator = pkCreator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPkMender() {
        return pkMender;
    }

    public void setPkMender(String pkMender) {
        this.pkMender = pkMender;
    }

    public Date getMendTimeLast() {
        return mendTimeLast;
    }

    public void setMendTimeLast(Date mendTimeLast) {
        this.mendTimeLast = mendTimeLast;
    }
}
