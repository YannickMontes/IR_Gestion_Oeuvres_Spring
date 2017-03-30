<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="fr">
<head>
    <%@include file="snippets/header.jsp" %>
</head>
<body>

<div class="wrapper">
    <%@include file="snippets/sidebar.jsp" %>

    <div class="main-panel">
        <%@include file="snippets/navbar.jsp" %>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Liste des adhérents</h4>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>Numero</th>
                                    	<th>Nom</th>
                                    	<th>Prénom</th>
                                    	<th>Ville</th>
                                    	<th>Options</th>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${mesAdherents}" var="item">
                                            <tr>
                                                <td>${item.idAdherent}</td>
                                                <td>${item.nomAdherent}</td>
                                                <td>${item.prenomAdherent}</td>
                                                <td>${item.villeAdherent}</td>
                                                <td>
                                                    <a href="modifierAdherent2.htm?id=${item.idAdherent}"><button class="btn btn-warning"><i class="pe-7s-edit"></i> Modifier</button></a>
                                                    <a href="supprimerAdherent.htm?id=${item.idAdherent}"><button class="btn btn-danger"><i class="pe-7s-trash"></i> Supprimer</button></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <a href="ajouterAdherent2.htm">
                            <button class="btn btn-info btn-fill btn-block"><i class="pe-7s-plus"></i> Ajouter un adhérent</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="snippets/footer.jsp" %>
    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="assets/js/light-bootstrap-dashboard.js"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>


</html>