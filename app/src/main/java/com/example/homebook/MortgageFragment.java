package com.example.homebook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Mortgage Calculator Page:
 * This Page will help the user with the loan calculating and their monthly payment
 * @author Omar Yousef
 * @version 1.0
 * @since NOV 27
 */
public class MortgageFragment extends Fragment {

    //Numbers Formats
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    NumberFormat percentageFormat = NumberFormat.getPercentInstance();

    //Storing the Fragment's elements in variables
    TextView loanAmountTextview;
    EditText loanAmountEditText;

    TextView downTextview;
    EditText downPaymentEditText;

    TextView percentTextView;
    SeekBar percentSeekBar;

    TextView yearsTextView;
    SeekBar yearsSeekBar;

    TextView monthlyPayment;

    TextView totalCost;

    private double interest = 0.03;
    private double homePrice = 0.00;
    private double downAmount = 0.00;
    private int numberOfYears = 5;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MortgageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MortgageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MortgageFragment newInstance(String param1, String param2) {
        MortgageFragment fragment = new MortgageFragment();
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
        View view = inflater.inflate(R.layout.fragment_mortgage, container, false);

        /*
            Locating the XML elements and storing them in variables
         */

        //Loan Amount Edit Text and TextView
        loanAmountEditText = view.findViewById(R.id.loanAmount);
        loanAmountTextview = view.findViewById(R.id.loanTextView);

        //Down Payment Edit Text And TextView
        downPaymentEditText = view.findViewById(R.id.downPayment);
        downTextview = view.findViewById(R.id.downTextView);

        //Percent TextView and SeekBar
        percentTextView = view.findViewById(R.id.percentTextView);
        percentSeekBar = view.findViewById(R.id.percentSeekBar);

        //Years TextView And SeekBar
        yearsTextView = view.findViewById(R.id.yearsTextView);
        yearsSeekBar = view.findViewById(R.id.yearsSeekBar);

        //Monthly Payment TextView
        monthlyPayment = view.findViewById(R.id.monthlyPayment);

        //Total Cost TextView
        totalCost = view.findViewById(R.id.totalPayment);



        //Setting up the monthly's payment and totalCost TextViews Number Format
        monthlyPayment.setText(currencyFormat.format(0));
        totalCost.setText(currencyFormat.format(0));


        /*
            Setting a on change listeners to live update the values
         */

        //Years SeekBar
        yearsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numberOfYears = progress;
                calculateLoan();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Loan Amount Edit Text
        loanAmountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    homePrice = Double.parseDouble(s.toString());
                }catch (NumberFormatException e){
                    homePrice = 0.0;
                }

                //Calculate the Loan
                calculateLoan();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Down Payment Edit Text
        downPaymentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    downAmount = Double.parseDouble(s.toString());
                }catch (NumberFormatException e){
                    downAmount = 0.0;
                }

                //Calculate the Loan
                calculateLoan();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //percent SeekBar
        percentSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                interest = (progress / 100.0);
                calculateLoan();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        return view;
    }

    /**
     * calculateLoan() Method:
     * 1. This Method will calculate the loan.
     * 2. Then we will include it in the on change listeners to lively change the elements values and do real time calculating
     * @author Omar Yousef
     */
    private void calculateLoan(){
        /**
         * Grab current interest rate and assign it to percentTextView
         */
        percentTextView.setText(percentageFormat.format(interest));

        /*
           Grab current number of years and assign it to yearsTextView
         */
        yearsTextView.setText(numberOfYears + " Year(s)");

        //Loan Amount
        double loanAmount = homePrice - downAmount;

        //Calculate Interest per year
        double interestPerYear = loanAmount * interest;

        //Calculate total payment
        double totalPayment = loanAmount + (interestPerYear * numberOfYears);

        //Calculate monthly payment
        monthlyPayment.setText(
                currencyFormat.format((totalPayment/numberOfYears)/12));

        //Calculate the total cost
        totalCost.setText(currencyFormat.format(totalPayment));

    }
}