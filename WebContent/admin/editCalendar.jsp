<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,io.loli.kaoqin.service.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script>
	function saveHoliday(id){
		alert(id);
	}
</script>
<style>
	
</style>
<form action="calendar" method="post">
	<input type="hidden" name="action" value="edit">
	<select name="year">
		<c:forEach var="year"
			items="2010,2011,2012,2013,2014,2015">
		<c:choose>
			<c:when test="${param.year==year}">
				<option selected>
			</c:when>
			<c:otherwise>
				<option>
			</c:otherwise>
		</c:choose>
		<c:out value="${year}"></c:out>
		</option>
		</c:forEach>
	</select> <select name="month">
		<c:forEach var="month" items="1,2,3,4,5,6,7,8,9,10,11,12">
		<c:choose>
			<c:when test="${param.month==month}">
				<option selected>
			</c:when>
			<c:otherwise>
				<option>
			</c:otherwise>

		</c:choose>
		<c:out value="${month}"></c:out>
		</option>
		</c:forEach>
		<fmt:setBundle basename="io.loli.kaoqin.prop.info"/>
	<input type="submit" value="<fmt:message key="form.submit"/>">
</form>

<table id="editMonthList">
	
	<c:forEach var="e" items="${map}" varStatus="vs">
			<c:if test="${vs.index==0}">
				<c:forEach begin="0" end="${e.value-1}" varStatus="vs2">
					<c:if test="${vs2.index==0}"><tr></c:if>
					<td></td>
				</c:forEach>
			</c:if>
		<c:choose>
			<c:when test="${e.value==0}">
				<tr>
					<td><div id="${e.key.id}" onclick="saveHoliday('${e.key.id}')"><c:out value="${e.key.date}"></c:out>
					<option id="${e.key.id}" style="display:none;" value="<c:choose>
						<c:when test="${e.key.holiday}">holiday</c:when>
						<c:otherwise>notholiday</c:otherwise>
					</c:choose>">
					</option></div></td>
			</c:when>
			<c:when test="${e.value==6}">
				<td><div id="${e.key.id}" onclick="saveHoliday('${e.key.id}')"><c:out value="${e.key.date}"></c:out>
					<option id="${e.key.id}" style="display:none;" value="<c:choose>
						<c:when test="${e.key.holiday}">holiday</c:when>
						<c:otherwise>notholiday</c:otherwise>
					</c:choose>">
					</option></div></td>
				</tr>
			</c:when>
			<c:otherwise>
				<td><div id="${e.key.id}" onclick="saveHoliday('${e.key.id}')"><c:out value="${e.key.date}"></c:out>
					<option id="${e.key.id}" style="display:none;" value="<c:choose>
						<c:when test="${e.key.holiday}">holiday</c:when>
						<c:otherwise>notholiday</c:otherwise>
					</c:choose>">
					</option></div></td>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</table>