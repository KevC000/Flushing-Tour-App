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
 * Use the {@link SightSeeingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SightSeeingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SightSeeingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SightSeeingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SightSeeingFragment newInstance(String param1, String param2) {
        SightSeeingFragment fragment = new SightSeeingFragment();
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

    ArrayList<Location> sightseeing = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        //Data for sightseeing locations
        sightseeing.add(new Location(
                getString(R.string.nybg_name),
                getString(R.string.nybg_desc_l1) +
                        "\n" +
                        getString(R.string.nybg_desc_l2),
                R.drawable.botanical,
                getString(R.string.nybg_link),
                getString(R.string.nybg_address),
                getString(R.string.nybg_phone)));
        sightseeing.add(new Location(
                getString(R.string.townhall_name),
                getString(R.string.townhall_desc),
                R.drawable.town_hall,
                getString(R.string.townhall_link),
                getString(R.string.townhall_address),
                getString(R.string.townhall_phone)));

        LocationListAdapter adapter = new LocationListAdapter(sightseeing);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}