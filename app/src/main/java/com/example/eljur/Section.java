package com.example.eljur;

public class Section {
    String AcademicSubject;
    Teacher ClassTeacher;
    Learner[] Learners;
    public Section(String AcademicSubject){
        this.AcademicSubject = AcademicSubject;
    }

    public String Get_Sub(){
        return AcademicSubject;
    }

}