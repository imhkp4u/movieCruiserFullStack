<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Movies</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movieCruiser.png"> <a href="ShowFavourites">Favorites</a>
		<a href="ShowMoviesListCustomer">Movies</a>
	</div>
	<div id="noItems">
		<h1>Favorites</h1>
		<h4>
			No movies in Favorites. Use 'Add to Favorite' option in <a
				href="ShowMoviesListCustomer">Movie List</a>
		</h4>
	</div>
	<div class="footer">
		<p>Copyright &copy; 2019</p>
	</div>
</body>
</html>