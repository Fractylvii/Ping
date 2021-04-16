package com.example.ping_application;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback{

    GoogleMap map;

    private LocationListener LocationListener;
    private LocationManager locationManager;

    private final long MIN_TIME = 1000; // 1 second
    private final long MIN_DIST = 5; // 5 Meters

    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECEIVE_SMS}, PackageManager.PERMISSION_GRANTED);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.setTrafficEnabled(true);

        LatLng Lubbock = new LatLng(33.55256708026539, -101.90227121452543);
        LatLng Uclub = new LatLng(33.5890, -101.8655);
        map.addMarker(new MarkerOptions() .position(Lubbock).title("Lubbock"));
        map.addMarker(new MarkerOptions() .position(Uclub).title("Uclub"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Lubbock));


        LocationListener = new LocationListener(){
            @Override
            public void onLocationChanged(Location location) {
            try {
                LatLng Myposition = new LatLng(location.getLatitude(), location.getLongitude());
                map.addMarker(new MarkerOptions().position(Myposition).title("My position"));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLng));

                String phoneNumber = "8325617849";
                String myLatitude = String.valueOf(location.getLatitude());
                String myLongitude = String.valueOf(location.getLongitude());

                String message = "Latitude = " + myLatitude + "Longitude = " + myLongitude;
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, message, null,null);

                ContentValues values = new ContentValues();
                values.put("address", "8325617849");
                values.put("body", message);
                getContentResolver().insert(Uri.parse("content://sms/inbox"), values);

                /*ContentValues values = new ContentValues();
                values.put("address", "+8325617849"); // phone number to send
                values.put("date", System.currentTimeMillis()+"");
                values.put("read", "1"); // if you want to mark is as unread set to 0
                values.put("type", "2"); // 2 means sent message
                values.put("body", ("Latitude = " + myLatitude + "Longitutde = " + myLongitude));

                Uri uri = Uri.parse("content://sms/");
                Uri rowUri = getContentResolver().insert(uri,values);*/
            }
            catch (Exception e){
                e.printStackTrace();
            }

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }


        };
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        try {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DIST, LocationListener);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DIST, LocationListener);
        }
        catch (SecurityException e){
            e.printStackTrace();
        }

        }
    }
