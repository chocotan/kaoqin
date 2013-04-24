<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<link rel="stylesheet" href="../css/styles.css">
<script type="text/javascript" src="../css/jquery-1.9.1.min.js"></script>
<fmt:setBundle basename="io.loli.kaoqin.prop.info"/>
<script type="text/javascript">
	var origin;
	function change(id){
		origin=$("tr#ds-"+id).html();
		var starttime = $("td#dst-"+id).text();
		var starthour = parseInt(starttime.split(":")[0]);
		var startmin = parseInt(starttime.split(":")[1]);
		$("td#dst-"+id).html("");
		var content = "<input type='text' size='1' id='dst-input-"+id+"' value='"+starthour+"'>"+"<fmt:message key="hour"/>"+"<input type='text' size='1' id='dsm-input-"+id+"' value='"+startmin+"'>"+"<fmt:message key="min"/>";
		$("td#dst-"+id).append(content);
		var endtime = $("td#det-"+id).text();
		var endhour = parseInt(endtime.split(":")[0]);
		var endmin = parseInt(endtime.split(":")[1]);
		$("td#det-"+id).html("");
		content = "<input type='text' size='1' id='det-input-"+id+"' value='"+endhour+"'>"+"<fmt:message key="hour"/>"+"<input type='text' size='1' id='dem-input-"+id+"' value='"+endmin+"'>"+"<fmt:message key="min"/>";
		$("td#det-"+id).append(content);
		
		var worktime = $("td#dwh-"+id).text();
		var breaktime = $("td#dbh-"+id).text();
		var extratime = $("td#deh-"+id).text();
		var tip = $("td#dtip-"+id).text();
		$("td#dwh-"+id).html("");
		$("td#dbh-"+id).html("");
		$("td#deh-"+id).html("");
		$("td#dtip-"+id).html("");
		$("td#dbt-"+id).html("");
		content = "<input type='text' size='1' id='dwt-input-"+id+"' value='"+worktime+"'>";
		$("td#dwh-"+id).append(content);
		content = "<input type='text' size='1' id='dbh-input-"+id+"' value='"+breaktime+"'>";
		$("td#dbh-"+id).append(content);
		content = "<input type='text' size='1' id='deh-input-"+id+"' value='"+extratime+"'>";
		$("td#deh-"+id).append(content);
		content = "<input type='text' size='1' id='deh-input-"+id+"' value='"+tip+"'>";
		$("td#dtip-"+id).append(content);
		content = "<input type='button' onclick='update("+id+")' id='dbt-button-"+id+"' value='"+"<fmt:message key="form.done"/>"+"'>"+"<input type='button' onclick='cancle("+id+")' value='"+"<fmt:message key="cancle"/>"+"'>";
		$("td#dbt-"+id).append(content);
	}
	function cancle(id){
		$("tr#ds-"+id).html("");
		$("tr#ds-"+id).append(origin);
	}
	function update(id){
		var starthour = $("dsh-input-"+id).text();
		var startmin = $("dsm-input-"+id).text();
		var endhour = $("deh-input-"+id).text();
		var endmin = $("dem-input-"+id).text();
		var worktime = $("dwh-input-"+id).text();
		var breaktime = $("dbh-input-"+id).text();
		var extratime = $("deh-input-"+id).text();
		var tip = $("dtip-input-"+id).text();
		var action = "update";
		var url = "addDayStatus";
		var param = {"starttimehour":starthour,"starttimemin":startmin,"endtimehour":endhour,"endtimemin":endmin,"workhours":worktime,"breakhours":breaktime,"extrahours":extratime,"id":id,"action":action,"tip":tip};
		
	}
</script>
</head>