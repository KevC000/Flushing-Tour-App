package com.android.example.flushingtourapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HotelsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HotelsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotelsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotelsFragment newInstance(String param1, String param2) {
        HotelsFragment fragment = new HotelsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ArrayList<Location> hotels =new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location_list,container,false);

        //ArrayList of hotel locations
        hotels.add(new Location("Hyatt Place Flushing",
                "Hyatt Place Flushing/LaGuardia Airport is an ultramodern hotel. It offers 168 guestrooms and one of the most unique rooftop spaces in the city—an outdoor garden, event spaces and restaurant and lounge with spectacular views of the Manhattan skyline.",
                R.drawable.hyatt,
                "https://www.hyatt.com/en-US/hotel/new-york/hyatt-place-flushing-laguardia-airport/nyczf",
                "133-42 39th Avenue, Flushing, New York, United States, 11354",
                "(718)888-1234"));
        hotels.add(new Location(
                "The Parc Hotel",
                "Trips to New York City don’t have to be expensive. Take advantage of the specials and deals at The Parc Hotel to save big on your upcoming vacation or business trip. All of our hotel specials in Flushing include complimentary WiFi and daily buffet breakfast.",
                R.drawable.parc,
                "https://www.theparchotel.com/",
                "3916 College Point Blvd"+"\nFlushing, NY 11354",
                "(718) 358-8897"));
        hotels.add(new Location(
                "Marco Laguardia Hotel",
                "Marco LaGuardia Hotel & Suites is the ideal place to unwind amid the high-vibe buzz of New York City. Our central location in Flushing, Queens, puts you close to the action and serves as a perfect hub for your exploration of the city.",
                R.drawable.marco,
                "https://www.marcolaguardiahotel.com/",
                "137-07 Northern Boulevard\n" +
                        "Flushing, New York 11354",
                "(718 )445-3300"));

        //Set adapter and recycler view
        recyclerView = view.findViewById(R.id.recyclerview);
        LocationListAdapter adapter = new LocationListAdapter(hotels);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}