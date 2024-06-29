<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Crear nuevo Estadio</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="col-md-6 mx-auto">
        <h1 class='mb-3'>Nuevo Estadio</h1>
        <form method="post" action="<%=request.getContextPath()%>/EstadioServlet?action=crear">
            <div class="mb-3">
                <label class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre">
            </div>
            <div class="mb-3">
                <label class="form-label">Provincia</label>
                <input type="text" class="form-control" name="provincia">
            </div>
            <div class="mb-3">
                <label class="form-label">Club</label>
                <input type="text" class="form-control" name="club">
            </div>
            <a href="<%= request.getContextPath()%>/EstadioServlet?action=listar" class="btn btn-danger">Cancelar</a>
            <button type="submit" class="btn btn-primary">Guardar</button>
        </form>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
