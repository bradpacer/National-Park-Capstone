<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="css" value="css/style.css"/>
<c:url var="logo" value="img/logo.png"/>
<c:url var="homeUrl" value="/"/>
<c:url var="surveyUrl" value="/survey"/>

<!doctype html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>${param.pageTitle}</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	
	<link rel="stylesheet" href="${css}">
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</head>

<body>
	<div class="header">
		<div class="container header-container">
			<div class="row">
				<div class="col-3">
					<a href="${homeUrl}"> <img src="${logo}" class="img-fluid" />
					</a>
				</div>
			</div>
	
		</div>
		<nav class="navbar navbar-expand-lg navbar-light bg-success text-light">
			<div class="container">
			<a href="${homeUrl}" class="mobile-logo-link"> <img src="${logo}" class="img-fluid"/>
					</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#main-nav"
					aria-controls="main-nav" aria-expanded="false">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="main-nav">
					<div class="navbar-nav">
						<a class="nav-item nav-link" href="${homeUrl }">Home</a> <a
							class="nav-item nav-link" href="${surveyUrl}">Survey</a>
					</div>
				</div>
			</div>
		</nav>
	</div>
	



	<div class="container-fluid container-main">