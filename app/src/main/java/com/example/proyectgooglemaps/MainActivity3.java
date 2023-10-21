package com.example.proyectgooglemaps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.proyectgooglemaps.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity3 extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtLatitud, txtLongitud;
    GoogleMap mMap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ImageView btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí abrimos la Activity2 al hacer clic en el ImageView
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        try {
            // Obtener valores de latitud y longitud desde el Intent
            float latitud1 = getIntent().getFloatExtra("Latitud1", 0.0f);
            float latitud2 = getIntent().getFloatExtra("Latitud2", 0.0f);
            float latitud3 = getIntent().getFloatExtra("Latitud3", 0.0f);
            float longitud1 = getIntent().getFloatExtra("Longitud1", 0.0f);
            float longitud2 = getIntent().getFloatExtra("Longitud2", 0.0f);
            float longitud3 = getIntent().getFloatExtra("Longitud3", 0.0f);
            String name1 = getIntent().getStringExtra("name1");
            String name2 = getIntent().getStringExtra("name2");
            String name3 = getIntent().getStringExtra("name3");


            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.Map);
            mapFragment.getMapAsync(this);
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores: Puedes mostrar un mensaje al usuario o tomar medidas adecuadas aquí.
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.clear();
        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }
        LatLng MiUbicacion = new LatLng(0.0, 0.0); // Reemplaza con las coordenadas de tu ubicación
        Marker myLocationMarker = mMap.addMarker(new MarkerOptions().position(MiUbicacion).title("Mi Ubicación"));

        try {
            // Obtener valores de latitud y longitud desde el Intent
            float latitud1 = getIntent().getFloatExtra("Latitud1", 0.0f);
            float latitud2 = getIntent().getFloatExtra("Latitud2", 0.0f);
            float latitud3 = getIntent().getFloatExtra("Latitud3", 0.0f);
            float longitud1 = getIntent().getFloatExtra("Longitud1", 0.0f);
            float longitud2 = getIntent().getFloatExtra("Longitud2", 0.0f);
            float longitud3 = getIntent().getFloatExtra("Longitud3", 0.0f);
            String name1 = getIntent().getStringExtra("name1");
            String name2 = getIntent().getStringExtra("name2");
            String name3 = getIntent().getStringExtra("name3");

            // Agregar marcadores a las ubicaciones de latitud y longitud
            LatLng location1 = new LatLng(latitud1, longitud1);
            LatLng location2 = new LatLng(latitud2, longitud2);
            LatLng location3 = new LatLng(latitud3, longitud3);

            mMap.addMarker(new MarkerOptions().position(location1).title(name1));
            mMap.addMarker(new MarkerOptions().position(location2).title(name2));
            mMap.addMarker(new MarkerOptions().position(location3).title(name3));


            // Mover la cámara a una ubicación inicial
            mMap.moveCamera(CameraUpdateFactory.newLatLng(MiUbicacion));

            mMap.setMinZoomPreference(4.0F);
            mMap.setMaxZoomPreference(18.0f);
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores: Puedes mostrar un mensaje al usuario o tomar medidas adecuadas aquí.
        }
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        try {
            txtLatitud.setText(String.valueOf(latLng.latitude));
            txtLongitud.setText(String.valueOf(latLng.longitude));

            mMap.clear();
            LatLng mexico = new LatLng(latLng.latitude, latLng.longitude);
            mMap.addMarker(new MarkerOptions().position(mexico).title(""));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mexico));
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores: Puedes mostrar un mensaje al usuario o tomar medidas adecuadas aquí.
        }
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        try {
            txtLatitud.setText(String.valueOf(latLng.latitude));
            txtLongitud.setText(String.valueOf(latLng.longitude));

            mMap.clear();
            LatLng mexico = new LatLng(latLng.latitude, latLng.longitude);
            mMap.addMarker(new MarkerOptions().position(mexico).title(""));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mexico));
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores: Puedes mostrar un mensaje al usuario o tomar medidas adecuadas aquí.
        }
    }
}