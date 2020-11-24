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

<title>Форум авторів</title>

<link href="<c:url value="/resources/images/icons/forum.ico"/>"
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
#content:after {
	content: "\1F882";
	float: right;
	margin-left: 15px;
}
/* Icon when the collapsible content is hidden */
#content.collapsed:after {
	content: "\1F87B";
}
</style>
<body>

	<!-- Navigation -->
	<tags:navbar />

	<!-- Page Content -->
	<div class="container">

		<div class="row pt-5 mt-3">

			<!-- Blog Entries Column -->
			<div class="col-md-8">

				<h1 class="my-4">
					<u>Форум авторів</u>
				</h1>
				<div class="mb-4 pb-4">
					<small class="lead">⦁ Це місце - платформа для вашого
						спілкування. Тут ви зможете обмінюватися думками про прочитанні
						твори і заводити знайомства з людьми, які мають схожі смаки.
						Жодних образ на адресу інших учасників дискусії.</small>
				</div>

				<h3 class="mb-3 ml-2">
					<em>Поділись своїми думками 💬</em>
				</h3>

				<c:choose>
					<c:when test="${!empty user.nik}">
						<form:form
							action="${pageContext.request.contextPath}/forum_articles"
							method="POST" modelAttribute="forumUserArticle"
							onsubmit="return validateArticle();">
							<div class="form-group mb-5 card container bg-light">
								<label for="textFormArea" class="lead ml-2 mt-2">Тема</label>
								<div id="titleArea">
									<form:input path="title" id="title" name="Title"
										class="form-control" type="text" placeholder="Тема"
										accept-charset="UTF-8" />
								</div>
								<label for="textFormArea" class="lead ml-2 mt-2">Думка</label>
								<div id="descriptArea">
									<form:textarea path="description" class="form-control mb-3"
										id="textFormArea" rows="6"
										placeholder="Вислови свої думки тут..." accept-charset="UTF-8"></form:textarea>
								</div>
								<button type="submit" class="btn btn-success ml-auto mb-3">Опублікувати</button>
							</div>
						</form:form>
					</c:when>
					<c:otherwise>
						<div class="mb-5">
							<p class="lead">
								⚠️ Щоб висловити свою думку потрібно <a type="button"
									href="<c:url value='/logIn'/>" class="btn btn-success btn-sm">Увійти</a>
							</p>
						</div>
					</c:otherwise>
				</c:choose>


				<h3 class="mb-3 ml-2">
					<em>Думки інших 💭</em>
				</h3>

				<!-- Blog Post -->
				<div class="panel-group" id="accordion">

					<c:forEach items="${listAllUserArticles}" var="article"
						varStatus="status">
						<div class="card mb-4">
							<div class="card mb-3 bg-light">
								<div class="card-body">
									<h2 class="card-title">${article.title}</h2>
									<p class="lead">by ${usersList[status.index].nik}</p>

									<button id="content" type="button"
										class="btn btn-info collapsed" data-toggle="collapse"
										data-target="#demo${status.index}">Розгорнути</button>

									<div id="demo${status.index}" class="collapse mt-3">
										<p class="card-text description">${article.description}</p>
									</div>
								</div>
								<div class="card-footer text-muted">
									Posted on ${article.date} by <em>${usersList[status.index].nik}</em>
								</div>
							</div>
							<div class="comments ml-3">
								<c:forEach var="mapItems"
									items="${mapForumComments[article.id]}">
									<div class="media mb-1">
										<img class="d-flex mr-3 rounded-circle"
											src="http://placehold.it/50x50" alt="">
										<div class="media-body">
											<h5 class="mt-0">${commentUsers[mapItems.commentId].nik}</h5>
											<p>${mapItems.commentContent}</p>
										</div>
									</div>
								</c:forEach>
							</div>
							<c:choose>
								<c:when test="${!empty user.nik}">
									<form:form
										action="${pageContext.request.contextPath}/forum_articles"
										method="POST" modelAttribute="userComment">
										<div class="input-group mt-1">
											<form:input path="commentContent" type="text"
												class="form-control" placeholder="Комментар..." />
											<form:input type="hidden" path="forumArticleId"
												value="${article.id}" />
											<span class="input-group-append">
												<button class="btn btn-success" type="submit">Комментувати</button>
											</span>
										</div>
									</form:form>
								</c:when>
								<c:otherwise>
									<div class="mt-1 text-center">
										<p class="lead">
											Щоб залишити коментар потрібно <a type="button"
												href="<c:url value='/logIn'/>"
												class="btn btn-success btn-sm">Увійти</a>
										</p>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</c:forEach>


				</div>

				<!-- Pagination -->
				<ul class="pagination justify-content-center mb-4">
					<li class="page-item"><a class="page-link" href="#">←
							Попередня</a></li>
					<li class="page-item disabled"><a class="page-link" href="#">Наступна
							→</a></li>
				</ul>

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
	<script
		src="<c:url value="/resources/js/bootstrap/bootstrap.bundle.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/custom/validation.js"/>"></script>
</body>

</html>
