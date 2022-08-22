<%--
  Created by IntelliJ IDEA.
  User: hoangnam
  Date: 22/08/2022
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Find Product</title>
</head>
<body>
<h1>Product Found</h1>
<form method="post" >
  <input type="text" name="findname" id="findname">
  <input type="submit" name="findname1" value="Enter">
  <c:if test='${requestScope["message"] == "Not Found"}'>
  <p><b>${requestScope["message"]}</b></p>
  </c:if>
  <span><h3>Is this your Product ?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>${requestScope["namePro"].name}</td>
            </tr>
            <tr>
                <td>Brand:</td>
                <td>${requestScope["namePro"].brand}</td>
            </tr>
            <tr>
                <td>Cost:</td>
                <td>${requestScope["namePro"].cost}</td>
            </tr>
        </table>
    </fieldset></span>

  <p><a href="/products">Back to Product list</a></p>
</body>
</html>