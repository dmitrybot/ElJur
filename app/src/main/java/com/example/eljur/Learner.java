package com.example.eljur;

public class Learner extends Participant{
    public Parent[] Parents = new Parent[2];
    String age;
    public Learner (String Phone, String FullName, int CardID, Parent Parent1, Parent Parent2, String age){
        super(Phone, FullName, CardID);
        Parents[0] = Parent1;
        Parents[1] = Parent2;
        this.age = age;
    }

    public String getParent1FullName(){
        return Parents[0].FullName;
    }
    public String getName(){return FullName;}
    public String getParent2FullName(){
        return Parents[1].FullName;
    }
}
