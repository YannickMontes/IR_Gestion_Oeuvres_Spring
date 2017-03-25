<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Affichage de toutes les oeuvres</title>
</head>
<body>
<P>
    <A href="index.htm"><FONT face="Arial" color="#004080">Retour
        Accueil</FONT></A>
</P>
<P align="center">
    <FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
        Oeuvres </STRONG></U></FONT>
</P>

<TABLE BORDER="1">
    <CAPTION>Tableau des Oeuvres</CAPTION>
    <TR>
        <TH>Numero</TH>
        <TH>Titre</TH>
        <TH>État</TH>
        <TH>Prix</TH>
        <TH>Propriétaire</TH>
        <TH>Modifier</TH>
        <TH>Supprimer</TH>
    </TR>

    <c:forEach items="${mesOeuvres}" var="oeuvre">
        <tr>
            <td>${oeuvre.idOeuvrevente}</td>
            <td>${oeuvre.titreOeuvrevente}</td>
            <td>${oeuvre.etatOeuvrevente}</td>
            <td>${oeuvre.prixOeuvrevente}</td>
            <td>${oeuvre.proprietaire.nomProprietaire}</td>
            <td><a href="modifierOeuvre.htm?id=${oeuvre.idOeuvrevente}"><font face="Arial">Modifier une oeuvre</font></a><font face="Arial"> </font></td>
            <td><a href="supprimerOeuvre.htm?id=${oeuvre.idOeuvrevente}"><font face="Arial">Supprimer une oeuvre</font></a><font face="Arial"> </font></td>
        </tr>
    </c:forEach>
</TABLE>
</body>
</html>