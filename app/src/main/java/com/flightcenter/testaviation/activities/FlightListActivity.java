package com.flightcenter.testaviation.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.flightcenter.testaviation.R;
import com.flightcenter.testaviation.adapter.RvAdapter;
import com.flightcenter.testaviation.model.Flight;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
 * This class demonstrate
 * 1. Accessing data from the JSON file,
 * 2. Storing JSON Data in ArrayList of flights and
 * 3. Set Recycler View Adapter for flights
 * Atiq Shaikh 31/10/2019
 * */

public class FlightListActivity extends AppCompatActivity {

    private static final String TAG = "FlightListActivity";
    private List<Flight> flightArrayList = new ArrayList<>();
    private RecyclerView flightRecyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_list);

        //getting the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setting text color
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);


        flightRecyclerView = findViewById(R.id.rv);
        getFlightJsonData(getApplicationContext());
    }

    //Get the data from JSON
    public void getFlightJsonData(Context context){
        String json=null;
        try{
            //Accessing JSON file
            InputStream inputStream = context.getAssets().open("flight_list.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer,"UTF-8");
            //Storing JSON data in JSON Array
            JSONArray jsonArray = new JSONArray(json);
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

            //Iterating JSON Array
            for(int i=0;i<jsonArray.length();i++)
            {
                //Particular instance of JSON Object
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Log.d(TAG, "getFlightJsonData: "+ jsonObject);
                //Toast.makeText(getApplicationContext(),jsonObject.toString(),Toast.LENGTH_LONG).show();
                //Setting JSON data to a flight
                Flight flight = new Flight();
                flight.setId(jsonObject.getInt("id"));
                flight.setDepartureDate(jsonObject.getString("departure_date"));
                flight.setAirlineCode(jsonObject.getString("airline_code"));
                flight.setFlightNumber(jsonObject.getInt("flight_number"));
                flight.setDepartureCity(jsonObject.getString("departure_city"));
                flight.setDepartureAirport(jsonObject.getString("departure_airport"));
                flight.setArrivalCity(jsonObject.getString("arrival_city"));
                flight.setArrivalAirport(jsonObject.getString("arrival_airport"));
                flight.setScheduledDuration(jsonObject.getString("scheduled_duration"));
                flight.setArrivalDate(jsonObject.getString("arrival_date"));
                flightArrayList.add(flight);
            }


        }catch (Exception e){
            Log.d(TAG, "getFlightJsonData: Error occured "+e.getMessage());
            e.printStackTrace();
        }

        setRvAdapter(flightArrayList);
    }

    //Setting up Recycler View Adapter for flights
    public void setRvAdapter (List<Flight> lst) {

        RvAdapter myAdapter = new RvAdapter(this,lst) ;
        flightRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        flightRecyclerView.setAdapter(myAdapter);
    }



}
