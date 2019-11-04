package com.flightcenter.testaviation.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.flightcenter.testaviation.R;

/*
 * This class demonstrate
 * 1. Check for list of incoming intents and get the data
 * 2. Set the data for flight details page
 * Atiq Shaikh 31/10/2019
 * */

public class FlightDetailsActivity extends AppCompatActivity {

    private static final String TAG = "FlightDetailsActivity";
    private ImageView secondPart;
    private ImageView lastPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        //Check for incoming intents from list item (particular flight)
        getIncomingIntent();

        //Present the terminal details of the flight
        secondPart = (ImageView) findViewById(R.id.middle_Part);
        int secondPartRes = getResources().getIdentifier("@drawable/middle_part", null, this.getPackageName());
        secondPart.setImageResource(secondPartRes);

        //Present the qr for entry inside the terminal
        lastPart = (ImageView) findViewById(R.id.last_Part);
        int lastPartRes = getResources().getIdentifier("@drawable/last_part", null, this.getPackageName());
        lastPart.setImageResource(lastPartRes);

    }

    //Getting incoming intents from a particular (flight) list item through an Adapter
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: Checking for incoming intents.");
        if(getIntent().hasExtra("departureAirport") &&
                getIntent().hasExtra("departureTime") &&
                getIntent().hasExtra("departureCity") &&
                getIntent().hasExtra("arrivalAirport") &&
                getIntent().hasExtra("arrivalTime") &&
                getIntent().hasExtra("arrivalCity")){
            String departureAirport = getIntent().getStringExtra("departureAirport");
            String departureTime = getIntent().getStringExtra("departureTime");
            String departureCity = getIntent().getStringExtra("departureCity");
            String arrivalAirport = getIntent().getStringExtra("arrivalAirport");
            String arrivalTime = getIntent().getStringExtra("arrivalTime");
            String arrivalCity = getIntent().getStringExtra("arrivalCity");

            //setting flight details
            setFlightDetails(departureAirport, departureTime, departureCity,
                    arrivalAirport, arrivalTime, arrivalCity);
            //Toast.makeText(getApplicationContext(),"Departure Airport: "+ departureAirport,Toast.LENGTH_LONG).show();
            //Log.d(TAG, "Departure Airport: "+departureAirport);
        }
    }

    //Setting details of the flight to flight detail xml
    private void setFlightDetails(String departureAirport, String departureTime, String departureCity,
                                  String arrivalAirport, String arrivalTime, String arrivalCity){
        TextView detailsDepartAirport= findViewById(R.id.departure_Airport);
        detailsDepartAirport.setText(departureAirport);
        TextView detailsDepartCity= findViewById(R.id.departure_City);
        detailsDepartCity.setText(departureCity);
        TextView detailsDepartTime= findViewById(R.id.departure_Time);
        detailsDepartTime.setText(departureTime);
        TextView detailsArrivalAirport= findViewById(R.id.arrival_Airport);
        detailsArrivalAirport.setText(arrivalAirport);
        TextView detailsArrivalCity= findViewById(R.id.arrival_City);
        detailsArrivalCity.setText(arrivalCity);
        TextView detailsArrivalTime= findViewById(R.id.arrival_Time);
        detailsArrivalTime.setText(arrivalTime);

    }


}
