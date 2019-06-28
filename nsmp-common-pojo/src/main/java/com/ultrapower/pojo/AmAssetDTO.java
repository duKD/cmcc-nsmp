package com.ultrapower.pojo;

import java.io.Serializable;
import java.util.List;

public class AmAssetDTO implements Serializable {
    private String id;
    private String name;
    private List<AmAssetDTO> secondTypes;

    public AmAssetDTO() {
    }

    public AmAssetDTO(String id, String name, List<AmAssetDTO> secondTypes) {
        this.id = id;
        this.name = name;
        this.secondTypes = secondTypes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AmAssetDTO> getSecondType() {
        return secondTypes;
    }

    public void setSecondType(List<AmAssetDTO> secondTypes) {
        this.secondTypes = secondTypes;
    }
}
