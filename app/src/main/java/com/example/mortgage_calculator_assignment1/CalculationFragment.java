package com.example.mortgage_calculator_assignment1;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class CalculationFragment extends Fragment {
    private TextView x_emi;
    private TextView x_tenure;
    private TextView x_loanAmount;
    private TextView x_interestPayable;
    private TextView x_totalPayment;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculation_fragment, container, false);

        // Retrieve input values from the intent extras
        double principAmount = getArguments().getDouble("principalAmount", 0);
        double interestValue = getArguments().getDouble("interest", 0);
        int year = getArguments().getInt("year", 0);
        int month = getArguments().getInt("month", 0);

        int yearExchange = (year * 12) + month;
        double principal = principAmount * (interestValue / 100);
        double power = Math.pow(interestValue / 100 + 1, yearExchange);
        double sum = principal / (1 - (1 / power));

        double TotalInterest = sum * yearExchange - principAmount;
        double TotalPayment = principAmount + TotalInterest;


        x_emi.setText(String.valueOf(sum));
        x_tenure.setText(String.valueOf(yearExchange) + " Month");
        x_loanAmount.setText(String.valueOf(principAmount));
        x_interestPayable.setText(String.valueOf(TotalInterest));
        x_totalPayment.setText(String.valueOf(TotalPayment));

        return view;
    }

}
