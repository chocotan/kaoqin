<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="io.loli.kaoqin.service.MonthStatusService,io.loli.kaoqin.javabean.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="io.loli.kaoqin.prop.info" />
<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div class="monthList">
<%
	List<MonthStatus> msl = new MonthStatusService().findByPersonId(((Person)session.getAttribute("person")).getId());
	request.setAttribute("msl", msl);
%>
<table>
<tr><th><fmt:message key="monthList.title.month"></fmt:message></th><th><fmt:message key="monthList.title.status"></fmt:message></th></tr>
<c:forEach var="ms" items="${msl}">
<tr>
<td><a href="dayList.jsp?m_id=${ms.id}&p_id=${ms.p.id}">${ms.year}<fmt:message key="year"></fmt:message>${ms.month+1}<fmt:message key="month"></fmt:message></a><br/></td>
<td><c:if test="${ms.approved}"><fmt:message key="approved"></fmt:message></c:if>
<c:if test="${ms.submitted}"><fmt:message key="submitted"></fmt:message></c:if></td>
</tr>
</c:forEach>
</table>
</div>