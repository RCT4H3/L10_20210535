<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Voy a jalar trafiiiiiiiii" %>
</h1>
<br/>
<a href="<%=request.getContextPath()%>/JugadoresServlet?action=listar">Ver la lista de jugadores</a>
</body>
</html>