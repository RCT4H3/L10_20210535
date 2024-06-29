<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 50px;
        }
        h1 {
            font-size: 3em;
            font-weight: bold;
            color: #4CAF50;
        }
        .btn-custom {
            margin-top: 20px;
            width: 100%;
            padding: 10px;
        }
    </style>
</head>
<body>
<div class="container text-center">
    <h1><%= "¡No quiero trabajar!" %></h1>
    <br/>
    <div class="row">
        <div class="col-md-6">
            <a href="<%=request.getContextPath()%>/JugadoresServlet?action=listar" class="btn btn-primary btn-custom">Ver la lista de jugadores</a>
        </div>
        <div class="col-md-6">
            <a href="<%=request.getContextPath()%>/EstadioServlet?action=listar" class="btn btn-secondary btn-custom">Ver la lista de estadios</a>
        </div>
    </div>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
