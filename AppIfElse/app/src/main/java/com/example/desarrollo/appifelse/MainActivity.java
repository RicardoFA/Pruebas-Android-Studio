package com.example.desarrollo.appifelse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btnAccion;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et = (EditText) findViewById(R.id.et_edad);
        btnAccion = (Button) findViewById(R.id.btnAccion);
        tv = (TextView) findViewById(R.id.tvEdad);

        btnAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //accion que v a producir el boton

                String aux = et.getText().toString();

                if (!aux.matches("")){
                    //Toast.makeText(getApplicationContext(), "Datos válidos", Toast.LENGTH_SHORT).show();

                    int auxEntero = 0;
                    try {
                        auxEntero = Integer.parseInt(aux);
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), "Ingresa sólo números por favor.", Toast.LENGTH_SHORT).show();
                    };
                    if (auxEntero > 18){
                        tv.setText("Eres mayor de edad");
                    }else
                        tv.setText("Eres menor de edad");
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
