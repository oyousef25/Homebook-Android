package com.example.homebook;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**
 * Home Page:
 * This page will include:
 * 1. A houses viewPager
 * 2. A houses ListView
 * 3. A menu that sends the user to the Credits and Realtors pages
 * @author Omar Yousef
 * @version 1.0
 * @since NOV 15th
 */
public class HomePageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Integer mParam3;

    public HomePageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomePageFragment newInstance(String param1, String param2, Integer param3) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
            Adding a menu to the homepage fragment
         */
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        CustomViewPageAdapter adapter = new CustomViewPageAdapter(getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.albumContent);
        viewPager.setAdapter(adapter);

        return view;
    }

    public class CustomViewPageAdapter extends FragmentPagerAdapter {

        public CustomViewPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            //Showing the viewPager slides
            switch (position){
                case 0: return HousesFragment.newInstance(getString(R.string.first_price), getString(R.string.first_address), R.drawable.first_home, getString(R.string.first_details));
                case 1: return HousesFragment.newInstance(getString(R.string.second_price), getString(R.string.second_address), R.drawable.second_home, getString(R.string.second_details));
                case 2: return HousesFragment.newInstance(getString(R.string.third_price), getString(R.string.third_address), R.drawable.third_home, getString(R.string.third_details));
                case 3: return HousesFragment.newInstance(getString(R.string.fourth_price), getString(R.string.fourth_address), R.drawable.fourth_home, getString(R.string.fourth_details));
                case 4: return HousesFragment.newInstance(getString(R.string.fifth_price), getString(R.string.fifth_address), R.drawable.fifth_home, getString(R.string.fifth_details));
                case 5: return HousesFragment.newInstance(getString(R.string.sixth_price), getString(R.string.sixth_address), R.drawable.sixth_home, getString(R.string.sixth_details));
                case 6: return HousesFragment.newInstance(getString(R.string.seventh_price), getString(R.string.seventh_address), R.drawable.seventh_home, getString(R.string.seventh_details));
                case 7: return HousesFragment.newInstance(getString(R.string.eighth_price), getString(R.string.eighth_address), R.drawable.eighth_home, getString(R.string.eighth_details));
                case 8: return HousesFragment.newInstance(getString(R.string.ninth_price), getString(R.string.ninth_address), R.drawable.ninth_home, getString(R.string.ninth_details));
                default: return null;
            }
        }

        @Override
        public int getCount() {
            //Returning only our 4 values
            return 9;
        }
    }

    /**
     * Adding a menu items to the homePage Fragment
     * @param menu
     */
    public void onPrepareOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }
}