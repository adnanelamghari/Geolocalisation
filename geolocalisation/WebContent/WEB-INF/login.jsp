
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>PhD easy - Se connecter</title>
  <!-- Bootstrap core CSS-->
  <link rel="shortcut icon" href="./icons/easy.ico" type="image/x-icon" />
  <!-- Bootstrap core CSS-->
  <link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="./vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="./css/sb-admin.css" rel="stylesheet">
</head>
<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header" style="text-align: center;">Connexion</div>
      <div class="card-body">
      	<c:if test="${ !empty message }"><p class="text-danger"><c:out value="${ message }"/></p></c:if>
        <form method="POST" name="login" action="./login">
          <div class="form-group">
            <label for="exampleInputEmail1">Pseudo</label>
            <input class="form-control" id="exampleInputEmail1" name="username" type="text" placeholder="Entrer Votre Pseudo" required>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Mot de Passe</label>
            <input class="form-control" id="exampleInputPassword1" type="password" name="password" placeholder="Entrer Votre Mot de Passe" required>
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox">Mémoriser Mon Mot de Passe</label>
            </div>
          </div>
          <input class="btn btn-primary btn-block" type="submit" value="Se Connecter">
          <a class="btn btn-primary btn-block" href="./index">Poursuivre Sans Connexion</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="./nouveau">Créer un Compte</a>
          <a class="d-block small" href="./mdpsoublie">Mot de Passe Oublié?</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="./vendor/jquery/jquery.min.js"></script>
  <script src="./vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="./vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
