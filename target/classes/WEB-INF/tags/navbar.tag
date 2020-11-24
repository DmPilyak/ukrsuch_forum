<%@tag pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.navbar .nav-item .dropdown-menu{ display: none; }
	.navbar .nav-item:hover .dropdown-menu{ display: block; }
	.navbar .nav-item .dropdown-menu{ margin-top:0; }
</style>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="<c:url value='/'/>"><img class="mr-2"
			style="width: 43px; height: 43px;"
			src="${pageContext.request.contextPath}/resources/images/main_logo.png"></img>СУЧ</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item text-center"><a class="nav-link ml-5 mr-5" href="<c:url value='/'/>">Головна</a></li>
				<li class="nav-item text-center"><a class="nav-link ml-4 mr-4" href="<c:url value='/articles'/>">Сучукрліт</a></li>
				<li class="nav-item text-center"><a class="nav-link ml-4 mr-4" style="white-space: nowrap;" href="<c:url value='/forum_articles'/>">Форум авторів</a></li>
				<li class="nav-item text-center"><a class="nav-link ml-4 mr-4" href="<c:url value='/comics'/>">Комікси</a></li>
				<li class="nav-item text-center"><a class="nav-link ml-4 mr-4" href="<c:url value='/contacts'/>">Контакти</a></li>
			</ul>
		</div>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<c:choose>
					<c:when test="${!empty user.nik}">
						<li class="nav-item dropdown"><a style="white-space: nowrap;"
							class="nav-link text-center text-warning dropdown-toggle ml-2" href="#"
							data-toggle="dropdown">${user.nik}</a>
							<ul class="dropdown-menu">
								<li class="ml-3 mr-3"><a type="button" class="dropdown-item nav-link text-secondary"
									href="<c:url value='/wishList'/>">Збережене</a></li>
								<li class="ml-3 mr-3"><a class="dropdown-item nav-link text-secondary "
									href="<c:url value='/logout'/>">Вийти</a></li>
							</ul></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link text-info text-center ml-2" href="<c:url value='/logIn'/>">Увійти</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>