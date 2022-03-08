<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>枫</title>
</head>
<body>
<h1>你已经成功登录进界面</h1>
<form action="/feng/logout" method="post">
    <input type="submit" value="注销" onclick="window.location.href='../login.jsp'">
<%--    这里要起到跳转界面的作用--%>
</form>
</body>
</html>
