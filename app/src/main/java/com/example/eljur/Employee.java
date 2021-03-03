package com.example.eljur;

public class Employee extends Participant{
    String Position;
    public Employee (String Phone, String FullName, int CardID, String Position){
        super(Phone, FullName, CardID);
        this.Position = Position;
    }
}