package com.example.adeptdiction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.adeptdiction.entidades.profesores;
import com.example.adeptdiction.entidades.usuario;
import com.example.adeptdiction.utilidades.Utilidades;

import java.util.ArrayList;

import static com.example.adeptdiction.ConexionSQLite.tabla;

public class ConexionSQLiteProfesores  extends SQLiteOpenHelper{
    Context c;
    profesores u;
    ArrayList<usuario> lista;
    SQLiteDatabase sql;
    String bd="profesor";

    public static final String TABLA_PROFESORES="profesores";
    public static final String CAMPO_ID_PROFESOR="id";
    public static final String CAMPO_NOMBRE_PROFESOR="nombre";
    public static final String CAMPO_APELLIDO_PROFESOR="apellido";
    public static final String CAMPO_USUARIO_PROFESOR="usuario";
    public static final String CAMPO_CONTRASEÑA_PROFESOR="contraseña";

    public static final String CREATE_TABLA_PROFESORES="CREATE TABLE IF  NOT EXISTS  "+TABLA_PROFESORES+
            "("+CAMPO_ID_PROFESOR+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CAMPO_NOMBRE_PROFESOR+" TEXT,"+
            CAMPO_APELLIDO_PROFESOR+" TEXT,"+
            CAMPO_USUARIO_PROFESOR+" TEXT,"+
            CAMPO_CONTRASEÑA_PROFESOR+" TEXT)";



   public ConexionSQLiteProfesores(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREATE_TABLA_PROFESORES);
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE_PROFESOR, "Bruno");
        values.put(Utilidades.CAMPO_APELLIDO_PROFESOR, "Diaz");
        values.put(Utilidades.CAMPO_USUARIO_PROFESOR, "BrunoD");
        values.put(Utilidades.CAMPO_CONTRASEÑA_PROFESOR, "14062017");

        this.c=c;
        sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE,null);
        sql.execSQL(CREATE_TABLA_PROFESORES);
        u=new profesores();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS profesores");
        onCreate(db);
    }

    public int login(String u, String p){
        int a=0;
        Cursor cr=sql.rawQuery("select * from profesores ",null);
        if(cr!=null && cr.moveToFirst()){
            do{
                if(cr.getString(1).equals(u) && cr.getString(4).equals(p)){
                    a++;
                }
            }while (cr.moveToNext());
        }
        return a;
    }


}
