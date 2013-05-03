<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c"%>
<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>


<div class="addDayStatus">
<fmt:setBundle basename="io.loli.kaoqin.prop.info" />
<style>
body{font-size:12px;font-family:Verdana,Arial,"宋体";}
a:link {color:#464646;text-decoration:none;}
a:visited {color:#464646;text-decoration:none;}
a:hover{color:#ed145b;text-decoration:underline;}
a:active{color:#ed145b;text-decoration:underline;}
td{font-size:12px}
</style>
<script type="text/javascript">
var ie =navigator.appName=="Microsoft Internet Explorer"?true:false;
function $(objID){
return document.getElementById(objID);
}
</script>
<script type="text/javascript" src="calendar.js"></script>
<form action="addDayStatus" method="post">
<input type="hidden" name="action" value="save">
<table>
<tr><td><fmt:message key="list.date"></fmt:message></td><td><input size="16" name="date" style="border:1px solid #666"  type="text" readonly="readonly" onclick="showcalendar(event, this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"></td></tr>
<tr><td><fmt:message key="list.startTime"></fmt:message></td>
<td>
<select name="starttimehour">
	<c:forEach var="h" items="0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23">
		<c:choose>
			<c:when test="${h==8}">
				<option selected>
			</c:when>
			<c:otherwise>
				<option>
			</c:otherwise>
		</c:choose>
			<c:out value="${h}"></c:out>
		</option>
	</c:forEach>
</select>:
<select name="starttimemin">
	<c:forEach var="m" items="0,10,20,30,40,50">
		<c:choose>
			<c:when test="${m==30}">
				<option selected>
			</c:when>
			<c:otherwise>
				<option>
			</c:otherwise>
		</c:choose>
			<c:out value="${m}"></c:out>
		</option>
	</c:forEach>
</select>
</td></tr>
<tr><td><fmt:message key="list.endTime"></fmt:message></td><td>
<select name="endtimehour">
	<c:forEach var="h" items="0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23">
		<c:choose>
			<c:when test="${h==17}">
				<option selected>
			</c:when>
			<c:otherwise>
				<option>
			</c:otherwise>
		</c:choose>
			<c:out value="${h}"></c:out>
		</option>
	</c:forEach>
</select>:
<select name="endtimemin">
	<c:forEach var="m" items="0,10,20,30,40,50">
		<c:choose>
			<c:when test="${m==30}">
				<option selected>
			</c:when>
			<c:otherwise>
				<option>
			</c:otherwise>
		</c:choose>
			<c:out value="${m}"></c:out>
		</option>
	</c:forEach>
</select>
</td></tr>
<tr><td><fmt:message key="list.workTime"></fmt:message></td><td><input value="8" type="text" size="2" name="workhours"></td></tr>
<tr><td><fmt:message key="list.breakTime"></fmt:message></td><td><input value="1" type="text" size="2" name="breakhours"></td></tr>
<tr><td><fmt:message key="list.extraTime"></fmt:message></td><td><input value="0" type="text" size="2" name="extrahours"></td></tr>
<tr><td><fmt:message key="list.tip"></fmt:message></td><td><input value="" type="text" size="30" name="tip"></td></tr>
<tr><td><input type="submit" value="<fmt:message key="form.submit"/>"></td></tr>
</table>
</form>
</div>