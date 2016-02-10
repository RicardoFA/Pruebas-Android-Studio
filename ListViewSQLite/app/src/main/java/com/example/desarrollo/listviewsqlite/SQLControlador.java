package com.example.desarrollo.listviewsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by Desarrollo on 10/02/2016.
 */
public class SQLControlador {

    private DBhelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControlador(Context c){
        ourcontext = c;
    }

    public SQLControlador abrirBaseDeDatos() throws SQLException{
        dbhelper = new DBhelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar(){
        dbhelper.close();
    }

    public void insertarDatos(String name) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.MIEMBRO_NOMBRE, name);
        database.insert(DBhelper.TABLE_MEMBER, null, cv);
    }
}
