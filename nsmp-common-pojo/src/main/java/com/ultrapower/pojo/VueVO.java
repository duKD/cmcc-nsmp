package com.ultrapower.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "asset_prop_value_col")
public class VueVO {
    @Id
    String id;

    String pkAsset;

    String pkAssetProp;

    String propName;

    String dataType;

    String propValue;

    List<provValue> list;

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

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    public String getPkAssetProp() {
        return pkAssetProp;
    }

    public void setPkAssetProp(String pkAssetProp) {
        this.pkAssetProp = pkAssetProp;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public List<provValue> getList() {
        return list;
    }

    public void setList(List<provValue> list) {
        this.list = list;
    }
}
