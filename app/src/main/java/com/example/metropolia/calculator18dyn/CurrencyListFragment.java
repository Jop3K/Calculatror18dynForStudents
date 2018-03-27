package com.example.metropolia.calculator18dyn;

/**
 * Created by kamaj on 30.3.2017.
 */

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CurrencyListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        String[] values = new String[] { "USD", "SEK", "DKK",
                "GBP", "HUF"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),  android.R.layout.simple_list_item_1, values);

        setListAdapter(adapter);
        //getListView().

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT)
                .show();
        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
        getActivity().getSupportFragmentManager().popBackStack();
        //getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();

    }
}
