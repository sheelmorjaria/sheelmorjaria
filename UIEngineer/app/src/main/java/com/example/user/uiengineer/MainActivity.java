package com.example.user.uiengineer;

import android.content.Intent;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtViewAccountDescription;
    TextView txtViewBenefitOne;
    TextView txtViewBenefitTwo;
    TextView txtViewFourBenefitThree;

    Button accountCreate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtViewAccountDescription = (TextView) findViewById(R.id.tvAccountDescription);
        txtViewBenefitOne = (TextView) findViewById(R.id.tvBenefitOne);
        txtViewBenefitTwo = (TextView) findViewById(R.id.tvBenefitTwo);
        txtViewFourBenefitThree= (TextView) findViewById(R.id.tvBenefitThree);
        accountCreate = (Button) findViewById(R.id.button);
        Typeface m_typeFace = Typeface.createFromAsset(getAssets(), "five.ttf");
     Typeface o_typeFace = Typeface.createFromAsset(getAssets(), "three.ttf");

        txtViewAccountDescription.setTypeface(m_typeFace);
        txtViewBenefitOne.setTypeface(o_typeFace);
        txtViewBenefitTwo.setTypeface(o_typeFace);
        txtViewFourBenefitThree.setTypeface(o_typeFace);
        accountCreate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intentOne = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intentOne);
            }
        });

    }
}
