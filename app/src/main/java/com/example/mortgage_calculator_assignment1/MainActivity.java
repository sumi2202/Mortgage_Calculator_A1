package com.example.mortgage_calculator_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText principalAmount;
    private EditText interest;
    private EditText inYear;
    private EditText inMonth;

    private TextView x_emi;
    private TextView x_tenure;
    private TextView x_principalAmount;
    private TextView x_interestPayable;
    private TextView x_totalPayment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principalAmount = (EditText)findViewById(R.id.principalAmount);
        interest = (EditText)findViewById(R.id.inMonth);
        inYear = (EditText)findViewById(R.id.year);
        inMonth = (EditText)findViewById(R.id.month);

    }
}