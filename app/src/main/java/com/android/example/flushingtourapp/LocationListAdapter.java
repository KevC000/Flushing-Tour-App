package com.android.example.flushingtourapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.MyViewHolder> {

    private ArrayList<Location> locations;

    public LocationListAdapter(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView description;
        private ImageView image;
        private TextView link;
        private TextView location;
        private TextView phone;


        public MyViewHolder(final View view) {
            super(view);
            name = view.findViewById(R.id.location_name_text);
            description = view.findViewById(R.id.location_description_text);
            image = view.findViewById(R.id.location_image);
            link = view.findViewById(R.id.link_text);
            location = view.findViewById(R.id.map_location_text);
            phone = view.findViewById(R.id.phone_text);

        }
    }

    @NonNull
    @Override
    public LocationListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_info, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationListAdapter.MyViewHolder holder, int position) {
        String name = locations.get(position).getName();
        String description = locations.get(position).getDescription();
        int image = locations.get(position).getImage();
        String link = locations.get(position).getLink();
        String location = locations.get(position).getLocation();
        String phone = locations.get(position).getPhone();

        holder.name.setText(name);
        holder.description.setText(description);
        holder.image.setImageResource(image);
        holder.link.setText(link);
        holder.location.setText(location);
        holder.phone.setText(phone);
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }
}
