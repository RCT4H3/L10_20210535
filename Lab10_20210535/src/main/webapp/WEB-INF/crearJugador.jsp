<%@page import="java.util.ArrayList" %>
<%@ page import="org.example.l10_20210535.beans.seleccionB" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean type="java.util.ArrayList<org.example.l10_20210535.beans.seleccionB>" scope="request" id="lista"/>
<!DOCTYPE html>
<html>
<head>
    <title>Crear nuevo Jugador</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="col-md-6 mx-auto">
        <h1 class='mb-3'>Nuevo Jugador</h1>
        <form method="post" action="<%=request.getContextPath()%>/JugadoresServlet?action=crear">
            <div class="mb-3">
                <label class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre">
            </div>
            <div class="mb-3">
                <label class="form-label">Edad</label>
                <input type="number" class="form-control" name="edad">
            </div>
            <div class="mb-3">
                <label class="form-label">Posición</label>
                <input type="text" class="form-control" name="posicion">
            </div>
            <div class="mb-3">
                <label class="form-label">Club</label>
                <input type="text" class="form-control" name="club">
            </div>
            <div class="mb-3">
                <label for="seleccion">Selección nacional:</label>
                <select class="form-control" id="seleccion" name="seleccion">
                    <%for(seleccionB seleccionB : lista){%>
                    <option value="<%=seleccionB.getIdSeleccion()%>"><%=seleccionB.getNombre()%></option>
                    <%}%>
                </select>
            </div>
            <a href="<%= request.getContextPath()%>/JugadoresServlet?action=listar" class="btn btn-danger">Cancelar</a>
            <button type="submit" class="btn btn-primary">Guardar</button>
        </form>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
