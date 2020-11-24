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

<title>Комікси</title>

<link
	href="<c:url value="/resources/images/icons/articles_and_comics.ico"/>"
	rel="icon" type="image/png" />
<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/descriptionRows.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>"
	rel="stylesheet">
</head>
<style>
p.description {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
<body>

	<!-- Navigation -->
	<tags:navbar />

	<!-- Page Content -->
	<div class="container">

		<div class="row pt-5 mt-3">

			<!-- Blog Entries Column -->
			<div class="col-md-7">

				<h1 class="my-4">
					<u>Комікси</u>
				</h1>

				<!-- Blog Post -->
				<c:forEach items="${listComicsArticle}" var="comics"
					varStatus="status">
					<div class="card mb-4">
						<div>
							<img class="card-img-top"
								src="<c:url value="/comics/image.html?id=${comics.id}"/>"
								alt="Card image cap">
						</div>
						<div class="card-body">
							<h2 class="card-title">${comics.title}</h2>
							<p class="card-text description">${comics.description}</p>
							<a href="<c:url value='/comics/id/${comics.id}'/>"
								class="btn btn-primary">Читати далі →</a>

							<c:choose>
								<c:when test="${!empty user.nik}">
									<c:choose>
										<c:when test="${boolComicsArticle[comics] == true}">
											<a href="" class="btn btn-success disabled"
												aria-disabled="true">Збережено</a>
										</c:when>
										<c:otherwise>
											<a href="<c:url value='/comics/add_comics/id/${comics.id}'/>"
												class="btn btn-success">Зберегти</a>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<a href="<c:url value='/logIn'/>" class="btn btn-success">Зберегти
										до списку</a>
								</c:otherwise>
							</c:choose>

						</div>
						<div class="card-footer text-muted">
							Posted on ${comics.date} by <em>${comics.autorName}</em>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- Sidebar Widgets Column -->
			<div class="col-md-5">

				<!-- Side Widgets -->
				<div class="card my-4">
					<div class="card-body">
						<blockquote class="mb-0">
							<em>
								<p class="mb-0">"Закрити цей світ немов недочитану книжку</p>
								<p class="mb-0">Де автор незграбно тримає сюжет і мотив</p>
								<p class="mb-0">Де гори героїв розпродуються зі знижкою</p>
								<p>Де горе героїв розведене в імператив."</p>
							</em>
							<footer class="blockquote-footer text-right">
								Український прозаїк та поет <cite>Юрій Іздрик</cite>
							</footer>
						</blockquote>
					</div>
				</div>

				<div class="card">
					<h5 class="card-header text-muted">Читай також</h5>
					<div class="card-body">
						<h6 class="card-subtitle mb-2 font-weight-bold">${articleReadMore.title}</h6>
						<p class="card-text description">${articleReadMore.description}</p>
						<a href="<c:url value='/article/id/${articleReadMore.id}'/>"
							class="card-link">Читати далі...</a>
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
