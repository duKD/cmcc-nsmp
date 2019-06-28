package com.ultrapower.pojo;

import java.util.List;

public class AmBsDTO {
    private String id;
    private String name;
    private List<AmBsDTO> nextAmBs;

    public AmBsDTO() {
    }

    public AmBsDTO(String id, String name, List<AmBsDTO> nextAmBs) {
        this.id = id;
        this.name = name;
        this.nextAmBs = nextAmBs;
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

    public List<AmBsDTO> getNextAmBs() {
        return nextAmBs;
    }

    public void setNextAmBs(List<AmBsDTO> nextAmBs) {
        this.nextAmBs = nextAmBs;
    }
}
