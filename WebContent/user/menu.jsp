<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="io.loli.kaoqin.prop.info" />
<div class="menus">
<ul>
	<li class="menu-item"><a href="monthList.jsp"><fmt:message key="menu.monthList"></fmt:message></a></li>
	<li class="menu-item"><a href="addDaystatus.jsp"><fmt:message key="menu.addDayStatus"></fmt:message></a></li>
	<li class="menu-item"><a href="info.jsp"><fmt:message key="menu.changeInfo"></fmt:message></a></li>
	<li class="menu-item"><a href="loginForm?action=logout"><fmt:message key="menu.logout"></fmt:message></a></li>
	<li class="menu-item"><a href="askForLeave.jsp"><fmt:message key="menu.leave"></fmt:message></a></li>
</ul>
</div>