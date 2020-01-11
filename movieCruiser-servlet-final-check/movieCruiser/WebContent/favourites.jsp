<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Favourites</title>
</head>
<body onload="addColumn()">

	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movieCruiser.png"> <a href="ShowFavourites">Favorites</a>
		<a href="ShowMoviesListCustomer">Movies</a>
	</div>
	<h1>Favorites</h1>
	<c:if test="${message }">
		<h3>Movie removed from Favourites Successfully</h3>
	</c:if>
	<span id="span"></span>

	<table id="table_id">
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Genre</th>
			<th></th>
		</tr>
		<c:forEach items="${favourites.movieList }" var="movies">
			<tr>
				<td>${movies.title }</td>
				<td>$ <fmt:formatNumber value="${movies.gross}"
						pattern="#,##,##,##,###" />
				</td>
				<td>${movies.genre}</td>
				<td><a href="RemoveFavourites?id=${movies.id }">Delete</a></td>
			</tr>
		</c:forEach>

		<tr>
			<td></td>
			<td class="total">Total no. of favourites</td>
			<td class="total">${favourites.total }</td>
			<td></td>
		</tr>

	</table>

	<div class="footer">
		<p>Copyright &copy; 2019</p>
	</div>
</body>
</html>