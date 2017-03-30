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
                    <div class="col-md-6">
                        <div class="card ">
                            <div class="header">
                                <h4 class="title">Oeuvres</h4>
                                <p class="category">Nombre d'oeuvres dans la base de données</p>
                            </div>
                            <div class="content">
                                <div id="chartActivity" class="ct-chart"></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="card ">
                            <div class="header">
                                <h4 class="title">Adhérents</h4>
                                <p class="category">Nombre d'adhérents dans la base de données</p>
                            </div>
                            <div class="content">
                                <div id="chartActivityd" class="ct-chart"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Réservations</h4>
                                <p class="category">Taux de réservation des oeuvres</p>
                            </div>
                            <div class="content">
                                <div id="chartPreferences" class="ct-chart ct-perfect-fourth"></div>

                                <div class="footer">
                                    <div class="legend">
                                        <i class="fa fa-circle text-info"></i> Libres
                                        <i class="fa fa-circle text-danger"></i> Réservés
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="snippets/footer.jsp" %>
    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="resources/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Charts Plugin -->
	<script src="resources/js/chartist.min.js"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="resources/js/light-bootstrap-dashboard.js"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="resources/js/demo.js"></script>

</html>
