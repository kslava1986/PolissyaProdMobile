package com.example.pp.models;

import java.util.Objects;

public class Address {
    private String name;
    private int index;
    private int idShop;

    public Address() {
    }

    public Address(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return index == address.index &&
                idShop == address.idShop &&
                Objects.equals(name, address.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, index, idShop);
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", idShop=" + idShop +
                '}';
    }
}
