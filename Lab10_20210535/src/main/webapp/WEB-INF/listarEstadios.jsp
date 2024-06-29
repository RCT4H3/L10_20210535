<%@page import="java.util.ArrayList" %>
<%@ page import="org.example.l10_20210535.beans.estadioB" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean type="java.util.ArrayList<org.example.l10_20210535.beans.estadioB>" scope="request" id="lista"/>
<!DOCTYPE html>
<html>
<head>
  <title>Lista de Estadios</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <h2 class="mb-4">Lista de Estadios</h2>
  <div class="mb-4">
    <a href="<%=request.getContextPath()%>/EstadioServlet?action=crear" class="btn btn-primary">Nuevo Estadio</a>
  </div>
  <table class="table table-striped">
    <thead class="thead-dark">
    <tr>
      <th>#</th>
      <th>Nombre</th>
      <th>Provincia</th>
      <th>Club</th>
      <th>Borrar estadio</th>

    </tr>
    </thead>
    <tbody>
    <%
      int i = 1;
      for (estadioB estadio : lista) {
    %>
    <tr>
      <td><%=i%></td>
      <td><%=estadio.getNombre()%></td>
      <td><%=estadio.getProvincia()%></td>
      <td><%=estadio.getClub()%></td>
      <td>
        <a href="<%=request.getContextPath()%>/EstadioServlet?action=borrar&idEstadio=<%=estadio.getIdEstadio()%>" class="btn btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este estadio?');">Borrar</a>
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
