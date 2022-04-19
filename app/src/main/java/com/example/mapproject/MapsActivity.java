package com.example.mapproject;

import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    SupportMapFragment mapFragment;
    private GoogleMap mMap;
    private UiSettings uiSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("map").toString();
        if (!name.matches("///")){
            String[] str = name.split("/// ");
            double a, b;
            String c;
            String s;
            for(int i = 0; i < str.length; i+=3){
                s = str[i + 1];
                a = Double.parseDouble(s);

                s = str[i + 2];
                b = Double.parseDouble(s);

                c = str[i];

                //z = Double.parseDouble(str[(int)i/3 + 1]);
                //mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(a), Double.parseDouble(b))).title(c));
                mMap.addMarker(new MarkerOptions().position(new LatLng(a, b)).title(c));
            }
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(54.7985226,56.0397862), 11.0f));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mapmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.chart :
                return true;
            case R.id.wiki:
                Intent intent = new Intent(MapsActivity.this, WikiActivity.class);
                startActivity(intent);
                return true;
            case R.id.changemap:
                switch(mMap.getMapType()){
                    case GoogleMap.MAP_TYPE_NORMAL:
                        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                        return true;
                    case GoogleMap.MAP_TYPE_SATELLITE:
                        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                        return true;
                    case GoogleMap.MAP_TYPE_TERRAIN:
                        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        return true;
                }
            case R.id.exit:
                finish();
        }
        //headerView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }
}