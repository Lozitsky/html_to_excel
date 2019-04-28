<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Надія
  Date: 28.04.2019
  Time: 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Excel Export</title>
</head>
<body>
<h1>Example for Spring MVC Excel Export</h1>

<h2>Animal List</h2>

<h3><a href="./export">Export</a></h3>

<table border="1px" cellpadding="8px">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Type</td>
        <td>Aggressive</td>
        <td>Weight</td>
    </tr>

    <c:forEach items="${animalList}" var="animal">
        <tr>
            <td><c:out value="${animal.id}"/></td>
            <td><c:out value="${animal.animalName}"/></td>
            <td><c:out value="${animal.animalType}"/></td>
            <td><c:out value="${animal.aggressive}"/></td>
            <td><c:out value="${animal.weight}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
