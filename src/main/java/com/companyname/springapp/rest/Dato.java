package com.companyname.springapp.rest;

import java.io.Serializable;

public class Dato implements Serializable {
    public String cadena;

    Dato(){
        this.cadena="";
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
}
