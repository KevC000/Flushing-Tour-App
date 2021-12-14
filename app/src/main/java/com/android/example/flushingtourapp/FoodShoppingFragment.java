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
        foodAndShopping.add(new Location("New World Mall",
                "Located in the heart of downtown Flushing and a short distance away from other heavily populated Queens neighborhoods, NWM stands to attract thousands of residents within the areas. The stunning three-story, cross-hatched window wall of clear glass on the exterior of the building has already received rave reviews from local community publications. This beautiful new mall is sure to enhance the appearance of the busiest block in Flushing and it reflects the company’s commitment to the community. The Mall expects to create over 1,000 new jobs and to promote social and economic awareness by hosting various community events and programs throughout the year."
                , R.drawable.new_world,
                "https://www.newworldmallny.com/",
                "136-20 Roosevelt Ave" + "\nFlushing, NY 11354" + "\nUSA",
                "(718) 353-0551"
        ));
        foodAndShopping.add(new Location("Sky View",
                "THERE’S A RHYTHM TO THIS PART OF THE CITY. IT BEATS WITH EXCITEMENT LIKE A LOUD, RED DRUM. THE NOISE NEVER STOPS AND THE PEOPLE NEVER REST.\n" +
                        "\n" +
                        "And in the middle of it all is Skyview. We see you, we’re here for you, and our doors are open for whatever you need, whenever you need it.\n" +
                        "\n" +
                        "We feed you when you’re hungry, we’re in-step with your style, and we immerse you in the culture that makes this neighborhood so special. We’re a place to relax, to have fun, to indulge and to come together. You belong at The Shops at Skyview, because we know this is your place.",
                R.drawable.skyview,
                "https://theshopsatskyviewny.com",
                "40-24 College Point Boulevard\n" +
                        "Flushing, NY 11354",
                "(718)460-2000"
        ));
        foodAndShopping.add(new Location(
                        "Queens Crossing",
                        "F&T Group is proud to present Queens Crossing, a state of the art mixed-use development in the heart of downtown Flushing, one of New York City’s most active and most diverse urban areas. Designed by world-renowned architects and engineers, the Thorton Tomasetti Group, Queens Crossing features a bold yet elegant architectural design that enhances its urban surroundings with a distinctive street presence. Behind its graceful curvilinear Façade, the building contains 110,000 sq. ft. of retail space, 37,000 sq. ft. entertainment and dining areas, full floor community facility, and 144,000 sq. ft. office condominiums, all served by 86,000 sq. ft. of valet parking. A visitor to this venue will discover specialty retail stores, both casual and fine dining options, and a large banquet hall at the lower levels of the building. Located on the fourth floor is Long Island Business Institute, a community college, and several medical offices. Floors five to eleven are professional offices, housing medical offices, lawyers, financial advisors, real estate and travel agencies. The top floor of Queens Crossing hosts the headquarters for the F&T Group.",
                        R.drawable.queens_crossing,
                        "http://www.queenscrossing.com/",
                        "136-17 39th Ave." + "\nFlushing, New York" + "\n11354",
                        "N/A"
                )
        );
        foodAndShopping.add(new Location(
                "One Fulton Square",
                "One Fulton Square offers a curated selection of authentic Asian eateries, including Chinese, Korean, Japanese, Malaysian and Taiwanese options. These bustling restaurants and bars are a vibrant addition to the nightlife of downtown Flushing and further advance the development of this flourishing neighborhood.",
                R.drawable.fulton,
                "http://www.onefultonsquareflushing.com/",
                "39-16 Prince Street" + "\nFlushing, NY 11354",
                "N/A"
        ));

//Setting Recycler  View
        recyclerView = view.findViewById(R.id.recyclerview);
        LocationListAdapter adapter = new LocationListAdapter(foodAndShopping);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

}