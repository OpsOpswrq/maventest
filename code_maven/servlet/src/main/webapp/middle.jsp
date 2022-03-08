<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>枫</title>
</head>
<body>
<%--    这个是三合一的页面，维护起来比较难，变量会冲突--%>
<%@ include file="header.jsp"%>
<h1>这是网页的主题</h1>
<%@ include file="footer.jsp"%>
<hr/>
<%--    这个是三个分开的页面，不会融合，单独存在，变量不会冲突--%>
<jsp:include page="header.jsp"/>
<h1>这是网页的主题</h1>
<jsp:include page="footer.jsp"/>
</body>
</html>
