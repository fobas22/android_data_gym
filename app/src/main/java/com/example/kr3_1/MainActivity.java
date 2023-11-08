package com.example.kr3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button add_btn,close_btn;
    private EditText name,lName,height,weight,age;
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> lNames = new ArrayList<String>();
    private ArrayList<String> heights = new ArrayList<String>();
    private ArrayList<Integer> weights = new ArrayList<Integer>();
    private ArrayList<String> ages = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn = (Button) findViewById(R.id.addBtn);
        close_btn = (Button) findViewById(R.id.closeBtn);
        name = (EditText) findViewById(R.id.nameV);
        lName = (EditText) findViewById(R.id.lastNameV);
        height = (EditText) findViewById(R.id.heightV);
        weight = (EditText) findViewById(R.id.weightV);
        age = (EditText) findViewById(R.id.ageV);
    }

    public void onClick(View view){
        int id = view.getId();

        if (id==R.id.addBtn)
        {
            if (
                    name.getText().toString().equals("") ||
                            lName.getText().toString().equals("") ||
                            height.getText().toString().equals("") ||
                            weight.getText().toString().equals("") ||
                            age.getText().toString().equals("") )
            {
                Toast.makeText(MainActivity.this, "Заполни все поля!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                names.add(name.getText().toString());
                lNames.add(lName.getText().toString());
                heights.add(height.getText().toString());
                weights.add(Integer.valueOf(weight.getText().toString()));
                ages.add(age.getText().toString());
                name.setText("");
                lName.setText("");
                height.setText("");
                weight.setText("");
                age.setText("");
                Toast.makeText(MainActivity.this, "Добавлен!", Toast.LENGTH_SHORT).show();
            }
        }
        if (id==R.id.closeBtn)
        {
            Intent intent = new Intent(MainActivity.this, ViewVisitors.class);
            for(int i=0;i<names.size();i++) {
                intent.putExtra("Visitor"+i+1, new Visitor(names.get(i), lNames.get(i), heights.get(i), weights.get(i), ages.get(i)));
            }
            intent.putExtra("Quantity",names.size());
            startActivity(intent);
        }
    }
}
