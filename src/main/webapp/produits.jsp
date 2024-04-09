<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PharmacyAdmin</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>

<%@ include file="header.jsp"%>
<div class="container col-md-10 col-md-offset-1" >
    <div class="panel panel-primary" style="border: 2px solid #58958E;">
        <div class="panel-heading" style="background-color: #58958E;">Recherche des produits</div>
        <div class="panel-body">
            <form action="chercher.php" method="get">
<!--                 <label>Recherche :</label> -->
                <input type="text" name="motCle"/>
                <button type="submit" class="btn btn-primary" style="background-color: #58958E; padding: 3px 7px;">Chercher</button>
            </form>
            <table class="table" style="margin-top:12px;">
                <thead>
                    <tr>
                        <th>ID</th> <th>Article</th> <th>Quantite</th> <th>Prix</th> <th>discription</th> 
                    </tr>
                </thead>
                <tbody>
 <c:forEach items="${model.produits}" var="p">

        <tr>
            <td>${p.id_produit}</td>
            <td>${p.nom_article}</td>
            <td>${p.quantite}</td>
            <td>${p.prix}</td>
            <td>${p.discription}</td>
           
        </tr>
 
</c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
