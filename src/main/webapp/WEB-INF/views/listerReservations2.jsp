<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                                <h4 class="title">Liste des réservations</h4>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>Oeuvre</th>
                                    	<th>Adhérent</th>
                                    	<th>Date</th>
                                    	<th>Statut</th>
                                    	<th>Options</th>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${reservations}" var="reservation">
                                            <tr>
                                                <td>${reservation.oeuvrevente.titreOeuvrevente}</td>
                                                <td>${reservation.adherent.nomAdherent}</td>
                                                <td>${reservation.dateDisplayed}</td>
                                                <td>${reservation.statut}</td>
                                                <td>
                                                    <a href="modifierReservation2.htm?iOeuvre=${reservation.oeuvrevente.idOeuvrevente}&idAdherent=${reservation.adherent.idAdherent}"><button class="btn btn-warning"><i class="pe-7s-edit"></i> Modifier</button></a>
                                                    <a href="supprimerReservation.htm?iOeuvre=${reservation.oeuvrevente.idOeuvrevente}&idAdherent=${reservation.adherent.idAdherent}"><button class="btn btn-danger"><i class="pe-7s-trash"></i> Supprimer</button></a>
                                                    <c:choose>
                                                        <c:when test="${reservation.statut != 'confirmee'}">
                                                            <a href="confirmerReservation.htm?iOeuvre=${reservation.oeuvrevente.idOeuvrevente}&idAdherent=${reservation.adherent.idAdherent}"><button class="btn btn-success"><i class="pe-7s-like2"></i> Confirmer</button></a>
                                                        </c:when>
                                                    </c:choose>
                                                 </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <a href="ajouterReservation2.htm">
                            <button class="btn btn-info btn-fill btn-block"><i class="pe-7s-plus"></i> Ajouter une réservation</button>
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