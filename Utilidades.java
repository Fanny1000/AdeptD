package com.example.adeptdiction.utilidades;

public class Utilidades {

    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDO="apellido";
    public static final String CAMPO_USUARIO="usuario";
    public static final String CAMPO_TELEFONO="telefono";
    public static final String CAMPO_NIVEL="nivel";
    public static final String CAMPO_CONTRASEÑA="contraseña";
    public static final String CAMPO_CORREO="correo";

    public static final String TABLA_PROFESORES="profesores";
    public static final String CAMPO_ID_PROFESOR="id";
    public static final String CAMPO_NOMBRE_PROFESOR="nombre";
    public static final String CAMPO_APELLIDO_PROFESOR="apellido";
    public static final String CAMPO_USUARIO_PROFESOR="usuario";
    public static final String CAMPO_CONTRASEÑA_PROFESOR="contraseña";

    public static final String CREATE_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIO+
            "("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            CAMPO_NOMBRE+" TEXT,"+
            CAMPO_APELLIDO+" TEXT,"+
            CAMPO_USUARIO+" TEXT,"+
            CAMPO_TELEFONO+" TEXT,"+
            CAMPO_NIVEL+" TEXT,"+
            CAMPO_CONTRASEÑA+" TEXT,"+
            CAMPO_CORREO+" TEXT)";

    public static final String CREATE_TABLA_PROFESORES="CREATE TABLE "+TABLA_PROFESORES+
            "("+CAMPO_ID_PROFESOR+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CAMPO_NOMBRE_PROFESOR+" TEXT,"+
            CAMPO_APELLIDO_PROFESOR+" TEXT,"+
            CAMPO_USUARIO_PROFESOR+" TEXT,"+
            CAMPO_CONTRASEÑA_PROFESOR+" TEXT)";

}
