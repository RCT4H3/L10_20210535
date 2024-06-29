package org.example.l10_20210535.daos;

import org.example.l10_20210535.beans.estadioB;
import org.example.l10_20210535.beans.jugadorB;
import org.example.l10_20210535.beans.seleccionB;

import java.sql.*;
import java.util.ArrayList;

public class EstadioDao extends DaoBase{
    public ArrayList<estadioB> listarEstadios(){
        ArrayList<estadioB> lista = new ArrayList<>();
        String sql = "SELECT * FROM estadio;\n";
        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                estadioB estadio = new estadioB();
                estadio.setIdEstadio(rs.getInt("idEstadio"));
                estadio.setNombre(rs.getString("nombre"));
                estadio.setProvincia("provincia");
                estadio.setClub("club");
                lista.add(estadio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;


    }

    public void crearEstadio(estadioB estadio){
        String sql = "INSERT INTO estadio (nombre, provincia, club) VALUES (?, ?, ?);";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1,estadio.getNombre());
            pstmt.setString(2,estadio.getProvincia());
            pstmt.setString(3,estadio.getClub());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void borrarEstadio(int idEstadio){
        String sql = "DELETE FROM estadio WHERE idEstadio = ?;\n";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, idEstadio);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
