package com.example.homebook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Houses Fragment:
 * This Page will hold the viewPager and it's design
 * @author Omar Yousef
 * @version 1.0
 * @since NOV 15th
 */
public class HousesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Integer mParam3;
    private String mParam4;

    public HousesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HousesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HousesFragment newInstance(String param1, String param2, Integer param3, String param4) {
        HousesFragment fragment = new HousesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_houses, container, false);

        //If the parameters are not empty. set the texts and imageView to the passed value
        if (mParam1 != null){
            TextView housePrice = view.findViewById(R.id.housePrice);
            housePrice.setText(mParam1);
        }
        if (mParam2 != null){
            TextView houseAddress = view.findViewById(R.id.houseAddress);
            houseAddress.setText(mParam2);
        }
        if (mParam3 != null){
            ImageView houseImage = view.findViewById(R.id.houseImage);
            houseImage.setImageResource(mParam3);
        }
        if (mParam4 != null){
            TextView houseDetails = view.findViewById(R.id.houseDetails);
            houseDetails.setText(mParam4);
        }

        return view;
    }
}