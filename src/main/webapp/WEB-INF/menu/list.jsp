<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单列表</title>
</head>
<body>
    <table class="table">
        <tr>
            <th>菜单名称</th>
            <th>url</th>
            <th>操作</th>
        </tr>
        <c:forEach var="menu" items="${menus}">
            <tr>
                <td>${menu.name}</td>
                <td>${menu.url}</td>
                <td>
                    <sp:url value="${path}/menu/delete.do?id=${menu.id}" var="deleteUrl"/>
                    <a href="${deleteUrl}">删除</a>
                    <sp:url value="${path}/menu/modifyInit.do?id=${menu.id}" var="modifyUrl"/>
                    <a href="${modifyUrl}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
