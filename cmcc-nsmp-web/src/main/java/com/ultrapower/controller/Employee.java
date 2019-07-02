package com.ultrapower.controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Employee {

    @DBRef
    Demo demo;
    @Id
    String oid;

    String eName;

    String eId;
    @Indexed
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Demo getDemo() {
        return demo;
    }

    public void setDemo(Demo demo) {
        this.demo = demo;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "demo=" + demo +
                ", oid='" + oid + '\'' +
                ", eName='" + eName + '\'' +
                ", eId='" + eId + '\'' +
                '}';
    }
}
