package com.example.user.uiengineer;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtEmail;
    EditText editEmail;
    TextView txtPassword;
    EditText editPassword;
    TextView rptPassword;
    EditText editPasswordRepeat;
    TextView passwordDesc;
    Button  next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtEmail = (TextView) findViewById(R.id.tvAccountDescription);
        txtPassword = (TextView) findViewById(R.id.tvPassword);
        rptPassword = (TextView) findViewById(R.id.tvPasswordRepeat);
        passwordDesc= (TextView) findViewById(R.id.tvPasswordDescription);
        next = (Button) findViewById((R.id.btnNext)) ;
//        Typeface m_typeFace = Typeface.createFromAsset(getAssets(), "five.ttf");
//   Typeface o_typeFace = Typeface.createFromAsset(getAssets(), "three.ttf");
//        txtEmail.setTypeface(m_typeFace);
//        passwordDesc.setTypeface(m_typeFace);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intentOne = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intentOne);
          }
        });
    }
}