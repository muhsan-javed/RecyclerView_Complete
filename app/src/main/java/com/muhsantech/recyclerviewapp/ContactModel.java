package com.muhsantech.recyclerviewapp;

public class ContactModel {
    String name, number;
    int img;

    public ContactModel(int img,String name, String number) {
        this.name = name;
        this.number = number;
        this.img = img;
    }
    public ContactModel(String name, String number){
        this.name = name;
        this.number = number;
    }
}
