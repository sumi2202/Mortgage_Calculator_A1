package com.example.mortgage_calculator_assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class WelcomeFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.welcome_fragment, container, false);

        Button startCalcButton = view.findViewById(R.id.start_button);
        startCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to InputActivity
                Intent intent = new Intent(getActivity(), InputFragment.class);
                startActivity(intent);
            }
        });

        return view;
    }
}


