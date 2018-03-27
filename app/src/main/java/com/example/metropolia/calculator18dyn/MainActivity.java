package com.example.metropolia.calculator18dyn;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
            // create Calculator-fragment programmatically...
            CalculatorFragment newFragment = new CalculatorFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.add(R.id.fragment_container, newFragment);
            //transaction.addToBackStack(null); // to get back from ListFragment
            // Commit the transaction
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id==R.id.action_list){
            //FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            //transaction.remove(fragment).commit(); // wipe the old
            CurrencyListFragment listFragment = new CurrencyListFragment();
            transaction.addToBackStack(null);
            transaction.replace(R.id.fragment_container, listFragment)
                    .commit();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCalculate(View view) {

       /* if (calculateFrag!= null){
            calculateFrag.onCalculate(view);
        } */

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment!=null)
            ((CalculatorFragment)fragment).onCalculate(view); // välitetään näppäinpainallukset fragmentille...
    }
}
