<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Affichage de toutes les réservations</title>
</head>
<body>
<P>
    <A href="index.htm"><FONT face="Arial" color="#004080">Retour
        Accueil</FONT></A>
</P>
<P align="center">
    <FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
        réservations </STRONG></U></FONT>
</P>

<TABLE BORDER="1">
    <CAPTION>Tableau des réservations</CAPTION>
    <TR>
        <TH>Oeuvre</TH>
        <TH>Adhérent</TH>
        <TH>Date</TH>
        <TH>Statut</TH>
        <TH>Modifier</TH>
        <TH>Supprimer</TH>
        <TH>Confirmer</TH>
    </TR>

    <c:forEach items="${reservations}" var="reservation">
        <tr>
            <td>${reservation.oeuvrevente.titreOeuvrevente}</td>
            <td>${reservation.adherent.nomAdherent}</td>
            <td>${reservation.dateDisplayed}</td>
            <td>${reservation.statut}</td>
            <td><a href="modifierReservation.htm?iOeuvre=${reservation.oeuvrevente.idOeuvrevente}&idAdherent=${reservation.adherent.idAdherent}"><font face="Arial">Modifier une réservation</font></a><font face="Arial"> </font></td>
            <td><a href="supprimerReservation.htm?iOeuvre=${reservation.oeuvrevente.idOeuvrevente}&idAdherent=${reservation.adherent.idAdherent}"><font face="Arial">Supprimer une réservation</font></a><font face="Arial"> </font></td>
            <td><a href="confirmerReservation.htm?iOeuvre=${reservation.oeuvrevente.idOeuvrevente}&idAdherent=${reservation.adherent.idAdherent}"><font face="Arial">Confirmer la réservation</font></a><font face="Arial"> </font></td>
        </tr>
    </c:forEach>
</TABLE>
</body>
</html>