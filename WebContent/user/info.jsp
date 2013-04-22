<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="io.loli.kaoqin.service.PersonService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人资料</title>
</head>
<body>
<form action="updateForm" method="post">
<table class="update">
	<tr><td><label>用户名:</label></td><td><label>${person.username}</label></td><td>(不可修改)</td></tr>
	<tr><td><label>密码:</label></td><td><input type="password" name="password" value="${person.password}"></td></tr>
	<tr><td><label>邮箱:</label></td><td><input type="text" name="email" value="${person.email}"></td></tr>
	<tr><td><label>电话:</label></td><td><input type="text" name="tel" value="${person.tel}"></td></tr>
	<tr><td><label>地址:</label></td><td><input type="text" name="address" value="${person.address}"></td><td><input type="hidden" name="action" value="update"></td></tr>
	<tr><td><input type="submit" value="提交"></td></tr>
</table>
</form>
${info}
</body>
</html>