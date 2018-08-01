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
    <title>PhD easy - Acceuil</title>
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
    <style type="text/css">
      #mapdiv {
        height: 700px;
        width: 100%;
      }
    </style>
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
        <c:if test="${!empty sessionScope.doctorant}">
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
        </c:if>
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
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">My Dashboard</li>
      </ol>
      <!-- Icon Cards-->
      <div class="row">
        <div class="col-12">
          <h1>Bienvenue <c:if test="${!empty sessionScope.doctorant}"> <c:out value="${doctorant.prenom}"/> <c:out value="${doctorant.nom}"/> </c:if> sur PhD easy</h1>
          <p>
          	<c:if test="${!empty sessionScope.doctorant}"> <i class="fa fa-quote-left"></i> <c:out value="${doctorant.biographie}"/> <i class="fa fa-quote-right"></i></c:if>   
          </p>
        </div>
      </div>
      <!-- Area Chart Example-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-map"></i> Carte</div>
        <div class="card-body">


          <div id="mapdiv"></div>
        </div>
        <div class="card-footer small text-muted"> Carte</div>
      </div>
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Table des Sujets</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Nom</th>
                  <th>Université</th>
                  <th>Discipline</th>
                  <th>Thématique</th>
                  <th>Description</th>
                  <th>Pays d'étude</th>
                  <th>Laboratoire</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Nom</th>
                  <th>Université</th>
                  <th>Discipline</th>
                  <th>Thématique</th>
                  <th>Description</th>
                  <th>Pays d'étude</th>
                  <th>Laboratoire</th>
                </tr>
              </tfoot>
              <tbody>
			  	<c:forEach items="${arrayProj}" var="projet">
  					<c:forEach items="${arrayDoc}" var="doctorant">
  						<c:if test="${projet.id_doc eq doctorant.userName}">
  	            <tr>
  	              <td> <c:out value="${doctorant.nom}" /> <c:out value="${doctorant.prenom}" /></td>
  							  <td> <c:out value="${!empty projet.ecole ? projet.ecole : 'Non défini'}" /> </td>
  							  <td> <c:out value="${!empty projet.discipline ? projet.discipline : 'Non défini'}" /> </td>
  							  <td> <c:out value="${!empty projet.titre ? projet.titre : 'Non défini'}" /> </td>
  							  <td> <c:out value="${!empty projet.description ? projet.description : 'Non défini'}" /> </td>
  							  <td> <c:out value="${!empty projet.pays ? projet.pays : 'Non défini'}" /> </td>
  							  <td> <c:out value="${!empty projet.laboratoire ? projet.laboratoire : 'Non défini'}" /> </td>			
  	            </tr> 
  	          </c:if>
  					</c:forEach >
         	</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted" id="time"></div>
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
    <!-- Page level plugin JavaScript-->
    <script src="./vendor/chart.js/Chart.min.js"></script>
    <script src="./vendor/datatables/jquery.dataTables.js"></script>
    <script src="./vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="./js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="./js/sb-admin-datatables.min.js"></script>
    <script src="./js/sb-admin-charts.min.js"></script>
    <script type="text/javascript">
      setInterval(function(){
                document.getElementById('time').innerHTML = new Date().toLocaleTimeString();
              }, 1000);
    </script>
  
  <script src="https://openlayers.org/api/OpenLayers.js"></script>
  <script>
    $('document').ready(function(){
    map = new OpenLayers.Map("mapdiv");
    map.addLayer(new OpenLayers.Layer.OSM());
    
    epsg4326 =  new OpenLayers.Projection("EPSG:4326"); //WGS 1984 projection
    projectTo = map.getProjectionObject(); //The map projection (Spherical Mercator)
    epsg3857 =  new OpenLayers.Projection("EPSG:900913"); //WGS 1984 projection
    var lonLat = new OpenLayers.LonLat( -0.1279688 ,51.5077286 ).transform(epsg4326, projectTo);
          
    
    var zoom=2;
    map.setCenter (lonLat, zoom);

    var vectorLayer = new OpenLayers.Layer.Vector("Overlay");
    
    // Define markers as "features" of the vector layer:
  <c:forEach items="${ arrayProj }" var="arrayProj">
    var labels ='Titre: <c:out value="${ arrayProj.titre }"/> <br/> Discipline: <c:out value="${ arrayProj.discipline}"/> <br/><a href="./profile?doctorant=<c:out value="${ arrayProj.id_doc }"/>"> Visiter le profile</a>';
    var longi=Number('<c:out value="${ arrayProj.longitude }"/>');
    var lati=Number('<c:out value="${ arrayProj.latitude }"/>');
    feature = new OpenLayers.Feature.Vector(
            new OpenLayers.Geometry.Point( lati, longi ).transform(epsg4326, epsg3857),//2
            {description: labels} ,
            {externalGraphic: './icons/marker.png', graphicHeight: 25, graphicWidth: 21, graphicXOffset:-12, graphicYOffset:-25  }
        );    
    vectorLayer.addFeatures(feature);
       map.addLayer(vectorLayer);
    //Add a selector control to the vectorLayer with popup functions
    var controls = {
      selector: new OpenLayers.Control.SelectFeature(vectorLayer, { onSelect: createPopup, onUnselect: destroyPopup })
    };
  </c:forEach>   
 

    function createPopup(feature) {
      feature.popup = new OpenLayers.Popup.FramedCloud("pop",
          feature.geometry.getBounds().getCenterLonLat(),
          null,
          '<div class="markerContent">'+feature.attributes.description+'</div>',
          null,
          true,
          function() { controls['selector'].unselectAll(); }
      );
      //feature.popup.closeOnMove = true;
      map.addPopup(feature.popup);
    }

    function destroyPopup(feature) {
      feature.popup.destroy();
      feature.popup = null;
    }
    
    map.addControl(controls['selector']);
    controls['selector'].activate();
     }); 
  </script>  
  </div>
</body>

</html>
