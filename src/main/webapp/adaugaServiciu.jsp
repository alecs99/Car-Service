<%--
  Created by IntelliJ IDEA.
  User: alc
  Date: 6/2/20
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adauga serviciu</title>
    <link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
<h2>Introduceti informatiile despre noul serviciu:</h2>
<form action="adaugaServiciu.jsp" method="post">
    <label for="tipMecanica">Mecanica <input type="radio" id="tipMecanica" name="tip" value="mecanica"></label>
    <label for="tipTinichigerie">Tinichigerie <input type="radio" id="tipTinichigerie" name="tip" value="tinichigerie"></label>
    <label for="tipTinichigerie">Vulcanizare <input type="radio" id="tipVulcanizare" name="tip" value="vulcanizare"></label>
    <button type="submit">Adauga</button>
</form>
<%
    if(request.getParameter("tip") != null && !request.getParameter("tip").equals("")){
        if(request.getParameter("tip").equals("mecanica")){%>
            <form action="adaugaServiciuServlet" method="post">
                <input class="radios" type="radio" id="Mecanica" name="operatiune" value="mecanica" checked="checked">
                <label>Nume serviciu: <input type="text" name="nume"></label>
                <label>Cost: <input type="text" name="cost"></label>
                <label>Durata: <input type="text" name="durata"></label>
                <label for="true">Da<input class="radios" type="radio" id="true" name="schimbat" value="true"></label>
                <label for="false">Nu<input class="radios" type="radio" id="false" name="schimbat" value="false"></label>
                <button type="submit">Adauga</button>
            </form>
            <%}else if(request.getParameter("tip").equals("tinichigerie")){%>
            <form action="adaugaServiciuServlet" method="post">
                <input class="radios" type="radio" id="Tinichigerie" name="operatiune" value="tinichigerie" checked="checked">
                <label>Nume serviciu: <input type="text" name="nume"></label>
                <label>Cost: <input type="text" name="cost"></label>
                <label>Durata: <input type="text" name="durata"></label>
                <label>Grad de dificultate: <input type="text" name="dificultate"></label>
                <button type="submit">Adauga</button>
            </form>
             <%}else{%>
                    <form action="adaugaServiciuServlet" method="post">
                        <input class="radios" type="radio" id="Vulcanizare" name="operatiune" value="vulcanizare" checked="checked">
                        <label>Nume serviciu: <input type="text" name="nume"> </label>
                        <label>Cost: <input type="text" name="cost"> </label>
                        <label>Durata: <input type="text" name="durata"></label>
                        <button type="submit">Adauga</button>
                    </form>
                <%}
         }%>

</body>
</html>
