<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import=" java.text.SimpleDateFormat,java.util.*,io.loli.kaoqin.service.*,io.loli.kaoqin.javabean.*" %>
<%
	int p_id=Integer.parseInt(request.getParameter("p_id"));
	int m_id=Integer.parseInt(request.getParameter("m_id"));
	MonthStatus m = new MonthStatusService().findById(m_id);
	List<DayStatus> dsl = new DayStatusService().findByPersonAndMonth(p_id, m_id);
	SimpleDateFormat sdf1 = new SimpleDateFormat("yy-MM-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
%>
<h2>
<%=m.getYear()%>年<%=m.getMonth()%>月
</h2>
<table>
<tr><td>日期</td><td>星期</td><td>上班时间</td><td>下班时间</td><td>工作时间</td><td>休息时间</td><td>加班时间</td><td>工作内容</td></tr>
<% 
	for(DayStatus ds:dsl){
%>
<tr><td><%=sdf1.format(ds.getDate())%></td><td><%=ds.getDay()%></td><td><%=sdf2.format(ds.getStartTime())%></td><td><%=sdf2.format(ds.getEndTime())%></td><td><%=ds.getWorkHours()%></td><td><%=ds.getBreakHours()%></td><td><%=ds.getExtraHours()%></td><td><%=ds.getTip()%></td>
</tr>
<%
	}
%>
</table>
本月工作天数:<%=dsl.size()%>
<form action="monthStatus" method="post">
<input type="hidden" name="action" value="back">
<input type="hidden" name="m_id" value="${param.m_id}">
<input type="submit" value="退回">
</form>
<form action="monthStatus" method="post">
<input type="hidden" name="action" value="approve">
<input type="hidden" name="m_id" value="${param.m_id}">
<input type="submit" value="通过">
</form>