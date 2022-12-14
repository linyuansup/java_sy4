<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>注册</title>
</head>

<body>
<form action="doRegister.jsp" method="post">
    用户名：<input type="text" name="username"> <br>
    密码： <input type="password" name="password"><br>
    性别： <select name="sex">
    <option value="man">男</option>
    <option value="woman">女</option>
</select><br>
    <input type="submit" value="注册">
</form>
</body>

</html>