package org.example.l10_20210535.beans;

public class jugadorB {
    private int idJugador;
    private String nombre;
    private int edad;
    private String posicion;
    private String club;
    private seleccionB seleccion;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public seleccionB getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(seleccionB seleccion) {
        this.seleccion = seleccion;
    }
}
