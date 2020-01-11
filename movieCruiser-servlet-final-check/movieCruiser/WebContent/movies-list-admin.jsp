<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie List Admin</title>
<link rel="stylesheet" href="styles/style.css">
<script src="js/script.js"></script>
</head>
<body>

	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movieCruiser.png"> <a href="ShowMoviesListAdmin">Movies</a>
	</div>
	<h1>Movies</h1>

	<table class="table">
		<tr>
			<th>Title</th>
			<th class="currency">Box Office</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${movies}" var="movies">
			<tr>
				<td><c:out value="${movies.title}" /></td>
				<td class="currency">$ <fmt:formatNumber
						value="${movies.gross}" pattern="#,##,##,##,###" /></td>
				<td><c:if test="${movies.active eq 'true'}">Yes</c:if> <c:if
						test="${movies.active eq 'false'}">No</c:if></td>
				<td><fmt:formatDate pattern="dd/MM/yyyy"
						value="${movies.dateOfLaunch}" /></td>
				<td><c:out value="${movies.genre}" /></td>
				<td><c:if test="${movies.hasTeaser eq 'true'}">Yes</c:if> <c:if
						test="${movies.hasTeaser eq 'false'}">No</c:if></td>
				<td><a href="ShowEditMovies?id=${movies.id }">Edit</a></td>
			</tr>
		</c:forEach>
	</table>

	<div class="footer">
		<p>Copyright &copy; 2019</p>
	</div>
</body>
</html>