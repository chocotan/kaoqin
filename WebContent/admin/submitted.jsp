<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="io.loli.kaoqin.service.*,io.loli.kaoqin.entity.*,java.util.*"%>
<%
	List<MonthStatus> ml = new MonthStatusService().findBySubmittedAndApproved(true, false);
	request.setAttribute("ml", ml);
%>
<table>
<tr>
<td>姓名</td><td>年月</td>
</tr>
<% 
	for(MonthStatus ms:ml){
		request.setAttribute("ms", ms);
%>
<tr><td>${ms.p.username}</td><td>${ms.year}年${ms.month}月</td><td><a href="dayList.jsp?m_id=${ms.id}&p_id=${ms.p.id}">查看</a></td></tr>
<% 
	}
%>
</table>