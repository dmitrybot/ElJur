package com.example.eljur;

import com.example.eljur.learners.Learner1_1;
import com.example.eljur.learners.Learner1_2;
import com.example.eljur.learners.Learner1_3;
import com.example.eljur.learners.Learner1_4;
import com.example.eljur.learners.Learner1_5;
import com.example.eljur.learners.Learner1_6;

import java.util.ArrayList;

public class Class {
    String Number;
    Teacher ClassTeacher;
    public ArrayList<Section> sections = new ArrayList<Section>();
    public ArrayList<Learner> learners=new ArrayList<Learner>();
    public Class (String Number, Teacher ClassTeacher){
        this.Number = Number;
        this.ClassTeacher = ClassTeacher;
    }

    public Class(){
    }
    public void addLearner(Learner x){
        learners.add(x);
    }

    public ArrayList<String[]> getListLearnersAndParents(){
        ArrayList<String[]> list = new ArrayList<String[]>();
        String[] list0 = new String[3]; // вспомогательный список, [0]-ФИО, [1]-квалификация
        for(Learner i: learners){
            list0[0]=i.FullName;
            list0[1] = i.Parents[0].FullName;
            list0[2] = i.Parents[1].FullName;
            list.add(list0.clone());
        }
        return list;
    }
    public ArrayList<Section> getSections(){
        return sections;
    }
    public String getNumber() {
        return Number;
    }
}