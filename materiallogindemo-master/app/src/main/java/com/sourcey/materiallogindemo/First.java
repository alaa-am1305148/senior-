package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

     DatabaseReference databaseZone;
        databaseZone = FirebaseDatabase.getInstance().getReference("zones");
       Property zone =
      //  new Property("CAAS Female Zone", 0,4);
     // new Property("CENG Male Zone", 0,  4);
    //  new Property("BNK Male Zone", 0, 4);

     new Property("CBAE Female & Male Zone", 0, 4);
     //  new Property("LIB Female & Male Zone", 0, 4);

     /*   Spot spot = new Spot("CENG Female Zone", 2, 1);
     // Spot spot = new Spot("CENG Female Zone", 1, 2);
      // Spot spot = new Spot("CENG Female Zone", 1, 3);
      //  Spot spot = new Spot("CENG Female Zone", 1, 4);*/
        String id = databaseZone.push().getKey();
        databaseZone.child(id).setValue(zone);

        // conitne a s vip or normal

        final Button normalBtn = findViewById(R.id.normal_btn);
        Button vipBtn = findViewById(R.id.vip_btn);


        normalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent normalIntent = new Intent(First.this,Choices2.class);
                startActivity(normalIntent);
            }
        });


        vipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vipIntent = new Intent(First.this,LoginActivity.class);
                startActivity(vipIntent);
            }
        });


    }
}
