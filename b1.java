package com.example.adeptdiction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class b1 extends AppCompatActivity {
    private TextView nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        nombre=(TextView)findViewById(R.id.nombreAlumno);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b1);
        recibirdatos();
    }
    private void recibirdatos() {
//Recibiendo los datos
        Bundle extras = getIntent().getExtras();
        String nombreA = extras.getString("Nombre");
        nombre = findViewById(R.id.nombreAlumno);
        nombre.setText(""+nombreA);
    }
    public void homework(View v){
        Intent i= new Intent(b1.this, calendar.class);
        startActivity(i);
    }
    public void notes(View v){
        Intent i= new Intent(b1.this, YNotes.class);
        startActivity(i);
    }
    public void content(View v){
        Intent i= new Intent(b1.this, contentb1.class);
        startActivity(i);
    }
    public void calendar(View v){
        Intent i= new Intent(b1.this, SEPcalendar.class);
        startActivity(i);
    }
    //@string/nombre_string
}