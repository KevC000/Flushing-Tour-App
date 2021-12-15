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
        hotels.add(new Location(getString(R.string.hyatt_name),
                getString(R.string.hyatt_desc),
                R.drawable.hyatt,
                getString(R.string.hyatt_link),
                getString(R.string.hyatt_address),
                getString(R.string.hyatt_phone)));
        hotels.add(new Location(
                getString(R.string.parc_name),
                getString(R.string.parc_desc),
                R.drawable.parc,
                getString(R.string.parc_link),
                getString(R.string.parc_address),
                getString(R.string.parc_phone)));
        hotels.add(new Location(
                getString(R.string.marco_name),
                getString(R.string.marco_desc),
                R.drawable.marco,
                getString(R.string.marco_link),
                getString(R.string.marco_address),
                getString(R.string.marco_phone)));

        //Set adapter and recycler view
        recyclerView = view.findViewById(R.id.recyclerview);
        LocationListAdapter adapter = new LocationListAdapter(hotels);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}