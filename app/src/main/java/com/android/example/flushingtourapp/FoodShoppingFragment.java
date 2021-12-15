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
 * Use the {@link FoodShoppingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodShoppingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodShoppingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodShoppingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodShoppingFragment newInstance(String param1, String param2) {
        FoodShoppingFragment fragment = new FoodShoppingFragment();
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

    ArrayList<Location> foodAndShopping = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_location_list, container, false);

        //ArrayList of the locations
        foodAndShopping.add(new Location(getString(R.string.new_world_name),
                getString(R.string.new_world_desc)
                , R.drawable.new_world,
                getString(R.string.new_world_link),
                getString(R.string.new_world_address),
                getString(R.string.new_world_phone)
        ));
        foodAndShopping.add(new Location(getString(R.string.sky_view_name),
                getString(R.string.sky_view_desc) +
                        "\n" +
                        getString(R.string.sky_view_desc2) +
                        "\n" +
                        getString(R.string.sky_view_desc3),
                R.drawable.skyview,
                getString(R.string.sky_view_link),
                getString(R.string.sky_view_address),
                getString(R.string.sky_view_phone)
        ));
        foodAndShopping.add(new Location(
                        getString(R.string.queenscrossing_name),
                        getString(R.string.queenscrossing_desc),
                        R.drawable.queens_crossing,
                        getString(R.string.queenscrossing_link),
                        getString(R.string.queenscrossing_address),
                        getString(R.string.no_phone)
                )
        );
        foodAndShopping.add(new Location(
                getString(R.string.fulton_name),
                getString(R.string.fulton_desc),
                R.drawable.fulton,
                getString(R.string.fulton_link),
                getString(R.string.fulton_address),
                getString(R.string.no_phone)
        ));

//Setting Recycler  View
        recyclerView = view.findViewById(R.id.recyclerview);
        LocationListAdapter adapter = new LocationListAdapter(foodAndShopping);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

}