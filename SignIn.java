package com.example.adeptdiction;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.adeptdiction.entidades.usuario;
import com.example.adeptdiction.utilidades.Utilidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SignIn extends AppCompatActivity implements View.OnClickListener{
    EditText tnombre, tapellido, ttelefono, tcontraseña, tcorreo,tusuario;
    RadioButton a1, a2, b1, b2;
    Button signin;
    String tnivel;
    ConexionSQLite dao;

    //para enviar e-mail

    String correo;
    String contraseña;
    String mensaje;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        tnombre = (EditText) findViewById(R.id.NameTexto);
        tapellido = (EditText) findViewById(R.id.apellidoTexto);
        ttelefono = (EditText) findViewById(R.id.telefonoTexto);
        tusuario = (EditText) findViewById(R.id.usuarioTexto);
        tcontraseña = (EditText) findViewById(R.id.contraseña);
        tcorreo = (EditText) findViewById(R.id.CorreoTexto);
        a1 = (RadioButton) findViewById(R.id.A1);
        a2 = (RadioButton) findViewById(R.id.A2);
        b1 = (RadioButton) findViewById(R.id.B1);
        b2 = (RadioButton) findViewById(R.id.B2);
        signin = (Button) findViewById(R.id.signin);
        signin.setOnClickListener(this);
        dao=new ConexionSQLite(this);

        //para enviar correo
        mensaje="Un usuario se ha registrado:\n";
        correo="holasoyfannyholaphi@gmail.com";
        contraseña="phine100";

    }
 public void onClick(View v){
     if (tnombre==null ||tnombre.equals("Ex. Estefania")||
             tapellido==null ||tapellido.equals("Ex. Bucio")||
             ttelefono==null ||ttelefono.equals("Ex. 5561077420")||
             tusuario==null ||tusuario.equals("Ex. FannyS")||
             tcontraseña==null ||tcontraseña.equals("Password")||
             tcorreo==null ||tcorreo.equals("Ex.fanny_s@gmail.com")||
             ((a1.isChecked() == false)&&(a2.isChecked() == false)&&(b1.isChecked() == false)&&(b2.isChecked() == false))){

         Toast.makeText(getApplicationContext(), "Porfavor ingresa todos los datos", Toast.LENGTH_SHORT).show();
     }else if(ttelefono.getText().length()<=9||!validarEmail(tcorreo.getText().toString())){
         Toast.makeText(getApplicationContext(), "Algunos de los datos no son validos, favor de revisarlos", Toast.LENGTH_SHORT).show();
         ttelefono.setError("Puede que este dato este mal");
         tcorreo.setError("Puede que este dato este mal");
     }else {
         usuario u = new usuario();
         u.setNombre(tnombre.getText().toString());
         u.setApellido(tapellido.getText().toString());
         u.setUsuario(tusuario.getText().toString());
         u.setTelefono(ttelefono.getText().toString());
         final String nivel;
         if (a1.isChecked() == true) {
             nivel = "A1";
             u.setNivel(nivel);
         } else if (a2.isChecked() == true) {
             nivel = "A2";
             u.setNivel(nivel);
         } else if (b1.isChecked() == true) {
             nivel = "B1";
             u.setNivel(nivel);
         } else if (b2.isChecked() == true) {
             nivel = "B2";
             u.setNivel(nivel);
         } else {
             nivel =  null;
             u.setNivel(nivel);
         }
         u.setContraseña(tcontraseña.getText().toString());
         u.setCorreo(tcorreo.getText().toString());

         if(dao.insertUsuario(u)==true){
             Intent i= new Intent(SignIn.this, MainActivity.class);
             startActivity(i);
                String datos=new String ("Datos del nuevo usuario:\n   Nombre:"+
                        tnombre.getText().toString()+
                        "\n   Apellido:"+ tapellido.getText().toString()+
                        "\n   Usuario:"+tusuario.getText().toString()+
                        "\n   Telefono:"+ttelefono.getText().toString()+
                        "\n   Nivel:"+nivel+
                        "\n   Contraseña:"+tcontraseña.getText().toString()+
                        "\n   Correo:"+tcorreo.getText().toString());
             //aqui e implementa lo del correo

             StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
             StrictMode.setThreadPolicy(policy);
             Properties properties=new Properties();
             properties.put("mail.smtp.host","smtp.googlemail.com");
             properties.put("mail.smtp.socketFactory.port","465");
                    //seguridad
             properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
             properties.put("mail.smtp.auth","true");
             properties.put("mail.smtp.port","465");

             /*Para que el correo pueda ser hotmail:
             1-   properties.put("mail.smtp.host","smtp.live.com");
             2- properties.put("mail.smtp.socketFactory.port","587");
             5-properties.put("mail.smtp.starttls.enable","true");
             */
             try{
                    session=Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo,contraseña);
                        }
                    });
                 if(session!=null){
                     javax.mail.Message message=new MimeMessage(session);
                     message.setFrom(new InternetAddress(correo));
                     message.setSubject("Nuevo registro de usuario");
                     message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("holasoyfannyholaphi@gmail.com"));
                     message.setContent(datos,"text/html; charset=utf-8");
                     Transport.send(message);
                     /*
                        Eliminas el ultimo transport y:
                     Transport transport=session.getTransport("smtp");
                    transport.connect("smtp,live.com",587,correo,contraseña);
                    transport.sendMessage(mensaje,message.getllRecipients());
                        transport.close();
                     */
                     Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                 }
             }catch(Exception e){
                    e.printStackTrace();
             }


             //esto ya no
             finish();
         }else{
             Toast.makeText(getApplicationContext(), "Usuario ya existente, error al registrar", Toast.LENGTH_SHORT).show();
         }


     }
 }
    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
    /*private void registrarUsuarios() {
       if (tnombre==null ||tnombre.equals("Ex. Estefania")||
                tapellido==null ||tapellido.equals("Ex. Bucio")||
                ttelefono==null ||ttelefono.equals("Ex. 5561077420")||
                tusuario==null ||tusuario.equals("Ex. FannyS")||
                tcontraseña==null ||tcontraseña.equals("Password")||
                tcorreo==null ||tcorreo.equals("Ex.fanny_s@gmail.com")||
                ((a1.isChecked() == false)&&(a2.isChecked() == false)&&(b1.isChecked() == false)&&(b2.isChecked() == false))){

            Toast.makeText(getApplicationContext(), "Porfavor ingresa todos los datos", Toast.LENGTH_SHORT).show();
        }else {

            ConexionSQLite conn = new ConexionSQLite(this, "bd_usuarios", null, 1);
            SQLiteDatabase db = conn.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_NOMBRE, tnombre.getText().toString());
            values.put(Utilidades.CAMPO_APELLIDO, tapellido.getText().toString());
            values.put(Utilidades.CAMPO_USUARIO, tusuario.getText().toString());
            values.put(Utilidades.CAMPO_TELEFONO, ttelefono.getText().toString());
            values.put(Utilidades.CAMPO_CONTRASEÑA, tcontraseña.getText().toString());
            values.put(Utilidades.CAMPO_CORREO, tcorreo.getText().toString());
            final String nivel;
            if (a1.isChecked() == true) {
                nivel = "A1";
                values.put(Utilidades.CAMPO_NIVEL, nivel);
            } else if (a2.isChecked() == true) {
                nivel = "A2";
                values.put(Utilidades.CAMPO_NIVEL, nivel);
            } else if (b1.isChecked() == true) {
                nivel = "B1";
                values.put(Utilidades.CAMPO_NIVEL, nivel);
            } else if (b2.isChecked() == true) {
                nivel = "B2";
                values.put(Utilidades.CAMPO_NIVEL, nivel);
            } else {
                nivel = null;
                values.put(Utilidades.CAMPO_NIVEL, nivel);
            }
            Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);
            Toast.makeText(getApplicationContext(), "Id Registro: " + idResultante+" ya puedes ingresar", Toast.LENGTH_SHORT).show();
            db.close();
            Intent i= new Intent(SignIn.this, MainActivity.class);
            startActivity(i);
        }
    }*/

}
