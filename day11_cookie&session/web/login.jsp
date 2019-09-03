<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "checkCode?"+new Date().getTime();
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
<form action="login" method="post">
    <table>
        <tr>
            <td><input type="text" name="username" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td><input type="password" name="password" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td><input type="text" name="checkCode" placeholder="请输入验证码"></td>
        </tr>
        <tr>
            <td><img src="checkCode" id="img"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登陆"></td>
        </tr>
        <div>
            <%=request.getAttribute("cc_error")==null?"":request.getAttribute("cc_error")%>
        </div>
        <div>
            <%=request.getAttribute("login_error")==null?"":request.getAttribute("login_error")%>
        </div>
    </table>
</form>

</body>
</html>
