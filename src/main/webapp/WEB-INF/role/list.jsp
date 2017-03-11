<%--
  Created by IntelliJ IDEA.
  User: Jayson
  Date: 2017/2/8 0008
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>角色列表</title>
</head>
<body>
    <table>
        <c:forEach items="${roles}" var="role">
            <sp:url value="/role/delete.do" var="deleteUrl"/>
            <tr>
                <td>${role.id}</td>
                <td>${role.name}</td>
                <td><a href="${deleteUrl}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
