package com.example.pp.model;

import java.util.Objects;

public class Address {
    private String name;
    private int number;
    private int idShop;

    public Address() {
    }

    public Address(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
        return number == address.number &&
                idShop == address.idShop &&
                Objects.equals(name, address.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, idShop);
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", idShop=" + idShop +
                '}';
    }
}
