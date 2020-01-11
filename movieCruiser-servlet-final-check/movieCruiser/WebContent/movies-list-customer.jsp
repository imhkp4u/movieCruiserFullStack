<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie List Customer</title>
<link rel="stylesheet" href="styles/style.css">
<script src="js/script.js"></script>
</head>
<body>

	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movieCruiser.png"> <a href="ShowFavourites">Favorites</a>
		<a href="ShowMoviesListCustomer">Movies</a>
	</div>
	<h1>Movies</h1>
	<c:if test="${addFavouritesStatus }">
		<h3>Movie Added to Favourites Successfully</h3>
	</c:if>

	<table class="table">
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${moviesList}" var="movies">
			<tr>
				<td><c:out value="${movies.title}" /></td>
				<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
						value="${movies.gross}" type="currency" /></td>
				<td><c:out value="${movies.genre}" /></td>
				<td><c:if test="${movies.hasTeaser eq 'true'}">Yes</c:if> <c:if
						test="${movies.hasTeaser eq 'false'}">No</c:if></td>
				<td><a href="AddToFavourites?id=${movies.id }">Add To
						Favourites</a></td>
			</tr>
		</c:forEach>

	</table>

	<div class="footer">
		<p>Copyright &copy; 2019</p>
	</div>
</body>
</html>