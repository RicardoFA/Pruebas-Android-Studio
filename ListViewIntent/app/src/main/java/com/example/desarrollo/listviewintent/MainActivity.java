package com.example.desarrollo.listviewintent;

import android.content.Intent;
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
            "pablo",
            "ramiro",
            "vilma",
            "canela",
            "tito",
            "nicolas",
            "maira",
            "pepita",
            "honguito",
            "ricardo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listView1);

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, personas);

        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long l){
                //Toast.makeText(getApplicationContext(),"posicion" + (i+1) + personas[i], Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                    Intent i = new Intent(getApplicationContext(), Pablo.class);
                    startActivity(i);
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Hola soy Ramiro", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"No soy Ramiro Ni Pablo", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
