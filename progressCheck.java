package com.example.adeptdiction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class progressCheck extends AppCompatActivity {
    ImageView h1, h2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_check);

        h1 = (ImageView) findViewById(R.id.pch1);
        h2 = (ImageView) findViewById(R.id.pch2);
        recibirdatos();
    }

    private void recibirdatos() {
//Recibiendo los datos
        Bundle extras = getIntent().getExtras();
        String Libro = extras.getString("Libro");
        String Unidad = extras.getString("Unidad");
        imagenes(Libro, Unidad);
    }

    @SuppressLint("ResourceType")
    public void imagenes(String l, String u) {
        String lu = l + u;
        switch (lu) {
            case "Studen't book 3pc12":
                h1.setImageResource(R.raw.p18);
                h2.setImageResource(R.raw.p19);
                break;
            case "Studen't book 3pc34":
                h1.setImageResource(R.raw.p32);
                h2.setImageResource(R.raw.p33);
                break;
            case "Studen't book 3pc56":
                h1.setImageResource(R.raw.p46);
                h2.setImageResource(R.raw.p47);
                break;
            case "Studen't book 3pc78":
                h1.setImageResource(R.raw.p60);
                h2.setImageResource(R.raw.p61);
                break;
            case "Studen't book 3pc910":
                h1.setImageResource(R.raw.p74);
                h2.setImageResource(R.raw.p75);
                break;
            case "Studen't book 3pc1112":
                h1.setImageResource(R.raw.p88);
                h2.setImageResource(R.raw.p89);
                break;
            case "Studen't book 3pc1314":
                h1.setImageResource(R.raw.p102);
                h2.setImageResource(R.raw.p103);
                break;
            case "Studen't book 3pc1516":
                h1.setImageResource(R.raw.p116);
                h2.setImageResource(R.raw.p117);
                break;
        }
    }
}