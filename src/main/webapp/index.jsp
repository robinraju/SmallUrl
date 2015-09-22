<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>smallurl - Shorten URLs</title>
<meta name="description" content="URL Shortener. Make long urls short">
<meta name="author" content="Robin Raju">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/style.css" />
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />

<script src="assets/js/jquery-2.1.4.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery-ui.min.js"></script>
<script src="assets/js/main.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="bg"></div>
		<div id="overlay"></div>
		<div id="main">
			<div align="center" id="header">
				<h2>Shortening URLs got easier than never before..!!</h2>
				<div id="url_form" class="clearfix">
					<input type="text" size="40" maxlength="300"
						placeholder="Paste your Very Very LooooooooooooooooooooooooonG URL"
						id="url_text" />
					<div id="url_button">Shorten</div>
				</div>
				<div class="col-md-12">
					<div id="result-box">
						<h4 id="longurl"></h4>
						<span id="arrow" class="fa fa-3x fa-arrow-down"></span>
						<h1 id="smallurl"></h1>
						<div class="ui-group-buttons">
							<button id="btn-copy" class="btn btn-success">
								<span class="glyphicon glyphicon-copy"></span> Copy
							</button>
							<div class="or"></div>
							<button id="btn-reset" class="btn btn-danger">
								<span class="glyphicon glyphicon-remove"></span> Reset
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
