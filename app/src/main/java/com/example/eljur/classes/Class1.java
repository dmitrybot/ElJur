package com.example.eljur.classes;

import com.example.eljur.Teacher1;
import com.example.eljur.Learner;
import com.example.eljur.Class;
import com.example.eljur.Teacher;
import com.example.eljur.learners.Learner1_1;
import com.example.eljur.learners.Learner1_2;
import com.example.eljur.learners.Learner1_3;
import com.example.eljur.learners.Learner1_4;
import com.example.eljur.learners.Learner1_5;
import com.example.eljur.learners.Learner1_6;
import com.example.eljur.sections.Section1_1;

public class Class1 extends Class{
    public Class1(){
        super("1", new Teacher1());
        learners.add(new Learner1_1());
        learners.add(new Learner1_2());
        learners.add(new Learner1_3());
        learners.add(new Learner1_4());
        learners.add(new Learner1_5());
        learners.add(new Learner1_6());
        sections.add(new Section1_1());
    }
}
