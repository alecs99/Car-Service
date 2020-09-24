<%--
  Created by IntelliJ IDEA.
  User: alc
  Date: 6/2/20
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adauga Angajat</title>
    <link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
<h2>Introduceti informatiile despre noul angajat:</h2>
<div>
    <form action="adaugaAngajat.jsp" method="post">
        <label for="tipMecanic">Mecanic <input class="radios" type="radio" id="tipMecanic" name="tip" value="mecanic"></label>
        <label for="Casierul">Casier <input class="radios" type="radio" id="Casierul" name="tip" value="casier"></label><br>
        <button type="submit">Adauga</button>
    </form>
</div>
<%
    if(request.getParameter("tip") != null && !request.getParameter("tip").equals("")){
        if(request.getParameter("tip").equals("mecanic")){%>
        <form action="adaugaAngajatServlet" method="post">
            <input type="text" name="numeAngajat" placeholder="Nume">
            <input type="text" name="prenumeAngajat" placeholder="Prenume">
            <input type="text" name="salariu" placeholder="Salariu">
            <label for="Mecanic">Mecanic <input type="radio" id="Mecanic" name="atributie" value="mecanic"></label>
            <label for="Vopsitor">Vopsitor <input type="radio" id="Vopsitor" name="atributie" value="vopsitor"></label>
            <label for="Vulcanizator">Vulcanizator <input type="radio" id="Vulcanizator" name="atributie" value="vulcanizator"></label>
            <label for="Tinichigiu">Tinichigiu <input type="radio" id="Tinichigiu" name="atributie" value="tinichigiu"></label>
            <label for="Ajutor">Ajutor <input type="radio" id="Ajutor" name="atributie" value="ajutor"></label>
            <input type="text" name="bonus" placeholder="Bonus">
            <button type="submit">Adauga</button>
        </form>
        <%}else{%>
                    <form action="adaugaAngajatServlet" method="post">
                        <input type="text" name="numeAngajat" placeholder="Nume">
                        <input type="text" name="prenumeAngajat" placeholder="Prenume">
                        <input class="radios" type="radio" id="Casier" name="atributie" value="Casier" checked="checked">
                        <input type="text" name="salariu" placeholder="Salariu"><br>
                        <button type="submit">Confirma</button>
                    </form>
                <%}
            }%>

</body>
</html>
