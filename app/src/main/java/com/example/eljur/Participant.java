package com.example.eljur;

public class Participant extends Person{
    int CardID;
    public Participant (String Phone, String FullName, int CardID){
        super(Phone, FullName);
        this.CardID = CardID;
    }
}