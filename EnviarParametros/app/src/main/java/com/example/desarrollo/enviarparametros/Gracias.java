package com.example.desarrollo.enviarparametros;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Desarrollo on 03/02/2016.
 */
public class Gracias extends Activity {

    TextView tv_gracias;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gracias);
    tv_gracias = (TextView) findViewById(R.id.tv_gracias);

        Bundle extras = getIntent().getExtras();
        String xnombre = extras.getString("nombre");
        String xapellido = extras.getString("apellido");

        tv_gracias.setText("Gracias " + xnombre + "Por usar nuestro servicio\n de apellido" + xapellido);

    }
}
