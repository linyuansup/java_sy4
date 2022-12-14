<%@ page import="dao.TxtDao" %>
<%@ page import="dao.User" %>
<%@ page import="dao.MongoDao" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录结果</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username.equals("")) {
%>
用户名不能为空
<%
} else if (password.equals("")) {
%>
密码不能为空
<%
} else {
    MongoDao mongoDao = new MongoDao("mongodb://localhost:27017");
    User user = null;
    if ((user = mongoDao.find(username)) != null) {
        if (user.comparePassword(password)) {
%>
用户名：<%=username%><br>
性别：<%=user.getSex()%>
<%
} else {
%>密码错误<%
    }
} else {
%>找不到用户<%
        }
    }
%>
</body>
</html>
