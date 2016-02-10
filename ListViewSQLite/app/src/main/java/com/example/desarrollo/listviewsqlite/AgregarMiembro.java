package com.example.desarrollo.listviewsqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Desarrollo on 10/02/2016.
 */
public class AgregarMiembro extends Activity implements View.OnClickListener {

    EditText et;
    Button btnAgregar, read_bt;
    SQLControlador dbconection;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        //TODO Auto-generate method sub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_miembro);
        et = (EditText) findViewById(R.id.et_miembro_id);
        btnAgregar = (Button) findViewById(R.id.btnAgregarId);

        dbconection = new SQLControlador(this);
        dbconection.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //TODO Auto-generate method sub
        switch (v.getId()){
            case R.id.btnAgregarId:
                String name = et.getText().toString();
                dbconection.insertarDatos(name);
                Intent main = new Intent(AgregarMiembro.this, MyActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;
            default:
                break;
        }
    }
}
