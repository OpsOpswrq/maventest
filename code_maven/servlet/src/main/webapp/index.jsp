<%@ page import="com.feng.util.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>枫</title>
</head>
<body>
<h1>当前网站有<%= this.getServletConfig().getServletContext().getAttribute(Constant.ONLINECOUNT)%>在线</h1>
</body>
</html>
