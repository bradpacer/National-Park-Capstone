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
</head>

<body>

<div class="container">
	<div class="row">
		<div class="col-3">
			<a href="${homeUrl}">
				<img src="${logo}" class="img-fluid"/>
			</a>
		</div>
	</div>
	
</div>

<nav class="navbar navbar-expand-lg navbar-light bg-success text-light">
	<div class="container">
		<div class="navbar-nav">
      <a class="nav-item nav-link" href="${homeUrl }">Home</a>
      <a class="nav-item nav-link" href="${surveyUrl}">Survey</a>
    </div>
	</div>
</nav>



<div class="container-fluid container-main">