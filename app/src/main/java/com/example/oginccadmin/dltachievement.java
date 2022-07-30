package com.example.oginccadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class dltachievement extends AppCompatActivity {

    private ListView listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dltachievement);
        listView2 = findViewById(R.id.listview2);

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> key_list = new ArrayList<String>();
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this,R.layout.list_items, list);
        listView2.setAdapter(arrayAdapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("App").child("Achievements");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    key_list.add(snapshot.getKey());
                    list.add(snapshot.getValue().toString());
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //Delete
        listView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                arrayAdapter.notifyDataSetChanged();
                reference.child(key_list.get(position)).removeValue();
                key_list.remove(position);
                Toast.makeText(dltachievement.this, "Deleted", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}