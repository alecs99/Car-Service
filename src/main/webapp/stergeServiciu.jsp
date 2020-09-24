<%@ page import="model.Rezervari" %>
<%@ page import="model.Servicii" %><%--
  Created by IntelliJ IDEA.
  User: alc
  Date: 6/2/20
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sterge Serviciu</title>
    <link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
<h2>Introdu indexul serviciului dorit:</h2>
<ol>
<%
    Servicii [] servicii = (Servicii[]) request.getAttribute("servicii");
    int i = 0;
    for (Servicii serviciu:servicii){
        i++;%>
        <li><%=serviciu%></li>
<%}%>
</ol>
<form id="centerDel" action="stergeServiciuServlet" method="post">
    <label>Index:</label>
    <input type="text" name="index">
    <button type="submit">Sterge</button>
</form>
</body>
</html>
