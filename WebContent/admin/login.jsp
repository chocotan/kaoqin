
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>
	管理员登陆
</h2>

<form action="admin">
<input type="hidden" name="action" value="login">
<table>
<tr><td>name:</td><td><input type="text" name="name"></td></tr>
<tr><td>password:</td><td><input type="password" name="password"></td></tr>
<tr><td><input type="submit" value="提交"></td></tr>
</table>
</form>
