<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modifier une réservation</title>
</head>


<body>
<H1> Modifier une réservation </H1>

<DIV align="center">
    <FORM name='identification' method="post" action="modifierReservationDB.htm">
        <P align="left"><FONT face="Arial" color="#004080"></FONT>
            <FONT face="Arial" color="#004080"> <BR>&nbsp; &nbsp; &nbsp; Oeuvre : ${reservation.oeuvrevente.titreOeuvrevente}</FONT>
            <input type="HIDDEN" name="oeuvre" value=${reservation.oeuvrevente.idOeuvrevente} s>

            <FONT face="Arial" color="#004080">
            <BR>Date de réservation : </FONT>
            <input type="date" name="dateReservation" value="${reservation.date}">
            <BR>

            <FONT face="Arial" color="#004080"> <BR>&nbsp; &nbsp; &nbsp; Adhérent : ${reservation.adherent.nomAdherent}</FONT>
            <input type="HIDDEN" name="adherent" value=${reservation.adherent.idAdherent} s>
            <FONT face="Arial" color="#004080"> <BR></FONT><BR>

            <!-- Boutons Ajouter -->
            <INPUT type="submit" name="bt" value="Modifier">
            <FONT face="Arial" color="#004080"></FONT>
            &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        </P>
    </FORM>
</DIV>
<BR>
</body>
</html>