package test;

import java.io.*;

public class EmployeeBean implements Serializable
{
    private String eid, ename, desg, password;
    private float bsal, hra, da, totalsal;

    public EmployeeBean() {}

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDesg() {
        return desg;
    }

    public void setDesg(String desg) {
        this.desg = desg;
    }

    public float getBsal() {
        return bsal;
    }

    public void setBsal(float bsal) {
        this.bsal = bsal;
    }

    public float getHra() {
        return hra;
    }

    public void setHra(float hra) {
        this.hra = hra;
    }

    public float getDa() {
        return da;
    }

    public void setDa(float da) {
        this.da = da;
    }

    public float getTotalsal() {
        return totalsal;
    }

    public void setTotalsal(float totalsal) {
        this.totalsal = totalsal;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
