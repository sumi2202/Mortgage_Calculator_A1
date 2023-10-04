package com.example.mortgage_calculator_assignment1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {

    private EditText principalAmount;
    private EditText interest;
    private EditText inYear;
    private EditText inMonth;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_fragment, container, false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().getWindow().setNavigationBarColor(ContextCompat.getColor(requireContext(), R.color.viridian));
            requireActivity().getWindow().setStatusBarColor(ContextCompat.getColor(requireContext(), R.color.viridian));
        }

        Button loanSummaryButton = view.findViewById(R.id.buttonTotal);
        Button clearButton = view.findViewById(R.id.buttonClear);

        principalAmount = (EditText) view.findViewById(R.id.principalAmount);
        interest = (EditText) view.findViewById(R.id.interest);
        inYear = (EditText) view.findViewById(R.id.year);
        inMonth = (EditText) view.findViewById(R.id.month);


       loanSummaryButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               try {
                   double principAmount = Double.parseDouble(principalAmount.getText().toString());
                   double interestValue = Double.parseDouble(interest.getText().toString());
                   int year = Integer.parseInt(inYear.getText().toString());
                   int month = Integer.parseInt(inMonth.getText().toString());

                   Intent i = new Intent(getActivity(), CalculationFragment.class);
                   i.putExtra("principal", principAmount);
                   i.putExtra("interest", interestValue);
                   i.putExtra("year", year);
                   i.putExtra("month", month);

                   startActivity(i);
               } catch (NumberFormatException e) {
                   Toast.makeText(requireContext(), "Please enter a valid numeric value. Enter 0 when applicable.", Toast.LENGTH_SHORT).show();
               }
           }
       });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                principalAmount.setText("");
                interest.setText("");
                inYear.setText("");
                inMonth.setText("");

            }
        });

        return view;
    }
}

