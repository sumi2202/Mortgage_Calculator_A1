package com.example.mortgage_calculator_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText principalAmount;
    private EditText interest;
    private EditText inYear;
    private EditText inMonth;

    private TextView x_emi;
    private TextView x_tenure;
    private TextView x_loanAmount;
    private TextView x_interestPayable;
    private TextView x_totalPayment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principalAmount = (EditText)findViewById(R.id.principalAmount);
        interest = (EditText)findViewById(R.id.interest);
        inYear = (EditText)findViewById(R.id.year);
        inMonth = (EditText)findViewById(R.id.month);

        x_emi = (TextView)findViewById(R.id.EMI);
        x_tenure = (TextView)findViewById(R.id.tenure);
        x_loanAmount = (TextView)findViewById(R.id.loanAmount);
        x_interestPayable = (TextView)findViewById(R.id.intPayable);
        x_totalPayment = (TextView)findViewById(R.id.totalPayable);
    }

    public void buttonTotal(View view){
        double M_principalAmount = Integer.parseInt(principalAmount.getText().toString());
        double M_interest = Integer.parseInt(interest.getText().toString());
        int M_year = Integer.parseInt(inYear.getText().toString());
        int M_month = Integer.parseInt(inMonth.getText().toString());

        int yearExchange = (M_year * 12) + M_month;
        double principal = M_principalAmount * (M_interest / 100);
        double power = Math.pow(M_interest / 100 + 1, yearExchange);
        double sum = principal / (1 - (1 / power));


    }
}