package com.ultrapower.pojo;

import java.util.List;

public class AddAssetVO {
    private AmAsset asset;
    private List<VueVO> props;
    private AmAssetExtendProp assetExtendProp;

    public AmAssetExtendProp getAssetExtendProp() {
        return assetExtendProp;
    }

    public void setAssetExtendProp(AmAssetExtendProp assetExtendProp) {
        this.assetExtendProp = assetExtendProp;
    }

    public AmAsset getAsset() {
        return asset;
    }

    public void setAsset(AmAsset asset) {
        this.asset = asset;
    }

    public List<VueVO> getProps() {
        return props;
    }

    public void setProps(List<VueVO> props) {
        this.props = props;
    }
}
