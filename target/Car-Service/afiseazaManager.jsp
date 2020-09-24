<%--
  Created by IntelliJ IDEA.
  User: alc
  Date: 5/31/20
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager</title>
    <link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
<%
    String manager = (String) request.getAttribute("manager");
%>
<h2><%=manager%></h2>
<a href="loginServlet?param=listing">Intoarce-te la optiuni</a>
</body>
</html>
