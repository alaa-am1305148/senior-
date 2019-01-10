package com.sourcey.materiallogindemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alaa on 1/10/2019.
 */

public class ShowReservations extends AppCompatActivity {
    ListView list;
    List<Reservation> reservations;
    List<Reservation> reservations2;
     User userLogged = Choices.user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_list);
        reservations = new ArrayList<>();
        reservations2 = new ArrayList<>();
        Intent i = getIntent();
        reservations = (List<Reservation>) i.getSerializableExtra("LIST");
        for (int j=0; j< reservations.size(); j++){
            if (reservations.get(j).getCarPlateNo().equals(userLogged.getPlateNo())){
                reservations2.add(reservations.get(j));
            }
        }
            list = (ListView) findViewById(R.id.listMenu);
            list.setAdapter(new ReservationAdapter(this, reservations2));

    }
    class ReservationAdapter extends ArrayAdapter<Reservation>
    {
        public ReservationAdapter(Context c, List<Reservation>  reservations2)
        {
            super( c,R.layout.menu_list_item,reservations2);
        }
        public View getView (int p, View v, ViewGroup parent)
        {
            if (v==null)
            {
                LayoutInflater in=LayoutInflater.from(getContext());
                v=in.inflate(R.layout.menu_list_item,parent,false);

            }

            TextView date =v.findViewById(R.id.date);
            TextView ResNo =v.findViewById(R.id.ResNo);
            TextView time =v.findViewById(R.id.time);
            TextView zoneName =v.findViewById(R.id.zoneName);
            ResNo.setText("Reservation No: "+getItem(p).getResNo()+"");
            date.setText("Date: "+getItem(p).getData());
            zoneName.setText("Zone Name: "+getItem(p).getZoneName());
            int endTime = getItem(p).getTime().get(getItem(p).getTime().size()-1)+1;
            time.setText("Time: "+getItem(p).getTime().get(0)+ " to " + endTime );

            return v;
        }
    }
}