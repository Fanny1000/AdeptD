package com.example.adeptdiction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControlador {

    private DBhelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControlador(Context c) {
        ourcontext = c;
    }

    public SQLControlador abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String name,String descripcion) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.NOTA_NOMBRE, name);
        cv.put(DBhelper.NOTA_DESCRIPCION, descripcion);
        database.insert(DBhelper.TABLE_NOTES, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelper.NOTA_ID,
                DBhelper.NOTA_NOMBRE,
                DBhelper.NOTA_DESCRIPCION
        };
        Cursor c = database.query(DBhelper.TABLE_NOTES, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long noteID, String noteName,String NOTEdescripcion) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelper.NOTA_NOMBRE, noteName);
        cvActualizar.put(DBhelper.NOTA_DESCRIPCION, NOTEdescripcion);
        int i = database.update(DBhelper.TABLE_NOTES, cvActualizar,
                DBhelper.NOTA_ID + " = " + noteID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelper.TABLE_NOTES, DBhelper.NOTA_ID + "="
                + memberID, null);
    }
}
