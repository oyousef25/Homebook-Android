package com.example.homebook;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.homebook.pojo.RealtorItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RealtorsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RealtorsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RealtorsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RealtorsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RealtorsFragment newInstance(String param1, String param2) {
        RealtorsFragment fragment = new RealtorsFragment();
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
        View view = inflater.inflate(R.layout.fragment_realtors, container, false);
        //Make the realtors listView
        final ListView realtorsList = view.findViewById(R.id.RealtorsList);

        //RealtorItem ArrayList
        ArrayList<RealtorItem> realtorItems = new ArrayList<>();

        //Storing Realtor companies and their data in the RealtorItem ArrayList
        realtorItems.add(new RealtorItem("Omario States", "1836 Oullette Ave", "(226)549-8769"));
        realtorItems.add(new RealtorItem("Homevalley", "5842 Pioneer", "(226)584-3568"));
        realtorItems.add(new RealtorItem("homeez INC.", "3964 Malden Rd", "(226)530-8100"));

        //Set the Adapter
        realtorsList.setAdapter(new CustomListViewAdapter(getContext(), realtorItems));

        return view;
    }


    /**
     * ListView Adapter:
     * We will use our Custom listView XML layout file we already made
     *
     * @author Omar Yousef
     * @version 1.0
     * @since 4th December 2020
     */
    public class CustomListViewAdapter extends ArrayAdapter<RealtorItem>{

        public CustomListViewAdapter(@NonNull Context context, ArrayList<RealtorItem> realtorItems) {
            super(context, 0, realtorItems);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null){
                //Setting our listView layout to the layout we made in the Layout XML directory
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_realtors, parent, false);

                //Declaring the name TextView and setting its text depending on its position
                TextView name = convertView.findViewById(R.id.companyTitle);
                name.setText(getItem(position).getName());

                //Declaring the Address TextView and setting its text depending on its position
                TextView address = convertView.findViewById(R.id.companyAddress);
                address.setText(getItem(position).getAddress());

                //Declaring the Contact(Phone Number) TextView and setting its text depending on its position
                TextView contact = convertView.findViewById(R.id.companyContact);
                contact.setText(getItem(position).getContact());
            }
            return convertView;
        }
    }
}