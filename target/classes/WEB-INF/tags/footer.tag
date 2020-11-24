<%@tag pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.fa {
	padding: 15px;
	font-size: 23px;
	width: 23px;
	height: 23px;
	text-align: center;
	text-decoration: none;
	margin: 5px 2px;
	border-radius: 50%;
	box-sizing: unset;
}

#facebook:hover {
	transition: 0.3s;
	opacity: 0.6;
	padding: 17px;
	font-size: 26px;
	width: 26px;
	height: 26px;
}

#telegram:hover {
	transition: 0.3s;
	opacity: 0.6;
	padding: 17px;
	font-size: 26px;
	width: 26px;
	height: 26px;
}

#instagtam:hover {
	transition: 0.3s;
	opacity: 0.6;
	padding: 17px;
	font-size: 26px;
	width: 26px;
	height: 26px;
}

#facebook {
	background: #3B5998;
	color: white;
}

#telegram {
	background: #55ACEE;
	color: white;
}

#instagtam {
	background: #eb4924;
	color: white;
}
</style>

<footer class="page-footer font-small bg-dark special-color-dark pt-4">

	<!-- Footer Elements -->
	<div class="container">

		<!-- Social buttons -->
		<ul class="list-unstyled list-inline text-center">
			<li class="list-inline-item"><a
				href="https://www.facebook.com/such.network/" target="_blank" class="btn"> <i id="facebook"
					class="fa fa-facebook"> </i>
			</a></li>
			<li class="list-inline-item"><a href="https://t.me/suchmedia" target="_blank"
				class="btn"> <i id="telegram" class="fa fa-telegram" aria-hidden="true"> </i>
			</a></li>
			<li class="list-inline-item"><a
				href="https://instagram.com/such.media?igshid=eln4jwnkkyzt" target="_blank"
				class="btn"> <i id="instagtam" class="fa fa-instagram"> </i>
			</a></li>
		</ul>
		<!-- Social buttons -->

	</div>
	<!-- Footer Elements -->

	<!-- Copyright -->
	<div class="footer-copyright text-muted text-center py-3">
		© 2020 Всі права захищені: <a class="text-info" href="<c:url value='/'/>"
			style="text-decoration: none;"> ukrsuch.heroku.com</a>
	</div>
	<!-- Copyright -->

</footer>
<!-- Footer -->