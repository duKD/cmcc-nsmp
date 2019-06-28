package com.ultrapower.pojo;

public class AmGroupAddDTO extends AmBsGroup{
    String provIds;

    String mappingRegex;

    @Override
    public String getMappingRegex() {
        return mappingRegex;
    }

    @Override
    public void setMappingRegex(String mappingRegex) {
        this.mappingRegex = mappingRegex;
    }

    public String getProvIds() {
        return provIds;
    }

    public void setProvIds(String provIds) {
        this.provIds = provIds;
    }
}
