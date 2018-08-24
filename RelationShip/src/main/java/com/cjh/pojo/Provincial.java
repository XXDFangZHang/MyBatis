package com.cjh.pojo;

import java.io.Serializable;

public class Provincial implements Serializable {
    private int pId;
    private String pName;

    @Override
    public String toString() {
        return "Provincial{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                '}';
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Provincial(int pId, String pName) {

        this.pId = pId;
        this.pName = pName;
    }

    public Provincial() {

    }
}
