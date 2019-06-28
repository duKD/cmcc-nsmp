package com.ultrapower.pojo;

import java.io.Serializable;
import java.util.List;

public class AmProvDTO implements Serializable {
    private String id;
    private  String name;
    private  List<AmProvDTO> amProvDTOS;

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

    public List<AmProvDTO> getAmProvDTOS() {
        return amProvDTOS;
    }

    public void setAmProvDTOS(List<AmProvDTO> amProvDTOS) {
        this.amProvDTOS = amProvDTOS;
    }
}
