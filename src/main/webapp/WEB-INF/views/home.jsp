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
                                <div id="chartOeuvres" class="ct-chart"></div>

                                <div class="footer">
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-check"></i> Informations en temps réel
                                    </div>
                                </div>
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
                                <div id="chartAdherents" class="ct-chart"></div>

                                <div class="footer">
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-check"></i> Informations en temps réel
                                    </div>
                                </div>
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
                                        <i class="fa fa-circle text-danger"></i> Réservés
                                        <i class="fa fa-circle text-info"></i> Libres
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

<input type="hidden" id="nbOeuvres" value="${nbOeuvres}"/>
<input type="hidden" id="nbAdherents" value="${nbAdherents}"/>
<input type="hidden" id="nbOeuvresLibres" value="${nbOeuvresLibres}"/>

</body>

<%@include file="snippets/scripts.jsp" %>
<script src="<c:url value="/resources/js/chartist.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/custom.js" />" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function(){
        var nbOeuvres = $("#nbOeuvres").val();
        var nbAdherents = $("#nbAdherents").val();
        var nbOeuvresLibres = $("#nbOeuvresLibres").val();

        charts.initChartist(nbOeuvres, nbAdherents, nbOeuvresLibres);
    });
</script>
</html>
