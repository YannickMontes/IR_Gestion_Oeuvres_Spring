<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Réserver une oeuvre</title>
</head>


<body>
<H1> Réserver une oeuvre </H1>

<DIV align="center">
    <FORM name='identification' method="post" action="insererReservation.htm">
        <P align="left"><FONT face="Arial" color="#004080"></FONT>
            <FONT face="Arial" color="#004080"> <BR>&nbsp; &nbsp; &nbsp; Oeuvre : </FONT>
            <select name="oeuvre" >
                <c:forEach items="${oeuvres}" var="item">
                    <option value="${item.idOeuvrevente}">${item.titreOeuvrevente}</option>
                </c:forEach>
            </select>

            <FONT face="Arial" color="#004080">
            <BR>Date de réservation : </FONT>
            <input type="date" name="dateReservation">
            <BR>

            <FONT face="Arial" color="#004080"> <BR>&nbsp; &nbsp; &nbsp; Propriétaire :</FONT>
            <select name="adherent" >
                <c:forEach items="${adherents}" var="item">
                    <option value="${item.idAdherent}">${item.nomAdherent}</option>
                </c:forEach>
            </select>
            <FONT face="Arial" color="#004080"> <BR></FONT><BR>

            <!-- Boutons Ajouter -->
            <INPUT type="submit" name="bt" value="Ajouter">
            <FONT face="Arial" color="#004080"></FONT>
            &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        </P>
    </FORM>
</DIV>
<BR>
</body>
</html>