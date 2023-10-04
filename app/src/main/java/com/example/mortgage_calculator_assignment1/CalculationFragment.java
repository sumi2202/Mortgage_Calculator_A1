package com.example.mortgage_calculator_assignment1;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
public class CalculationFragment extends Fragment {
    private TextView x_emi;
    private TextView x_tenure;
    private TextView x_loanAmount;
    private TextView x_interestPayable;
    private TextView x_totalPayment;
    x_emi = view.findViewById(R.id.EMI);
    x_tenure = view.findViewById(R.id.tenure);
    x_loanAmount = view.findViewById(R.id.loanAmount);
    x_interestPayable = view.findViewById(R.id.intPayable);
    x_totalPayment = view.findViewById(R.id.totalPayable);

        loanSummaryButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                double M_principalAmount = Double.parseDouble(principalAmount.getText().toString());
                double M_interest = Double.parseDouble(interest.getText().toString());
                int M_year = Integer.parseInt(inYear.getText().toString());
                int M_month = Integer.parseInt(inMonth.getText().toString());

                int yearExchange = (M_year * 12) + M_month;
                double principal = M_principalAmount * (M_interest / 100);
                double power = Math.pow(M_interest / 100 + 1, yearExchange);
                double sum = principal / (1 - (1 / power));

                double TotalInterest = sum * yearExchange - M_principalAmount;
                double TotalPayment = M_principalAmount + TotalInterest;

                x_emi.setText(String.valueOf(sum));
                x_tenure.setText(String.valueOf(yearExchange) + " Month");
                x_loanAmount.setText(String.valueOf(M_principalAmount));
                x_interestPayable.setText(String.valueOf(TotalInterest));
                x_totalPayment.setText(String.valueOf(TotalPayment));
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

            // Clear TextViews
            x_emi.setText("0");
            x_tenure.setText("0 Month");
            x_loanAmount.setText("0");
            x_interestPayable.setText("0");
            x_totalPayment.setText("0");
        }
    });

}
