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
	function sleep(numberMillis) { 
		   var now = new Date();
		   var exitTime = now.getTime() + numberMillis;  
		   while (true) { 
		       now = new Date(); 
		       if (now.getTime() > exitTime)    return;
		    }
		}
	function change(id,vid){
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
		var extratime = $("td#dehh-"+id).text();
		var tip = $("td#dtip-"+id).text();
		$("td#dwh-"+id).html("");
		$("td#dbh-"+id).html("");
		$("td#deh-"+id).html("");
		$("td#dehh-"+id).html("");
		$("td#dtip-"+id).html("");
		$("td#dbt-"+id).html("");
		content = "<input type='text' size='1' id='dwt-input-"+id+"' value='"+worktime+"'>";
		$("td#dwh-"+id).append(content);
		content = "<input type='text' size='1' id='dbt-input-"+id+"' value='"+breaktime+"'>";
		$("td#dbh-"+id).append(content);
		content = "<input type='text' size='1' id='dehh-input-"+id+"' value='"+extratime+"'>";
		$("td#dehh-"+id).append(content);
		content = "<input type='text' size='1' id='dtip-input-"+id+"' value='"+tip+"'>";
		$("td#dtip-"+id).append(content);
		content = "<input type='button' onclick='update("+id+","+vid+")' id='dbt-button-"+id+"' value='"+"<fmt:message key="form.done"/>"+"'>"+"<input type='button' onclick='cancle("+id+")' value='"+"<fmt:message key="cancle"/>"+"'>";
		$("td#dbt-"+id).append(content);
	}
	

	/** 
	 * 时间对象的格式化 
	 */
	Date.prototype.format = function(format) {
		/* 
		 * format="yyyy-MM-dd hh:mm:ss"; 
		 */
		var o = {
			"M+" : this.getMonth() + 1,
			"d+" : this.getDate(),
			"h+" : this.getHours(),
			"m+" : this.getMinutes(),
			"s+" : this.getSeconds(),
			"q+" : Math.floor((this.getMonth() + 3) / 3),
			"S" : this.getMilliseconds()
		}

		if (/(y+)/.test(format)) {
			format = format.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		}

		for ( var k in o) {
			if (new RegExp("(" + k + ")").test(format)) {
				format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
						: ("00" + o[k]).substr(("" + o[k]).length));
			}
		}
		return format;
	}
	
	function cancle(id) {
		$("tr#ds-" + id).html("");
		$("tr#ds-" + id).append(origin);
	}
	function update(id,vid) {
		var starthour = $("input#dst-input-" + id).val();
		var startmin = $("input#dsm-input-" + id).val();
		var endhour = $("input#det-input-" + id).val();
		var endmin = $("input#dem-input-" + id).val();
		var worktime = $("input#dwt-input-" + id).val();
		var breaktime = $("input#dbt-input-" + id).val();
		var extratime = $("input#dehh-input-" + id).val();
		var tip = $("input#dtip-input-" + id).val();
		var action = "update";
		var url = "addDayStatus";
		var param = {
			"starttimehour" : starthour,
			"starttimemin" : startmin,
			"endtimehour" : endhour,
			"endtimemin" : endmin,
			"workhours" : worktime,
			"breakhours" : breaktime,
			"extrahours" : extratime,
			"id" : vid,
			"action" : action,
			"tip" : tip,
			"kind" : "ajax"
		};
		var startDate = new Date();
		startDate.setHours(starthour);
		startDate.setMinutes(startmin);
		var endDate = new Date();
		endDate.setHours(endhour);
		endDate.setMinutes(endmin);
		$.post(url, param, function f(data) {
			if(data=="SUCCESS"){
				$("tr#ds-" + id).html("");
				$("tr#ds-" + id).append(origin);
				$("td#dst-" + id).html(startDate.format("hh:mm"));
				$("td#det-" + id).html(endDate.format("hh:mm"));
				$("td#dwh-" + id).html(worktime);
				$("td#dbh-" + id).html(breaktime);
				$("td#dehh-" + id).html(extratime);
				$("td#dtip-" + id).html(tip);
				$("td#info-" + id).html("<fmt:message key="change.success"/>");
				
			}
		});
	}
	
	function add(id){
		origin=$("tr#ds-"+id).html();
		var starthour = 8;
		var startmin = 30;
		$("td#dst-"+id).html("");
		var content = "<input type='text' size='1' id='dst-input-"+id+"' value='"+starthour+"'>"+"<fmt:message key="hour"/>"+"<input type='text' size='1' id='dsm-input-"+id+"' value='"+startmin+"'>"+"<fmt:message key="min"/>";
		$("td#dst-"+id).append(content);
		var endhour = 17;
		var endmin =30;
		$("td#det-"+id).html("");
		content = "<input type='text' size='1' id='det-input-"+id+"' value='"+endhour+"'>"+"<fmt:message key="hour"/>"+"<input type='text' size='1' id='dem-input-"+id+"' value='"+endmin+"'>"+"<fmt:message key="min"/>";
		$("td#det-"+id).append(content);
		
		var worktime = 8;
		var breaktime = 1;
		var extratime = 0;
		var tip = $("td#dtip-"+id).text();
		$("td#dwh-"+id).html("");
		$("td#dbh-"+id).html("");
		$("td#deh-"+id).html("");
		$("td#dehh-"+id).html("");
		$("td#dtip-"+id).html("");
		$("td#dbt-"+id).html("");
		content = "<input type='text' size='1' id='dwt-input-"+id+"' value='"+worktime+"'>";
		$("td#dwh-"+id).append(content);
		content = "<input type='text' size='1' id='dbt-input-"+id+"' value='"+breaktime+"'>";
		$("td#dbh-"+id).append(content);
		content = "<input type='text' size='1' id='dehh-input-"+id+"' value='"+extratime+"'>";
		$("td#dehh-"+id).append(content);
		content = "<input type='text' size='1' id='dtip-input-"+id+"' value='"+tip+"'>";
		$("td#dtip-"+id).append(content);
		content = "<input type='button' onclick='addSubmit("+id+")' id='dbt-button-"+id+"' value='"+"<fmt:message key="form.submit"/>"+"'>"+"<input type='button' onclick='cancle("+id+")' value='"+"<fmt:message key="cancle"/>"+"'>";
		$("td#dbt-"+id).append(content);
	}
	function addSubmit(id){
		var date = $("td#ddt-"+id).text();
		var starthour = $("input#dst-input-" + id).val();
		var startmin = $("input#dsm-input-" + id).val();
		var endhour = $("input#det-input-" + id).val();
		var endmin = $("input#dem-input-" + id).val();
		var worktime = $("input#dwt-input-" + id).val();
		var breaktime = $("input#dbt-input-" + id).val();
		var extratime = $("input#dehh-input-" + id).val();
		var tip = $("input#dtip-input-" + id).val();
		var action = "save";
		var url = "addDayStatus";
		var startDate = new Date();
		startDate.setHours(starthour);
		startDate.setMinutes(startmin);
		var endDate = new Date();
		endDate.setHours(endhour);
		endDate.setMinutes(endmin);
		var param = {
			"date" : date,
			"starttimehour" : starthour,
			"starttimemin" : startmin,
			"endtimehour" : endhour,
			"endtimemin" : endmin,
			"workhours" : worktime,
			"breakhours" : breaktime,
			"extrahours" : extratime,
			"action" : action,
			"tip" : tip,
			"kind" : "ajax"
		};
		
		$.post(url, param, function callback(data) {
				newid = data;
				if (newid!=0) {
					$("tr#ds-" + id).html("");
					$("tr#ds-" + id).append(origin);
					$("td#dst-" + id).html(startDate.format("hh:mm"));
					$("td#det-" + id).html(endDate.format("hh:mm"));
					$("td#dwh-" + id).html(worktime);
					$("td#dbh-" + id).html(breaktime);
					$("td#dehh-" + id).html(extratime);
					$("td#dtip-" + id).html(tip);
					$("td#dbt-" + id).html("<input type='button' onclick='change("+id+","+newid+")' value='<fmt:message key='change'></fmt:message>'>");
					$("td#info-" + id).html("<fmt:message key="add.success"/>");
					
				}
			});
		}
	
	
	
</script>
</head>