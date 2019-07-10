package com.ultrapower.pojo;

import java.util.List;

public class ProvVO {
    AmAssetProp assetPropBaseInfo;

    List<AmAssetPropValue> assetPropValues;

    public AmAssetProp getAssetPropBaseInfo() {
        return assetPropBaseInfo;
    }

    public void setAssetPropBaseInfo(AmAssetProp assetPropBaseInfo) {
        this.assetPropBaseInfo = assetPropBaseInfo;
    }

    public List<AmAssetPropValue> getAssetPropValues() {
        return assetPropValues;
    }

    public void setAssetPropValues(List<AmAssetPropValue> assetPropValues) {
        this.assetPropValues = assetPropValues;
    }
}
