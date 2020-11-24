<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Головна</title>
<link href="<c:url value="/resources/images/icons/home.ico"/>"
	rel="icon" type="image/png" />
<link
	href="<c:url value="/resources/fonts/dashboardFontAwesome/css_font_awesome/all.css"/>"
	rel="stylesheet">

<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>"
	rel="stylesheet">
</head>
<body>

	<!-- Navigation -->
	<tags:navbar />

	<!-- Page Content -->
	<div class="container mb-4">

		<!-- Jumbotron Header -->
		<header class="jumbotron my-4">
			<h1 class="display-3">Ласкаво просимо, читачу!</h1>
			<p class="lead mb-4 pb-4">
				Привіт! Привіт! Привіт! Щойно ти потрапив на найкращий сайт про <b>сучасну
					українську літературу</b>. Завари чайку або кави, сідай у крісло та
				починай перегляд наших, ну ду-уже цікавих матеріалів на тему, яка
				тобі близька. А також не забудь розповісти про нас своїм друзям у
				соціальних мережах!
			</p>
		</header>

		<!-- Page Features -->
		<div class="row text-center">

			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">

					<div class="card-body">
						<h4 class="card-title">Сучукрліт</h4>
						<p class="card-text">Українська література і все-все-все.</p>
					</div>
					<div class="card-footer">
						<a href="<c:url value='/articles'/>" class="btn btn-primary">Переглянути!</a>
					</div>
				</div>
			</div>

			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">
					<div class="card-body">
						<h4 class="card-title">Форум авторів</h4>
						<p class="card-text">Тут ви можете почитати свої власні твори!
							Не соромтеся надсилати їх сюди.</p>
					</div>
					<div class="card-footer">
						<a href="<c:url value='/forum_articles'/>" class="btn btn-primary">Переглянути!</a>
					</div>
				</div>
			</div>

			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">
					<div class="card-body">
						<h4 class="card-title">Комікси</h4>
						<p class="card-text">Українські комікси - це не міф! Читайте
							тут.</p>
					</div>
					<div class="card-footer">
						<a href="<c:url value='/comics'/>" class="btn btn-primary">Переглянути!</a>
					</div>
				</div>
			</div>




		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<tags:footer />

	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value="/resources/js/jquery/jquery.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/bootstrap/bootstrap.bundle.min.js"/>"></script>

</body>

</html>
