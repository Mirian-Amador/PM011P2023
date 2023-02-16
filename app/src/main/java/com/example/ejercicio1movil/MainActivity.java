package com.example.ejercicio1movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio1movil.configuracion.SQLiteConexion;
import com.example.ejercicio1movil.transacciones.Transacciones;

import java.util.Enumeration;

public class MainActivity extends AppCompatActivity
{
    //global
    EditText nombres, apellidos, correo,Edad;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = (EditText) findViewById(R.id.nombres);
        apellidos = (EditText) findViewById(R.id.apellidos);
        correo = (EditText) findViewById(R.id.correo);
        Edad = (EditText) findViewById(R.id.Edad);

        btnagregar = (Button) findViewById(R.id.btnagregar);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarPersona();
            }
        });
    }

    private void AgregarPersona()
    {
        try {
            SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase,null,1);
            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nombres",nombres.getText().toString());
            valores.put("apellidos",apellidos.getText().toString());
            valores.put("Edad",Edad.getText().toString());
            valores.put("correo",correo.getText().toString());



            Long Resultado = db.insert(Transacciones.tablapersonas,"id",valores);
            Toast.makeText(this,Resultado.toString(), Toast.LENGTH_SHORT).show();

            ClearScreen();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"No se pudo insertar el dato", Toast.LENGTH_LONG).show();
        }

    }
    private void ClearScreen()
    {
        nombres.setText(Transacciones.Empty);
        apellidos.setText(Transacciones.Empty);
        correo.setText(Transacciones.Empty);
        Edad.setText(Transacciones.Empty);
    }


    private void MostrarCliente()
    {
        String mensaje = nombres.getText().toString() +
                " | "+apellidos.getText().toString()+
                " | "+correo.getText().toString();

        Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show();
    }
}