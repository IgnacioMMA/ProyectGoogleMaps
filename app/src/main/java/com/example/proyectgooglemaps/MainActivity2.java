package com.example.proyectgooglemaps;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText txtvLatUno, txtvLatDos, txtvLatTres, txtvLongUno, txtvLongDos, txtvLongTres, txtvNaUno, txtvNaDos, txtvNaTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtvLatUno = findViewById(R.id.txtvNameUno);
        txtvLatDos = findViewById(R.id.txtvNameDos);
        txtvLatTres = findViewById(R.id.txtvNameTres);
        txtvLongUno = findViewById(R.id.txtvLongUno);
        txtvLongDos = findViewById(R.id.txtvLongDos);
        txtvLongTres = findViewById(R.id.txtvLongTres);
        txtvNaUno = findViewById(R.id.txtvNaUno);
        txtvNaDos= findViewById(R.id.txtvNaDos);
        txtvNaTres = findViewById(R.id.txtvNaTres);

        Button buttonGoToActivity3 = findViewById(R.id.btnAgregar);
        buttonGoToActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String latUno = txtvLatUno.getText().toString();
                String latDos = txtvLatDos.getText().toString();
                String latTres = txtvLatTres.getText().toString();
                String longUno = txtvLongUno.getText().toString();
                String longDos = txtvLongDos.getText().toString();
                String longTres = txtvLongTres.getText().toString();
                String NameUno = txtvNaUno.getText().toString();
                String NameDos = txtvNaDos.getText().toString();
                String NameTres = txtvNaTres.getText().toString();

                if (isValidNumber(latUno) && isValidNumber(latDos) && isValidNumber(latTres) &&
                        isValidNumber(longUno) && isValidNumber(longDos) && isValidNumber(longTres) &&
                        !NameUno.isEmpty() && !NameDos.isEmpty() && !NameTres.isEmpty()) {

                    float LatUno = Float.parseFloat(latUno);
                    float LatDos = Float.parseFloat(latDos);
                    float LatTres = Float.parseFloat(latTres);
                    float LongUno = Float.parseFloat(longUno);
                    float LongDos = Float.parseFloat(longDos);
                    float LongTres = Float.parseFloat(longTres);

                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("Latitud1", LatUno);
                    intent.putExtra("Latitud2", LatDos);
                    intent.putExtra("Latitud3", LatTres);
                    intent.putExtra("Longitud1", LongUno);
                    intent.putExtra("Longitud2", LongDos);
                    intent.putExtra("Longitud3", LongTres);
                    intent.putExtra("Nombre1", NameUno);
                    intent.putExtra("Nombre2", NameDos);
                    intent.putExtra("Nombre3", NameTres);

                    startActivity(intent);
                } else {

                    Toast.makeText(MainActivity2.this, "Por favor ingresa valores de latitud y longitud válidos y nombres no vacíos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidNumber(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
