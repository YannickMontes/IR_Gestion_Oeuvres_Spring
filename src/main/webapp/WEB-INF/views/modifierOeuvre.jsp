<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modifier une oeuvre</title>
</head>
<SCRIPT language="Javascript" type="text/javascript">
    <script type="text/javascript" src="js/foncControle.js"></script>


<body>
<H1> Modification d'une oeuvre </H1>

<DIV align="center">
    <FORM name='identification' method="post" action="/modifierOeuvreDB.htm">
        <P align="left"><FONT face="Arial" color="#004080"></FONT>
            <FONT face="Arial" color="#004080"> <BR>&nbsp; &nbsp; &nbsp; Titre de l'oeuvre : </FONT>
            <INPUT type="text" name="txttitre" value=${oeuvre.titreOeuvrevente} id="title"> <BR>

            <FONT face="Arial" color="#004080">
                <BR>Prix de l'oeuvre : </FONT>
            <input type="number" name="numPrix" id="price" min="0" value="${oeuvre.prixOeuvrevente}" step="0.01">
            <BR>

            <FONT face="Arial" color="#004080"> <BR>&nbsp; &nbsp; &nbsp; État :</FONT>
            <select name="etat" >
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
            <BR>

            <FONT face="Arial" color="#004080"> <BR>&nbsp; &nbsp; &nbsp; Propriétaire :</FONT>
            <select name="proprietaire" >
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
            <FONT face="Arial" color="#004080"> <BR></FONT><BR>
            <input type="HIDDEN" name="id" value=${oeuvre.idOeuvrevente} s>

            <!-- Boutons Ajouter -->
            <INPUT type="submit" name="bt" value="Modifer">
            <FONT face="Arial" color="#004080"></FONT>
            &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        </P>
    </FORM>
</DIV>
<BR>
</body>
</html>