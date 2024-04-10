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
<div class="container col-md-8 col-md-offset-2 col-xs-12" >
    <div class="panel panel-primary" style="border: none;box-shadow: 0 2px 6px rgba(0,0,0,0.1);">
        <div class="panel-heading" style="background-color: #7BAFA9;">Confirmation</div>
        <div class="panel-body">
          
          <div class="form-group">
          <label>ID:</label>
          <label>${produit.id_produit}</label>
          </div>
          
          <div class="form-group">
          <label>Article:</label>
          <label>${produit.nom_article}</label>
          </div>
          
          <div class="form-group">
          <label>Quantite:</label>
          <label>${produit.quantite}</label>
          </div>
          
          <div class="form-group">
          <label>Prix:</label>
          <label>${produit.prix}</label>
          </div>
            
                
        </div>
    </div>
</div>

</body>
</html>
