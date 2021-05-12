package com.example.adeptdiction;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.adeptdiction.entidades.usuario;
import com.example.adeptdiction.utilidades.Utilidades;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ConexionSQLite {
    Context c;
    usuario u;
    ArrayList<usuario> lista;
    SQLiteDatabase sql;
    String bd="usuarios";

    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDO="apellido";
    public static final String CAMPO_USUARIO="usuario";
    public static final String CAMPO_TELEFONO="telefono";
    public static final String CAMPO_NIVEL="nivel";
    public static final String CAMPO_CONTRASEÑA="contraseña";
    public static final String CAMPO_CORREO="correo";

    public static final String tabla="CREATE TABLE IF  NOT EXISTS "+TABLA_USUARIO+
            "("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            CAMPO_NOMBRE+" TEXT,"+
            CAMPO_APELLIDO+" TEXT,"+
            CAMPO_USUARIO+" TEXT,"+
            CAMPO_TELEFONO+" TEXT,"+
            CAMPO_NIVEL+" TEXT,"+
            CAMPO_CONTRASEÑA+" TEXT,"+
            CAMPO_CORREO+" TEXT)";

    public ConexionSQLite(Context c){
        this.c=c;
        sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        u=new usuario();
    }
    public boolean insertUsuario(usuario u){
        if((buscar(u.getNombre())==0 && buscar(u.getApellido())==0) ||(buscar(u.getUsuario())==0 && buscar(u.getContraseña() )==0)){
            ContentValues values = new ContentValues();
            values.put(CAMPO_NOMBRE, u.getNombre());
            values.put(CAMPO_APELLIDO, u.getApellido());
            values.put(CAMPO_USUARIO, u.getUsuario());
            values.put(CAMPO_TELEFONO, u.getTelefono());
            values.put(CAMPO_CONTRASEÑA, u.getContraseña());
            values.put(CAMPO_CORREO, u.getCorreo());
            values.put(CAMPO_NIVEL, u.getNivel());
            return (sql.insert("usuario",null,values)>0);

        }else{
            return false;
        }
    }
    public int buscar(String u){
        int x=0;
        lista=selectusuario();
        for (usuario us : lista) {
            if (us.getUsuario().equals(u)) {
                x++;
            }
        }
        return x;
    }
    public ArrayList<usuario> selectusuario(){
        ArrayList<usuario> lista=new ArrayList<usuario>();
        lista.clear();
        Cursor cr=sql.rawQuery("select * from usuario ",null);
        if(cr!=null&&cr.moveToFirst()){
            do{
                usuario u=new usuario();
                u.setId(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setApellido(cr.getString(2));
                u.setUsuario(cr.getString(3));
                u.setTelefono(cr.getString(4));
                u.setNivel(cr.getString(5));
                u.setContraseña(cr.getString(6));
                u.setCorreo(cr.getString(7));

                lista.add(u);
            }while(cr.moveToNext());
        }
        return lista;
    }

    public boolean login(String u, String p){
        boolean a=false;
        Cursor cr=sql.rawQuery("select * from usuario ",null);
        if(cr!=null && cr.moveToFirst()){
            do{
                if(cr.getString(3).equals(u) && cr.getString(6).equals(p)){
                    a=true;
                }
            }while (cr.moveToNext());
        }
        return a;
    }

    public usuario getUsuario(String u, String p) {
        lista = selectusuario();
        for (usuario us : lista) {
            if (us.getUsuario().equals(u) && us.getContraseña().equals(p)) {
                return us;
            }
        }
                return null;
    }
}
