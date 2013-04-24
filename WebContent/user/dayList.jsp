<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import=" java.text.SimpleDateFormat,java.util.*,io.loli.kaoqin.service.*,io.loli.kaoqin.javabean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<fmt:setBundle basename="io.loli.kaoqin.prop.info" />
<%
	int p_id=Integer.parseInt(request.getParameter("p_id"));
	int m_id=Integer.parseInt(request.getParameter("m_id"));
	MonthStatus m = new MonthStatusService().findById(m_id);
	List<DayStatus> dsl = new DayStatusService().findByPersonAndMonth(p_id, m_id);
	request.setAttribute("m", m);
	request.setAttribute("dsl", dsl);
%>
<div id="dayList">
	<h3>
		${m.year}
		<fmt:message key="year"></fmt:message>
		${m.month+1}
		<fmt:message key="month"></fmt:message>
	</h3>
	<fmt:message key="issubmitted"></fmt:message>
	<c:choose>
		<c:when test="${m.submitted}">
			<fmt:message key="yes"></fmt:message>
		</c:when>
		<c:otherwise>
			<fmt:message key="no"></fmt:message>
		</c:otherwise>
	</c:choose>
	<fmt:message key="isapproved"></fmt:message>
	<c:choose>
		<c:when test="${m.approved}">
			<fmt:message key="yes"></fmt:message>
		</c:when>
		<c:otherwise>
			<fmt:message key="no"></fmt:message>
		</c:otherwise>
	</c:choose>
	<table>
		<tr class="header">
			<th><fmt:message key="list.date"></fmt:message>
			</th>
			<th><fmt:message key="list.day"></fmt:message>
			</th>
			<th><fmt:message key="list.startTime"></fmt:message>
			</th>
			<th><fmt:message key="list.endTime"></fmt:message>
			</th>
			<th><fmt:message key="list.workTime"></fmt:message>
			</th>
			<th><fmt:message key="list.breakTime"></fmt:message>
			</th>
			<th><fmt:message key="list.extraTime"></fmt:message>
			</th>
			<th><fmt:message key="list.tip"></fmt:message>
			</th>
			<th></th>
		</tr>
		<c:forEach var="ds" items="${dsl}">
			<tr id="ds-${ds.id}">
				<td><fmt:formatDate value="${ds.calendar.date}" pattern="yyyy-MM-dd"></fmt:formatDate>
				</td>
				<td>${ds.day}</td>
				<td class="dst" id="dst-${ds.id}"><fmt:formatDate value="${ds.startTime}" pattern="HH:mm"></fmt:formatDate>
				</td>
				<td class="det" id="det-${ds.id}"><fmt:formatDate value="${ds.endTime}" pattern="HH:mm"></fmt:formatDate>
				</td>
				<td class="dwh" id="dwh-${ds.id}">${ds.workHours}</td>
				<td class="dbh" id="dbh-${ds.id}">${ds.breakHours}</td>
				<td class="deh" id="deh-${ds.id}">${ds.extraHours}</td>
				<td class="dtip" id="dtip-${ds.id}">${ds.tip}</td>
				<c:if test="${!m.submitted}">
						<td class="dbt" id="dbt-${ds.id}">
						<input type="button" onclick="change(${ds.id})" value="<fmt:message
								key="change"></fmt:message>">
						</td>
					</c:if>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${!m.submitted}">
		<form action="monthStatus" method="post">
			<input type="hidden" name="action" value="submit"> 
			<input type="hidden" name="m_id" value="${param.m_id}">
			<input type="submit"
				value="<fmt:message key="submitToAdmin"></fmt:message>">
		</form>
	</c:if>
</div>