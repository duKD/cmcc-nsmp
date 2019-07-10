package com.ultrapower.pojo;

import java.io.Serializable;
import java.util.Date;

public class AdcAssetProblem implements Serializable {
    private String pkAssetProblem;

    private String provCode;

    private String pkAsset;

    private String propCode;

    private String currentVersion;

    private String previousVersion;

    private String baselineVersion;

    private Date foundTime;

    private String problemType;

    private String problemContent;

    private Short problemState;

    private String problemDesc;

    private String problemSrc;

    private static final long serialVersionUID = 1L;

    public String getPkAssetProblem() {
        return pkAssetProblem;
    }

    public void setPkAssetProblem(String pkAssetProblem) {
        this.pkAssetProblem = pkAssetProblem == null ? null : pkAssetProblem.trim();
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

    public String getPropCode() {
        return propCode;
    }

    public void setPropCode(String propCode) {
        this.propCode = propCode == null ? null : propCode.trim();
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion == null ? null : currentVersion.trim();
    }

    public String getPreviousVersion() {
        return previousVersion;
    }

    public void setPreviousVersion(String previousVersion) {
        this.previousVersion = previousVersion == null ? null : previousVersion.trim();
    }

    public String getBaselineVersion() {
        return baselineVersion;
    }

    public void setBaselineVersion(String baselineVersion) {
        this.baselineVersion = baselineVersion == null ? null : baselineVersion.trim();
    }

    public Date getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(Date foundTime) {
        this.foundTime = foundTime;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType == null ? null : problemType.trim();
    }

    public String getProblemContent() {
        return problemContent;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent == null ? null : problemContent.trim();
    }

    public Short getProblemState() {
        return problemState;
    }

    public void setProblemState(Short problemState) {
        this.problemState = problemState;
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc == null ? null : problemDesc.trim();
    }

    public String getProblemSrc() {
        return problemSrc;
    }

    public void setProblemSrc(String problemSrc) {
        this.problemSrc = problemSrc == null ? null : problemSrc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkAssetProblem=").append(pkAssetProblem);
        sb.append(", provCode=").append(provCode);
        sb.append(", pkAsset=").append(pkAsset);
        sb.append(", propCode=").append(propCode);
        sb.append(", currentVersion=").append(currentVersion);
        sb.append(", previousVersion=").append(previousVersion);
        sb.append(", baselineVersion=").append(baselineVersion);
        sb.append(", foundTime=").append(foundTime);
        sb.append(", problemType=").append(problemType);
        sb.append(", problemContent=").append(problemContent);
        sb.append(", problemState=").append(problemState);
        sb.append(", problemDesc=").append(problemDesc);
        sb.append(", problemSrc=").append(problemSrc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}