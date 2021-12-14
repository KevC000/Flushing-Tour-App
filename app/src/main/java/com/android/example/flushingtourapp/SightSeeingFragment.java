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
                "New York Botanical Garden",
                "Queens Botanical Garden (QBG) is an urban oasis where people, plants, and cultures are celebrated through inspiring gardens, innovative educational programs, and real-world applications of environmental stewardship.\n" +
                        "\n" +
                        "QBG is located on property owned by the City of New York, and its operation is made possible in part by public funds provided through the New York City Department of Cultural Affairs, Queens Borough President, the New York City Council, State elected officials, the New York State Department of Parks, Recreation and Historic Preservation, along with corporate, foundation, and individual supporters.",
                R.drawable.botanical,
                "https://queensbotanical.org/",
                "43-50 Main Street" + "\nFlushing, NY 11355",
                "(718)886-3800"));
        sightseeing.add(new Location(
                "Flushing Town Hall",
                "The mission of Flushing Council on Culture and the Arts (FCCA) is to present multi-disciplinary global arts that engage and educate the global communities of Queens, New York and New York City, New York, in order to foster mutual appreciation. As advocates of arts equity since 1979, we support local, immigrant, national, and international artists, developing partnerships and collaborations that enhance our efforts. As a member of New York City’s Cultural Institutions Group (CIG), we serve as stewards of Flushing Town Hall, restoring, managing and programming the historic 1862 landmark on behalf of the City of New York. FCCA celebrates the history of Queens as the home of Jazz, by presenting the finest in Jazz performance. We are committed to arts education and hands-on learning, for the arts-curious, arts enthusiasts, and professional artists. We serve one of the most diverse communities in the world, and strive to uphold the legacy of inclusiveness that has defined our community since the Flushing Remonstrance of 1657",
                R.drawable.town_hall,
                "https://www.flushingtownhall.org",
                "137-35 Northern Blvd" + "\nQueens, NY 1135",
                " (718) 463-7700"));

        LocationListAdapter adapter = new LocationListAdapter(sightseeing);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}