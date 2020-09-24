<%@ page import="model.Servicii" %><%--
  Created by IntelliJ IDEA.
  User: alc
  Date: 5/31/20
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Afiseaza Servicii</title>
    <link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
<h2>Serviciile sunt:</h2>
<ol>
    <%
        Servicii [] servicii = (Servicii[]) request.getAttribute("servicii");
        for (Servicii serviciu:servicii){%>
    <li><%=serviciu.toString()%></li>
    <%}%>
</ol>
<a href="loginServlet?param=listing">Intoarce-te la optiuni</a>
</body>
</html>
