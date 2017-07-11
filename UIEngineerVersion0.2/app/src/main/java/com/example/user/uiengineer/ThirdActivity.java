package com.example.user.uiengineer;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.example.user.uiengineer.model.CustomerModel;
import com.hbb20.CountryCodePicker;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

import io.realm.Realm;

public class ThirdActivity extends AppCompatActivity {
    int counter=0;
    //TextView displayDOB;
//    String pathToPhoto;
    EditText name;
    EditText age;
    ImageView ivPhotoCapture;
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
    Intent intent;
    ByteArrayOutputStream bos;
    byte[] photoByteArray;
    File file;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        name = (EditText) findViewById(R.id.editTextName);
        age = (EditText) findViewById(R.id.editTextAge);
        datePicker = (Button) findViewById(R.id.datePicker);
        postalAddress = (EditText) findViewById(R.id.etPostal);
        ivPhotoCapture =(ImageView)findViewById(R.id.imageViewPhoto);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        maleGender = (RadioButton) findViewById(R.id.rbMale);
        femaleGender = (RadioButton) findViewById(R.id.rbFemale);
        otherGender = (RadioButton) findViewById(R.id.rbOther);
        realm = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm);
        arrayList =  realmHelper.findCustomers();

        Log.i("modelprinted",arrayList.toString());
//        arrayList = realmHelper.findCustomers();
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerBuilder dpb = new DatePickerBuilder()
                        .setFragmentManager(getSupportFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment);
                dpb.show();
            }
        });
        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                countryNameSave = ccp.getSelectedCountryName();            }
        });

        fabPhoto = (FloatingActionButton) findViewById(R.id.fabCamera);
        fabPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            //    if()
                startActivityForResult(i,0);


            }
        });



        fabSave = (FloatingActionButton) findViewById(R.id.fabSave);
        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customerModel = new CustomerModel(name.getText().toString(),age.getText().toString(),countryNameSave,genderSave,postalAddress.getText().toString(), photoByteArray);
                realmHelper.saveData(customerModel);


             Log.i("modelprinted",arrayList.toString());
                intent = new Intent(ThirdActivity.this, DatabaseRecyclerView.class);
               intent.putExtra("customer info", customerModel);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 0:
                 if (resultCode == RESULT_OK ) {
                            try {
                                photo = (Bitmap) data.getExtras().get("data");
                                ivPhotoCapture.setImageBitmap(photo);
                            }catch(NullPointerException ex){
                                ex.printStackTrace();
                            }
                 }
                break;

        }
    }
    public byte[] getByteArray(Bitmap bitmap) {
        bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos);
        return bos.toByteArray();
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

        outState.putString("name", name.getText().toString());
        outState.putString("age", age.getText().toString());
        

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

