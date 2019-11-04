package com.flightcenter.testaviation.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.flightcenter.testaviation.R;

/*
 * This class demonstrate
 * 1. Initial Activity of an application or
 * Landing page of an application
 * Atiq Shaikh 31/10/2019
 * */

public class MainActivity extends AppCompatActivity {

    //Declaring button to go to flight list page
    private Button btnFlightList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting the button
        btnFlightList = (Button) findViewById(R.id.flightList);
        //Setting onclick listener for a button
        btnFlightList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFlightList();
            }
        });

    }

    //Navigating from Main Activity to Flight List Activity through Intent
    private void goToFlightList() {
        Intent intent1 = new Intent(MainActivity.this, FlightListActivity.class);
        startActivity(intent1);
    }

}
