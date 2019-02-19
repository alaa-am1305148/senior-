package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Check_availability extends AppCompatActivity {
    List<Spot> spots;
    DatabaseReference databaseSpot;
    Button btn1, btn2, btn3, btn4;
    ImageView img3, img4;
    String zoneName;

     List<Property> zones;
    DatabaseReference databaseZones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_availability_2);

        zones = new ArrayList<>();
        databaseZones = FirebaseDatabase.getInstance().getReference("zones");

        databaseZones.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                // if(users != null)
                zones.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Property zone = postSnapshot.getValue(Property.class);
                    //adding artist to the list
                    zones.add(zone);
                }
                // int count =0;

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

       zoneName= getIntent().getStringExtra("zoneName");

        btn1 =(Button) findViewById(R.id.btn1);
        btn2 =(Button) findViewById(R.id.btn2);
        btn3 =(Button) findViewById(R.id.btn3);
        btn4 =(Button) findViewById(R.id.btn4);

        img3 =(ImageView) findViewById(R.id.img3);
        img4 =(ImageView) findViewById(R.id.img4);

        databaseSpot = FirebaseDatabase.getInstance().getReference("spots");
         spots = new ArrayList<>();
      /*  Spot spot = new Spot("A", 0, 4);
        String id = databaseSpot.push().getKey();
        databaseSpot.child(id).setValue(spot);*/
        databaseSpot.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // if(users != null)
                spots.clear();


                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Spot spot = postSnapshot.getValue(Spot.class);
                    spots.add(spot);
                }


                for(int i=0;  i< spots.size(); i++){
                    if(spots.get(i).getZoneName().equals(zoneName)){
                        if(spots.get(i).getStatus() == 2)
                        {
                      /*  if (spots.get(i).getSpotNo() == 1){
                          //  btn1.setBackgroundColor(Color.WHITE);


                        }
                        if (spots.get(i).getSpotNo() == 2){
                          //  btn2.setBackgroundColor(Color.WHITE);
                        }
                        if (spots.get(i).getSpotNo() == 3){
                           // btn3.setBackgroundColor(Color.WHITE);
                            img3.setVisibility(View.INVISIBLE);

                        }*/
                            if (spots.get(i).getSpotNo() == 1){
                                //  btn4.setBackgroundColor(Color.WHITE);
                                img4.setVisibility(View.INVISIBLE);
                            }
                        }
                        else
                        {
                       /* if (spots.get(i).getSpotNo() == 1){
                         //   btn1.setBackgroundColor(Color.RED);
                        }
                        if (spots.get(i).getSpotNo() == 2){
                          //  btn2.setBackgroundColor(Color.RED);
                        }
                        if (spots.get(i).getSpotNo() == 3){
                          //  btn3.setBackgroundColor(Color.RED);
                            img3.setVisibility(View.VISIBLE);
                        }*/
                            if (spots.get(i).getSpotNo() == 1){
                                //  btn4.setBackgroundColor(Color.RED);
                                img4.setVisibility(View.VISIBLE);
                            }
                        }
                    }




                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    protected void onStop() {
        super.onStop();

        for (int j = 0; j <zones.size(); j++) {
            if (zones.get(j).getZoneName().equals(zoneName)) {
                int count = zones.get(j).getCurrentlyLooking();
                count--;
                Property zone = new Property(zones.get(j).getZoneName(), count, zones.get(j).getTotalSpotsNo());

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

                Query applesQuery = ref.child("zones").orderByChild("zoneName").equalTo(zoneName);

                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot : dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

                String id2 = databaseZones.push().getKey();
                databaseZones.child(id2).setValue(zone);
                finish();

            }
        }
    }
}
