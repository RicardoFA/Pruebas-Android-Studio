package com.example.desarrollo.ejemplolayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Desarrollo on 03/02/2016.
 */
public class Segundo extends Activity {
    Button btnVoyA1ero;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundo);

        btnVoyA1ero = (Button) findViewById(R.id.btnVoyAPrincipal);
    }

    public void onClickVoyAPrincipal (View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
