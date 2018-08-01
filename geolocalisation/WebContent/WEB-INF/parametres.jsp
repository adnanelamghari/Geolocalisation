<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>PhD easy - Parametres de compte</title>
  <!-- Bootstrap core CSS-->
  <link rel="shortcut icon" href="./icons/easy.ico" type="image/x-icon" />
  <!-- Bootstrap core CSS-->
  <link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="./vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="./vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="./css/sb-admin.css" rel="stylesheet">
  <link href="./css/style.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="./css/datepicker.min.css">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="./index"><img src="./icons/logo.svg" height="30"></a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="./index">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Accueil</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="./recherches">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">Recherches</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
          <a class="nav-link" href="./parametres">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Parametres de compte</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
          <a class="nav-link" href="./utilisateurs">
            <i class="fa fa-users"></i>
            <span class="nav-link-text">Utilisateurs du Site</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-file"></i>
            <span class="nav-link-text">Autres</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseComponents">
            <li>
              <a href="./login">Page de connexion</a>
            </li>
            <li>
              <a href="./nouveau">Créer un compte</a>
            </li>
            <li>
              <a href="./login">Mot de passe Oublié</a>
            </li>
          </ul>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
          <a class="nav-link" href="https://ensias.um5s.ac.ma">
            <i class="fa fa-fw fa-link"></i>
            <span class="nav-link-text">Site de L'ENSIAS</span>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <c:if test="${!empty sessionScope.doctorant}"> 
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-envelope"></i>
            <span class="d-lg-none">Messages
              <span class="badge badge-pill badge-primary">Nouveaux</span>
            </span>
            <span class="indicator text-primary d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="messagesDropdown">
            <h6 class="dropdown-header">Nouveaux Messages:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>David Miller</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">Hey there! This new version of SB Admin is pretty awesome! These messages clip off when they reach the end of the box so they don't overflow over to the sides!</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>Jane Smith</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">I was wondering if you could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>John Doe</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">I've sent the final files over to you for review. When you're able to sign off of them let me know and we can discuss distribution.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">Voir tout les messages</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-bell"></i>
            <span class="d-lg-none">Notifications
              <span class="badge badge-pill badge-warning">Nouveaux</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="alertsDropdown">
            <h6 class="dropdown-header">Notifications:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="./parametres">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">PhD easy</span>
              <div class="dropdown-message small">Merci de bien Vouloir remplir vos informations personnelles.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="./profile">
              <span class="text-danger">
                <strong>
                  <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">PhD easy</span>
              <div class="dropdown-message small"> Bienvenu sur votre espace PhD easy</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">Voir toutes les notifications</a>
          </div>
        </li>
        </c:if>
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Chercher..">
              <span class="input-group-btn">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <c:if test="${!empty sessionScope.doctorant}"> 
          <li class="nav-item">
            <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
              <i class="fa fa-fw fa-sign-out"></i>Se deconnecter</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="./profile">
              <img src="./profil_pics/<c:out value='${!empty doctorant.pictureName ? doctorant.pictureName : "no-img-user.png"}' />" width="30" height="30" class="rounded-circle hvr-pulse-grow"></a>
          </li>
        </c:if>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
<div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="./index">Page d'Accueil</a>
        </li>
        <li class="breadcrumb-item active">Parametres du Profil</li>
      </ol>
      <div class="row">
        <div class="col-12">
          <h1>Bienvenue <c:if test="${!empty sessionScope.doctorant}"> <c:out value="${doctorant.prenom}"/> <c:out value="${doctorant.nom}"/> </c:if> sur PhD easy</h1>
          <p>
            <c:if test="${!empty sessionScope.doctorant}"> <i class="fa fa-quote-left"></i> <c:out value="${doctorant.biographie}"/> <i class="fa fa-quote-right"></i></c:if>   
          </p>
        </div>
      </div>
      <div class="row row-eq-height">
        <div class="col-lg-4">
          <!-- Example Pie Chart Card-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-ellipsis-v fa-lg"></i><span style="margin-left: 2px;"> LES RÉGLAGES PRINCIPAUX</span></div>
              <div class="list-group" id="list">  
                  <span class="list-group-item choix active" id="profil-button"><i class="fa fa-user "></i> Mes informations du profil</span>
                  <span class="list-group-item choix" id="mdps-button"><i class="fa fa-lock "></i> Mon mot de passe</span>
                  <span class="list-group-item choix" id="tele-button" ><i class="fa fa-envelope "></i> Email et téléphone</span>
                  <span class="list-group-item choix" id="biographie-button"><i class="fa fa-newspaper-o"></i> Ma biographie</span>
                  <span class="list-group-item choix" id="diplome-button"><i class="fa fa-graduation-cap"></i> Mes diplômes et expériences</span>
                  <span class="list-group-item choix" id="social-media-button"><i class="fa fa-globe"></i> Mes médias sociaux </span>
                  <span class="list-group-item choix" id="parametre-button"><i class="fa fa-shield"></i> Paramètres de confidentialité </span>
                  <span class="list-group-item choix" id="parametres-generale-button"><i class="fa fa-language"></i> Paramètres généraux </span> 
            </div>
          </div>
        </div>
        <div class="col-lg-8">
          <!-- Example Bar Chart Card-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-cog fa-lg"></i><span> MODIFICATION DE PROFIL</span><hr>
              <div class="card-body">
                <form id="dateRangeForm" method="POST" action="./parametres" data-fv-framework="bootstrap" data-fv-icon-valid="fa fa-check" data-fv-icon-invalid="fa fa-times" data-fv-icon-validating="fa fa-refresh" enctype="multipart/form-data">
                  <div id="mdps-panel" style="display: none;">
                    <center style="color: blue" ><i class="fa fa-lock"></i> PARAMÈTRES DE MOT DE PASSE</center>
                    <div class="form-group">
                      <label for="InputPseudo">Pseudo</label>
                      <input class="form-control" id="InputPseudo" name="InputPseudo" value='<c:out value="${doctorant.userName}"/>' aria-describedby="basic-addon1" disabled="true" type="text">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputPassword-old">Ancien Mot de Passe</label>
                      <input class="form-control" id="exampleInputPassword-old" name="InputPassword-old" type="password">
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                        <div class="col-md-6">
                          <label for="exampleInputPassword1">Nouveau Mot de Passe</label>
                          <input class="form-control" id="exampleInputPassword1" name="InputPasswordNew1" type="password" placeholder="Nouveau Mot de Passe">
                        </div>
                        <div class="col-md-6">
                          <label for="exampleConfirmPassword">Confirmer le Mot de Passe</label>
                          <input class="form-control" id="exampleConfirmPassword" name="InputPasswordNew2" type="password" placeholder="Confirmer le Mot de Passe" data-fv-identical="true" data-fv-identical-field="InputPasswordNew1" data-fv-identical-message="Les deux Mots de passe ne sont pas identiques">
                        </div>
                      </div>
                    </div>
                  </div>
                  <div id="diplome-panel" style="display: none;">
                    <center style="color: blue" ><i class="fa fa-graduation-cap fa-lg"></i> MES DIPLÔMES ET EXPERIENCES</center>
                    <div class="form-group">
                      <label for="InputIntitule">Intitulé</label>
                      <input class="form-control" id="InputIntitule" name="InputIntitule" type="text">
                    </div>
                    <div class="form-group">
                      <label for="InputLieu">Lieu</label>
                      <input class="form-control" id="InputLieu" name="InputLieu" type="text">
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                        <div class="col-md-6">
                          <label for="dateDebut">Date de début</label>
                          <div class="date">
                            <div class="input-group input-append date" id="dateRangePicker1">
                              <input type="date" class="form-control" name="date1" />
                              <span class="input-group-addon add-on" id="spdate1"><span class="fa fa-calendar"></span></span>
                            </div>
                          </div>
                        </div>
                        <div class="col-md-6">
                          <label for="dateFin">Date de fin</label>
                          <div class="date">
                            <div class="input-group input-append date" id="dateRangePicker2">
                              <input type="date" class="form-control" name="dateFin" />
                              <span class="input-group-addon add-on" id="spdate2"><span class="fa fa-calendar"></span></span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div id="mail-panel" style="display: none;">
                    <center style="color: blue" ><i class="fa fa-envelope"></i> PARAMÈTRES DE MAIL ET TELEPHONE</center>
                    <div class="form-group">
                      <label for="InputPseudo">Téléphone</label>
                      <div class="input-group">
                        <span class="input-group-addon" ><i class="fa fa-phone"></i></span>
                        <input class="form-control" id="InputPhoneNumber" value='<c:out value="${doctorant.telephone}"/>' name="InputPhoneNumber" type="text">
                      </div>                        
                    </div>
                    <div class="form-group">
                      <label for="Email">Mail</label>
                      <div class="input-group">
                        <span class="input-group-addon" >@</span>
                        <input class="form-control" name="mail" value='<c:out value="${doctorant.mail}"/>' type="mail">
                      </div>
                    </div>
                  </div>
                  <div id="social-media-panel" style="display: none;">
                    <center style="color: blue" ><i class="fa fa-globe fa-lg"></i> MÉDIAS SOCIAUX</center>
                    <p class="font-khfif">Vous pouvez ajouter à votre compte vos comptes Facebook et LinkedIn pour rester en contacte avec vos partenaires.</p>
                    <div class="form-group">
                      <label for="InputFacebook">Facebook</label>
                      <div class="input-group">
                        <span class="input-group-addon" ><i class="fa fa-facebook"></i></span>
                        <input class="form-control" name="UrlFacebook" type="url" value='<c:out value="${doctorant.facebookUrl}"/>'>
                      </div>                        
                    </div>
                    <div class="form-group">
                      <label for="InputLinkedIn">LinkedIn</label>
                      <div class="input-group">
                        <span class="input-group-addon" ><i class="fa fa-linkedin"></i></span>
                        <input class="form-control" name="UrlFacebook" type="url" value='<c:out value="${doctorant.linkedInUrl}"/>'>
                      </div>
                    </div>
                  </div>
                  <div id="biographie-panel" style="display: none;">
                    <center style="color: blue" ><i class="fa fa-newspaper-o"></i> MA BIOGRAPHIE</center>
                    <div class="form-group">
                      <label for="InputPseudo">Biographie</label>
                      <div class="input-group">
                        <textarea class="form-control" name="Biographie" rows="3" style="max-width: 100%; min-height: 200px;"><c:out value="${doctorant.biographie}"/></textarea>
                      </div>                        
                    </div>
                  </div>
                  <div id="info-profil-panel" >
                    <center style="color: blue" ><i class="fa fa-user"></i> Mes informations du profil</center>
                    <div class="row">
                      <div class="col-md-8">
                        <div class="form-row">
                          <div class="col-md-12">
                            <label for="exampleInputName">Prénom:</label>
                            <input class="form-control" id="exampleInputName" name="InputName" type="text" value='<c:out value="${doctorant.prenom}"/>' aria-describedby="nameHelp" placeholder="Prénom">
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="col-md-12">
                            <label for="exampleInputLastName">Nom:</label>
                            <input class="form-control" id="exampleInputLastName" name="InputLastName" type="text" value='<c:out value="${doctorant.nom}"/>' aria-describedby="nameHelp" placeholder="Nom">
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="col-md-12">
                            <label for="exampleInputLastName">Date de Naissance:</label>
                            <div class="date">
                            <div class="input-group input-append date" id="dateRangePicker">
                              <input type="text" class="form-control" name="date" value='<c:out value="${dateNaissance}"/>' />
                              <span class="input-group-addon add-on" id="spdate"><span class="fa fa-calendar"></span></span>
                            </div>
                          </div>
                          </div>
                        </div>
                        <hr>
                      </div>
                      <div class="col-md-4">
                        <div  class="thumbnail btn-block" align="center">
                        <img src="./profil_pics/<c:out value='${!empty doctorant.pictureName ? doctorant.pictureName : "no-img-user.png"}' />" width="100%" id="image">
                        <small class="text-center btn-block">
                          <div class="btn btn-success btn-block fileUpload">
                            <span class="font-khfif" id="btn-modify"><i class="fa fa-camera"></i> Modifier</span>
                            <input type="file" class="upload" name="userfilel" accept="image/x-png,image/gif,image/jpeg" onchange="readURL(this);" style="visibility: hidden; height:0px; width:0;" id="user_image"/>
                          </div>
                          <div class="btn btn-danger btn-block" style="margin-top:5px" id="deletePhotoprofile">
                            <span class="font-khfif"><i class="fa fa-trash"></i> Supprimer</span> 
                          </div>
                        </small>
                      </div>
                      </div>
                    </div>
                    <div class="form-group">
                    </div>
                  </div>

                  <div id="parametres-generale-panel" style="display: none;">
                    <center style="color: blue" ><i class="fa fa-language"></i> PARAMÈTRES GÉNÉRALES</center>
                    <div class="form-group">
                      <label for="InputPseudo"><i class="fa fa-shield"></i> Désactiver votre compte</label>
                      <div class="input-group">
                        <label class="col-md-9" style="font-size: 12px; color: red;">La désactivation de votre compte désactive votre profil et supprime votre nom et votre photo de la plupart des articles que vous avez posté sur ce site. Certaines informations peuvent toujours être visibles pour d'autres, telles que votre nom dans les messages que vous avez envoyés.</label>
                        <button class="col-md-3 btn btn-danger" style="height: 40px;" id="button-desactivation"><i class="fa fa-power-off"></i> Désactiver</button>
                        <input type="text" name="desctivation" value="false" id="input-desactivation" style="display: none;">
                      </div>                        
                    </div>
                  </div>
                  <div id="confidentialite-panel" style="display: none;">
                    <center style="color: blue" ><i class="fa fa-shield"></i> PARAMÈTRES DE CONFIDENTIALITE</center>
                    <div class="row">
                       <div class="col-md-6">  
                          <div >Qui peut voir mes Recherches ?</div>
                          <div class="list-group secondfont" id="recherche">
                               <div class="list-group-item"> <label ><input type="radio" name="RecherchePRVICY" value="VISIBLE" ${doctorant.enumProjet=="1" ? 'checked' : ''}> Tout le monde.</label></div>
                              <div class="list-group-item"> <label ><input type="radio" name="RecherchePRVICY" value="PORTEUR" ${doctorant.enumProjet=="0" ? 'checked' : ''}> Les porteurs de projets seulement.</label></div>
                              <div class="list-group-item"> <label ><input type="radio" name="RecherchePRVICY" value="HIDDEN" ${doctorant.enumProjet=="-1" ? 'checked' : ''}> Aucune personne(caché).</label></div>
                          </div>
                        </div> 
                        <div class="col-md-6">
                          <div>Qui peut voir mon profil ?</div>
                            <div class="list-group secondfont" id="profile">
                                <div class="list-group-item"> <label ><input type="radio" name="profilePRVICY" value="VISIBLE" ${doctorant.enumProfile=="1" ? 'checked' : ''}> Tout le monde.</label></div>
                                <div class="list-group-item"> <label ><input type="radio" name="profilePRVICY" value="PORTEUR" ${doctorant.enumProfile=="0" ? 'checked' : ''}> Les porteurs de projets seulement.</label></div>
                                <div class="list-group-item"> <label ><input type="radio" name="profilePRVICY" value="HIDDEN" ${doctorant.enumProfile=="-1" ? 'checked' : ''}> Aucune personne (caché).</label></div>
                            </div>                         
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                      <div class="col-md-3"></div>
                      <div class="col-md-6">
                        <div>Qui peut m'envoyer les messages ?</div>
                        <div class="list-group secondfont" id="message">
                          <div class="list-group-item"> <label><input type="radio" name="msgPRVICY" value="ALL" ${doctorant.enumMessage=="1" ? 'checked' : ''}> Tout le monde.</label></div>
                          <div class="list-group-item"> <label><input type="radio" name="msgPRVICY" value="PORTEUR" ${doctorant.enumMessage=="0" ? 'checked' : ''}> Les porteurs de projets seulement.</label></div>
                          <div class="list-group-item"> <label><input type="radio" name="msgPRVICY" value="NONE" ${doctorant.enumMessage=="-1" ? 'checked' : ''}> Je ne veux plus recevoir des messages.</label></div>
                        </div>
                      </div>
                      <div class="col-md-3"></div>
                    </div>
                    <div class="row"><br></div>
                  </div>
                  
                  <button type="submit" class="btn btn-primary btn-block hvr-bounce-to-right" >
                    <span><i class="fa fa-save"> </i> Enregistrer les modifications</span>
                  </button>
                </form>
              </div>
          </div>
        </div>
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Groupe 3-3</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Voulez-vous partir?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Selectionner "Se deconnecter" si vous voulez terminer votre session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Annuler</button>
            <a class="btn btn-primary" href="./login">Se deconnecter</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="./vendor/jquery/jquery.min.js"></script>
    <script src="./vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="./vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="./js/sb-admin.min.js"></script>
    <script src="./js/datepicker.js"></script>
    <!-- Custom scripts for this page-->
    <!-- Toggle between fixed and static navbar-->
    <script>
    $('#toggleNavPosition').click(function() {
      $('body').toggleClass('fixed-nav');
      $('nav').toggleClass('fixed-top static-top');
    });

    </script>
    <!-- Toggle between dark and light navbar-->
    <script>
    $('#toggleNavColor').click(function() {
      $('nav').toggleClass('navbar-dark navbar-light');
      $('nav').toggleClass('bg-dark bg-light');
      $('body').toggleClass('bg-dark bg-light');
    });

    $('#btn-modify').click(function() {
      $('#user_image').click();
    });
    </script>
  <script type="text/javascript" src="./js/bootstrap-datepicker.min.js"></script>  
  </div>
  <script src="./js/bootstrapValidator.min.js"></script>
  <script src="./js/bootstrapValidator.js"></script>
  <script type="text/javascript" src="./js/bootstrap-datepicker.min.js"></script>
  <script type="text/javascript">
      function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#image')
                    .attr('src', e.target.result)
            };

            reader.readAsDataURL(input.files[0]);
        }
        var cw = $('#image').width();
        $('#image').css({'height':cw+'px'});
    }
    </script>   
  <script type="text/javascript">
  $(document).ready(function() {
      $('#dateRangeForm').bootstrapValidator({
          message: 'Cette Valeur est invalide',
          feedbackIcons: {
              valid: 'fa fa-check',
              invalid: 'fa fa-remove',
              validating: 'fa fa-refresh'
          },
          fields: {
              InputPasswordNew1: {
                  validators: {
                      identical: {
                          field: 'InputPasswordNew2',
                          message: 'Les deux mots de passe ne sont pas identiques'
                      }
                  }
              },
              InputPasswordNew2: {
                  validators: {
                      identical: {
                          field: 'InputPasswordNew1',
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
