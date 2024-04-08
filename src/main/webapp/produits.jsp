<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PharmacyAdmin</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>


<p>
<div class= "container col-md-10 col-md-offset-1" >

<div class="panel panel-primary" >
<div class="panel-heading"> Recherche des produit</div>
<div class="panel-body">
<form action="chercher.do" method ="get">
<label></label>
<input type="text" name ="motCle"/>
<button type="submit" class="btn btn-primary">Chercher</button>

</form>

</div>

</div>

</div>

</body>
</html>