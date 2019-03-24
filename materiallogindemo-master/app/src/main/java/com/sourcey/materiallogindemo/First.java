package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class First extends AppCompatActivity {
private DrawerLayout mDrawerLayout;
private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


    /*    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        Query applesQuery = ref.child("zones").orderByChild("zoneName").equalTo("CBAE Female & Male Zone");

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
        });*/
//
//       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar cal = Calendar.getInstance();
//        String date1 =  dateFormat.format(cal.getTime());


  /*  ArrayList<String> date = new ArrayList<String>();
//       date.add(date1);
       ArrayList<historyInfoPerDay> info = new ArrayList<historyInfoPerDay>();

        info.add(new historyInfoPerDay("6", 0, date));
        info.add(new historyInfoPerDay("7", 0, date));
        info.add(new historyInfoPerDay("8", 0, date));
        info.add(new historyInfoPerDay("9", 0, date));
        info.add(new historyInfoPerDay("10", 0, date));
        info.add(new historyInfoPerDay("11", 0, date));
        info.add(new historyInfoPerDay("12", 0, date));
        info.add(new historyInfoPerDay("13", 0, date));
        info.add(new historyInfoPerDay("14", 0, date));
        info.add(new historyInfoPerDay("15", 0, date));
        info.add(new historyInfoPerDay("16", 0, date));
        info.add(new historyInfoPerDay("17", 0, date));
        info.add(new historyInfoPerDay("18", 0, date));
        info.add(new historyInfoPerDay("19", 0, date));
        info.add(new historyInfoPerDay("20", 0, date));
        info.add(new historyInfoPerDay("21", 0, date));
        info.add(new historyInfoPerDay("22", 0, date));


            //    { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        History sun = new History( "Sun", info);
        History mon = new History( "Mon",info );
        History tue = new History( "Tue",info);
        History wed = new History("Wed",info);
        History thu = new History("Thu",info);
        History fri = new History( "Fri",info);
        History sat = new History( "Sat",info);

      //  History[] history = {sun, mon, tue, wed, thu, fri, sat};
        ArrayList<History> histories = new ArrayList<History>();
        histories.add(sun);
        histories.add(mon);
        histories.add(tue);
        histories.add(wed);
        histories.add(thu);
        histories.add(fri);
        histories.add(sat);


        Property zone = new Property("CBAE Female & Male Zone", 4, histories);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseZones = database.getReference("zones");
        String id = databaseZones.push().getKey();
        databaseZones.child(id).setValue(zone);

*/

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // conitne a s vip or normal

        final Button normalBtn = findViewById(R.id.btnMap);
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


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        switch (menuItem.getItemId()) {
                            case R.id.nav_aboutParQU:
                                Intent i = new Intent(First.this, AboutParQU.class);
                                startActivity(i);
                                break;

                            case R.id.nav_contactUs:
                                Intent i2 = new Intent(First.this, ContactUs.class);
                                startActivity(i2);
                                break;

                            case R.id.nav_shareThisApp:

                                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                                sharingIntent.setType("text/plain");
                                String shareBodyText = "Check it out. Your message goes here";
                                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
                                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                                startActivity(Intent.createChooser(sharingIntent, "Choose Sharing Method"));
                                return true;

                        }


                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;

        }
        return super.onOptionsItemSelected(item);
    }



    }
