package com.example.desarrollo.listviewanimado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListViewAdapter adapter;

    String[] titulo = new String[] {
            "Titulo 1",
            "Titulo 2",
            "Titulo 3",
            "Titulo 4"
    };

    int[] imagenes = {
            R.mipmap.icon01,
            R.mipmap.icon02,
            R.mipmap.icon01,
            R.mipmap.icon02
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                //Toast.makeText(getApplicationContext(), "Presiona largooo" + (position + 1), Toast.LENGTH_SHORT).show();
                View container = lista.getChildAt(position);
                container.findViewById(R.id.list_row_nuevo).setVisibility(View.VISIBLE);
                return true;
            }
        });

    }
}
