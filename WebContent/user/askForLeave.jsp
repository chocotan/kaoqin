<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<script type="text/javascript">

var ie =navigator.appName=="Microsoft Internet Explorer"?true:false;
function $(objID){
return document.getElementById(objID);
}
</script>
</head>
<body>
<fmt:setBundle basename="io.loli.kaoqin.prop.info"/>
<script type="text/javascript" src="calendar.js"></script>
<form action="leave">
<table>
<input type="hidden" name="action" value="save">
<tr><td colspan="2">
<fmt:message key="leave.from"></fmt:message>
<input size="12" name="startDate" style="border:1px solid #666"  type="text" readonly="readonly" onclick="showcalendar(event, this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''">
<select name="start">
<option selected value="morning">
<fmt:message key="leave.morning"></fmt:message>
</option>
<option value="afternoon">
<fmt:message key="leave.afternoon"></fmt:message>
</option>
</select>
</td>
<tr>
<td colspan="2">
<fmt:message key="leave.to"></fmt:message>
<input size="12" name="endDate" style="border:1px solid #666"  type="text" readonly="readonly" onclick="showcalendar(event, this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''">
<select name="end">
<option value="morning">
<fmt:message key="leave.morning"></fmt:message>
</option>
<option selected value="afternoon">
<fmt:message key="leave.afternoon"></fmt:message>
</option>
</select>
</td></tr><tr><td>
<textarea name="tip" cols="25" rows="5"></textarea></td>
</tr>
<tr><td>
<input type="submit" value="<fmt:message key="form.submit"/>">
</td></tr>
</table>
</form>
</body>