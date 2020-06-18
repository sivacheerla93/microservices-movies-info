<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movies Information</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript">
	function getMovies() {
		$("#moviesList").html("");
		$("#moviesDetails").html("");
		var movieName = $("#movieName").val();
		$.getJSON("/search/" + movieName, function(data) {
			if (data.total_results == 0) {
				$("#moviesList").html("<h2>No movies found! Try again!!");
			} else {
				var ul = "<ul>";
				$.each(data.results, function(i, movie) {
					ul = ul + "<li><a href = '#' onclick = getMovieDetails("
							+ movie.id + ")>" + movie.id + "</a> --- "
							+ movie.title + " --- " + movie.original_language
							+ "</li>";
				});
				ul = ul + "</ul>";
				$("#moviesList").html(ul);
			}
		});
	}

	function getMovieDetails(movieId) {
		$("#moviesDetails").html("");
		$.getJSON("/details/" + movieId, function(data) {
			var ul = "<ul>";
			ul = ul + "<li>Id: " + data.id + "</li>";
			ul = ul + "<li>Title: " + data.title + "</li>";
			ul = ul + "<li>Overview: " + data.overview + "</li>";
			ul = ul + "<li>Release date: " + data.release_date + "</li>";
			ul = ul + "<li>Status: " + data.status + "</li>";
			ul = ul + "<li>Runtime: " + data.runtime + "</li>";
			ul = ul + "<li>Vote average: " + data.vote_average + "</li>";
			ul = ul + "<li>Vote count: " + data.vote_count + "</li>";
			ul = ul + "</ul>";
			$("#moviesDetails").html(ul);
		});
	}
</script>
</head>
<body>
	<div class="container" style="margin-top: 20px;">
		<div class="row">
			<div class="col-md-9 form-group">
				<label for="usr">Enter a movie name:</label> <input type="text"
					class="form-control" id="movieName">
			</div>
			<div class="col-md-3" style="margin-top: 25px;">
				<button type="button" class="btn btn-primary" onclick="getMovies();">Search
					Movies</button>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<h2>
					<u>Movie results</u>
				</h2>
				<div id="moviesList"></div>
			</div>
			<div class="col-md-6">
				<h2>
					<u>Movie details</u>
				</h2>
				<div id="moviesDetails"></div>
			</div>
		</div>
	</div>
</body>
</html>