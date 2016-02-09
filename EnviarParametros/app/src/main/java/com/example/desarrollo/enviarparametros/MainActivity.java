package com.example.desarrollo.enviarparametros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre,
            et_apellido;
    Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_apellido = (EditText) findViewById(R.id.et_apellido);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);

    }

    public void onClickAceptar (View view){
        //Toast.makeText(getApplication(),"Algo",Toast.LENGTH_SHORT).show();

        String aux_nombre = et_nombre.getText().toString();
        String aux_apellido = et_apellido.getText().toString();

        if (!aux_nombre.matches( "") && !aux_apellido.matches("")) {


            Intent i = new Intent(this, Gracias.class);
            i.putExtra("nombre", aux_nombre);
            i.putExtra("apellido", aux_apellido);
            startActivity(i);
        }else{
            Toast.makeText(getApplication(), "Ingresa datos válidos", Toast.LENGTH_SHORT).show();
        }
    }

}
