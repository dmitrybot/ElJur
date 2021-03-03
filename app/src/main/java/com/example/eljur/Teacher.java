package com.example.eljur;

public class Teacher extends Employee{
    String Qualification;
    public Teacher (String Phone, String FullName, int CardID, String Position, String Qualification){
        super(Phone, FullName, CardID, Position);
        this.Qualification = Qualification;
    }
}

