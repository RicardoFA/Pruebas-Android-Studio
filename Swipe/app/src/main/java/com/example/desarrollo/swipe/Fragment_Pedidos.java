package com.example.desarrollo.swipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Desarrollo on 10/02/2016.
 */
public class Fragment_Pedidos extends Fragment{

    //VIsta
    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fm_pedidos, container, false);
        return rootView;
    }
}
