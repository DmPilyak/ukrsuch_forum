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

<title>Збережене</title>

<link href="<c:url value="/resources/images/icons/wish_list.ico"/>"
	rel="icon" type="image/png" />
<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>"
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

		<div class="row pt-4">

			<!-- Blog Entries Column -->
			<div class="col-md-6 mb-5 pb-5">

				<div class="row align-items-center my-5 pt-5 mt-3">
					<div class="col-lg text-center">
						<h1 class="font-weight-light">Збережені статті</h1>
						<p>Нижче знаходяться всі збережені Вами статті</p>
					</div>
				</div>

				<!-- Content Row -->
				<c:choose>
					<c:when test="${!empty user.nik}">
						<div class="row">
							<c:if test="${!empty articlesWishList}">
								<c:forEach items="${articlesWishList}" var="article">
									<div class="col-lg mb-3">
										<div class="card h-100">
											<div class="card-body">
												<h2 class="card-title">${article.title}</h2>
												<p class="description card-text">${article.description}</p>
											</div>
											<div class="card-footer d-flex justify-content-between">
												<a href="<c:url value='/article/id/${article.id}'/>"
													class="btn btn-primary btn-sm">Читати далі →</a> <a
													href="<c:url value='/wishList/remove_article/id/${article.id}'/>"
													class="btn btn-danger btn-sm">Видалити зі збереженного</a>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:if>
							<c:if test="${empty articlesWishList}">
								<div class="col-lg mb-3">
									<div class="col-lg text-center mt-5 pb-5" style="height: 170px;">
										<p>У вас немає збережених сатей :(</p>
										<p>Ви можете переглянути та зберегти їх з розділу <a style="text-decoration: none;" href="<c:url value='/articles'/>">Сучукрліт</a></p>
									</div>
								</div>
							</c:if>
						</div>
					</c:when>
					<c:otherwise>
						<div class="mb-5 pb-5 text-center">
							<h3 class="card-text">Ви не авторизовані!</h3>
							<a href="<c:url value='/login'/>"
								class="btn btn-warning btn-lg mb-5">Увійти</a>
						</div>
						<div class="mb-5 pb-5">
							<hr>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- Sidebar Widgets Column -->
			<div class="col-md-6 mb-5 pb-5">

				<!-- Search Widget -->
				<div class="row align-items-center my-5 pt-5 mt-3">
					<div class="col-lg text-center">
						<h1 class="font-weight-light">Збережені комікси</h1>
						<p>Нижче знаходяться всі збережені Вами комікси</p>
					</div>
				</div>

				<!-- Content Row -->
				<c:choose>
					<c:when test="${!empty user.nik}">
						<div class="row">
							<c:if test="${!empty comicsWishList}">
								<c:forEach items="${comicsWishList}" var="comics">
									<div class="col-lg mb-3">
										<div class="card h-100">
											<div class="card-body">
												<h2 class="card-title">${comics.title}
													<em><small class="text-muted ml-1"> (комікс)</small></em>
												</h2>
												<p class="description card-text">${comics.description}</p>
											</div>
											<div class="card-footer d-flex justify-content-between">
												<a href="<c:url value='/comics/id/${comics.id}'/>"
													class="btn btn-primary btn-sm">Читати далі →</a> <a
													href="<c:url value='/wishList/remove_comics/id/${comics.id}'/>"
													class="btn btn-danger btn-sm">Видалити зі збереженного</a>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:if>
							<c:if test="${empty comicsWishList}">
								<div class="col-lg mb-3">
									<div class="col-lg text-center mt-5 pb-5" style="height: 170px;">
										<p>У вас немає збережених коміксів :(</p>
										<p>Ви можете переглянути та зберегти їх з розділу <a style="text-decoration: none;" href="<c:url value='/comics'/>">Комікси</a></p>
									</div>
								</div>
							</c:if>
						</div>
					</c:when>
					<c:otherwise>
						<div class="mb-5 pb-5 text-center">
							<h3 class="card-text">Ви не авторизовані!</h3>
							<a href="<c:url value='/login'/>"
								class="btn btn-warning btn-lg mb-5">Увійти</a>
						</div>
						<div class="mb-5 pb-5">
							<hr>
						</div>
					</c:otherwise>
				</c:choose>
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
