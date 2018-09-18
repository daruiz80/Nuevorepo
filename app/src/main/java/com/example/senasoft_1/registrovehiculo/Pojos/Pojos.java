package com.example.senasoft_1.registrovehiculo.Pojos;

/**
 * Created by SENASOFT-1 on 10/09/2018.
 */

public class Pojos {

    String numMXAutos;
    String numMXMotos;
    int items;
    int tipoVehiculo;

    public Pojos() {
    }

    public Pojos(String numMXAutos, String numMXMotos) {
        this.numMXAutos = numMXAutos;
        this.numMXMotos = numMXMotos;
    }

    public Pojos(int items, int tipoVehiculo) {
        this.items = items;
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getNumMXAutos() {
        return numMXAutos;
    }

    public void setNumMXAutos(String numMXAutos) {
        this.numMXAutos = numMXAutos;
    }

    public String getNumMXMotos() {
        return numMXMotos;
    }

    public void setNumMXMotos(String numMXMotos) {
        this.numMXMotos = numMXMotos;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(int tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
}
