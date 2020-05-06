/*
Java Workshop 2020
First Application
06/05/2020
Moshe Weizman 305343931
Aharon Packter 201530508
 */
package com.example.myapplication.UI;

import com.example.myapplication.R;
import com.example.myapplication.model.FirebaseManager;
import com.example.myapplication.model.Parcel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Parcel parcel;
    private RadioButton radioButtonEnvelop, radioButtonSmallParcel, radioButtonBigParcel, radioButtonUpTo500,
            radioButtonUpTo1, radioButtonUpTo5, radioButtonUpTo20;
    private Button buttonSubmitParcel, buttonClear;
    private EditText editTextPhone, editTextAddress, editTextFirstName, editTextLastName;
    private CheckBox checkBoxFragile;
    private Parcel.ParcelType type;
    private Parcel.ParcelWeight weight;
    private boolean isFragile;
    private String address;
    private int PERMISSION_ID = 44;
    private FusedLocationProviderClient mFusedLocationClient;

    public void onRadioButtonClickedType(View view) {
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButtonEnvelop:
                type = Parcel.ParcelType.ENVELOPE;
                break;
            case R.id.radioButtonSmallParcel:
                type = Parcel.ParcelType.SMALL_PARCEL;
                break;
            case R.id.radioButtonBigParcel:
                type = Parcel.ParcelType.BIG_PARCEL;
                break;
        }
    }

    public void onRadioButtonClickedWeight(View view) {
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButtonUpTo500:
                weight = Parcel.ParcelWeight.UP_TO_500G;
                break;
            case R.id.radioButtonUpTo1:
                weight = Parcel.ParcelWeight.UP_TO_1KG;
                break;
            case R.id.radioButtonUpTo5:
                weight = Parcel.ParcelWeight.UP_TO_5KG;
                break;
            case R.id.radioButtonUpTo20:
                weight = Parcel.ParcelWeight.UP_TO_20KG;
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        isFragile = ((CheckBox) view).isChecked();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                buttonSubmitParcel.setEnabled(true);
            }
        });

        buttonSubmitParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(editTextPhone.getText()) || TextUtils.isEmpty(editTextAddress.getText())) {
                    Toast.makeText(MainActivity.this, "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                } else {

                    String key = FirebaseManager.parcelRef.push().getKey();
                    parcel = new Parcel(editTextPhone.getText().toString(), editTextFirstName.getText().toString()
                            , editTextLastName.getText().toString(),
                            editTextAddress.getText().toString(), type, isFragile, weight, key, address);
                    Task<Void> task = FirebaseManager.addParcelToFirebase(parcel);
                    task.addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                                Toast.makeText(MainActivity.this, "successful", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(MainActivity.this, "error. try again", Toast.LENGTH_SHORT).show();
                        }

                    });
                    buttonSubmitParcel.setEnabled(false);
                }
            }
        });

    }

    private void init() {
        radioButtonSmallParcel = findViewById(R.id.radioButtonSmallParcel);
        radioButtonBigParcel = findViewById(R.id.radioButtonBigParcel);
        radioButtonUpTo500 = findViewById(R.id.radioButtonUpTo500);
        radioButtonUpTo1 = findViewById(R.id.radioButtonUpTo1);
        radioButtonUpTo5 = findViewById(R.id.radioButtonUpTo5);
        radioButtonUpTo20 = findViewById(R.id.radioButtonUpTo20);
        radioButtonEnvelop = findViewById(R.id.radioButtonEnvelop);
        buttonSubmitParcel = findViewById(R.id.buttonSubmitParcel);
        buttonClear = findViewById(R.id.buttonClear);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        checkBoxFragile = findViewById(R.id.acheckBoxFrgile);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        getLastLocation();
    }

    private void clear() {
        editTextFirstName.setText("");
        editTextLastName.setText("");
        editTextPhone.setText("");
        editTextAddress.setText("");
        radioButtonEnvelop.setChecked(false);
        radioButtonSmallParcel.setChecked(false);
        radioButtonBigParcel.setChecked(false);
        radioButtonUpTo500.setChecked(false);
        radioButtonUpTo1.setChecked(false);
        radioButtonUpTo5.setChecked(false);
        radioButtonUpTo20.setChecked(false);
        checkBoxFragile.setChecked(false);
    }

    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.getLastLocation().addOnCompleteListener(
                        new OnCompleteListener<Location>() {
                            @Override
                            public void onComplete(@NonNull Task<Location> task) {
                                Location location = task.getResult();
                                if (location == null) {
                                    requestNewLocationData();
                                } else {
                                    Toast.makeText(MainActivity.this, "lat and long found", Toast.LENGTH_SHORT).show();
                                    getAddressString(location.getLatitude(), location.getLongitude());
                                }
                            }
                        }
                );
            } else {
                Toast.makeText(this, "Turn on location", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            requestPermissions();
        }
    }

    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(0);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(
                mLocationRequest, mLocationCallback,
                Looper.myLooper()
        );
    }

    private LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
            Toast.makeText(MainActivity.this, "lat and long found", Toast.LENGTH_SHORT).show();
            getAddressString(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        }
    };

    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
              ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                PERMISSION_ID
        );
    }

    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
                LocationManager.NETWORK_PROVIDER
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }
    }

    private void getAddressString(double lat, double lng) {
        Geocoder geocoder;
        List<Address> addresses = null;
        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(lat, lng, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Can't resolve address. " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }
        address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
    }
}