<%@ page import="model.Angajat" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alc
  Date: 6/2/20
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sterge Angajat</title>
    <link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
<h2>Introdu indexul angajatului pe care doresti sa il elimini din firma:</h2>
<ol>
<%
    List<Angajat> angajati = (List) request.getAttribute("angajati");
    int i = 0;
    for (Angajat angajat:angajati){
        i++;%>
        <li><%=angajat%></li>
<%}%>
</ol>
<form id="centerDel" action="stergeAngajatServlet" method="post">
    <label>Index:</label>
    <input type="text" name="index">
    <button type="submit">Sterge</button>
</form>
</body>
</html>
