<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${path}/resource/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${path}/resource/bootstrap/css/bootstrap-theme.min.css"/>
    <script type="application/javascript" src="${path}/resource/jquery-3.2.0.min.js"></script>
    <script type="application/javascript" src="${path}/resource/bootstrap/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="${path}/resource/vue.min.js"></script>
    <script type="application/javascript">
        $(function(){
            var addForm = new Vue({
                el:'#add-form',
                data:{
                    name:'资源名称：',
                    url:'资源url：'
                }
            });
        });
    </script>
    <title>添加资源</title>
</head>
<body>
    <form:form action="${path}/resource/add.do" method="post" modelAttribute="form">
        <div class="container" id="add-form">
            <div class="row">
                <div class="col-lg-2">{{name}}</div>
                <div class="col-lg-2">
                    <input name="name">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-2">{{url}}</div>
                <div class="col-lg-2">
                    <input name="url">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4">
                    <input type="submit">
                </div>
            </div>
        </div>
    </form:form>
</body>
</html>
