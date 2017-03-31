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
                                    <form name='identification' method="post" action="insererReservation.htm">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <select name="oeuvre" required>
                                                        <label>Oeuvre</label>
                                                        <option selected="true" disabled="disabled" value="">Choisir une oeuvre</option>
                                                        <c:forEach items="${oeuvres}" var="item">
                                                            <option value="${item.idOeuvrevente}">${item.titreOeuvrevente}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Date de réservation</label>
                                                    <input type='text' class="form-control" name="dateReservation" id='datepicker' required/>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Adhérent</label>
                                                    <select name="adherent" required>
                                                        <option selected="true" disabled="disabled" value="L">Choisir un adhérent</option>
                                                        <c:forEach items="${adherents}" var="item">
                                                            <option value="${item.idAdherent}">${item.nomAdherent}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <button type="submit" class="btn btn-info btn-fill pull-right" name="bt">Ajouter</button>
                                        <a href="home.htm"><button class="btn btn-warning btn-fill pull-right" name="bt">Annuler</button></a>
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
    <%@include file="snippets/scripts.jsp" %>

    <script src="<c:url value="/resources/js/moment.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery-ui.min.js" />" type="text/javascript"></script>

    <script type="text/javascript">
        $( function() {
            $( "#datepicker" ).datepicker({ dateFormat: 'dd/mm/yy' });
        } );
    </script>
</html>