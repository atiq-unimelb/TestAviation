package com.flightcenter.testaviation.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flightcenter.testaviation.R;
import com.flightcenter.testaviation.activities.FlightDetailsActivity;
import com.flightcenter.testaviation.activities.FlightListActivity;
import com.flightcenter.testaviation.model.Flight;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
 * This class demonstrate
 * 1. Recycler View Adapter for flights
 * Atiq Shaikh 1/11/2019
 * */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private static final String TAG = "RvAdapter";
    private Context mContext ;
    //Declaring ArrayList of flights
    private List<Flight> flightList ;

    public RvAdapter(Context mContext, List lst) {
        this.mContext = mContext;
        this.flightList = lst;
    }

    @NonNull
    @Override
    //  Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent an item.
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_row_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    // to bind the resources to viewHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        long totalTime = getTotalTime(flightList.get(position).getArrivalDate(), flightList.get(position).getDepartureDate());

        holder.departureAirport.setText(flightList.get(position).getDepartureAirport());
        holder.departureTime.setText(flightList.get(position).getDepartureDate());
        holder.departureCity.setText(flightList.get(position).getDepartureCity());
        holder.arrivalAirport.setText(flightList.get(position).getArrivalAirport());
        holder.arrivalTime.setText(flightList.get(position).getArrivalDate());
        holder.arrivalCity.setText(flightList.get(position).getArrivalCity());
        holder.toDestination.setText("Flights to " +(flightList.get(position).getArrivalCity()));
        //holder.totalTime.setText((int) totalTime);


        // To show how to add click listener to a item in recyclerView
        // Set onClickListener for the list item (when user click on a particular flight);
        // When clicking a item from the list, it will take you to flight details page;
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = view.getContext();
                Intent intent = new Intent(context, FlightDetailsActivity.class);
                intent.putExtra("departureAirport",flightList.get(position).getDepartureAirport());
                intent.putExtra("departureTime",flightList.get(position).getDepartureDate());
                intent.putExtra("departureCity",flightList.get(position).getDepartureCity());
                intent.putExtra("arrivalAirport",flightList.get(position).getArrivalAirport());
                intent.putExtra("arrivalTime",flightList.get(position).getArrivalDate());
                intent.putExtra("arrivalCity",flightList.get(position).getArrivalCity());
                context.startActivity(intent);

            }
        });
    }

    private long getTotalTime(String arrivalDate, String departureDate) {

        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss:ms");
        Date d1 = null;
        Date d2 = null;
        long diffSeconds;
        long diffMinutes;
        long diffHours = 0;

        try {
            d1 = format.parse(arrivalDate);
            d2 = format.parse(departureDate);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            diffSeconds = diff / 1000 % 60;
            diffMinutes = diff / (60 * 1000) % 60;
            diffHours = diff / (60 * 60 * 1000) % 24;

            Log.d(TAG, "getTotalTime: "+diffHours+" hr "+diffMinutes+" min "+diffSeconds);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return diffHours;
    }

    @Override
    // to get the size of the flights array
    public int getItemCount() {
        return flightList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //To bind textview and linearlayout from flight_row_item.xml to show respective details
        TextView departureAirport, departureTime, departureCity;
        TextView arrivalAirport, arrivalTime, arrivalCity;
        TextView toDestination;
        TextView totalTime;
        LinearLayout parentLayout;

        ViewHolder(View view) {
            super(view);
            departureAirport = view.findViewById(R.id.departure_Airport);
            departureTime = view.findViewById(R.id.departure_Time);
            departureCity = view.findViewById(R.id.departure_City);
            arrivalAirport = view.findViewById(R.id.arrival_Airport);
            arrivalTime = view.findViewById(R.id.arrival_Time);
            arrivalCity = view.findViewById(R.id.arrival_City);
            toDestination = view.findViewById(R.id.to_Destination);
            totalTime = view.findViewById(R.id.total_time);
            parentLayout = view.findViewById(R.id.parent_Layout);
        }

    }


}
