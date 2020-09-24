<%@ page import="model.Rezervari" %><%--
  Created by IntelliJ IDEA.
  User: alc
  Date: 6/2/20
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sterge Rezervare</title>
    <link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
<h2>Introdu indexul serviciului dorit:</h2>
<ol>
<%
    Rezervari[] rezervari = (Rezervari[]) request.getAttribute("rezervari");
    int i = 0;
    for (Rezervari rezervare:rezervari){
        i++;%>
<li><%=rezervare%></li>
<%}%>
</ol>
<form id="centerDel" action="stergeRezervareServlet" method="post">
    <label>Index:</label>
    <input type="text" name="index">
    <button type="submit">Sterge</button>
</form>
</body>
</html>
