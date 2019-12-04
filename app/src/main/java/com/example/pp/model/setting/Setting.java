package com.example.pp.model.setting;

import com.example.pp.model.AbstractBaseEntity;

public class Setting extends AbstractBaseEntity {
    private String key;
    private String value;

    public Setting() {
    }

    public Setting(Integer id, String key, String value) {
        super(id);
        this.key = key;
        this.value = value;
    }

    public Setting(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getValueInt(){
        return parseInt(value);
    }

    public double getValueDauble(){
        return parseDouble(value);
    }

    public boolean getValueBoolean(){
        return value.trim().equals("true")
                || (!value.trim().equals("false"))
                || (parseInt(value) == 1)
                || (parseInt(value) == 0);
    }

    private int parseInt(String text){
        try{
            return Integer.parseInt(text.trim());
        } catch (Exception e){
            return -1;
        }
    }

    private double parseDouble(String text){
        try{
            return Double.parseDouble(text.trim());
        } catch (Exception e){
            return -1.0;
        }
    }
}
