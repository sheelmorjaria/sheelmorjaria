package com.example.user.uiengineer;


import android.content.Intent;
import android.graphics.Bitmap;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.example.user.uiengineer.model.CustomerAdapter;
import com.example.user.uiengineer.model.CustomerModel;
import com.hbb20.CountryCodePicker;

import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.internal.IOException;

public class ThirdActivity extends AppCompatActivity {
    int counter=0;
    static final int CAMERA_REQUEST = 1;
    static final int VIEW_RECYCLER =2;
    //TextView displayDOB;
//    String pathToPhoto;
    EditText name;
    EditText age;
    Button datePicker;
    CustomerModel customerModel;
    CountryCodePicker ccp;
    Bitmap photo;
    RadioButton maleGender;
    RadioButton femaleGender;
    RadioButton otherGender;
    FloatingActionButton fabPhoto;
    FloatingActionButton fabSave;
    String countryNameSave;
    String genderSave;
    EditText postalAddress;
    Realm realm;
    RealmHelper realmHelper;
    ArrayList<CustomerModel> arrayList;
    RecyclerView myRecyclerView;
    Intent intent;
    ByteArrayOutputStream stream;
    byte[] byteArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        name = (EditText) findViewById(R.id.editTextName);
        age = (EditText) findViewById(R.id.editTextAge);
        datePicker = (Button) findViewById(R.id.datePicker);
        postalAddress = (EditText) findViewById(R.id.etPostal);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        maleGender = (RadioButton) findViewById(R.id.rbMale);
        femaleGender = (RadioButton) findViewById(R.id.rbFemale);
        otherGender = (RadioButton) findViewById(R.id.rbOther);

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerBuilder dpb = new DatePickerBuilder()
                        .setFragmentManager(getSupportFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment);
                dpb.show();
            }
        });

        countryNameSave = ccp.getSelectedCountryName();
        fabPhoto = (FloatingActionButton) findViewById(R.id.fabCamera);
        fabPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
        fabSave = (FloatingActionButton) findViewById(R.id.fabSave);
        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customerModel = new CustomerModel();
                realm = Realm.getDefaultInstance();
                realmHelper = new RealmHelper(realm);
                realmHelper.saveData(customerModel);
                arrayList = realmHelper.findCustomers();
//                Log.i("modelprinted",arrayList.toString());
                intent = new Intent(ThirdActivity.this, DatabaseRecyclerView.class);
                intent.putExtra("customer info", customerModel);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST) {
            try{
                photo = (Bitmap) data.getExtras().get("data");
                stream = new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byteArray = stream.toByteArray();
            }
           catch(IOException exception){
               Log.i("Error", "IOException");
           }
        }

    }


    public void onRadioButtonPressed(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbMale:
                if (checked)
                    genderSave = "male";
                break;
            case R.id.rbFemale:
                if (checked)
                    genderSave = "female";
                break;
            case R.id.rbOther:
                if (checked)
                    genderSave = "other";
                break;

        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //save info ideally realm database
        realmHelper.saveData(customerModel);

    }
    @Override

    protected void onDestroy() {

        super.onDestroy();
        realm.close();

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Lifecycle","On onRestart Called");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Lifecycle","On onPause Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Lifecycle","On onStop Called");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Lifecycle","On onResume Called");


        counter++;
    }
}

