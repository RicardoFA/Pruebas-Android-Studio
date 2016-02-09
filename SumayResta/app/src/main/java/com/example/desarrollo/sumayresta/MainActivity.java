package com.example.desarrollo.sumayresta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);

        Button btnSumar = (Button) findViewById(R.id.btnSumar);

        final TextView tvResultado = (TextView) findViewById(R.id.textViewResultado);
        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int aux1 = Integer.valueOf( et1.getText().toString() );
                int aux2 = Integer.valueOf( et2.getText().toString() );
                int resultado = aux1 + aux2;

                tvResultado.setText("El resultado es: "+resultado);
            }
        });

        Button btnResta = (Button) findViewById(R.id.btnResta);

        btnResta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int aux1 = Integer.valueOf( et1.getText().toString() );
                int aux2 = Integer.valueOf( et2.getText().toString() );
                int resultado = aux1 - aux2;

                tvResultado.setText("El resultado es: "+resultado);
                }
        });

    }

}
