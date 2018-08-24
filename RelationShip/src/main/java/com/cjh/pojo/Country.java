package com.cjh.pojo;

import java.io.Serializable;
import java.util.Set;

public class Country implements Serializable {
    private int cId;
    private String cName;
    private Set<Provincial> provincials;

    @Override
    public String toString() {
        return "Country{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", provincials=" + provincials +
                '}';
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Set<Provincial> getProvincials() {
        return provincials;
    }

    public void setProvincials(Set<Provincial> provincials) {
        this.provincials = provincials;
    }

    public Country(int cId, String cName, Set<Provincial> provincials) {

        this.cId = cId;
        this.cName = cName;
        this.provincials = provincials;
    }

    public Country() {

    }
}
