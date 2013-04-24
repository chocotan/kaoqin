<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="io.loli.kaoqin.service.PersonService" %>
<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="io.loli.kaoqin.prop.login"/>
<div class="updateInfo">
<form action="updateForm" method="post">
<table class="update">
	<tr><td><label><fmt:message key="user.regist.form.username"></fmt:message></label></td><td><label>${person.username}</label></td><td><fmt:message key="cannotbechanged"></fmt:message></td></tr>
	<tr><td><label><fmt:message key="user.regist.form.password"></fmt:message></label></td><td><input type="password" name="password" value="${person.password}"></td></tr>
	<tr><td><label><fmt:message key="user.regist.form.email"></fmt:message></label></td><td><input type="text" name="email" value="${person.email}"></td></tr>
	<tr><td><label><fmt:message key="user.regist.form.tel"></fmt:message></label></td><td><input type="text" name="tel" value="${person.tel}"></td></tr>
	<tr><td><label><fmt:message key="user.regist.form.address"></fmt:message></label></td><td><input type="text" name="address" value="${person.address}"></td><td><input type="hidden" name="action" value="update"></td></tr>
	<tr><td><input type="submit" value="<fmt:message key="submit"/>"></td></tr>
</table>
</form>
${info}

</div>