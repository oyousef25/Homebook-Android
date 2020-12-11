package com.example.homebook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homebook.pojo.HouseItem;
import com.example.homebook.recyclerViewAdapter.CustomRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HousesList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HousesList extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HousesList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HousesList.
     */
    // TODO: Rename and change types and number of parameters
    public static HousesList newInstance(String param1, String param2) {
        HousesList fragment = new HousesList();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_houses_list, container, false);

        //Declaring the RecyclerView we made
        RecyclerView recyclerView = view.findViewById(R.id.housesRecycler);

        //Storing recipes and their description in an arrayList
        ArrayList<HouseItem> houseItemArrayList = new ArrayList<>();

        //Adding items to arrayList
        houseItemArrayList.add(new HouseItem(R.drawable.first_home, getString(R.string.first_details), getString(R.string.first_price), getString(R.string.first_address)));
        houseItemArrayList.add(new HouseItem(R.drawable.second_home, getString(R.string.second_details), getString(R.string.second_price), getString(R.string.second_address)));
        houseItemArrayList.add(new HouseItem(R.drawable.third_home, getString(R.string.third_details), getString(R.string.third_price), getString(R.string.third_address)));
        houseItemArrayList.add(new HouseItem(R.drawable.fourth_home, getString(R.string.fourth_details), getString(R.string.fourth_price), getString(R.string.fourth_address)));
        houseItemArrayList.add(new HouseItem(R.drawable.fifth_home, getString(R.string.fifth_details), getString(R.string.fifth_price), getString(R.string.fifth_address)));
        houseItemArrayList.add(new HouseItem(R.drawable.sixth_home, getString(R.string.sixth_details), getString(R.string.sixth_price), getString(R.string.sixth_address)));
        houseItemArrayList.add(new HouseItem(R.drawable.seventh_home, getString(R.string.seventh_details), getString(R.string.seventh_price), getString(R.string.seventh_address)));
        houseItemArrayList.add(new HouseItem(R.drawable.eighth_home, getString(R.string.eighth_details), getString(R.string.eighth_price), getString(R.string.eighth_address)));
        houseItemArrayList.add(new HouseItem(R.drawable.ninth_home, getString(R.string.ninth_details), getString(R.string.ninth_price), getString(R.string.ninth_address)));

        //RecyclerView Layout
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Set an Adapter
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(houseItemArrayList));
        return view;
    }
}