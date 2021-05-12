package com.example.adeptdiction;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adeptdiction.entidades.usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener/*implements Response.Listener<JSONObject>,Response.ErrorListener*/{
    EditText cajaUser,cajaPwd;
    Button btnConsultar;
    ConexionSQLite dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaUser=(EditText)findViewById(R.id.usuario);
        cajaPwd=(EditText)findViewById(R.id.contraseña);
        btnConsultar=(Button)findViewById(R.id.entrar);
        btnConsultar.setOnClickListener(this);
        dao=new ConexionSQLite(this);
      //  ConexionSQLite conn=new ConexionSQLite(this,"bd usuarios",null,1);

    }
    public void direccion(View v) {
        Uri uri = Uri.parse("https://www.google.com.mx/maps/place/Adept+Diction/@19.684613,-99.2073027,17z/data=!3m1!4b1!4m5!3m4!1s0x85d21f1427e0aa57:0xeecd5dcd28b214ef!8m2!3d19.684613!4d-99.205114");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void AboutUs(View v){
        Intent i= new Intent(MainActivity.this, AboutUs.class);
        startActivity(i);
    }
    public void LogInProfesor(View v){
        Intent i= new Intent(MainActivity.this, LogInProfesos.class);
        startActivity(i);
    }
   /* public void enter(View view){

        Intent i= new Intent(MainActivity.this, b1.class);
        String nombreA = usuario.getText().toString();
        i.putExtra("Nombre",nombreA);
        startActivity(i);*/

    /*    final String nombre=tnombre.getText().toString();
        final String contraseña=tcontraseña.getText().toString();

        Response.Listener<String> responseListener= new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        };
    }*/
    @Override
    public void onClick(View v) {
            String u=cajaUser.getText().toString();
        String p=cajaPwd.getText().toString();
        if(u.equals("User")||u.equals("")||p.equals("Password")||p.equals("")){
            Toast.makeText(getApplicationContext(), "Porfavor ingresa todos los datos", Toast.LENGTH_SHORT).show();
        }else if(dao.login(u,p)==true){
            usuario us=dao.getUsuario(u,p);
            Intent i= new Intent(MainActivity.this, b1.class);
            i.putExtra("Nombre",us.getNombre());
            startActivity(i);
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Este usuario no esta registrado en el dispositivo", Toast.LENGTH_SHORT).show();
        }
    }
}
