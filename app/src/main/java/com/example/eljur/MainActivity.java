package com.example.eljur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {
    School school= new School();
    Teacher x = new Teacher("1" , "3", 2, "34", "323r");
    Button docs, elJur, teachers, button_classes_back, button_classes_generate, adding, button_add, button_continue;
    TableLayout docstable, table_eljur;
    String id;
    LinearLayout addingLay, choose_class_lay;
    RelativeLayout startLay, docsLay, tableDocsLay, ElJurLay;
    Spinner spinner_classes, spinner_participants, spinner_clas, spinner_sub;
    EditText text_fullName, text_phone, text_ID, text_position, text_qualification, text_age, text_parent1fio, text_parent1phone, text_parent2fio, text_parent2phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        docs = findViewById(R.id.docs);
        adding = findViewById(R.id.adding);
        elJur = findViewById(R.id.elJur);
        ElJurLay = findViewById(R.id.ElJurLay);
        startLay = findViewById(R.id.startLay);
        docsLay = findViewById(R.id.docsLay);
        addingLay = findViewById(R.id.addingLay);
        choose_class_lay = findViewById(R.id.choose_class_lay);
        tableDocsLay = findViewById(R.id.tableDocsLay);
        teachers = findViewById(R.id.teachers);
        startLay.setVisibility(View.VISIBLE);
        /*docs.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                startLay.setVisibility(View.GONE);
                docsLay.setVisibility(View.VISIBLE);
            }
        });*/
    }
    public void onMyButtonClick(View v)     //кнопка документы
    {
        startLay.setVisibility(View.GONE);
        ElJurLay.setVisibility(View.GONE);
        addingLay.setVisibility(View.GONE);
        docsLay.setVisibility(View.VISIBLE);
        choose_class_lay.setVisibility(View.GONE);
        tableDocsLay.setVisibility(View.GONE);
        Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_LONG).show();
    }
    public void TeachersButton(View v)     //кнопка преподаватели
    {
        docsLay.setVisibility(View.GONE);
        addingLay.setVisibility(View.GONE);
        ElJurLay.setVisibility(View.GONE);
        tableDocsLay.setVisibility(View.VISIBLE);
        choose_class_lay.setVisibility(View.GONE);
        docstable = findViewById(R.id.table_documents);

        docstable.removeAllViews();


        TableRow row = new TableRow(this);
        TextView item0 = new TextView(this);
        TextView item1 = new TextView(this);
        item0.setPadding(5, 0, 5, 0);
        item1.setPadding(5, 0, 5, 0);
        row.setPadding(0, 2, 0, 2);
        item0.setText("ФИО");
        row.addView(item0, 0);
        item1.setText("Квалификация");
        row.addView(item1, 1);
        docstable.addView(row);

        ArrayList<String[]> list= new ArrayList<String[]>();
        list = school.getListTeachers();

        for (String[] i : list) {

            row = new TableRow(this);
            item0 = new TextView(this);
            item1 = new TextView(this);
            item0.setPadding(5, 0, 5, 0);
            item1.setPadding(5, 0, 5, 0);
            item0.setText(i[0]);
            row.addView(item0);
            item1.setText(i[1]);
            row.addView(item1);

            docstable.addView(row);

        }
        Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show();
    }

    public void LearnersButton(View v){ //кнопка школьники
        docsLay.setVisibility(View.GONE);
        addingLay.setVisibility(View.GONE);
        ElJurLay.setVisibility(View.GONE);
        choose_class_lay.setVisibility(View.GONE);
        tableDocsLay.setVisibility(View.VISIBLE);
        docstable = findViewById(R.id.table_documents);

        docstable.removeAllViews();

        TableRow row = new TableRow(this);
        TextView item0 = new TextView(this);
        TextView item1 = new TextView(this);
        item0.setPadding(5, 0, 5, 0);
        item1.setPadding(5, 0, 5, 0);
        row.setPadding(0, 2, 0, 2);
        item0.setText("ФИО");
        row.addView(item0, 0);
        item1.setText("Возраст");
        row.addView(item1, 1);
        docstable.addView(row);

        ArrayList<String[]> list= new ArrayList<String[]>();
        list = school.getListLearners();

        for (String[] i : list) {

            row = new TableRow(this);
            item0 = new TextView(this);
            item1 = new TextView(this);
            item0.setPadding(5, 0, 5, 0);
            item1.setPadding(5, 0, 5, 0);
            item0.setText(i[0]);
            row.addView(item0);
            item1.setText(i[1]);
            row.addView(item1);

            docstable.addView(row);

        }
        Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show();
    }

    public void ParticipantsButton(View v){ //кнопка имеющие доступ
        docsLay.setVisibility(View.GONE);
        addingLay.setVisibility(View.GONE);
        ElJurLay.setVisibility(View.GONE);
        tableDocsLay.setVisibility(View.VISIBLE);
        choose_class_lay.setVisibility(View.GONE);
        docstable = findViewById(R.id.table_documents);

        docstable.removeAllViews();

        TableRow row = new TableRow(this);
        TextView item0 = new TextView(this);
        TextView item1 = new TextView(this);
        item0.setPadding(5, 0, 5, 0);
        item1.setPadding(5, 0, 5, 0);
        row.setPadding(0, 2, 0, 2);
        item0.setText("ФИО");
        row.addView(item0, 0);
        item1.setText("CardID");
        row.addView(item1, 1);
        docstable.addView(row);

        ArrayList<String[]> list= new ArrayList<String[]>();
        list = school.getListParticipants();

        for (String[] i : list) {

            row = new TableRow(this);
            item0 = new TextView(this);
            item1 = new TextView(this);
            item0.setPadding(5, 0, 5, 0);
            item1.setPadding(5, 0, 5, 0);
            item0.setText(i[0]);
            row.addView(item0);
            item1.setText(i[1]);
            row.addView(item1);

            docstable.addView(row);

        }
        Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show();
    }

    public void ClassesButton(View v){ //кнопка имеющие доступ
        docsLay.setVisibility(View.GONE);
        addingLay.setVisibility(View.GONE);
        tableDocsLay.setVisibility(View.GONE);
        ElJurLay.setVisibility(View.GONE);
        choose_class_lay.setVisibility(View.VISIBLE);
        button_classes_generate = findViewById(R.id.button_classes_generate);
        button_classes_back = findViewById(R.id.button_classes_back);
        spinner_classes = findViewById(R.id.spinner_classes);

        ArrayList<Class> classes = new ArrayList<Class>();
        classes = school.getClasses();
        String[] data = new String[classes.size()];
        for (int i = 0; i < classes.size(); i++) {
            data[i] = classes.get(i).getNumber();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_classes.setAdapter(adapter);
    }

    public void ClassesGenerateButton(View v){
        ArrayList<Class> classes = new ArrayList<Class>();
        ArrayList<String[]> list= new ArrayList<String[]>();
        classes = school.getClasses();
        String selected_name = "There are no classes. Add a class";
        if (spinner_classes.getChildCount()!=0) selected_name = spinner_classes.getSelectedItem().toString();
        for (Class i: classes){
            if (i.getNumber().equals(selected_name)){
                list = i.getListLearnersAndParents();
                break;
            }
        }

        docsLay.setVisibility(View.GONE);
        addingLay.setVisibility(View.GONE);
        tableDocsLay.setVisibility(View.VISIBLE);
        choose_class_lay.setVisibility(View.GONE);
        ElJurLay.setVisibility(View.GONE);
        docstable = findViewById(R.id.table_documents);
        docstable.removeAllViews();

        TableRow row = new TableRow(this);
        TextView item0 = new TextView(this);
        TextView item1 = new TextView(this);
        TextView item2 = new TextView(this);
        item0.setPadding(5, 0, 5, 0);
        item1.setPadding(5, 0, 5, 0);
        item2.setPadding(5, 0, 5, 0);
        item0.setText("ФИО ученика");
        row.addView(item0);
        item1.setText("ФИО родителя1");
        row.addView(item1);
        item2.setText("ФИО родителя2");
        row.addView(item2);
        docstable.addView(row);

        for (String[] i : list) {
            row = new TableRow(this);
            item0 = new TextView(this);
            item1 = new TextView(this);
            item2 = new TextView(this);
            item0.setPadding(5, 0, 5, 0);
            item1.setPadding(5, 0, 5, 0);
            item2.setPadding(5, 0, 5, 0);
            item0.setText(i[0]);
            row.addView(item0);
            item1.setText(i[1]);
            row.addView(item1);
            item2.setText(i[2]);
            row.addView(item2);

            docstable.addView(row);
        }
    }

    public void Adding(View v){   //кнопка добавления
        startLay.setVisibility(View.GONE);
        docsLay.setVisibility(View.GONE);
        ElJurLay.setVisibility(View.GONE);
        addingLay.setVisibility(View.VISIBLE);
        choose_class_lay.setVisibility(View.GONE);
        tableDocsLay.setVisibility(View.GONE);
        spinner_participants = findViewById(R.id.spinner_participants);
        text_fullName = findViewById(R.id.text_fullName);
        text_phone = findViewById(R.id.text_phone);
        text_ID = findViewById(R.id.text_ID);
        text_position = findViewById(R.id.text_position);
        text_qualification = findViewById(R.id.text_qualification);
        text_age = findViewById(R.id.text_age);
        text_parent1fio = findViewById(R.id.text_parent1fio);
        text_parent1phone = findViewById(R.id.text_parent1phone);
        text_parent2fio = findViewById(R.id.text_parent2fio);
        text_parent2phone = findViewById(R.id.text_parent2phone);
        button_add = findViewById(R.id.button_add);
        button_continue = findViewById(R.id.button_continue);

        text_fullName.setVisibility(View.GONE);
        text_phone.setVisibility(View.GONE);
        text_ID.setVisibility(View.GONE);
        text_age.setVisibility(View.GONE);
        text_parent1fio.setVisibility(View.GONE);
        text_parent1phone.setVisibility(View.GONE);
        text_parent2fio.setVisibility(View.GONE);
        text_parent2phone.setVisibility(View.GONE);
        text_position.setVisibility(View.GONE);
        text_qualification.setVisibility(View.GONE);

        button_continue.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                id = spinner_participants.getSelectedItem().toString();
                text_fullName.setText(null);
                text_phone.setText(null);
                text_ID.setText(null);
                text_age.setText(null);
                text_parent1fio.setText(null);
                text_parent1phone.setText(null);
                text_parent2fio.setText(null);
                text_parent2phone.setText(null);
                text_position.setText(null);
                text_qualification.setText(null);
                switch(id) {
                    case "Ученик":
                        text_fullName.setVisibility(View.VISIBLE);
                        text_phone.setVisibility(View.VISIBLE);
                        text_ID.setVisibility(View.VISIBLE);
                        text_age.setVisibility(View.VISIBLE);
                        text_parent1fio.setVisibility(View.VISIBLE);
                        text_parent1phone.setVisibility(View.VISIBLE);
                        text_parent2fio.setVisibility(View.VISIBLE);
                        text_parent2phone.setVisibility(View.VISIBLE);
                        text_position.setVisibility(View.GONE);
                        text_qualification.setVisibility(View.GONE);
                        break;
                    case "Учитель":
                        text_fullName.setVisibility(View.VISIBLE);
                        text_phone.setVisibility(View.VISIBLE);
                        text_ID.setVisibility(View.VISIBLE);
                        text_position.setVisibility(View.VISIBLE);
                        text_qualification.setVisibility(View.VISIBLE);
                        text_parent1fio.setVisibility(View.GONE);
                        text_age.setVisibility(View.GONE);
                        text_parent1phone.setVisibility(View.GONE);
                        text_parent2fio.setVisibility(View.GONE);
                        text_parent2phone.setVisibility(View.GONE);
                        break;
                    case "Работник":
                        text_fullName.setVisibility(View.VISIBLE);
                        text_phone.setVisibility(View.VISIBLE);
                        text_ID.setVisibility(View.VISIBLE);
                        text_position.setVisibility(View.VISIBLE);
                        text_age.setVisibility(View.GONE);
                        text_parent1fio.setVisibility(View.GONE);
                        text_parent1phone.setVisibility(View.GONE);
                        text_parent2fio.setVisibility(View.GONE);
                        text_parent2phone.setVisibility(View.GONE);
                        text_qualification.setVisibility(View.GONE);
                        break;
                }
            }
        });

        button_add.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                id = spinner_participants.getSelectedItem().toString();
                switch(id) {
                    case "Ученик":
                        if (text_fullName.getText().toString().equals("") || text_phone.getText().toString().equals("") || text_ID.getText().toString().equals("")  ||
                                text_parent1fio.getText().toString().equals("") || text_parent1phone.getText().toString().equals("") || text_parent2phone.getText().toString().equals("") || text_parent2fio.getText().toString().equals("") || text_age.getText().toString().equals("")){
                            Toast.makeText(getApplicationContext(), "Не все поля заполнены", Toast.LENGTH_SHORT).show();
                        } else {
                            Parent p1 = new Parent(text_parent1phone.getText().toString(), text_parent1fio.getText().toString());
                            Parent p2 = new Parent(text_parent1phone.getText().toString(), text_parent1fio.getText().toString());
                            int i = Integer.parseInt (text_ID.getText().toString());
                            Learner l = new Learner(text_phone.getText().toString(), text_fullName.getText().toString(), i, p1, p2 , text_age.getText().toString());
                            school.addLearner(l);
                            text_fullName.setVisibility(View.GONE);
                            text_phone.setVisibility(View.GONE);
                            text_ID.setVisibility(View.GONE);
                            text_age.setVisibility(View.GONE);
                            text_parent1fio.setVisibility(View.GONE);
                            text_parent1phone.setVisibility(View.GONE);
                            text_parent2fio.setVisibility(View.GONE);
                            text_parent2phone.setVisibility(View.GONE);
                            text_position.setVisibility(View.GONE);
                            text_qualification.setVisibility(View.GONE);
                            text_fullName.setText(null);
                            text_phone.setText(null);
                            text_ID.setText(null);
                            text_age.setText(null);
                            text_parent1fio.setText(null);
                            text_parent1phone.setText(null);
                            text_parent2fio.setText(null);
                            text_parent2phone.setText(null);
                            text_position.setText(null);
                            text_qualification.setText(null);
                        }
                        break;
                    case "Учитель":
                        if (text_fullName.getText().toString().equals("") || text_phone.getText().toString().equals("") || text_ID.getText().toString().equals("")  ||
                                text_position.getText().toString().equals("") || text_qualification.getText().toString().equals("")){
                            Toast.makeText(getApplicationContext(), "Не все поля заполнены", Toast.LENGTH_SHORT).show();
                        } else {
                            int i = Integer.parseInt (text_ID.getText().toString());
                            Teacher t = new Teacher(text_phone.getText().toString(), text_fullName.getText().toString(), i, text_position.getText().toString(), text_qualification.getText().toString());
                            school.addTeacher(t);
                            text_fullName.setVisibility(View.GONE);
                            text_phone.setVisibility(View.GONE);
                            text_ID.setVisibility(View.GONE);
                            text_age.setVisibility(View.GONE);
                            text_parent1fio.setVisibility(View.GONE);
                            text_parent1phone.setVisibility(View.GONE);
                            text_parent2fio.setVisibility(View.GONE);
                            text_parent2phone.setVisibility(View.GONE);
                            text_position.setVisibility(View.GONE);
                            text_qualification.setVisibility(View.GONE);
                            text_fullName.setText(null);
                            text_phone.setText(null);
                            text_ID.setText(null);
                            text_age.setText(null);
                            text_parent1fio.setText(null);
                            text_parent1phone.setText(null);
                            text_parent2fio.setText(null);
                            text_parent2phone.setText(null);
                            text_position.setText(null);
                            text_qualification.setText(null);
                        }
                        break;
                    case "Работник":
                        if (text_fullName.getText().toString().equals("") || text_phone.getText().toString().equals("") || text_ID.getText().toString().equals("")  ||
                                text_position.getText().toString().equals("")){
                            Toast.makeText(getApplicationContext(), "Не все поля заполнены", Toast.LENGTH_SHORT).show();
                        } else {
                            int i = Integer.parseInt (text_ID.getText().toString());
                            Employee e = new Employee(text_phone.getText().toString(), text_fullName.getText().toString(), i, text_position.getText().toString());
                            school.addEmployee(e);
                            text_fullName.setVisibility(View.GONE);
                            text_phone.setVisibility(View.GONE);
                            text_ID.setVisibility(View.GONE);
                            text_age.setVisibility(View.GONE);
                            text_parent1fio.setVisibility(View.GONE);
                            text_parent1phone.setVisibility(View.GONE);
                            text_parent2fio.setVisibility(View.GONE);
                            text_parent2phone.setVisibility(View.GONE);
                            text_position.setVisibility(View.GONE);
                            text_qualification.setVisibility(View.GONE);
                            text_fullName.setText(null);
                            text_phone.setText(null);
                            text_ID.setText(null);
                            text_age.setText(null);
                            text_parent1fio.setText(null);
                            text_parent1phone.setText(null);
                            text_parent2fio.setText(null);
                            text_parent2phone.setText(null);
                            text_position.setText(null);
                            text_qualification.setText(null);
                        }
                        break;
                }
            }
        });
    }

    public void ElJurStart(View v) throws ParseException {
        ElJurLay.setVisibility(View.VISIBLE);
        Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_LONG).show();
        startLay.setVisibility(View.GONE);
        addingLay.setVisibility(View.GONE);
        docsLay.setVisibility(View.GONE);
        choose_class_lay.setVisibility(View.GONE);
        tableDocsLay.setVisibility(View.GONE);

        spinner_clas = findViewById(R.id.spinner_clas);
        spinner_sub = findViewById(R.id.spinner_sub);
        table_eljur = findViewById(R.id.table_eljur);

        ArrayList<Class> classes = school.getClasses();
        String[] data = new String[classes.size()];
        for (int i=0;i<classes.size();i++) {
            data[i] = classes.get(i).getNumber();
        }
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_clas.setAdapter(adapter);

        if (spinner_clas.getCount() == 0){
            Toast.makeText(this, "Ошбика. Класс не выбран", Toast.LENGTH_SHORT).show();
            return;
        }
        // получение экземпляр класса
        Class selected_class;
        String selected_name = spinner_clas.getSelectedItem().toString();
        for (Class i: classes){
            if (i.getNumber().equals(selected_name)){
                selected_class = i;
                ArrayList<Section> sections = i.sections;
                String[] data2 = new String[sections.size()];
                for (int j = 0; j < sections.size(); j++) {
                    data2[j] = sections.get(j).Get_Sub();
                }
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data2);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_sub.setAdapter(adapter2);
                break;
            }
        }
        for (Class i: classes){
            if (i.getNumber().equals(selected_name)){
                selected_class = i;
                TableRow row2 = new TableRow(this);
                TextView item2 = new TextView(this);
                item2.setPadding(15, 0, 15, 0);
                item2.setText("ФИО");
                row2.addView(item2);
                String dt = "01-09-2020";  // Start date
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Calendar c = Calendar.getInstance();
                c.setTime(sdf.parse(dt));
                for (int k = 0; k < 10; k++){
                    TextView item1 = new TextView(this);
                    item1.setPadding(15, 0, 15, 0);
                    item1.setText(sdf.format(c.getTime()));
                    row2.addView(item1);
                    c.add(c.DATE, 7);
                }
                table_eljur.addView(row2);
                for (int k = 0; k < selected_class.learners.size(); k++){
                    TableRow row = new TableRow(this);
                    TextView item1 = new TextView(this);
                    item1.setPadding(5, 0, 5, 0);
                    item1.setText(selected_class.learners.get(k).getName());
                    row.addView(item1);
                    for (int z = 0; z < 10; z++){
                        TextView item0 = new TextView(this);
                        item0.setPadding(60, 0, 60, 0);
                        item0.setText("5");
                        row.addView(item0);
                    }
                    table_eljur.addView(row);
                }
                break;
            }
        }
        /*for (int k = 0; k < 30; k++){

        }
        String dt = "01-09-2020";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        //c.add(c.DATE, 30);  // number of days to add-
        dt = sdf.format(c.getTime());
        TableRow row = new TableRow(this);
        TextView item0 = new TextView(this);
        TextView item1 = new TextView(this);
        TextView item2 = new TextView(this);
        item0.setPadding(5, 0, 5, 0);
        item1.setPadding(5, 0, 5, 0);
        item2.setPadding(5, 0, 5, 0);
        item0.setText("ФИО ученика");
        row.addView(item0);
        item1.setText("ФИО родителя1");
        row.addView(item1);
        item2.setText("ФИО родителя2");
        row.addView(item2);
        docstable.addView(row);*/
    }
}
