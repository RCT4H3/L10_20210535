package org.example.l10_20210535.daos;

import org.example.l10_20210535.beans.estadioB;
import org.example.l10_20210535.beans.jugadorB;
import org.example.l10_20210535.beans.seleccionB;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JugadorDao extends DaoBase{
    public ArrayList<jugadorB> listarJugadores(){
        ArrayList<jugadorB> lista = new ArrayList<>();
        String sql = "SELECT\n" +
                "    jugador.idJugador,\n" +
                "    jugador.nombre AS nombre_jugador,\n" +
                "    jugador.edad,\n" +
                "    jugador.posicion,\n" +
                "    jugador.club,\n" +
                "    seleccion.idSeleccion,\n" +
                "    seleccion.nombre AS nombre_seleccion,\n" +
                "    seleccion.tecnico,\n" +
                "    estadio.idEstadio,\n" +
                "    estadio.nombre AS nombre_estadio,\n" +
                "    estadio.provincia,\n" +
                "    estadio.club AS club_estadio\n" +
                "FROM\n" +
                "    jugador\n" +
                "JOIN\n" +
                "    seleccion ON jugador.sn_idSeleccion = seleccion.idSeleccion\n" +
                "JOIN\n" +
                "    estadio ON seleccion.estadio_idEstadio = estadio.idEstadio;\n";
        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                jugadorB jugador = new jugadorB();
                jugador.setIdJugador(rs.getInt(1));
                jugador.setNombre(rs.getString(2));
                jugador.setEdad(rs.getInt(3));
                jugador.setPosicion(rs.getString(4));
                jugador.setClub(rs.getString(5));
                seleccionB seleccion = new seleccionB();
                seleccion.setIdSeleccion(rs.getInt(6));
                seleccion.setNombre(rs.getString(7));
                seleccion.setTecnico(rs.getString(8));
                estadioB estadio = new estadioB();
                estadio.setIdEstadio(rs.getInt(9));
                estadio.setNombre(rs.getString(10));
                estadio.setProvincia(rs.getString(11));
                estadio.setClub(rs.getString(12));
                seleccion.setEstadios(estadio);
                jugador.setSeleccion(seleccion);

                lista.add(jugador);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;


    }
    public  ArrayList<seleccionB> listarSelecciones(){
        ArrayList<seleccionB> lista = new ArrayList<>();
        String sql = "SELECT * FROM seleccion;\n";
        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                seleccionB seleccionB = new seleccionB();
                seleccionB.setIdSeleccion(rs.getInt(1));
                seleccionB.setNombre(rs.getString(2));
                seleccionB.setTecnico(rs.getString(3));
                estadioB estadioB = new estadioB();
                estadioB.setIdEstadio(rs.getInt(4));
                seleccionB.setEstadios(estadioB);
                lista.add(seleccionB);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }
    public void crearJugador(jugadorB jugador){
        String sql = "INSERT INTO jugador (nombre, edad, posicion, club, sn_idSeleccion) VALUES (?, ?, ?, ?, ?);";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, jugador.getNombre());
            pstmt.setInt(2, jugador.getEdad());
            pstmt.setString(3, jugador.getPosicion());
            pstmt.setString(4, jugador.getClub());
            pstmt.setInt(5, jugador.getSeleccion().getIdSeleccion());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void borrarJugador(int idJugador){
        String sql = "DELETE FROM jugador WHERE idJugador = ?;";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, idJugador);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
