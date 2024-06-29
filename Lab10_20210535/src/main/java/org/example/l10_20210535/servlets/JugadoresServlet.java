package org.example.l10_20210535.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.l10_20210535.beans.jugadorB;
import org.example.l10_20210535.beans.seleccionB;
import org.example.l10_20210535.daos.JugadorDao;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "JugadoresServlet", value = "/JugadoresServlet")
public class JugadoresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        RequestDispatcher view;
        JugadorDao jugadorDao = new JugadorDao();
        switch (action) {
            case "crear":
                ArrayList<seleccionB> lista = jugadorDao.listarSelecciones();
                request.setAttribute("lista", lista);
                view = request.getRequestDispatcher("WEB-INF/crearJugador.jsp");
                view.forward(request, response);
                break;
            case "listar":
                ArrayList<jugadorB> listaJugadores = jugadorDao.listarJugadores();
                request.setAttribute("lista", listaJugadores);
                view = request.getRequestDispatcher("WEB-INF/listarJugadores.jsp");
                view.forward(request, response);
                break;
            case "borrar":
                int idJugador = Integer.parseInt(request.getParameter("idJugador"));
                jugadorDao.borrarJugador(idJugador);
                response.sendRedirect(request.getContextPath() + "/JugadoresServlet?action=listar");
                break;
            case "editar":
                view = request.getRequestDispatcher("editar.jsp");
                view.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "guardar" : request.getParameter("action");
        JugadorDao jugadorDao = new JugadorDao();
        switch (action){
            case "crear":
                jugadorB jugador = new jugadorB();
                jugador.setNombre(request.getParameter("nombre"));
                jugador.setEdad(Integer.parseInt(request.getParameter("edad")));
                jugador.setPosicion(request.getParameter("posicion"));
                jugador.setClub(request.getParameter("club"));
                seleccionB seleccion = new seleccionB();
                seleccion.setIdSeleccion(Integer.parseInt(request.getParameter("seleccion")));
                jugador.setSeleccion(seleccion);
                jugadorDao.crearJugador(jugador);
                // Redirigir a la lista de jugadores después de crear el jugador
                response.sendRedirect(request.getContextPath() + "/JugadoresServlet?action=listar");
                break;
        }
    }
}
