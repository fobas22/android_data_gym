package com.example.kr3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewVisitors extends AppCompatActivity {

    private ListView visitorsView;
    private int quantity = 0;
    private String name[] = new String[quantity];
    private String lName[] = new String[quantity];
    private String height[] = new String[quantity];
    private int weight[] = new int[quantity];
    private String age[] = new String[quantity];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitors);
        getSupportActionBar().setTitle("Список посетителей");
        visitorsView = findViewById(R.id.listVisitors);
        quantity = getIntent().getIntExtra("Quantity",0);
        Log.i("Количество",String.valueOf(quantity));

        name = new String[quantity];
        lName = new String[quantity];
        height = new String[quantity];
        weight = new int[quantity];
        age = new String[quantity];

        for (int i = 0; i < quantity; i++) {
            Visitor documentInfo = (Visitor) getIntent().getParcelableExtra("Visitor" + i + 1);
            name[i] = documentInfo.getName();
            lName[i] = documentInfo.getLastName();
            height[i] = documentInfo.getHeight();
            weight[i] = documentInfo.getWeight();
            age[i] = documentInfo.getbYear();
        }
    }

    public void onClick(View view)
    {//разные конструкторы для разного вывода по заданию
        int id = view.getId();
        if (id == R.id.btn1){
            //1 конструктор Все данные;
            Visitor b;
            String[]  l1 = new String[quantity];
            for (int i = 0; i < quantity; i++)
            {
                b = new Visitor(name[i],lName[i],height[i],weight[i],age[i]);
                l1[i]= "ФИО:"+b.lastName+ " "+b.name +" Рост:" + b.height +" Вес:"+ b.weight+ " Возраст:"+ b.bYear;
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, l1);
            visitorsView.setAdapter(adapter);
        }
        if (id == R.id.btn2){
            //2 конструктор Имя, фамилия, возраст
            Visitor b;
            String[]  l1 = new String[quantity];
            for (int i = 0; i < quantity; i++)
            {
                b = new Visitor(name[i],lName[i],age[i]);
                l1[i]= "ФИО:"+b.lastName+ " "+b.name +" Возраст:" + b.bYear;
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, l1);
            visitorsView.setAdapter(adapter);
        }
        if (id == R.id.btn3){
            //3 конструктор Имя, фамилия, вес.
            Visitor b;
            String[]  l1 = new String[quantity];
            for (int i = 0; i < quantity; i++)
            {
                b = new Visitor(name[i],lName[i],weight[i]);
                l1[i]= "ФИО:"+b.lastName+ " "+b.name +" Вес:" + b.weight;
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, l1);
            visitorsView.setAdapter(adapter);
        }
    }
}

