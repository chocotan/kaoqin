<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat,java.util.*,io.loli.kaoqin.service.*,io.loli.kaoqin.entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<fmt:setBundle basename="io.loli.kaoqin.prop.info" />
<%
	int p_id = Integer.parseInt(request.getParameter("p_id"));
	int m_id = Integer.parseInt(request.getParameter("m_id"));
	MonthStatus m = new MonthStatusService().findById(m_id);
	List<DayStatus> dsl = new DayStatusService().findByPersonAndMonth(
	p_id, m_id);
	request.setAttribute("m", m);
	request.setAttribute("dsl", dsl);
	List<io.loli.kaoqin.entity.Calendar> monthDateList = new CalendarService().listByYearAndMonth(m.getYear(), m.getMonth()+1);
	request.setAttribute("mdl", monthDateList);
	Map<io.loli.kaoqin.entity.Calendar, DayStatus> map = new TreeMap<io.loli.kaoqin.entity.Calendar, DayStatus>();
	Iterator<io.loli.kaoqin.entity.Calendar> ditr = monthDateList.iterator();
	for (int i = 0; ditr.hasNext(); i++) {
		io.loli.kaoqin.entity.Calendar date = ditr.next();
		try {
	if (date.getDate().getDate() != dsl.get(i).getCalendar().getDate()
			.getDate()) {
		i--;
		map.put(date, null);
	} else {
		map.put(date, dsl.get(i));
	}
		} catch (Exception e) {
	map.put(date, null);
		}
	}
	request.setAttribute("map", map);
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
	<table id="dayListTable">
		<tr class="header">
			<th><fmt:message key="list.date"></fmt:message>
			</th>
			<th><fmt:message key="list.day"></fmt:message>
			</th>
			<th class="hour-min"><fmt:message key="list.startTime"></fmt:message>
			</th>
			<th class="hour-min"><fmt:message key="list.endTime"></fmt:message>
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
		<c:forEach var="e" items="${map}">
			<tr id="ds-${e.key.id}" class="<c:choose><c:when test='${e.key.holiday}'>holiday</c:when><c:otherwise>workday</c:otherwise></c:choose>">
				<td class="ddt" id="ddt-${e.key.id}"><fmt:formatDate value="${e.key.date}" pattern="yyyy-MM-dd"></fmt:formatDate>
				</td>
				<td>${e.key.date.day}</td>
				<td class="dst" id="dst-${e.key.id}"><fmt:formatDate value="${e.value.startTime}" pattern="HH:mm"></fmt:formatDate>
				</td>
				<td class="det" id="det-${e.key.id}"><fmt:formatDate value="${e.value.endTime}" pattern="HH:mm"></fmt:formatDate>
				</td>
				<td class="dwh" id="dwh-${e.key.id}">${e.value.workHours}</td>
				<td class="dbh" id="dbh-${e.key.id}">${e.value.breakHours}</td>
				<td class="deh" id="dehh-${e.key.id}">${e.value.extraHours}</td>
				<td class="dtip" id="dtip-${e.key.id}">${e.value.tip}</td>
				<td class="dbt" id="dbt-${e.key.id}">
					<c:if
						test="${!m.submitted&&!e.key.holiday}">
						<c:choose>
							<c:when test="${e.value!=null}">
								<input type="button" onclick="change(${e.key.id},${e.value.id})"
									value="<fmt:message
								key="change"></fmt:message>">

							</c:when>
							<c:otherwise>
								<input type="button"
									onclick="add(${e.key.id})"
									value="<fmt:message
								key="new"></fmt:message>">
								
							</c:otherwise>
						</c:choose>
					</c:if></td>
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