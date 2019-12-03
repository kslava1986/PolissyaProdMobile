package com.example.pp.models._new;

import com.example.pp.models.AbstractBaseEntity;

public class Shop extends AbstractBaseEntity {
    //logo
    private String name;
    private String address;
    private int numberAdrress;
    private int tel;
    private long startWorkTime;
    private long endWorkTime;

    public Shop() {
    }

    public Shop(Integer id, String name, String address, int numberAdrress, int tel, long startWorkTime, long endWorkTime) {
        super(id);
        this.name = name;
        this.address = address;
        this.numberAdrress = numberAdrress;
        this.tel = tel;
        this.startWorkTime = startWorkTime;
        this.endWorkTime = endWorkTime;
    }

    public Shop(String name, String address, int numberAdrress, int tel, long startWorkTime, long endWorkTime) {
        this.name = name;
        this.address = address;
        this.numberAdrress = numberAdrress;
        this.tel = tel;
        this.startWorkTime = startWorkTime;
        this.endWorkTime = endWorkTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberAdrress() {
        return numberAdrress;
    }

    public void setNumberAdrress(int numberAdrress) {
        this.numberAdrress = numberAdrress;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public long getStartWorkTime() {
        return startWorkTime;
    }

    public void setStartWorkTime(long startWorkTime) {
        this.startWorkTime = startWorkTime;
    }

    public long getEndWorkTime() {
        return endWorkTime;
    }

    public void setEndWorkTime(long endWorkTime) {
        this.endWorkTime = endWorkTime;
    }
}
