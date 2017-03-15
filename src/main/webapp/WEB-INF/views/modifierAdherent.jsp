<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modifier un  adhérent</title>
</head>
<SCRIPT language="Javascript" type="text/javascript">
    <script type="text/javascript" src="js/foncControle.js"></script>


<body>
<H1> Modification d'un adhérent </H1>

<DIV align="center">
    <FORM  name='identification' method="post" action="modifierAdherentDB.htm" onsubmit="return teste()">
        <c:set var="adherant"  scope="page" />
        <P align="left"><FONT face="Arial" color="#004080"></FONT>
            <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Nom de l'adherent : </FONT>
            <INPUT type="text" name="txtnom" value=${adherant.nomAdherent}  id ="nom"> <BR>
            <FONT face="Arial" color="#004080"> <BR>Prenom de l'adherent : </FONT>
            <INPUT type="text" name="txtprenom"  id ="prenom" value=${adherant.prenomAdherent} > <BR>

            <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Ville de l'adherent :</FONT>
            <INPUT type="text" name="txtville" id ="ville" value=${adherant.villeAdherent}>
            <FONT face="Arial" color="#004080">	<BR></FONT><BR>

            <input type="HIDDEN" name="id" value=${adherant.idAdherent} s>

            <INPUT type="submit" name="annuler"  value="Annuler">
            <INPUT type="submit" name="bt"  value="Modifier" >
            <FONT face="Arial" color="#004080"></FONT>
            &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </P>
    </FORM>
</DIV>
<BR>
</body>
</html>