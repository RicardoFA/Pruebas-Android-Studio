package com.example.desarrollo.spinner;

import android.app.ActionBar;
import android.app.Notification;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements ActionBar.OnNavigationListener {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.texto);
        ActionBar actionBar = getSupportActionBar();

        //Se crea el spinner
        SpinnerAdapter spinneradapter = ArrayAdapter.createFromResource(this,R.array.lista, android.R.layout.simple_spinner_dropdown_item);
        actionBar.setListNavigationCallbacks(spinneradapter, this);

        //Muestra el spinner
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
    }


    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
       switch (itemPosition){
           case 0:
           texto.setText("Opcion seleccionada: \n\nLunes");
               break;
           case 1:
               texto.setText("Opcion seleccionada: \n\nMartes");
               break;
           case 2:
               texto.setText("Opcion seleccionada: \n\nMiercoles");
               break;
           case 3:
               texto.setText("Opcion seleccionada: \n\nJueves");
               break;
           case 4:
               texto.setText("Opcion seleccionada: \n\nViernes");
               break;
           case 5:
               texto.setText("Opcion seleccionada: \n\nSabado");
               break;
           case 6:
               texto.setText("Opcion seleccionada: \n\nDomingo");
               break;
       }
        return false;
    }
}
