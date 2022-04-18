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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    SupportMapFragment mapFragment;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(54.7406256, 55.7409398)));
        // Add a marker in Sydney and move the camera
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
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
            case R.id.exit:
                finish();
        }
        //headerView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }
}