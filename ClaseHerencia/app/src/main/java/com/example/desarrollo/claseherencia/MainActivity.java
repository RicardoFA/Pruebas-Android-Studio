package com.example.desarrollo.claseherencia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnAceptar;

    EditText etNumeroDePlaca;
    EditText etModelo;

    TextView tvNumeroPlaca;
    TextView tvModelo;

    String aux1, aux2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Text Edit
        etNumeroDePlaca = (EditText) findViewById(R.id.et_placa);
        etModelo = (EditText) findViewById(R.id.et_modelo);

        //TextView
        tvNumeroPlaca = (TextView) findViewById(R.id.tvPlaca);
        tvModelo = (TextView) findViewById(R.id.tvModelo);

        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btnAceptar:

                aux1 = etNumeroDePlaca.getText().toString();
                aux2 = etModelo.getText().toString();

                Moto motito2 = new Moto();
                motito2.setNumeroPlaca(aux1);
                motito2.setModelo(aux2);

                aux1 = motito2.getNumeroPlaca();
                aux2 = motito2.getModelo();


                tvNumeroPlaca.setText(aux1);
                tvModelo.setText(aux2);
                break;

        }
    }
}
