package com.itlong.gfyluiapp;

public class SelectFloorInfo {

    String selectName;
    String selectFloor;
    int selectIndex;

    @Override
    public String toString() {
        return "SelectFloorInfo{" +
                "selectName='" + selectName + '\'' +
                ", selectFloor='" + selectFloor + '\'' +
                ", selectIndex=" + selectIndex +
                '}';
    }

    public String getSelectName() {
        return selectName;
    }

    public void setSelectName(String selectName) {
        this.selectName = selectName;
    }

    public String getSelectFloor() {
        return selectFloor;
    }

    public void setSelectFloor(String selectFloor) {
        this.selectFloor = selectFloor;
    }

    public int getSelectIndex() {
        return selectIndex;
    }

    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
    }
}
