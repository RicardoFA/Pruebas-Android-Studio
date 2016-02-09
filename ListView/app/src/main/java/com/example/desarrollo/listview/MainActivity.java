package com.example.desarrollo.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    String[] personas = {
            "Pablo",
            "Ramiro",
            "Vilma",
            "Canela",
            "Tito",
            "Nicolas",
            "Mayra",
            "Pepita",
            "Honguito"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listView1);


        //Se compone de tres partes: Desde donde lo esta llamando, formato que va a tener el listView, contenido
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,personas);

        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "posicion " + (position+1) + personas[position], Toast.LENGTH_SHORT).show();

            }
        });

    }


}
