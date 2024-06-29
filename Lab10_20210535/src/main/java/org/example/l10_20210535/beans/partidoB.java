package org.example.l10_20210535.beans;

public class partidoB {
    private int idPartido;
    private String fecha;
    private String numeroJornada;
    private seleccionB seleccion1;
    private seleccionB seleccion2;
    private arbitroB arbitro;

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumeroJornada() {
        return numeroJornada;
    }

    public void setNumeroJornada(String numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    public seleccionB getSeleccion1() {
        return seleccion1;
    }

    public void setSeleccion1(seleccionB seleccion1) {
        this.seleccion1 = seleccion1;
    }

    public seleccionB getSeleccion2() {
        return seleccion2;
    }

    public void setSeleccion2(seleccionB seleccion2) {
        this.seleccion2 = seleccion2;
    }

    public arbitroB getArbitro() {
        return arbitro;
    }

    public void setArbitro(arbitroB arbitro) {
        this.arbitro = arbitro;
    }
}
