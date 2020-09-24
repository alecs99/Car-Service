<%@ page import="model.Rezervari" %><%--
  Created by IntelliJ IDEA.
  User: alc
  Date: 5/31/20
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Afiseaza Rezervari</title>
    <link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
<h2>Rezervarile sunt:</h2>
<ol>
    <%
        Rezervari[] rezervari = (Rezervari[])  request.getAttribute("rezervari");
        for (Rezervari rezervare:rezervari){%>
    <li><%=rezervare.toString()%></li>
    <%}%>
</ol>
<a href="loginServlet?param=listing">Intoarce-te la optiuni</a>
</body>
</html>
