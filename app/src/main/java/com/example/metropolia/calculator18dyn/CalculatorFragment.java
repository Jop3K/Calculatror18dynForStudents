package com.example.metropolia.calculator18dyn;

/**
 * Created by kamaj on 25.3.2018.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class CalculatorFragment extends Fragment {

    public CalculatorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    public void onCalculate(View view) {

        Toast.makeText(getActivity(), "ready to calculate",
                Toast.LENGTH_LONG).show();
    }
}
