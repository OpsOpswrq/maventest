<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>枫</title>
</head>
<body>
<h1>这个是footer</h1>
<form action="footer.jsp" method="post">
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="登录">
</form>
<%--if的测试，var返回的true or false--%>
<%--EL表达式--%>
<c:if test="${param.username=='feng'}" var="isAdmin">
    <c:out value="欢迎回来管理员"/>
</c:if>
<c:out value="${isAdmin}"/>S
<br/>
<c:set var="score" value="80"/>
<c:choose>
    <c:when test="${score>=90}">
        <c:out value="你的成绩为优秀"/>
    </c:when>
    <c:when test="${score>=80}">
        你的成绩为良好
    </c:when>
</c:choose>
<br/>
<%
    ArrayList<String> people = new ArrayList<>();
    people.add("张三");
    people.add("李四");
    people.add("天舞");
    request.setAttribute("list",people);
%>
<C:forEach var="people" items="${list}" begin="0" end="2" step="1">
<c:out value="${people}"/>
</C:forEach>
</body>
</html>