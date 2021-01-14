package com.example.entrega2;

public class Instancia {
    private String posicion;
    private int puntuacion;
    private int dificultad;
    Instancia(String pos, int puntu, int dif){
        posicion = pos;
        puntuacion = puntu;
        dificultad = dif;
    }

    public String getPosicion(){
        return posicion;
    }
    public int getPuntuacion(){
        return puntuacion;
    }

    public int getDificultad(){
        return dificultad;
    }

}
