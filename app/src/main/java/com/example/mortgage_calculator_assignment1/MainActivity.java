package com.example.mortgage_calculator_assignment1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.mortgage_calculator_assignment1.CalculationFragment;
import com.example.mortgage_calculator_assignment1.InputFragment;
import com.example.mortgage_calculator_assignment1.WelcomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // Load the WelcomeFragment initially
            loadFragment(new WelcomeFragment());
        }

        // Set status and navigation bar colors
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.viridian));
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.viridian));
        }
    }

    // Load a fragment into the fragment container
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    // Navigate to the InputActivity
    public void navigateToInputActivity() {
        Intent i = new Intent(this, InputFragment.class);
        startActivity(i);
    }

    // Navigate to the CalculationActivity with data passed as extras
    public void navigateToCalculationActivity(double principAmount, double interestValue, int year, int month) {
        CalculationFragment calculate = new CalculationFragment();
        Bundle x = new Bundle();
        x.putDouble("principalAmount", principAmount);
        x.putDouble("interestValue", interestValue);
        x.putInt("year", year);
        x.putInt("month", month);
        calculate.setArguments(x);
    }
}
