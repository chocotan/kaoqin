<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/styles.css" type="text/css">

<!--[if IE]> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script src="html5placeholder.jquery.js"></script>
<script type="text/javascript"> 
document.createElement("section"); 
document.createElement("header"); 
document.createElement("footer"); 
$(function(){
    $(':input[placeholder]').placeholder();
});
</script> 
<![endif]-->
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:setBundle basename="io.loli.kaoqin.prop.login" /> <fmt:message
		key="user.login.title" /></title>
</head>
<body>
	<div class="login">
		<form id="loginForm" action="loginForm" method="post">
			<section class="loginForm"> 
			<header>
			<h1>
				<fmt:message key="user.login.title" />
			</h1>
			</header>
			<div class="loginForm_content">
				<fieldset>
					<input type="hidden" name="action" value="login">
					<div class="inputWrap">
						<input id="username" type="text" required
							placeholder="<fmt:message key="user.login.form.username"/>"
							required="true" tabindex="1" size="12" value="" id="username"
							name="username">
					</div>
					<div class="inputWrap">
						<input type="password" required
							placeholder="<fmt:message key="user.login.form.password"/>"
							name="password">
					</div>
				</fieldset>
				<fieldset>
					<input type="submit"
						value="<fmt:message key="user.login.form.submit"/>"> <a
						href="register.jsp"><fmt:message key="user.login.regist" /></a>
					<label class="error"><c:out value="${info}"></c:out>
					</label>
				</fieldset>
				
			</div>
			</section>
		</form>

	</div>
</body>
</html>