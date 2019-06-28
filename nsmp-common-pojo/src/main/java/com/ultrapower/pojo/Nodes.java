package com.ultrapower.pojo;

import java.io.Serializable;
import java.util.List;

public class Nodes implements Serializable {
    String pkid;
    String name;
    String id;
    String pId;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Nodes() {
    }
    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    public Nodes(String name, String id, String pId) {
        this.name = name;
        this.id = id;
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
