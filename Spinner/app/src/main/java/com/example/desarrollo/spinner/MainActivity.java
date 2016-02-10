package com.example.desarrollo.spinner;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity  implements ActionBar.OnNavigationListener {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.texto);

        ActionBar actionBar = getSupportActionBar();

        //Crear el spinner
        SpinnerAdapter adapter = ArrayAdapter.createFromResource(this, R.array.lista, android.R.layout.simple_spinner_dropdown_item);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

    }


    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        switch (itemPosition){
            case 0:
                texto.setText("Opcion seleccionada \n\n Lunes");
                break;
            case 1:
                texto.setText("Opcion seleccionada \n\n Martes");
                break;
            case 2:
                texto.setText("Opcion seleccionada \n\n Miercoles");
                break;
            case 3:
                texto.setText("Opcion seleccionada \n\n Jueves");
                break;
            case 4:
                texto.setText("Opcion seleccionada \n\n Viernes ");
                break;
            default:
                Toast.makeText(getApplicationContext(),"No existe este dia", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
