<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Читати: ${article.title}</title>

<link href="<c:url value="/resources/images/icons/article.ico"/>"
	rel="icon" type="image/png" />
<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/descriptionRows.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>"
	rel="stylesheet">
</head>
<body>

	<!-- Navigation -->
	<tags:navbar />

	<!-- Page Content -->
	<div class="container">

		<div class="row pt-5 mt-3">

			<!-- Post Content Column -->
			<div class="col-lg-8">

				<!-- Title -->
				<h1 class="mt-4">
					<u>${article.title}</u>
				</h1>

				<!-- Author -->
				<p class="lead">
					by <em>${article.autorName}</em>
				</p>

				<hr>

				<!-- Date/Time -->
				<p class="text-muted">Posted on ${article.date}</p>

				<hr>

				<!-- Preview Image -->
				<img class="img-fluid rounded"
					src="<c:url value="/articles/image.html?id=${article.id}"/>"
					alt="Без зображення">

				<hr>

				<!-- Post Content -->
				<p class="lead mb-5">${article.description}</p>
				<hr>
				<!-- Comments Form -->
				<c:choose>
					<c:when test="${!empty user.nik}">
						<div class="card my-4">
							<h5 class="card-header">Залишити коментар:</h5>
							<div class="card-body">
								<form:form
									action="${pageContext.request.contextPath}/add_comment"
									method="POST" modelAttribute="comment"
									onsubmit="return validateCommentArticleAndComics();">
									<div class="form-group">
										<div class="commentArea">
											<form:textarea id="commentContent" path="commentContent"
												class="form-control" rows="3"></form:textarea>
										</div>
									</div>
									<button type="submit" class="btn btn-primary">Коментувати</button>
								</form:form>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="mb-5">
							<p class="lead">
								⚠️ Щоб комментувати статтю потрібно <a type="button"
									href="<c:url value='/logIn'/>" class="btn btn-success btn-sm">Увійти</a>
							</p>
						</div>
					</c:otherwise>
				</c:choose>

				<!-- Single Comment -->
				<div class="comments ml-3">

					<c:forEach items="${comments}" var="comment" varStatus="status">

						<div class="media mb-4">
							<img class="d-flex mr-3 rounded-circle"
								src="http://placehold.it/50x50" alt="">
							<div class="media-body">
								<h5 class="mt-0">${usersComment[status.index].nik}</h5>
								<p>${comment.commentContent}</p>
							</div>
						</div>

					</c:forEach>
				</div>
			</div>

			<!-- Sidebar Widgets Column -->
			<div class="col-md-4">

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
	<script src="<c:url value="/resources/js/custom/validation.js"/>"></script>
	<script
		src="<c:url value="/resources/js/bootstrap/bootstrap.bundle.min.js"/>"></script>

</body>

</html>
