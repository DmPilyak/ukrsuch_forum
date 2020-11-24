<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Контакти</title>

<link href="<c:url value="/resources/images/icons/contacts.ico"/>"
	rel="icon" type="image/png" />
<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="/resources/css/heroic-features.css" rel="stylesheet">
<link
	href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>"
	rel="stylesheet">
</head>
<body>

	<tags:navbar />
	<div class="container mt-5 pt-3">
		<h1 class="my-4">
			<u>Контакти</u><small class="text-muted"> (та трохи про нас)</small>
		</h1>
	</div>
	<div class="container">
		<h3 class="my-4">Хто ми такі?🤔</h3>
		<p class="lead" style="text-indent: 20px;">
			<em><strong>«СУЧ»</strong></em> – це молода й амбітна команда
			ентузіастів, які вирішили створити великий майданчик про сучасну
			українську літературу та комікси. Ми втомилися від повсякчасного
			оцінювання нашої літератури як чогось журливого, що обов'язково
			розповідає про важку долю українського народу. Відповідно – це
			відлякує українців від читання своєї ж літератури.
		</p>

		<h3 class="my-4 pt-4">Наші наміри📚</h3>
		<p class="lead" style="text-indent: 20px;">Ми хочемо, щоб українці
			й не тільки читали сучасну українську літературу, яку б видавали
			українськів видавництва. І, звичайно, ми хочемо, щоб літературу
			популяризувала не тільки наша команда. Саме тому «СУЧ» дає ВАМ
			можливість ділитися власними думками про літературу, писати рецензії.</p>
		<p class="lead mt-1">💥А для всіх молодих авторів ми пропонуємо
			невеличкий бонус – ви можете опублікувати свої твори у нас. І хтозна,
			можливо за декілька років саме цей вірш чи оповідання стануть першими
			у вашій збірці чи книзі!</p>

		<h3 class="my-4 pt-4">Шукай нас в інших мережах</h3>
		<div class="mb-5 pb-5">
			<div class="row">
				<a href="https://www.facebook.com/such.network/" target="_blank"
					class="text-dark"> <i style="color: rgb(5, 4, 115);"
					class="fa fa-facebook"></i> Сторінка у Facebook
				</a>
			</div>
			<div class="row">
				<a href="https://t.me/suchmedia" target="_blank" class="text-dark">
					<i style="color: rgb(2, 124, 254);" class="fa fa-telegram"
					aria-hidden="true"> </i>Канал у Telegram
				</a>
			</div>
			<div class="row">
				<a href="https://instagram.com/such.media?igshid=eln4jwnkkyzt"
					target="_blank" class="text-dark"> <i
					style="color: rgb(233, 1, 65);" class="fa fa-instagram"> </i>
					Сторінка у Instagram
				</a>
			</div>
		</div>

	</div>
	<tags:footer />

	<script src="<c:url value="/resources/js/jquery/jquery.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/bootstrap/bootstrap.bundle.min.js"/>"></script>
</body>
</html>