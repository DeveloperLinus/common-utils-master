package com.linus.liu.showruzeltui;

public class DtInfo implements LiftMode{
    String DtName;


    public DtInfo(String dtName) {
        DtName = dtName;
    }

    public String getDtName() {
        return DtName;
    }

    public void setDtName(String dtName) {
        DtName = dtName;
    }
}
