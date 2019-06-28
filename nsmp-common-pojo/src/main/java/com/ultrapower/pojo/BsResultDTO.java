package com.ultrapower.pojo;

public class BsResultDTO {
    String pKBsProv;
    String provName;
    String bsName;
    String matchType;
    int assetSum;

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public int getAssetSum() {
        return assetSum;
    }

    public void setAssetSum(int assetSum) {
        this.assetSum = assetSum;
    }

    public BsResultDTO() {
    }

    public BsResultDTO(String pKBsProv, String provName, String bsName, String matchType, int assetSum) {
        this.pKBsProv = pKBsProv;
        this.provName = provName;
        this.bsName = bsName;
        this.matchType = matchType;
        this.assetSum = assetSum;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public String getpKBsProv() {
        return pKBsProv;
    }

    public void setpKBsProv(String pKBsProv) {
        this.pKBsProv = pKBsProv;
    }
}
