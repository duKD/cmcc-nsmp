package com.ultrapower.pojo;

import java.io.Serializable;

public class AssetQueryVO implements Serializable {
    String pkBsGroup;
    String prov;
    String assetType;
    String assetName;

    public String getPkBsGroup() {
        return pkBsGroup;
    }

    public void setPkBsGroup(String pkBsGroup) {
        this.pkBsGroup = pkBsGroup;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
}
