<%--
  Created by IntelliJ IDEA.
  User: Jayson
  Date: 2017/2/8 0008
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>修改角色</title>
</head>
<body>
    <sp:url value="/role/modify.do" var="modifyUrl"/>
    <form:form action="${modifyUrl}" modelAttribute="form">
        <form:input path="id"/>
        <form:input path="name"/>
        <input type="submit">
    </form:form>
</body>
</html>
