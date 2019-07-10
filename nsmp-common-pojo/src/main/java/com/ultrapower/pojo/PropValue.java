package com.ultrapower.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "asset_prop_value_col")
public class PropValue implements Serializable {
    @Id
    private String id;

    private String pkAsset;

    private String pkAssetProp;

    private String propValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getPkAsset() {
        return pkAsset;
    }

    public void setPkAsset(String pkAsset) {
        this.pkAsset = pkAsset;
    }

    public String getPkAssetProp() {
        return pkAssetProp;
    }

    public void setPkAssetProp(String pkAssetProp) {
        this.pkAssetProp = pkAssetProp;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }
}
