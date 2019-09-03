<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<%=request.getSession().getAttribute("username")%>欢迎回来
</body>
</html>
