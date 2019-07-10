package com.ultrapower.pojo;

import java.io.Serializable;

public class AdcAssetProblemDetail implements Serializable {
    private String pkAssetProblemDetail;

    private String pkAssetProblem;

    private String problemCode;

    private String problemContent;

    private Integer severityLevel;

    private String pkCollectRecord;

    private String pkProblemBaseline;

    private static final long serialVersionUID = 1L;

    public String getPkAssetProblemDetail() {
        return pkAssetProblemDetail;
    }

    public void setPkAssetProblemDetail(String pkAssetProblemDetail) {
        this.pkAssetProblemDetail = pkAssetProblemDetail == null ? null : pkAssetProblemDetail.trim();
    }

    public String getPkAssetProblem() {
        return pkAssetProblem;
    }

    public void setPkAssetProblem(String pkAssetProblem) {
        this.pkAssetProblem = pkAssetProblem == null ? null : pkAssetProblem.trim();
    }

    public String getProblemCode() {
        return problemCode;
    }

    public void setProblemCode(String problemCode) {
        this.problemCode = problemCode == null ? null : problemCode.trim();
    }

    public String getProblemContent() {
        return problemContent;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent == null ? null : problemContent.trim();
    }

    public Integer getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(Integer severityLevel) {
        this.severityLevel = severityLevel;
    }

    public String getPkCollectRecord() {
        return pkCollectRecord;
    }

    public void setPkCollectRecord(String pkCollectRecord) {
        this.pkCollectRecord = pkCollectRecord == null ? null : pkCollectRecord.trim();
    }

    public String getPkProblemBaseline() {
        return pkProblemBaseline;
    }

    public void setPkProblemBaseline(String pkProblemBaseline) {
        this.pkProblemBaseline = pkProblemBaseline == null ? null : pkProblemBaseline.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkAssetProblemDetail=").append(pkAssetProblemDetail);
        sb.append(", pkAssetProblem=").append(pkAssetProblem);
        sb.append(", problemCode=").append(problemCode);
        sb.append(", problemContent=").append(problemContent);
        sb.append(", severityLevel=").append(severityLevel);
        sb.append(", pkCollectRecord=").append(pkCollectRecord);
        sb.append(", pkProblemBaseline=").append(pkProblemBaseline);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}