<%--
  Created by IntelliJ IDEA.
  User: hoangnam
  Date: 22/08/2022
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Deleting Product</title>
</head>
<body>
<h1>Delete Product</h1>
<h3><b>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</b></h3>
<form method="post">
  <h3>Are you sure?</h3>
  <fieldset>
    <legend>Customer information</legend>
    <table>
      <tr>
        <td>Name:</td>
        <td>${requestScope["thisP"].name}</td>
      </tr>
      <tr>
        <td>Brand:</td>
        <td>${requestScope["thisP"].brand}</td>
      </tr>
      <tr>
        <td>Cost:</td>
        <td>${requestScope["thisP"].cost}</td>
      </tr>
      <tr>
        <td><input type="submit" value="Delete Product"></td>
        <%--        <td><a href="/products">Back to customer list</a></td>--%>
      </tr>
    </table>
  </fieldset>
</form>
<p>
  <a href="/products">Back to customer list</a>
</p>
</body>
</html>