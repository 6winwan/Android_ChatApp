package com.example.a6winwan.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class TabActivity extends AppCompatActivity {


    private TextView mTextMessage;
    long lastPressed;
    Fragment fragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragment = new HomeFragment();
                        switchFragment(fragment);
                        return true;

                    case R.id.navigation_dashboard:
                        fragment = new FriendsFragment();
                        switchFragment(fragment);
                        return true;
                    case R.id.navigation_notifications:
                        fragment = new ProfileFragment();
                        switchFragment(fragment);
                        return true;
                }
                return false;
            }

        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tab);


            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment fragment = new HomeFragment();
            fragmentTransaction.add(R.id.content, fragment);
            fragmentTransaction.commit();

            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        }

    public void switchFragment(Fragment fragment){
        // Create new fragment and transaction

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.content, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "Quit , if you press 'Back',", Toast.LENGTH_LONG).show();
        if (System.currentTimeMillis() - lastPressed < 2000) {
            finish();
        }
        lastPressed = System.currentTimeMillis();


    }
}

