package com.example.oginccadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //screen1---achivements
    public void achivements(View view){
        Intent intent = new Intent(this, achievements.class);
        startActivity(intent);
    }

    //screen2---Notice and Forms
    public void notice(View view){
        Intent intent = new Intent(this, notice.class);
        startActivity(intent);
    }

    //screen3--- Syllabus and PDF's
    public void syllabus(View view){
        Intent intent = new Intent(this, syllabus.class);
        startActivity(intent);
    }

    //screen4--- Our Cadets
    public void cadets(View view){
        Intent intent = new Intent(this, cadets.class);
        startActivity(intent);
    }

    //screen5--- Gallery
    public void gallery(View view){
        Intent intent = new Intent(this, gallery.class);
        startActivity(intent);
    }

    //screen6--- Camps
    public void applicationform(View view){
        Intent intent = new Intent(this, applicationform.class);
        startActivity(intent);
    }

}