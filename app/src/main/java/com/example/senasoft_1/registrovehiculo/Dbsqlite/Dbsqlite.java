package com.example.senasoft_1.registrovehiculo.Dbsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.senasoft_1.registrovehiculo.Pojos.Pojos;

/**
 * Created by SENASOFT-1 on 10/09/2018.
 */

public class Dbsqlite extends SQLiteOpenHelper{

    public static final String NAMEDB="parqueadero";
    public static final int VERSION=1;
    public static final String NAMETABLE="vehiculo";
    public static final String NAMETABLETWO="vehiculoTwo";
    public final String NUMMXAUTOS="numMXautos";
    public final String NUMMXMOTOS="numMXMotos";
    public final String ITEMS="items";
    public final String TIPOVEHICULO="tipoVehiculo";

    public final String CREATETABLE="CREATE TABLE vehiculo(id INTEGER PRIMARY KEY AUTOINCREMENT,numMXautos TEXT,numMXMotos TEXT)";
    public final String CREATETABLETWO="CREATE TABLE vehiculoTwo(id INTEGER PRIMARY KEY AUTOINCREMENT,items TEXT,tipoVehiculo TEXT)";

    SQLiteDatabase sqLiteDatabase;


    public Dbsqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NAMEDB, factory, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATETABLE);
        db.execSQL(CREATETABLETWO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void abrir(boolean write){
        if (write){
            sqLiteDatabase=this.getWritableDatabase();
        }else {
            sqLiteDatabase=this.getReadableDatabase();
        }
    }

    public void cerrar(){sqLiteDatabase.close();}

    public long insertCanti(Pojos pojos){
        abrir(true);
        ContentValues  values=new ContentValues();
        values.put(NUMMXAUTOS,pojos.getNumMXAutos());
        values.put(NUMMXMOTOS,pojos.getNumMXMotos());

        long ret=sqLiteDatabase.insert(NAMETABLE,null,values);
        cerrar();
        return ret;
    }

    public long insertRegiVehi(Pojos pojos){
        abrir(true);
        ContentValues  values=new ContentValues();
        values.put(ITEMS,pojos.getItems());
        values.put(TIPOVEHICULO,pojos.getTipoVehiculo());

        long ret=sqLiteDatabase.insert(NAMETABLE,null,values);
        cerrar();
        return ret;
    }

}
