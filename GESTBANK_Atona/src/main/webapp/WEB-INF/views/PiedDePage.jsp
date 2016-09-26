<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="static/css/style_PiedDePage.css" />
<script src="static/js/controller/accueilController.js"> </script>
<title>Pied de Page</title>
</head>
<body>


<hr />
<div id="MyFooter" ng-controller="dateCtrl">
<p>Site créé par Atona©</p> 
<p><strong>{{CurrentDate | date:'dd MMM yyyy'}}</strong></p>
<p>Private Policy | Terms ans Conditions</p></div>


</body>

</html>