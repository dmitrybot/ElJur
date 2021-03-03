package com.example.eljur;

import com.example.eljur.classes.Class1;
import com.example.eljur.learners.Learner1_1;
import com.example.eljur.learners.Learner1_2;
import com.example.eljur.learners.Learner1_3;
import com.example.eljur.learners.Learner1_4;
import com.example.eljur.learners.Learner1_5;
import com.example.eljur.learners.Learner1_6;

import java.util.ArrayList;

public class School {
    public String adress, name;
    ArrayList<Employee> employees=new ArrayList<Employee>();
    public ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    ArrayList<Learner> learners=new ArrayList<Learner>();
    ArrayList<Participant> participants=new ArrayList<Participant>();
    ArrayList<Class> classes=new ArrayList<Class>();
    ArrayList<Elective> electives=new ArrayList<Elective>();
    ArrayList<Section> sections=new  ArrayList<Section>();

    public School(){
        teachers.add(new Teacher1());
        teachers.add(new Teacher2());
        teachers.add(new Teacher3());
        teachers.add(new Teacher4());
        teachers.add(new Teacher5());
        teachers.add(new Teacher6());
        learners.add(new Learner1_1());
        learners.add(new Learner1_2());
        learners.add(new Learner1_3());
        learners.add(new Learner1_4());
        learners.add(new Learner1_5());
        learners.add(new Learner1_6());
        participants.add(new Teacher1());
        participants.add(new Teacher2());
        participants.add(new Teacher3());
        participants.add(new Teacher4());
        participants.add(new Teacher5());
        participants.add(new Teacher6());
        participants.add(new Learner1_1());
        participants.add(new Learner1_2());
        participants.add(new Learner1_3());
        participants.add(new Learner1_4());
        participants.add(new Learner1_5());
        participants.add(new Learner1_6());
        classes.add(new Class1());
    }

    public void addTeacher(Teacher x){
        teachers.add(x);
    }

    public void addParticipant(Participant x){
        participants.add(x);
    }

    public void addEmployee(Employee x){
        employees.add(x);
    }

    public void addLearner(Learner x){
        learners.add(x);
    }

    public ArrayList<String[]> getListTeachers(){
        ArrayList<String[]> list = new ArrayList<String[]>();
        String[] list0 = new String[2]; // вспомогательный список, [0]-ФИО, [1]-квалификация
        for(Teacher i: teachers){
            list0[0]=i.FullName;
            list0[1]=i.Qualification;
            list.add(list0.clone());
        }
        return list;
    }

    public ArrayList<String[]> getListLearners(){
        ArrayList<String[]> list = new ArrayList<String[]>();
        String[] list0 = new String[2]; // вспомогательный список, [0]-ФИО, [1]-квалификация
        for(Learner i: learners){
            list0[0]=i.FullName;
            list0[1]=i.age;
            list.add(list0.clone());
        }
        return list;
    }

    public ArrayList<String[]> getListParticipants(){
        ArrayList<String[]> list = new ArrayList<String[]>();
        String[] list0 = new String[2]; // вспомогательный список, [0]-ФИО, [1]-квалификация
        for(Participant i: participants){
            list0[0] = i.FullName;
            list0[1] = String.valueOf(i.CardID);
            list.add(list0.clone());
        }
        return list;
    }

    public ArrayList<Class> getClasses(){
        return classes;
    }
}
