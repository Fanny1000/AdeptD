package com.example.adeptdiction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ModificarMiembro extends AppCompatActivity implements OnClickListener {

    EditText et,etdd;
    Button btnActualizar, btnEliminar;
    long nota_id;
    SQLControlador dbcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_nota);

        dbcon = new SQLControlador(this);
        dbcon.abrirBaseDeDatos();

        et = (EditText) findViewById(R.id.et_nota_id);
        etdd = (EditText) findViewById(R.id.et_nota_descripcion);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);

        Intent i = getIntent();
        String notaID = i.getStringExtra("miembroId");
        String notaName = i.getStringExtra("miembroNombre");
        String notaDescripcion = i.getStringExtra("miembroDescrip");

        nota_id = Long.parseLong(notaID);

        et.setText(notaName);
        etdd.setText(notaDescripcion);

        btnActualizar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnActualizar:
                String NotName_upd = et.getText().toString();
                String NotDescripcion_upd = etdd.getText().toString();
                dbcon.actualizarDatos(nota_id, NotName_upd,NotDescripcion_upd);
                this.returnHome();
                break;

            case R.id.btnEliminar:
                dbcon.deleteData(nota_id);
                this.returnHome();
                break;
        }
    }

    public void returnHome() {

        Intent home_intent = new Intent(getApplicationContext(),
                YNotes.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(home_intent);
    }
}