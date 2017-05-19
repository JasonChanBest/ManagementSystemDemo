<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
        </tr>
        <c:forEach var="menu" items="${menus}">
            <tr>
                <td>${menu.name}</td>
                <td>${menu.url}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
