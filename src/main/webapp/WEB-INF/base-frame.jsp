<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <title><sitemesh:write property="title"/></title>

    <script type="application/javascript" src="${path}/resource/jquery.min.js"></script>
    <script type="application/javascript" src="${path}/resource/bootstrap/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="${path}/resource/vue.min.js"></script>
    <script type="application/javascript" src="${path}/resource/bootstrap-treeview/bootstrap-treeview.min.js"></script>

    <script type="application/javascript" src="${path}/resource/base-frame.js"></script>

    <link rel="stylesheet" href="${path}/resource/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/resource/bootstrap/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${path}/resource/bootstrap-treeview/bootstrap-treeview.min.css">

    <sitemesh:write property="head"/>

</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-2" id="menu">

            </div>
            <div class="col-lg-8">
                <sitemesh:write property='body'/>
            </div>
        </div>
    </div>

    <script type="application/javascript">
        $(function(){
            loadMenu();
        });
    </script>
</body>
</html>
