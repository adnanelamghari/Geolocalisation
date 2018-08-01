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
  <title>PhD easy - Créer un Nouveau compte</title>
  <!-- Bootstrap core CSS-->
  <link rel="shortcut icon" href="./icons/easy.ico" type="image/x-icon" />
  <link href="./css/bootstrap.css" rel="stylesheet">
  <link href="./css/bootstrapValidator.css" rel="stylesheet">
  <link href="./css/bootstrapValidator.min.css" rel="stylesheet">  
  <!-- Bootstrap core CSS-->
  <link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="./vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="./css/sb-admin.css" rel="stylesheet">
</head>
<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Créer Un Nouveau Compte</div>
      <div class="card-body">
      <c:if test="${ !empty message }"><p class="text-danger"><c:out value="${ message }"/></p></c:if>
        <form id="defaultForm" method="POST" action="./nouveau" >
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Nom</label>
                <input class="form-control" name="InputName" type="text" aria-describedby="nameHelp" placeholder="Entrer Votre Nom" required>
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Prénom</label>
                <input class="form-control" name="InputLastName" type="text" aria-describedby="nameHelp" placeholder="Entrer Votre Prénom" required>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Pseudo</label>
            <input class="form-control" name="InputPseudo" type="text" aria-describedby="emailHelp" placeholder="Entrer Votre Pseudo" required>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Mot de Passe</label>
                <input class="form-control" name="InputPassword1" type="password" placeholder="Mot de Passe" required>
              </div>
              <div class="col-md-6">
                <label for="exampleConfirmPassword">Confirmer le Mot de Passe</label>
                <input class="form-control" name="ConfirmPassword" type="password" placeholder="Confirmer le Mot de Passe" required>
              </div>
            </div>
          </div>
          <input class="btn btn-primary btn-block" type="submit" value="Register">
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="./login">Se Connecter</a>
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
  <script src="./js/bootstrapValidator.min.js"></script>
  <script src="./js/bootstrapValidator.js"></script>
  <script type="text/javascript">
  $(document).ready(function() {
      $('#defaultForm').bootstrapValidator({
          message: 'Cette Valeur est invalide',
          feedbackIcons: {
              valid: 'fa fa-check',
              invalid: 'fa fa-remove',
              validating: 'fa fa-refresh'
          },
          fields: {
              InputName: {
                  message: 'Ce Nom est Invalid',
                  validators: {
                      notEmpty: {
                          message: 'Le nom ne doit pas etre vide'
                      }
                  }
              },
              InputLastName: {
                  message: 'Ce Prenom est Invalid',
                  validators: {
                      notEmpty: {
                          message: 'Le prenom ne doit pas etre vide'
                      }
                  }
              },
              InputPseudo: {
                  message: 'Ce Pseudo est invalid',
                  validators: {
                      notEmpty: {
                          message: 'Le pseudo ne doit pas etre vide'
                      },
                      stringLength: {
                          min: 6,
                          max: 50,
                          message: 'Le Pseudo de contenir au moins 6 caractères'
                      },
                      regexp: {
                          regexp: /^[a-zA-Z0-9_\.]+$/,
                          message: 'Le pseudo ne peut contenir que des alphabets, nombres, point ou underscore'
                      }
                  }
              },
              InputPassword1: {
                  validators: {
                      notEmpty: {
                          message: 'Le mot de passe ne doit pas etre vide'
                      },
                      identical: {
                          field: 'ConfirmPassword',
                          message: 'Les deux mots de passe ne sont pas identiques'
                      }
                  }
              },
              ConfirmPassword: {
                  validators: {
                      notEmpty: {
                          message: 'Veillez comfirmer votre mot de passe'
                      },
                      identical: {
                          field: 'Password',
                          message: 'Les deux mots de passe ne sont pas identiques'
                      }
                  }
              }
          }
      });
  });
  </script>
</body>
</html>
