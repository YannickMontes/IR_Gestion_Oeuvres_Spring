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
                                    <h4 class="title">Modifier une oeuvre</h4>
                                </div>
                                <div class="content">
                                    <form name='identification' method="post" action="modifierOeuvreDB.htm">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Titre</label>
                                                    <input type="hidden" name="id" value=${oeuvre.idOeuvrevente} />
                                                    <input type="text" class="form-control" value="${oeuvre.titreOeuvrevente}" name="txttitre" id="title" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Prix (€)</label>
                                                    <input type="number" class="form-control" name="numPrix" id="price" min="0" step="0.01" value="${oeuvre.prixOeuvrevente}" required>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>État</label>
                                                    <select name="etat" required>
                                                        <c:choose>
                                                            <c:when test="${oeuvre.etatOeuvrevente=='L'}">
                                                                <option value="L" selected>L</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="L">L</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <c:choose>
                                                            <c:when test="${oeuvre.etatOeuvrevente=='R'}">
                                                                <option value="R" selected>R</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="R">R</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Propritétaire</label>
                                                    <select name="proprietaire" required>
                                                        <c:forEach items="${proprietaires}" var="item">
                                                            <c:choose>
                                                                <c:when test="${item.idProprietaire==oeuvre.proprietaire.idProprietaire}">
                                                                    <option value="${item.idProprietaire}" selected>${item.nomProprietaire}</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="${item.idProprietaire}">${item.nomProprietaire}</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <button type="submit" class="btn btn-info btn-fill pull-right" name="bt">Modifier</button>
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

</html>