<%@ page import="model.Angajat" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Mecanic" %><%--
  Created by IntelliJ IDEA.
  User: alc
  Date: 5/31/20
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Afiseaza Angajati</title>
    <link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
<h2>Angajatii sunt:</h2>
<ol>
    <%
    List<Angajat> angajati = (List) request.getAttribute("angajati");
    for (Angajat angajat:angajati){%>
        <li><%=angajat%></li>
    <%}%>
</ol>
<a href="loginServlet?param=listing">Intoarce-te la optiuni</a>
</body>
</html>
