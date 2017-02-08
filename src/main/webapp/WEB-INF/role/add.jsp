<%--
  Created by IntelliJ IDEA.
  User: Jayson
  Date: 2017/2/8 0008
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>添加角色</title>
</head>
<body>
    <sp:url var="addRole" value="/role/add.do"/>
    <form:form action="${addRole}" modelAttribute="form">
        <form:input path="name"/>
        <input type="submit">
    </form:form>
</body>
</html>
