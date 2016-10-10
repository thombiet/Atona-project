<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style_PageAccueil.css">

<title>"Accueil"</title>
</head>
<body ng-app="myApp" >
<div id="bloc_page">
	<header>

		<div id="Presentation">
			<h1>
				Bienvenue chez <br>Gest Bank	
			</h1>
			&nbsp;
			<h2>     &nbsp;   User {{user.role}}</h2>
		</div>
		<div id="logo">
			<img src="<c:url value='/static/images/GestBank_logo.png' />"
				alt="Logo GestBank" height="110px" />
		</div>
	</header>
		
		<div class="Ma_vue">
	<ng-view> </ng-view></div>
	</div>


	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script type="text/javascript" src="<c:url value='/static/bower_components/angular-route/angular-route.js' />"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/config.js' />"></script>
	<script src="<c:url value='/static/js/controller/convert_controller.js' />"></script>
	<script src="<c:url value='/static/js/controller/client_controller.js' />"></script>
	<script src="<c:url value='/static/js/service/client_service.js' />"></script>
	<jsp:include page="PiedDePage.jsp"></jsp:include>
</body>


</html>
