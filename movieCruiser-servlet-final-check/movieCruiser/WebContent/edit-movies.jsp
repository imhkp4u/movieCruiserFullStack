<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<img src="images/movieCruiser.png"> <a
			href="ShowMoviesListAdmin">Movies</a>
	</div>
	<div class="div_body">
		<h1>Edit Movie</h1>

		<div class="body-content-color">
			<form action="EditMovies" onsubmit="return validateForm()"
				name="editMovie" method="post">
				<div class="form-field-spacing">
					<label for="title">Title</label>
					<div>
						<input type="text" value="${movies.title }" class="name-box"
							name="title" id="title">
					</div>
				</div>
				<div>
					<input type="hidden" name="id" value="${movies.id }">
				</div>
				<div class="form-field-spacing-2">
					<div class="form-field-spacing">
						<label for="gross">Gross ($)</label>
						<div>
							<input type="text" value="${movies.gross }" class="text-box"
								name="gross" id="gross">
						</div>
					</div>
					<div class="form-field-spacing">
						<label for="">Active</label>
						<div>
							<input class="radio" type="radio" name="active" value="Yes"
								<c:if test="${movies.active }">checked </c:if>>Yes <input
								class="radio" type="radio" name="active" value="No"
								<c:if test="${!movies.active }">checked </c:if>>No
						</div>
					</div>

					<div class="form-field-spacing">
						<label for="">Date of Launch</label>
						<div>
							<input type="text" class="text-box" name="dateOfLaunch"
								value="<fmt:formatDate type="date" pattern="dd/MM/yyyy"
                                         value="${movies.dateOfLaunch}" />">
						</div>
					</div>

					<div class="form-field-spacing">
						<label for="">Genre</label>
						<div>
							<select name="genre" class="dropdown" id="genre">
								<option value="${movies.genre }">${movies.genre }</option>
								<option value="Science-Fiction">Science Fiction</option>
								<option value="Superhero">Super-hero</option>
								<option value="Romantic">Romantic</option>
								<option value="Comedy">Comedy</option>
								<option value="Adventure">Adventure</option>
								<option value="Thriller">Thriller</option>
							</select>
						</div>
					</div>

					<div>
						<div class="form-field-spacing" id="has_teaser">
							<c:if test="${movies.hasTeaser }">
								<input type="checkbox" name="hasTeaser" checked>
							</c:if>
							<c:if test="${!movies.hasTeaser }">
								<input type="checkbox" name="hasTeaser">
							</c:if>
							<label for="hasTeaser">Has Teaser</label>
						</div>
					</div>

					<div>
						<div>
							<input type="hidden" name="id" value="${movies.id }">
						</div>
						<input type="submit" class="success-button" value="Save">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<p>Copyright &copy; 2019</p>
	</div>
</body>
</html>