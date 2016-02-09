package com.example.desarrollo.sonidos;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();
    ImageButton imgBtn1, imgBtn2, imgBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtn1 = (ImageButton) findViewById(R.id.imageButton);
        imgBtn2 = (ImageButton) findViewById(R.id.imageButton2);
        imgBtn3 = (ImageButton) findViewById(R.id.imageButton3);

    }

    public void onClickImgBtn1(View view){
        mp.reset(); //cuando se quite el click en el boton, se quita el sonido
        mp.release(); //cuando se quite el click en el boton, se quita el sonido
        mp = MediaPlayer.create(this, R.raw.buenochao);
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp.seekTo(0);
        mp.start();
    }

    public void onClickImgBtn2(View view){
        mp.reset(); //cuando se quite el click en el boton, se quita el sonido
        mp.release(); //cuando se quite el click en el boton, se quita el sonido
        mp = MediaPlayer.create(this, R.raw.carlitoxidea);
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp.seekTo(0);
        mp.start();
    }

    public void onClickImgBtn3(View view){
        mp.reset(); //cuando se quite el click en el boton, se quita el sonido
        mp.release(); //cuando se quite el click en el boton, se quita el sonido
        mp = MediaPlayer.create(this, R.raw.chaleco);
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp.seekTo(0);
        mp.start();
    }


}
