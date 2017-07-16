package com.example.user.weekendassignmenttwo;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import static com.example.user.weekendassignmenttwo.R.id.rock;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    static FragmentManager fragmentManager;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case rock:
                    RockFragment rockFragment = new RockFragment();
                    fragmentManager.beginTransaction()
                            .add(R.id.container , rockFragment)
                            .commit();
                    return true;
                case R.id.pop:
                  PopFragment popFragment= new PopFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container , popFragment)
                            .commit();
                    return true;
                case R.id.classic:
                    ClassicFragment classicFragment = new ClassicFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container , classicFragment)
                            .commit();                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getFragmentManager();

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
