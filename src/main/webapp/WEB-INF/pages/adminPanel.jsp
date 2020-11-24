<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>admin article</title>

</head>

<body>
	<h1>Add article to Сучукрліт</h1>
	<form method="post" action="admin_panel_7355608_articles" enctype="multipart/form-data">
		Выберите фото 700х350 (желательно): <input type="file" name="file" accept=".png, .jpg, .jpeg" /><br />
		Введите оглавление статьи: <input type="text" name="title" /><br />
		Введите содержимое статьи: <input type="text" name="description" /><br />
		Введите имя автора статьи: <input type="text" name="autorName" /><br />
		<input type="submit" value="Upload" />
	</form>

</body>

</html>
