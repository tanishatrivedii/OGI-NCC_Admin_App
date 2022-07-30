package com.example.oginccadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class notice extends AppCompatActivity {

    //creating data members
    private Button add1;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        editText1 = findViewById(R.id.editText1);
        add1 = findViewById(R.id.add1);


        add1.setOnClickListener(v -> {
            String notice_name = editText1.getText().toString();
            if (notice_name.isEmpty()){
                Toast.makeText(notice.this, "No data inserted", Toast.LENGTH_SHORT).show();
            } else{
                //    database

                FirebaseDatabase.getInstance().getReference().child("App").child("Notices").push().setValue(notice_name);
                Toast.makeText(notice.this, "Notice inserted successfully", Toast.LENGTH_SHORT).show();}
        });
    }

    public void deletenotice(View view){
        Intent intent = new Intent(this, deletenotice.class);
        startActivity(intent);
    }
}