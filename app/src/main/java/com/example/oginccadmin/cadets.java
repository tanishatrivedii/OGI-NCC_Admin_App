package com.example.oginccadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class cadets extends AppCompatActivity {

    private Button add1;
    private EditText name , fname, college, enyear;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("App").child("Cadets");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadets);

        name = findViewById(R.id.editText1);
        fname = findViewById(R.id.editText2);
        college = findViewById(R.id.editText4);
        enyear = findViewById(R.id.editText5);
        add1 = findViewById(R.id.add1);


        add1.setOnClickListener(v -> {

            String c_name = name.getText().toString();
            String f_name = fname.getText().toString();
            String college_name = college.getText().toString();
            String en_year = enyear.getText().toString();

            HashMap<String, String> userMap = new HashMap<>();

            userMap.put("Name", c_name);
            userMap.put("father_name", f_name);
            userMap.put("college", college_name);
            userMap.put("en_Year", en_year);
            //    database
            root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(cadets.this, "Cadet added successfully", Toast.LENGTH_SHORT).show();

                }
            });

        });
    }
}