package com.example.ejercicio1movil;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ejercicio1movil.configuracion.SQLiteConexion;
import com.example.ejercicio1movil.transacciones.Personas;
import com.example.ejercicio1movil.transacciones.Transacciones;

import java.util.ArrayList;

public class ActivityListView extends AppCompatActivity
{
    //Variables Globales
    SQLiteConexion conexion;
    ListView listView;
    //creamos un array de la clase persona
    ArrayList<Personas> listapersonas;
    // array para concatenacion de string
    ArrayList<String> Arreglopersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //creamos la conexion
        conexion = new SQLiteConexion(this, Transacciones.NameDatabase,null,1);
        listView = (ListView) findViewById(R.id.listview);

        OntenerlistaPersonas();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,Arreglopersonas);
        //
        listView.setAdapter(adp);
    }

    private void OntenerlistaPersonas()
    {
        //para leer la base de datos
        SQLiteDatabase db = conexion.getReadableDatabase();
        //objeto personas
        Personas person = null;
        //lista que vamos a rrellenar con los datos de la base de datos
        listapersonas=new ArrayList<Personas>();

        //cursor para recorrer la tablas de persona
        Cursor cursor = db.rawQuery("SELECT * FROM personas",null);
        //recorrer el cursor
        while(cursor.moveToNext())
        {
            person = new Personas();
            //
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));

            //mandamos los datos al array de lista personas
            listapersonas.add(person);
        }
        //cerramos el cursor
        cursor.close();
        FillList();
    }
    //metodo
    private void FillList()
    {
        Arreglopersonas = new ArrayList<String>();
        for(int i = 0; i < listapersonas.size(); i++)
        {
            Arreglopersonas.add(listapersonas.get(i).getId() + " | "+
                    listapersonas.get(i).getNombres() + " | "+
                    listapersonas.get(i).getApellidos() + " | ");
        }

    }

}