<%--
  Created by IntelliJ IDEA.
  User: alc
  Date: 6/1/20
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adauga rezervare</title>
    <link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
<h2>Introduceti informatiile despre rezervare:</h2>
<form action="adaugaRezervareServlet" method="post">
    <input type="text" name="nume" placeholder="Nume">
    <input type="text" name="prenume" placeholder="Prenume">
    <input type="text" name="masina" placeholder="Marca masina">
    <label for="Mecanicaa">Mecanica <input class="radios" type="radio" id="Mecanicaa" name="serviciu" value="mecanica"></label>
    <label for="Vopsitoria">Vopsitorie <input type="radio" id="Vopsitoria" name="serviciu" value="vopsitorie"></label>
    <label for="Vulcanizarea">Vulcanizare <input class="radios" type="radio" id="Vulcanizarea" name="serviciu" value="vulcanizare"></label><br>
    <label>Data rezervarii:</label>
    <input type="text" name="data" placeholder="zz/ll/aa oo:mm"><br>
    <button type="submit">Adauga</button>
</form>
</body>
</html>
