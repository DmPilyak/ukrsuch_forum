<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Sign In</title>

<link href="<c:url value="/resources/images/icons/login.ico"/>"
	rel="icon" type="image/png" />
<link
	href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/fonts/iconic/css/material-design-iconic-font.min.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/animate/animate.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/css/hamburgers/hamburgers.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/css/animsition/animsition.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/css/daterangepicker/daterangepicker.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/util.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">

<style>
.input100::-webkit-input-placeholder {
	color: #bdbebd;
}
</style>
</head>

<div class="limiter">
	<div class="container-login100"
		style="background-image: url('resources/images/bg-01.jpg');">
		<div class="wrap-login100">
			<form:form action="${pageContext.request.contextPath}/signin" method="POST" class="login100-form"
				onsubmit="return validateSignIn();" modelAttribute="user">

				<div class="circle login100-form-logo"
					style="width: 110px; height: 110px;">
					<img style="width: 110px; height: 110px;"
						src="<c:url value='resources/images/main_logo.png'/>"></img>
				</div>
				<span class="login100-form-title p-b-34 p-t-27"> Sign In </span>


				<div class="wrap-input100" data-validate="Введіть нікнейм">
					<form:input path="nik" class="input100" type="text" name="nik"
						placeholder="Нікнейм" accept-charset="UTF-8"/>
					<span class="focus-input100" data-placeholder="&#xf207;"></span>
				</div>

				<div class="wrap-input100" data-validate="Введіть e-mail">
					<form:input path="email" id="email" class="input100" type="text"
						name="email" placeholder="Електронна пошта" accept-charset="UTF-8"/>
					<span class="focus-input100" data-placeholder="&#xf324;"></span>
				</div>

				<div class="wrap-input100" data-validate="Введіть пароль">
					<form:input path="password" id="pass" class="input100"
						type="password" name="pass" placeholder="Пароль" accept-charset="UTF-8"/>
					<span class="focus-input100" data-placeholder="&#xf191;"></span>
				</div>

				<div class="wrap-input100" data-validate="Повторіть пароль">
					<input id="repPass" class="input100" type="password" name="repPass"
						placeholder="Повторіть пароль"> <span
						class="focus-input100" data-placeholder="&#xf191;"></span>
				</div>
				<br />
				<div class="container-login100-form-btn">
					<button type="submit" class="login100-form-btn">Зареєструватися</button>
				</div>
				<div class="message text1 center-block mt-3"
					style="text-align: center; color: rgb(205, 0, 0);">${message}</div>
			</form:form>
			<form action="signup">
				<div class="text-center p-t-50">
					<p class="text-warning p-b-10">Ви вже зареєстровані?</p>
					<a class="h6 text-light" href="<c:url value='/logIn'/>"> Увійти </a>
				</div>
			</form>

		</div>
	</div>
</div>


<div id="dropDownSelect1"></div>

<script src="<c:url value="/resources/js/custom/validation.js"/>"></script>

</body>
</html>