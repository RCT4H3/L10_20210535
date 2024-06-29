<%@page import="java.util.ArrayList" %>
<%@ page import="org.example.l10_20210535.beans.jugadorB" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean type="java.util.ArrayList<org.example.l10_20210535.beans.jugadorB>" scope="request" id="lista"/>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Jugadores</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Lista de Jugadores</h2>
    <div class="mb-4">
        <a href="<%=request.getContextPath()%>/JugadoresServlet?action=crear" class="btn btn-primary">Nuevo Jugador</a>
    </div>
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Edad</th>
            <th>Posición</th>
            <th>Club</th>
            <th>Selección ID</th>
            <th>Nombre Selección</th>
            <th>Borrar Jugador</th>
        </tr>
        </thead>
        <tbody>
        <%
            int i = 1;
            for (jugadorB jugador : lista) {
        %>
        <tr>
            <td><%=i%></td>
            <td><%=jugador.getNombre()%></td>
            <td><%=jugador.getEdad()%></td>
            <td><%=jugador.getPosicion()%></td>
            <td><%=jugador.getClub()%></td>
            <td><%=jugador.getSeleccion().getIdSeleccion()%></td>
            <td><%=jugador.getSeleccion().getNombre()%></td>
            <td>
                <a href="<%=request.getContextPath()%>/JugadoresServlet?action=borrar&idJugador=<%=jugador.getIdJugador()%>" class="btn btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este jugador?');">Borrar</a>
            </td>
        </tr>
        <%
                i++;
            }
        %>
        </tbody>
    </table>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
