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
                                    <h4 class="title">Ajouter une oeuvre</h4>
                                </div>
                                <div class="content">
                                    <form name='identification' method="post" action="insererOeuvre.htm">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Titre</label>
                                                    <input type="text" class="form-control" placeholder="Titre de l'oeuvre" name="txttitre" id="title" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Prix</label>
                                                    <span class="input-group-addon">€</span>
                                                    <input type="number" class="form-control" name="numPrix" id="price" min="0" value="0" step="0.01" required>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>État</label>
                                                    <select name="etat" required>
                                                        <option selected="true" disabled="disabled" value="L">Choisir un état</option>
                                                        <option value="L">L</option>
                                                        <option value="R">R</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Propritétaire</label>
                                                    <select name="proprietaire" required>
                                                        <option selected="true" disabled="disabled" value="L">Choisir un propriétaire</option>
                                                        <c:forEach items="${proprietaires}" var="item">
                                                            <option value="${item.idProprietaire}">${item.nomProprietaire}</option>
                                                        </c:forEach>
                                                    </select>
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
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="assets/js/light-bootstrap-dashboard.js"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>

</html>