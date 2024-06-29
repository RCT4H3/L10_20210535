package org.example.l10_20210535.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.l10_20210535.beans.estadioB;
import org.example.l10_20210535.beans.jugadorB;
import org.example.l10_20210535.beans.seleccionB;
import org.example.l10_20210535.daos.EstadioDao;
import org.example.l10_20210535.daos.JugadorDao;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EstadioServlet", value = "/EstadioServlet")
public class EstadioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        RequestDispatcher view;

        EstadioDao estadioDao = new EstadioDao();
        switch (action) {
            case "crear":
                view = request.getRequestDispatcher("WEB-INF/crearEstadio.jsp");
                view.forward(request, response);
                break;
            case "listar":
                ArrayList<estadioB> listarEstadios = estadioDao.listarEstadios();
                request.setAttribute("lista", listarEstadios);
                view = request.getRequestDispatcher("WEB-INF/listarEstadios.jsp");
                view.forward(request, response);
                break;
            case "borrar":
                int idEstadio = Integer.parseInt(request.getParameter("idEstadio"));
                estadioDao.borrarEstadio(idEstadio);
                response.sendRedirect(request.getContextPath() + "/EstadioServlet?action=listar");
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
        EstadioDao estadioDao = new EstadioDao();
        switch (action){
            case "crear":
                estadioB estadio = new estadioB();
                estadio.setNombre(request.getParameter("nombre"));
                estadio.setProvincia(request.getParameter("provincia"));
                estadio.setClub(request.getParameter("club"));
                estadioDao.crearEstadio(estadio);
                response.sendRedirect(request.getContextPath() + "/EstadioServlet?action=listar");
                break;
        }
    }
}
