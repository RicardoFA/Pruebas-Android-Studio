package com.example.desarrollo.listviewimagenes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {

    ListViewAdapter adapter;

    String[] titulo = new String[] {
        "Titulo 1",
            "Titulo 2",
            "Titulo 3",
            "Titulo 4"
    };

    int[] imagenes = {
      R.drawable.icon01,
            R.drawable.icon02,
            R.drawable.icon01,
            R.drawable.icon02
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final ListView lista = (ListView) findViewById(R.id.listView1);
        adapter = new ListViewAdapter(this,titulo,imagenes);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "posicion " + position, Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Presiona largooo" + (position+1), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}
