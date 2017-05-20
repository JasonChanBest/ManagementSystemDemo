<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>添加菜单</title>
</head>
<body>
    <sf:form action="${path}/menu/add.do" commandName="form" method="post">
        <table class="table">
            <tr>
                <td>菜单名称：</td>
                <td>
                    <sf:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>菜单URL：</td>
                <td>
                    <sf:input path="url"/>
                </td>
            </tr>
            <tr>
                <td>父级菜单：</td>
                <td>
                    <select name="parentId">
                        <option value="0">无</option>
                        <c:forEach items="${menus}" var="menu">
                            <option value="${menu.id}">${menu.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" class="button" value="确定">
                </td>
            </tr>
        </table>
    </sf:form>
</body>
</html>
