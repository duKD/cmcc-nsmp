package com.ultrapower.pojo;

public class BsGroupConnectAsset {
    String pkAsset;
    String pkBsProv;
    String gName;
    String provName;
    String pName;
    String bsName;
    String assetName;
    String assetIP;
    String typeName;
    String parentName;

    public BsGroupConnectAsset() {
    }

    public BsGroupConnectAsset(String pkAsset, String pkBsProv, String gName, String provName, String pName, String bsName, String assetName, String assetIP, String typeName, String parentName) {
        this.pkAsset = pkAsset;
        this.pkBsProv = pkBsProv;
        this.gName = gName;
        this.provName = provName;
        this.pName = pName;
        this.bsName = bsName;
        this.assetName = assetName;
        this.assetIP = assetIP;
        this.typeName = typeName;
        this.parentName = parentName;
    }

    public String getPkAsset() {
        return pkAsset;
    }

    public void setPkAsset(String pkAsset) {
        this.pkAsset = pkAsset;
    }

    public String getPkBsProv() {
        return pkBsProv;
    }

    public void setPkBsProv(String pkBsProv) {
        this.pkBsProv = pkBsProv;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetIP() {
        return assetIP;
    }

    public void setAssetIP(String assetIP) {
        this.assetIP = assetIP;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
