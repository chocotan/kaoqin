<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
<fmt:setBundle basename="io.loli.kaoqin.prop.login"/>
<fmt:message key="user.regist.title"/>
</title>
<link rel="stylesheet" href="../css/styles.css" type="text/css">
<!--为了让IE支持HTML5元素，做如下操作：--> 
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
<script type="text/javascript">
function  checkForm(obj){
	var rf=obj;
	var err=document.getElementById("error");
	if(rf.username.value==""){
		err.innerText="<fmt:message key='user.regist.form.usernameError'/>";
	}else if(rf.password.value.length<6){
		err.innerText="<fmt:message key='user.regist.form.passwordTooShort'/>";
	}else if(rf.repeatPassword.value!=rf.password.value){
		err.innerText="<fmt:message key='user.regist.form.passwordNotSame'/>";
	}else if(!rf.tel.value.match(/^1[3|4|5|8][0-9]{9}$/)){
		err.innerText="<fmt:message key='user.regist.form.telError'/>";
	}else if(!rf.email.value.match(/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/)){
		err.innerText="<fmt:message key='user.regist.form.emailError'/>";
	}else if(rf.address.value==""){
		err.innerText="<fmt:message key='user.regist.form.NULL'/>";
	}else{
		return true;
	}
	return false;
}
</script>
</head>
<body>

<div class="regist">

<form action="registForm" name="regist" method="post" id="registForm" onsubmit="return checkForm(this);">
<section class="registForm">
	<header>
		<h1>
			<fmt:message key="user.regist.title" />
		</h1>
	</header>
	<div class="registForm_content">
	<input type="hidden" name="action" value="regist">
	<fieldset>
		<div class="inputWrap"><input required placeholder="<fmt:message key="user.regist.form.username"/>" type="text" name="username"></div>
		<div class="inputWrap"><input required placeholder="<fmt:message key="user.regist.form.password"/>" type="password" name="password"></div>
		<div class="inputWrap"><input required placeholder="<fmt:message key="user.regist.form.repeatPassword"/>" type="password" name="repeatPassword"></div>
		<div class="inputWrap"><input required placeholder="<fmt:message key="user.regist.form.tel"/>" type="text" name="tel"></div>
		<div class="inputWrap"><input required placeholder="<fmt:message key="user.regist.form.email"/>" type="email" name="email" ></div>
		<div class="inputWrap"><input required placeholder="<fmt:message key="user.regist.form.address"/>" type="text" name="address"></div>
	</fieldset>
	<fieldset>
		<input type="submit" value="<fmt:message key="user.regist.form.submit"/>" >
		<a href="login.jsp"><fmt:message key="user.regist.login"/></a>
		<label id="error"></label>
	</fieldset>
	</div>
</section>
</form>


</div>
</body>
</html>