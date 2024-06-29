package org.example.l10_20210535.beans;

public class seleccionB {
    private int idSeleccion;
    private String nombre;
    private String tecnico;
    private estadioB estadios;

    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public estadioB getEstadios() {
        return estadios;
    }

    public void setEstadios(estadioB estadios) {
        this.estadios = estadios;
    }
}
