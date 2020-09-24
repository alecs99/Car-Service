<%@ page import="model.Angajat" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alc
  Date: 6/2/20
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualizeaza salariu</title>
    <link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
<h2>Alege angajatul caruia doresti sa ii actualizezi salariul</h2>
<ol>
    <%
        List<Angajat> angajati = (List) request.getAttribute("angajati");
        int i = 0;
        for (Angajat angajat:angajati){
             i++;%>
            <li><%=angajat%></li>
    <%}%>
</ol>
<form id="centerDel"  action="actualizeazaSalariuServlet" method="post">
    <input type="text" name="index" placeholder="Index">
    <input type="text" name="salariu" placeholder="Salariu">
    <button type="submit">Confirma</button>
</form>
</body>
</html>
