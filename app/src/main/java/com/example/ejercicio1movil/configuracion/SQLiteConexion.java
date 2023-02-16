package com.example.ejercicio1movil.configuracion;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import com.example.ejercicio1movil.transacciones.Transacciones;

public class SQLiteConexion extends SQLiteOpenHelper
{
    //constructor de clase con parametros

    public SQLiteConexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory,int version)
    {
        super(context,dbname,factory,version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        //listas de la tabla a crear
        sqLiteDatabase.execSQL(Transacciones.CreateTBPersonas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL(Transacciones.DropTablePersonas);

    }


}
