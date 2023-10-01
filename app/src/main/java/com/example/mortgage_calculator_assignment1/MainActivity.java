package com.example.mortgage_calculator_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText loanAmount;
    private EditText interest;
    private EditText year;
    private EditText month;

    private TextView x_emi;
    private TextView x_tenure;
    private TextView x_loanAmount;
    private TextView x_interestPayable;
    private TextView x_totalPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}