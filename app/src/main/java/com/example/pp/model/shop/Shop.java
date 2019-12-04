package com.example.pp.model.shop;

import com.example.pp.model.AbstractBaseEntity;

import java.util.Objects;

public class Shop extends AbstractBaseEntity {
    //logo
    private String name;
    private Address address;
    private int tel;
    private WorkTime workTime;

    public Shop() {
    }

    public Shop(String name, Address address, int tel, WorkTime workTime) {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.workTime = workTime;
    }

    public Shop(Integer id, String name, Address address, int tel, WorkTime workTime) {
        super(id);
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.workTime = workTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public WorkTime getWorkTime() {
        return workTime;
    }

    public void setWorkTime(WorkTime workTime) {
        this.workTime = workTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return tel == shop.tel &&
                Objects.equals(name, shop.name) &&
                Objects.equals(address, shop.address) &&
                Objects.equals(workTime, shop.workTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, tel, workTime);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", tel=" + tel +
                ", workTime=" + workTime +
                '}';
    }
}
