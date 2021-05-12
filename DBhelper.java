package com.example.adeptdiction;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    // Información de la tabla
    public static final String TABLE_NOTES = "notas";
    public static final String NOTA_ID = "_id";
    public static final String NOTA_NOMBRE = "nombre";
    public static final String NOTA_DESCRIPCION = "descripcion";

    // información del a base de datos
    static final String DB_NAME = "DBNOTA";
    static final int DB_VERSION = 1;

    // Información de la base de datos
    private static final String CREATE_TABLE = "create table "
            + TABLE_NOTES + "(" + NOTA_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOTA_DESCRIPCION
            + " TEXT NOT NULL, "
            + NOTA_NOMBRE + " TEXT NOT NULL);";

    public DBhelper(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }
}

