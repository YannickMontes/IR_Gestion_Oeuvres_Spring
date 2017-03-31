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
                        <div class="card ">
                            <div class="header">
                                <h4 class="title">Erreur</h4>
                            </div>
                            <div class="content">
                                <input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
                                <p class="text-danger" id="descErreur">
                                    Une erreur s'est produite :
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <<a href="home.htm">
                        <button class="btn btn-info btn-fill btn-block">Retour accueil</button>
                    </a>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="snippets/footer.jsp" %>
    </div>
</div>


</body>

<%@include file="snippets/scripts.jsp" %>

<script type="text/javascript">
    $( function()
        {
            var obj = $( "#id_erreur" )
            if (obj.value!= '') {
                $( "#descErreur" ).append(obj.value)
            }
        }
    );
</script>

</html>