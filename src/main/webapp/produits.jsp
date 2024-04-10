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
    <div class="panel panel-primary" style="border: none;">
        <div class="panel-heading" style="background-color: #7BAFA9; ">Recherche des produits</div>
        <div class="panel-body">
            <form action="chercher.php" method="get">
<!--                 <label>Recherche :</label> -->
                <input type="text" name="motCle"/>
                <button type="submit" class="btn btn-primary" style="background-color: #7BAFA9; padding: 3px 7px;">Chercher</button>
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
                <td><a href="Edit.php?id=${p.id_produit}"style="color:#86CDB0">Modifier</a></td>
            <td><a  onclick="return confirm('Etes vous sur?')" href="Supprime.php?id=${p.id_produit}" style="color:#86CDB0">Supprimer</a></td>
        
        </tr>
 
</c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<style>
    /* Add hover effect for table rows */
    tbody tr:hover {
        background-color: #F4FAF9;
    }
    
    .panel {
        box-shadow: 0 2px 6px rgba(0,0,0,0.1); /* Modify the values as needed */
    }
</style>

</body>
</html>
