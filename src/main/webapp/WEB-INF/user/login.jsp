<%--
  Created by IntelliJ IDEA.
  User: Jayson
  Date: 2017/2/6 0006
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sps" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>欢迎登陆！</title>
</head>
<body>
    <sp:form action="/user/login.do" modelAttribute="loginForm">
        <sp:input path="name"/>
        <sp:input path="password"/>
        <input type="checkbox" name="remember-me"/>
        <input type="submit"/>
    </sp:form>
</body>
</html>
