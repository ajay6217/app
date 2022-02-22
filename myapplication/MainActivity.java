package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String [] arr={"this is ","item","item2"," tguhij"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        //ArrayAdapter ad= new ArrayAdapter(this, android.R.layout.simple_list_item_1,arr);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // for built in adapter
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "you", Toast.LENGTH_SHORT).show();
            }
        });
        Ajayadapter ad=new Ajayadapter(this,R.layout.adplayout,arr);
        
        listView.setAdapter(ad);
    }
}
