<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>枫</title>
    <script src="./js/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function (){
            $("h1:first").click(function (){
                var txt = $("<h1></h1>").text("这个是新增的");
                $(this).css("color","blue");
                $(this).append(txt);
            });
        });
    </script>
</head>
<body>
<h1>这个是header</h1>
</body>
</html>