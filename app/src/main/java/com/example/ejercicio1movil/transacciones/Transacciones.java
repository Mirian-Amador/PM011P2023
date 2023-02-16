package com.example.ejercicio1movil.transacciones;

public class Transacciones
{
    //nombre de la base de datos
    public static final String NameDatabase = "PM01DB";
    //tabla de la base de datos
    public static final String tablapersonas = "personas";

    /*Transacciones de la base de datos PM01DB*/
    public static final String CreateTBPersonas =
            "CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, "+
                    "apellidos TEXT,Edad INTEGER,correo TEXT)";

    public static final String DropTablePersonas = "DROP TABLE IF EXISTS personas";

    //helpers
    public static final String Empty= "";
}
