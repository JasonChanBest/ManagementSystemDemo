<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="${path}/resource/addInit.do">添加</a>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>url</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${resources}" var="r">
            <tr>
                <td>${r.id}</td>
                <td>${r.name}</td>
                <td>${r.url}</td>
                <td><a href="${path}/resource/delete.do?id=${r.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
