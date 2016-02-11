package com.example.desarrollo.listviewsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MyActivity extends ActionBarActivity {

    Button btnAgregarMiembro;
    ListView lista;
    SQLControlador dbconection;
    TextView tv_miemID, tv_miemNombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        dbconection = new SQLControlador(this);
        dbconection.abrirBaseDeDatos();
        btnAgregarMiembro = (Button) findViewById(R.id.btnAgregarMiembros);
        lista = (ListView) findViewById(R.id.listViewMiembros);

        //accion del boton agregar miembro
        btnAgregarMiembro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(MyActivity.this, AgregarMiembro.class);
                startActivity(iagregar);
            }
        });

        //Tomar los datos desde la base de datos para poner el curso y despues en el adapter
        Cursor cursor = dbconection.leerDatos();

        String[] from = new String[]{
                DBhelper.MIEMBRO_ID,
                DBhelper.MIEMBRO_NOMBRE
        };

        int[] to = new int[] {
                R.id.miembro_id,
                R.id.miembro_nombre
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                MyActivity.this,R.layout.formato_fila,cursor,from,to);

        adapter.notifyDataSetChanged();
        lista.setAdapter(adapter);

        //Accion cuando hacemos click en item para poder modificarlo o eliminarlo
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_miemID = (TextView) view.findViewById(R.id.miembro_id);
                tv_miemNombre = (TextView) view.findViewById(R.id.miembro_nombre);

                String aux_miembroId = tv_miemID.getText().toString();
                String aux_miembroNombre = tv_miemNombre.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ModificarMiembro.class);
                modify_intent.putExtra("miembroID", aux_miembroId);
                modify_intent.putExtra("miembroNombre", aux_miembroNombre);
                startActivity(modify_intent);
            }
        });
    } //Termina clase onCreate
} //Termina clase

