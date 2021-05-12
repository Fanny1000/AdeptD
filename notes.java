package com.example.adeptdiction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class notes extends AppCompatActivity implements OnClickListener {
    EditText et,etd;
    Button btnAgregar, read_bt;
    ImageView icono;
    SQLControlador dbconeccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes);

        et = (EditText) findViewById(R.id.editText2);
        etd = (EditText) findViewById(R.id.editText);
        icono= (ImageView) findViewById(R.id.icono);
        btnAgregar = (Button) findViewById(R.id.save_button);

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }
    public void Ynotes(View v){
        Intent i= new Intent(notes.this, YNotes.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_button:
                if(et.getText().toString().equals("")||et.getText().toString().equals("Title of your note")||etd.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "\n" + "Empty notes will not be saved", Toast.LENGTH_SHORT).show();
               }else{
                    String name = et.getText().toString();
                    String descripcion = etd.getText().toString();
                    dbconeccion.insertarDatos(name,descripcion);
                    Intent main = new Intent(notes.this, YNotes.class)
                            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(main);
                }
                break;

            default:
                break;
        }

    }
}