package com.example.adeptdiction;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class YNotes extends AppCompatActivity {

    Button btnAgregarMiembro;
    ListView lista;
    SQLControlador dbconeccion;
    TextView tv_miemID, tv_miemNombre,tv_miemDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_notes);

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarMiembro = (Button) findViewById(R.id.btnAgregarNota);
        lista = (ListView) findViewById(R.id.listviewNotes);

        //acción del boton agregar miembro
        btnAgregarMiembro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(YNotes.this, notes.class);
                startActivity(iagregar);
            }
        });

        // Tomar los datos desde la base de datos para poner en el curso y después en el adapter
        Cursor cursor = dbconeccion.leerDatos();

        String[] from = new String[] {
                DBhelper.NOTA_ID,
                DBhelper.NOTA_NOMBRE,
                DBhelper.NOTA_DESCRIPCION
        };
        int[] to = new int[] {
                R.id.nota_id,
                R.id.nota_nombre,
                R.id.nota_descripcion
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                YNotes.this, R.layout.formatonotas, cursor, from, to);

        adapter.notifyDataSetChanged();
        lista.setAdapter(adapter);

        // acción cuando hacemos click en item para poder modificarlo o eliminarlo
        lista.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                tv_miemID = (TextView) view.findViewById(R.id.nota_id);
                tv_miemNombre = (TextView) view.findViewById(R.id.nota_nombre);
                tv_miemDescrip = (TextView) view.findViewById(R.id.nota_descripcion);

                String aux_miembroId = tv_miemID.getText().toString();
                String aux_miembroNombre = tv_miemNombre.getText().toString();
                String aux_miembroDescrip = tv_miemDescrip.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ModificarMiembro.class);
                modify_intent.putExtra("miembroId", aux_miembroId);
                modify_intent.putExtra("miembroNombre", aux_miembroNombre);
                modify_intent.putExtra("miembroDescrip", aux_miembroDescrip);
                startActivity(modify_intent);
            }
        });
    }  //termina el onCreate
} //termina clase
