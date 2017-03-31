<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="fr">
<head>
    <%@include file="snippets/header.jsp" %>

    <link href="<c:url value="/resources/css/jquery-ui.theme.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/jquery-ui.min.css" />" rel="stylesheet" />
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
                                    <h4 class="title">Ajouter une réservation</h4>
                                </div>
                                <div class="content">
                                    <form name='identification' method="post" action="modifierReservationDB.htm">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Oeuvre</label>
                                                    <input type='text' class="form-control" disabled="disabled" value="${reservation.oeuvrevente.titreOeuvrevente}"/>
                                                    <input type="hidden" name="oeuvre" value=${reservation.oeuvrevente.idOeuvrevente} />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Date de réservation</label>
                                                    <input type='text' class="form-control" name="dateReservation" id='datepicker' value="${reservation.dateDisplayed}" required/>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Adhérent</label>
                                                    <input type='text' class="form-control" disabled="disabled" value="${reservation.adherent.nomAdherent}"/>
                                                    <input type="hidden" name="adherent" value=${reservation.adherent.idAdherent} />
                                                </div>
                                            </div>
                                        </div>

                                        <button type="submit" class="btn btn-info btn-fill pull-right" name="bt">Ajouter</button>
                                        <a href="home2.htm"><button class="btn btn-warning btn-fill pull-right" name="bt">Annuler</button></a>
                                        <div class="clearfix"></div>
                                    </form>
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
    <script src="<c:url value="/resources/js/jquery.min.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/moment.min.js" />" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="<c:url value="/resources/js/bootstrap-checkbox-radio-switch.js" />" type="text/javascript"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="<c:url value="/resources/js/light-bootstrap-dashboard.js" />" type="text/javascript"></script>





    <script src="<c:url value="/resources/js/jquery-ui.min.js" />" type="text/javascript"></script>

    <script type="text/javascript">
        $( function() {
            $( "#datepicker" ).datepicker({ dateFormat: 'dd/mm/yy' });
        } );
    </script>
</html>