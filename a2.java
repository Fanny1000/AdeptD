package com.example.adeptdiction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class a2 extends AppCompatActivity {
    private TextView nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //nombre=(TextView)findViewById(R.id.nombreAlumno);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2);
        recibirdatos();
    }
    private void recibirdatos() {
//Recibiendo los datos
        Bundle extras = getIntent().getExtras();
        String nombreA = extras.getString("Nombre");
       // nombre = findViewById(R.id.nombreAlumno);
        //nombre.setText(""+nombreA);
    }
}