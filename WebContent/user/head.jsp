<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<link rel="stylesheet" href="../css/styles.css">
<script type="text/javascript" src="../css/jquery-1.9.1.min.js"></script>
<fmt:setBundle basename="io.loli.kaoqin.prop.info"/>
<script type="text/javascript">
	function change(id){
		var starttime = $("td#dst-"+id).text();
		var starthour = parseInt(starttime.split(":")[0]);
		var startmin = parseInt(starttime.split(":")[1]);
		$("td#dst-"+id).html("");
		var content = "<input type='text' size='1' id='dst-input-"+id+"' value='"+starthour+"'>"+"<fmt:message key="hour"/>"+"<input type='text' size='1' id='dst-input-"+id+"' value='"+startmin+"'>"+"<fmt:message key="min"/>";
		$("td#dst-"+id).append(content);
		var endtime = $("td#det-"+id).text();
		var endhour = parseInt(endtime.split(":")[0]);
		var endmin = parseInt(endtime.split(":")[1]);
		$("td#det-"+id).html("");
		content = "<input type='text' size='1' id='det-input-"+id+"' value='"+endhour+"'>"+"<fmt:message key="hour"/>"+"<input type='text' size='1' id='dst-input-"+id+"' value='"+endmin+"'>"+"<fmt:message key="min"/>";
		$("td#det-"+id).append(content);
		
		var worktime = $("td#dwh-"+id).text();
		var breaktime = $("td#dbh-"+id).text();
		var extratime = $("td#deh-"+id).text();
		var tip = $("td#dtip-"+id).text();
		$("td#dwh-"+id).html("");
		$("td#dbh-"+id).html("");
		$("td#deh-"+id).html("");
		$("td#dtip-"+id).html("");
		content = "<input type='text' size='1' id='dwt-input-"+id+"' value='"+worktime+"'>";
		$("td#dwh-"+id).append(content);
		content = "<input type='text' size='1' id='dbh-input-"+id+"' value='"+breaktime+"'>";
		$("td#dbh-"+id).append(content);
		content = "<input type='text' size='1' id='deh-input-"+id+"' value='"+extratime+"'>";
		$("td#deh-"+id).append(content);
		content = "<input type='text' size='1' id='deh-input-"+id+"' value='"+tip+"'>";
		$("td#dtip-"+id).append(content);
	}
</script>
</head>