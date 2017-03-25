<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajouter un adhérent</title>
</head>


<body>
<H1> Ajout d'une oeuvre </H1>

<DIV align="center">
    <FORM name='identification' method="post" action="insererOeuvre.htm">
        <P align="left"><FONT face="Arial" color="#004080"></FONT>
            <FONT face="Arial" color="#004080"> <BR>&nbsp; &nbsp; &nbsp; Titre de l'oeuvre : </FONT>
            <INPUT type="text" name="txttitre" value="" id="title"> <BR>

            <FONT face="Arial" color="#004080">
            <BR>Prix de l'oeuvre : </FONT>
            <input type="number" name="numPrix" id="price" min="0" value="0" step="0.01">
            <BR>

            <FONT face="Arial" color="#004080"> <BR>&nbsp; &nbsp; &nbsp; État :</FONT>
            <select name="etat" >
                <option value="L">L</option>
                <option value="R">R</option>
            </select>
            <BR>

            <FONT face="Arial" color="#004080"> <BR>&nbsp; &nbsp; &nbsp; Propriétaire :</FONT>
            <select name="proprietaire" >
                <c:forEach items="${proprietaires}" var="item">
                    <option value="${item.idProprietaire}">${item.nomProprietaire}</option>
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