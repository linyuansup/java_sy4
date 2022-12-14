<%@ page import="dao.TxtDao" %>
<%@ page import="dao.User" %>
<%@ page import="dao.MongoDao" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>注册结果</title>
</head>
<body>
<%
    // 获取相应数据
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String sex = request.getParameter("sex");
    if (username.equals("")) {
%>
用户名不能为空
<%
} else if (password.equals("")) {
%>密码不能为空<%
} else {
    MongoDao mongoDao = new MongoDao("mongodb://localhost:27017");
    if (mongoDao.find(username) != null) {
%>
用户名重复
<%
} else {
    mongoDao.addUser(new User(username, password, sex));
%>
注册成功
<%
        }
    }
%>
</body>
</html>
