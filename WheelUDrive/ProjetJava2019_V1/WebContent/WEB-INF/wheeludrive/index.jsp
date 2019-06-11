<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	

<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="Debelette" content="Wheel U Drive template">

		<title>Wheel U Drive</title>
		
		<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/images/favicon.ico">

		<!-- Bootstrap -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

		<!-- Font awesome 5 -->
		<link href="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/fonts/fontawesome/css/fontawesome-all.css" type="text/css" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

		
		<link href="https://fonts.googleapis.com/css?family=Catamaran:400,800" rel="stylesheet">
		<!-- Material-icons -->
		<link href="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/fonts/material-icons/material-icons.css" type="text/css" rel="stylesheet">
		<!-- UI KIT -->
		<link href="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/css/responsive.css"  rel="stylesheet">
		<link href="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/css/ui.css"  rel="stylesheet">
		<!-- custom styles -->
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
    
    <style>
		
@font-face {
  font-family: 'LemonMilklight';
  src: url("${pageContext.request.contextPath}/assets/fonts/LemonMilklight.woff2") format('woff2'),
      url('${pageContext.request.contextPath}/assets/fonts/LemonMilklight.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}

@font-face {
  font-family: 'LemonMilklightitalic';
  src: url('${pageContext.request.contextPath}/assets/fonts/LemonMilklightitalic.woff2') format('woff2'),
      url('${pageContext.request.contextPath}/assets/fonts/LemonMilklightitalic.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}

@font-face {
  font-family: 'LemonMilkitalic';
  src: url('${pageContext.request.contextPath}/assets/fonts/LemonMilkitalic.woff2') format('woff2'),
      url('${pageContext.request.contextPath}/assets/fonts/LemonMilkitalic.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}

@font-face {
  font-family: 'LemonMilk';
  src: url('${pageContext.request.contextPath}/assets/fonts/LemonMilk.woff2') format('woff2'),
      url('${pageContext.request.contextPath}/assets/fonts/LemonMilk.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
		
</style>

	</head>

  <body> 
		
	<header class="section-header">
			<nav class="navbar navbar-top navbar-expand-lg navbar-dark bg-primary">
				<div class="container">
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
						
					</button>
			
					<div class="collapse navbar-collapse" id="navbarsExample07">
						<ul class="navbar-nav mr-auto">
							<li><a href="#" class="nav-link"> <i class="fab fa-facebook"></i> </a></li>
							<li><a href="#" class="nav-link"> <i class="fab fa-instagram"></i> </a></li>
							<li><a href="#" class="nav-link"> <i class="fab fa-twitter"></i> </a></li>
						</ul>
						<ul class="navbar-nav">
							<li class="nav-item"><a href="#" class="nav-link" > Aide </a></li>
							<li class="nav-item dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"> 
									<img  src="${pageContext.request.contextPath}/assets/images/fr.png"> 
								</a>
								<ul class="dropdown-menu dropdown-menu-right" style="min-width: 70px;">
									<li><a class="dropdown-item" href="#"><img  src="${pageContext.request.contextPath}/assets/images/en.png"></a></li>
								</ul>
							</li>
						</ul> <!-- navbar-nav.// -->
					</div> <!-- collapse.// -->
				</div>
			</nav>
			
			<section class="header-main shadow-sm bg-white">
				<div class="container">
					<div class="row align-items-center">
						<div class="col-lg-3 col-sm-4">
						<div class="brand-wrap">
							<a href="${pageContext.request.contextPath}/wheeludrive" ><img class="logo" src="${pageContext.request.contextPath}/assets/images/logoV3.png" width="auto"></a>
						</div> <!-- brand-wrap.// -->
						</div>
						<div class="col-lg-4 col-xl-6 col-sm-8">
								<form action="#" class="search-wrap">
									<div class="input-group ">
									<span class="nav-wish">Je souhaite acheter </span>	 
											<!-- <select class="custom-select-lg custom-select"  name="category_name">
													<option value="">Acheter</option>
													<option value="codex">Louer</option>
											</select> -->
											<input type="text" class="form-control-lg w-input-wish" placeholder="BMW, Volkswagen, 308, ...">
											
											<div class="input-group-append ">
											
													<a href="${pageContext.request.contextPath}/wheeludrive/vehicules" class="btn btn-primary pt-3" >
														<i class="fa fa-search"></i>
													</a>
											</div>
										</div>
								</form> <!-- search-wrap .end// -->
						</div> <!-- col.// -->
						<div class="col-lg-5 col-xl-3 col-sm-12">
						
						
							
							
							
							
							${navFormLog}
							
							
							
						</div> <!-- col.// -->
					</div> <!-- row.// -->
				</div> <!-- container.// -->
			</section> <!-- header-main .// -->
		</header> <!-- section-header.// -->
		
	

	<jsp:include page="/WEB-INF/wheeludrive/${page}.jsp"/>
	
	
    <footer class="text-center">
	      <div class="container">
		        <div class="row">
		          	<div class="col-12 p-5">
			            <p>Copyright © MyWebsite. All rights reserved.</p>
					</div>
				</div>
			</div>
		</footer>
			
	<!-- =========================MODALS========================= -->
			
		<!-- MODALS-erreur inscription email -->
		<div class="modal fade text-left ${errEmail}" ${db} id="errEmail" >
				<div class="modal-dialog">
					<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title"></h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<!-- Modal body -->
					<div class="modal-body text-center">
						<article class="p-5">
								<h1 class="title-m"> <i class="fa fa-check fa-2X" aria-hidden="true"></i><br><br>Email déjà existant!  </h1>
								<h2>Connectez-vous ici!</h2>
								<div class="">
									<form class="px-4 py-3" action="wheeludrive" method="post">
										<fieldset>
											<div class="form-group">
												<label>Email</label>
												<input type="email" name="emailConnexion" class="form-control" placeholder="email@exemple.com">
											</div>
											<div class="form-group">
												<label>Mot de passe</label>
												<input type="password" name="pswdConnexion" class="form-control" placeholder="Mot de passe">
											</div>
											<input type="submit" class="btn btn-primary" placeholder="Se connecter">
										</fieldset>
									</form>
								</div>
							<p></p>
						</article>
					</div>
				</div>
			</div>
		</div>
		<!-- ./MODALS-erreur inscription email  -->
		<!-- MODALS-Email déjà existant -> modal connexion -->
		<div class="modal fade text-left ${showModalConnexion}"  ${showModalConnexionD}>
				<div class="modal-dialog">
					<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title"></h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<!-- Modal body -->
					<div class="modal-body text-center">
						<article class="p-5">
							<h1><i class="fas  fa-frown-open"></i></h1>
							<h4>Aucun compte n'existe pour cet email </h4>
							<a class="btn btn-primary white" style="color: #FFF;" data-toggle="modal" data-target="#modal-sign">Créer un compte ? </a>
							<p></p>
						</article>
					</div>
				</div>
			</div>
		</div>
		<!-- ./Modal-Email déjà existant -> modal connexion - -->
		<!-- MODALS-sendMailContact -->
		<div class="modal fade text-left" id="sendMailContact">
				<div class="modal-dialog">
					<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title"></h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<!-- Modal body -->
					<div class="modal-body text-center">
						<article class="p-5">
								<h1 class="title-m"> <i class="fa fa-check fa-2X" aria-hidden="true"></i><br><br>Email bien envoyé </h1>
								<p></p>
						</article>
					</div>
				</div>
			</div>
		</div>
		<!-- ./MODALS-sendMailContact -->
		
		<!-- MODALS-ANNONCE -->
		<div class="modal fade text-left" id="modal-annonce">
			<div class="modal-dialog annonce">
				<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Publier une annonce</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<article class="">
						<!--formulaire vente-->
						<form>
							<main class="col-sm-12">
								<article class="form ">
									<h1 class="title-m">1. Informations du véhicule</h1>
									<hr>
									<!-- form  -->
									<div class="form-row mt-4">
											<!--Row1-->
											<div class="col-md-3 pb-3">
												<label for="marque">Marque</label>
												<select id="marque" class="form-control custom-select" size="0">
													<option value="Hawaii">Audi</option>
												</select>
											</div>
											<div class="col-md-3 pb-3">
												<label for="modele">Modèle</label>
												<select id="modele" class="form-control custom-select" size="0">
													<option value="Hawaii">A1</option>
												</select>
											</div>
											<div class="col-md-6 pb-3">
													<label for="version">Version</label>
													<input type="text" class="form-control" id="version">
											</div>
											<!--Row2-->
											<div class="col-md-3 pb-3">
												<div class="form-group">
													<label >Date immatrictulation</label>
													<input type="date" name="bday" max="3000-12-31"  min="1000-01-01"  class="form-control">
												</div>
											</div>
											<div class="col-md-3 pb-3">
												<label for="modele">Carburant</label>
												<select id="modele" class="form-control custom-select" size="0">
													<option value="Essence">Essence</option>
													<option value="Diesel">Diesel</option>
												</select>
											</div>
											
											<div class="col-md-3 pb-3">
												<label for="puissance">Puissance</label>
												<input type="text" name="puissance"  class="form-control">
											</div>
											<div class="col-md-3 pb-3">
												<div class="form-group ">
													<label for="boite">Boite à vitesses <sup> </sup></label>
													<select name="boite" id="boite" class="form-control boite" data-base="">
															<option value="0">Choisissez le type de boite à vitesse</option>
															<option value="manuelle">Manuelle</option>
															<option value="automatique">Automatique</option>
															<option value="semi-automatique">Semi-automatique</option>
													</select>
												</div>
											</div>
											<!--row3-->
											<div class="col-md-3 pb-3">
												<label for="couleurInt">Couleur intérieur</label>
												<select id="couleurInt" class="form-control custom-select" size="0">
													<option value="Rouge">Rouge</option>
												</select>
											</div>
											<div class="col-md-3 pb-3">
												<label for="couleurExt">Couleur Extérieur</label>
												<select id="couleurExt" class="form-control custom-select" size="0">
													<option value="Rouge">Rouge</option>
												</select>
											</div>
											<div class="col-md-3 pb-3">
												<label for="typePeinture">Type de peinture</label>
												<select id="typePeinture" class="form-control custom-select" size="0">
													<option value="Rouge">Rouge</option>
												</select>
											</div>
											<div class="col-md-3 pb-3">
												<label for="typeSiege">Type de sièges</label>
												<select id="typeSiege" class="form-control custom-select" size="0">
													<option value="Rouge">Rouge</option>
												</select>
											</div>
											<!--row4-->
											<div class="col-md-3 pb-3">
												<label for="kilometre">Kilomètres</label>
												<select id="kilometre" class="form-control custom-select" size="0">
													<option value="Rouge">3</option>
												</select>
											</div>
											<div class="col-md-3 pb-3">
												<div class="form-group ">
													<label for="cylindree">Cylindrée <sup> </sup></label>
													<input type="text" required="required" name="cylindree" id="cylindree" class="form-control" value="">
												</div>
											</div>
											<div class="col-md-3 pb-3">
												<div class="form-group ">
													<label for="cylindree">CV <sup></sup></label>
													<input type="text" required="required" name="cylindree" id="cylindree" class="form-control" value="">
												</div>
											</div>
											<div class="col-md-3 pb-3">
												<div class="form-group ">
													<label for="cylindree">KW <sup></sup></label>
													<input type="text" required="required" name="cylindree" id="cylindree" class="form-control" value="">
												</div>
											</div>
											<!--row5-->
											<div class="col-md-3 pb-3">
												<div class="form-group ">
														<label for="type">Carrosserie <sup> </sup></label>
														<select name="carrosserie" id="carrosserie" class="form-control" data-base="">
															<option disable value="0">Choisissez le type de véhicule</option>
													</select>
												</div>
											</div>
											<div class="col-md-3 pb-3">
												<div class="form-group ">
														<label for="type">Transmission <sup></sup></label>
														<select name="transmission" id="transmission" class="form-control" data-base="">
															<option disable value="0">Transmission</option>
													</select>
												</div>
											</div>
											<div class="col-md-3 pb-3">
												<label for="nombrePortes">Nombre de portes</label>
												<select id="nombrePortes" class="form-control custom-select" size="0">
													<option value="Rouge">3</option>
												</select>
											</div>
											<div class="col-md-3 pb-3">
												<div class="form-group ">
													<label for="motorisation">Motorisation <sup></sup></label>
													<input type="text" required="required" name="cylindree" id="motorisation" class="form-control" value="">
												</div>
											</div>
											
											<!--row6-->
											<div class="col-md-3 pb-3">
												<div class="form-group ">
													<label for="emissionCO2">emissionCO2 <sup></sup></label>
													<input type="text" required="required" name="cylindree" id="emissionCO2" class="form-control" value="">
												</div>
											</div>
											<div class="col-md-2 pb-3">
												<div class="form-group ">
													<label for="carpassEstOk">Car pass <sup></sup></label>
													<select name="carpassEstOk" id="carpassEstOk" class="form-control" data-base="">															<option disable value="0">Non</option>
														<option disable value="1">Oui</option>
													</select>
												</div>
											</div>
											<div class="col-md-2 pb-3">
												<div class="form-group ">
													<label for="normeEuropeene">Norme Euro <sup></sup></label>
													<select name="normeEuropeene" id="normeEuropeene" class="form-control" data-base="">															<option disable value="0">Euro 1</option>
														<option disable value="1">Euro 2</option>
													</select>
												</div>
											</div>
											<div class="col-md-2 pb-3">
												<div class="form-group ">
													<label for="nombreClefs">Nombre de clés <sup></sup></label>
													<select name="nombreClefs" id="nombreClefs" class="form-control" data-base="">
														<option disable value="1"> 1</option>
														<option disable value="2"> 2</option>
													</select>
												</div>
											</div>
											<div class="col-md-3 pb-3">
												<div class="form-group ">
													<div class="form-group ">
														<label for="numeroChassis">Numéro de châssis <sup></sup></label>
														<input type="text" required="required" name="numeroChassis" id="numeroChassis" class="form-control" value="">
													</div>
												</div>
											</div>
											<!--row6-->
											<div class="col-md-6 ">
												<form>
													<div class="form-group">
														<label for="exampleFormControlFile1">Importer des photos</label>
														<input type="file" class="form-control-file" id="exampleFormControlFile1">
													</div>
												</form>
											</div>
											<div class="col-md-6 ">
												<form>
													<div class="form-group">
														<label for="carnetEntretien">Importer le carnet d'entretien</label>
														<input type="file" class="form-control-file" id="carnetEntretien">
													</div>
												</form>
											</div>
											
									</div>
								</article> 
								<!-- ./article -->
								<article class="form  mt-5">
									<h1 class="title-M">2. Détails de l'annonce </h1>
									<hr>
									<!-- form  -->
									<div class="form-row mt-4">
										<!--Row1-->
										<div class="col-md-3">
											<div class="">
												<label for="description">Prix de vente</label>
											<input type="text" name="prixVente" class="form-control" id="prixVente">
											</div>
										</div>
										<!-- à afficher uniquement si compte professionnel-->
										<div class="col-md-3">
											<div class="form-group ">
												<label for="nombreClefs">Tva déductible <sup></sup></label>
												<select name="nombreClefs" id="nombreClefs" class="form-control" data-base="">
													<option disable value="1"> Non</option>
													<option disable value="2"> Oui</option>
												</select>
											</div>
										</div>
										<!-- ./à afficher uniquement si compte professionnel-->
									</div>
									<div class="form-row mt-4">
										<div class="col-md-6 pb-4">
												<div class="">
													<label for="description">Titre de l'annonce</label>
												<input type="text" name="prixVente" class="form-control" id="prixVente">
												</div>
											</div>
										<div class="col-md-12 ">
											<div class="form-row">
												<label for="description">Description</label>
												<textarea class="form-control" id="description" rows="6"></textarea>
												<small class="text-info">
												
												</small>
											</div>
										</div>
									</div>
								</article> <!-- ./article -->
								
								<div class="form-row">
									<div class="col-12 text-center p-5">
										<button class="btn btn-primary mr-3">Sauvegarder mon annonce</button>
									
										<button class="btn btn-outline-primary">Publier mon annonce</button>
									</div>
								</div>
							</main> <!-- ./main -->
							<!-- ============== ./COL RIGHT============== -->
						</form>
						<!-- ./formulaire evente-->
								
					</article>
					<!--  card-body end .//
					<div class="border-top card-body text-center">
							Déjà un compte? <a href="">Se connecter</a>
					</div> -->
				</div>
		
				</div>
			</div>
		</div>
		<!-- ./MODALS-ANNONCE -->
		
		<!-- MODALS-ABO -->
		<div class="modal fade text-left" id="modal-abo">
			<div class="modal-dialog modal-abo">
				<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Modifier mon abonnement</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<article class="">
						<form action="">
							<div class="col-md-12 ">
								<h2 class="title-m">1. Choisissez votre type d'abonnement</h2><br>
								<table class="plan table table-hover table-bordered table-striped text-center">
									<thead>
										<tr>
											<th colspan="6" style="vertical-align: middle;">
												<h2>Features</h2>
											</th>

											<th colspan="2">
												
													<div class="form-check"><br>
														<label class="form-check-label"><h5> <i class="fas fa-poo"></i><br> CLASSIQUE <br> version limitée</h5>
															<p class="muted">GRATUIT</p> 
															<input type="radio" checked="checked" class="form-check-input" name="optradio"><br>
														</label>
													</div>
													
											

												

												<!-- <div class="plan-action">
													<a class="btn btn-primary btn-block btn-large" href=
													"https://cloud.meetingresult.com/signup/trial">Sign Up
													Now</a>
												</div> -->
												
											</th>

											<th colspan="2">
												
												<div class="form-check"><br>
													<label class="form-check-label"><h5><i class="fas fa-gem    "></i><br>PREMIUM <br>
														version illimitée </h5>
														<p class="muted">9.99EUR/MOIS</p> 
														<input type="radio" class="form-check-input" name="optradio"><br>
													</label>
												</div>

												<!-- <div class="plan-action">
													<a class="btn btn-primary btn-block btn-large" href=
													"https://cloud.meetingresult.com/signup/monthly">Sign
													Up Now</a>
												</div> -->
											
											</th>

											
										</tr>
									</thead>

									<tbody>
										<tr>
											<td colspan="6">NOMBRE DE LICENSE</td>
											<td colspan="2">1</td>
											<td colspan="2">LICENSE DE GROUPE </td>
										</tr>

										<tr>
											<td colspan="6">COMPTE PROFESSIONNEL</td>
											<td colspan="2">/</td>
											<td colspan="2">✔</td>
										</tr>

										<tr>
											<td colspan="6">NOMBRE DE VENTES MAXIMUM PAR MOIS</td>
											<td colspan="2">3</td>
											<td colspan="2">ILLIMITEES</td>
										</tr>
										<tr>
											<td colspan="6">NOMBRE D'ACHATS MAXIMUM PAR MOIS</td>
											<td colspan="2">3</td>
											<td colspan="2">ILLIMITES</td>
										</tr>
										<tr>
											<td colspan="6">ACCES AUX STATISTIQUES DE VENTES</td>
											<td colspan="2">/</td>
											<td colspan="2">✔</td>
										</tr>

										
									</tbody>
								</table><br>
<!-- 								<h2 class="mt-3 title-m">2. Choisissez votre adresse de facturation</h2><br> -->
<!-- 								<h5> -->
<!-- 									<div class="form-check form-check-inline"> -->
<!-- 										<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" checked="checked" value="option1"> -->
<!-- 										<label class="form-check-label" for="inlineRadio1">Adresse personnelle</label> -->
<!-- 										</div> -->
<!-- 										<div class="form-check form-check-inline"> -->
<!-- 										<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> -->
<!-- 										<label class="form-check-label" for="inlineRadio2">Adresse de facturation</label> -->
<!-- 									</div> -->
<!-- 								</h5> -->
<!-- 								<h2 class="mt-3 title-m">3. Payer</h2><br> -->
								<div class="title white">
									<a class="btn btn-primary btn-block p-3" data-dismiss="modal" data-target="#modal-abo-valide" data-toggle="modal" >Valider mon changement d'abonnement</a>
								</div>
							</div>
						</form>
				</article>
				
				</div>
		
				</div>
			</div>
		</div>
		<!-- ./MODALS-ABO -->

		<!-- MODALS-ABO-VALID -->
		<div class="modal fade text-left" id="modal-abo-valide">
			<div class="modal-dialog">
				<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title"></h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body text-center">
					<article class="p-5">
						<h1 class="title-m"> <i class="fa fa-check fa-2X" aria-hidden="true"></i><br><br>Votre abonnement a bien été mis à jour! </h1>
				</article>
				</div>
		
				</div>
			</div>
		</div>
		<!-- ./MODALS-ABO-VALID -->

		<!-- MODALS-PSWD-LOST -->
		<div class="modal fade text-left" id="modal-pswd-lost">
			<div class="modal-dialog">
				<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Mot de passe perdu</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<article class="">
							<form action="">
								<div class="form-group input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
									</div>
									<input name="" class="form-control" placeholder="Email" type="email" required>
								</div> <!-- form-group// -->                                     
								<div class="form-group">
										<button type="submit" class="btn btn-primary btn-block"> Réinitialiser le mot de passe par email  </button>
								</div> <!-- form-group// -->      
						</form>
				</article>
					<!--  card-body end .//
					<div class="border-top card-body text-center">
							Déjà un compte? <a href="">Se connecter</a>
					</div> -->
				</div>
		
				</div>
			</div>
		</div>
		<!-- ./MODALS-PSWD-LOST -->

		<!-- MODALS-SIGN -->
		<div class="modal fade text-left" id="modal-sign">
			<div class="modal-dialog modal-abo">
				<div class="modal-content ">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Inscription</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<article>
						<form action="wheeludrive" method="post">
							<fieldset>
								<h2 class="title-m">1. Choisissez votre type d'abonnement</h2><br>
								<!-- table -->
								<table class="plan table table-hover table-bordered table-striped text-center">
									<thead>
										<tr>
											<th colspan="6" style="vertical-align: middle;">
												<h2></h2>
											</th>

											<th colspan="2">
												<div class="form-check"><br>
													<label class="form-check-label"><h5> <i class="fas fa-poo fa-2x mb-4"></i><br> CLASSIQUE <br> version limitée</h5>
														<p class="muted">GRATUIT</p> 
														<input type="radio" checked="checked" id="check-classic" class="form-check-input checkbox-inscription" name="typeAbo"><br>
													</label>
												</div>
											</th>

											<th colspan="2">
												
												<div class="form-check"><br>
													<label class="form-check-label"><h5><i class="fas fa-gem  fa-2x mb-4  "></i><br>PREMIUM <br>
														version illimitée </h5>
														<p class="muted">9.99EUR/MOIS</p> 
														<input type="radio" class="form-check-input checkbox-inscription" id="check-prem" name="typeAbo"><br>
													</label>
												</div>
											</th>
										</tr>
									</thead>

									<tbody>
										<tr>
											<td colspan="6">NOMBRE DE LICENSE</td>
											<td colspan="2">1</td>
											<td colspan="2">LICENSE DE GROUPE </td>
										</tr>

										<tr>
											<td colspan="6">COMPTE PROFESSIONNEL</td>
											<td colspan="2">/</td>
											<td colspan="2">✔</td>
										</tr>

										<tr>
											<td colspan="6">NOMBRE DE VENTES MAXIMUM PAR MOIS</td>
											<td colspan="2">3</td>
											<td colspan="2">ILLIMITEES</td>
										</tr>
										<tr>
											<td colspan="6">NOMBRE D'ACHATS MAXIMUM PAR MOIS</td>
											<td colspan="2">3</td>
											<td colspan="2">ILLIMITES</td>
										</tr>
										<tr>
											<td colspan="6">ACCES AUX STATISTIQUES DE VENTES</td>
											<td colspan="2">/</td>
											<td colspan="2">✔</td>
										</tr>

										
									</tbody>
								</table><br>
								<!-- ./table -->
								<h2 class="mt-3 title-m">2. Entrez vos coordoonées</h2><br>
								<!-- form-inscription -->
								<div class="row">
									<div class="col-md-6">
										<div class="form-group input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i class="fa fa-user"></i> </span>
											</div>
											<input  id="nom" name="nom"  class="form-control" placeholder="Nom" type="text" required>
										</div> <!-- form-group// -->
									</div>
									<div class="col-md-6">
										<div class="form-group input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i class="fa fa-user"></i> </span>
											</div>
											<input name="prenom" class="form-control" placeholder="Prénom" type="text" required>
										</div> <!-- form-group// -->
									</div>
									<div class="col-md-6">
										<div class="form-group input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i class="fa fa-birthday-cake"></i> </span>
											</div>
											<input type="date" name="dateNaissance" placeholder="Date de naissance" max="3000-12-31"  min="1000-01-01"  class="form-control">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
											</div>
											<input name="email" class="form-control" placeholder="Email" type="email" required>
										</div> <!-- form-group// -->
									</div>
									<div class="col-md-6">
										<div class="form-group input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i class="fa fa-phone"></i> </span>
											</div>
											<input name="telFixe" class="form-control" placeholder="téléphone fixe" type="tel" required>
										</div> <!-- form-group// -->
									</div>
									<div class="col-md-6">
										<div class="form-group input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i class="fa fa-phone"></i> </span>
											</div>
											<input name="telMobile" class="form-control" placeholder="téléphone mobile" type="tel" required>
										</div> <!-- form-group// -->
									</div>
									<div class="col-md-6">
									<div class="form-group input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
										</div>
										<input name="rue" class="form-control" placeholder="Adresse" type="text" required>
									</div> <!-- form-group// -->
								</div>
								<div class="col-md-3">
									<div class="form-group input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
										</div>
										<input name="num" class="form-control" placeholder="Numéro" type="text" required>
									</div> <!-- form-group// -->
								</div>
								<div class="col-md-3">
									<div class="form-group input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-building"></i> </span>
									</div>
									<select class="form-control custom-select" name="cp">
										<option selected="selected" disabled required> Code postal</option>
										<option value="5000">5000</option>
									</select>
									</div> <!-- form-group end.// -->
								</div>
								
								
								<div class="col-md-6">
									<div class="form-group input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-building"></i> </span>
									</div>
									<select class="form-control custom-select" name="ville">
										<option selected="" disabled aria-required="true" required> Ville</option>
										<option value="Charleroi">Charleroi</option>
									</select>
									</div> <!-- form-group end.// -->
								</div>
								<div class="col-md-6">
									<div class="form-group input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-building"></i> </span>
									</div>
									<select class="form-control custom-select" name="pays">
										<option selected="" disabled aria-required="true" required> Pays</option>
										<option value="Belgique">Belgique</option>
									</select>
									</div> <!-- form-group end.// -->
								</div>
								<div class="col-md-6">
									<div class="form-group input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-building"></i> </span>
									</div>
									<select class="form-control custom-select" name="professionnel" id="select-pro">
										<option selected="" disabled aria-required="true" required> Créer un compte en tant que...</option>
										<option value="1" id="particulier">Particulier</option>
										<option value="2" id="professionnel">Professionnel</option>
									</select>
									</div> <!-- form-group end.// -->
								</div>
								
								<!-- professionnel -->
								<div class="col-md-6" id="professionnelTVA" ></div>
								<!-- ./professionnel -->
								<div class="col-md-12">
									<div class="form-group input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-lock"></i> </span>
									</div>
											<input class="form-control" name="motdepasse" placeholder="Entrez un mot de passe" type="password">
									</div> <!-- form-group// -->
									<div class="form-group input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-lock"></i> </span>
										</div>
										<input class="form-control" name="confirmation" placeholder="Répétez le mot de passe" type="password">
									</div> <!-- form-group// -->   
								</div>
								</div>
								<!-- ./form-inscription -->
								
								
                                   
								<div class="form-group">
									<input type="submit" class="btn btn-primary btn-block" value="Créer un compte">
									
								</div> <!-- form-group// -->      
							</fieldset>
						</form>	
					</article> <!-- card-body end .// -->
					<div class="border-top card-body text-center">
							Déjà un compte? <a href="">Se connecter</a>
					</div>
				</div>
		
				</div>
			</div>
		</div>
		<!-- ./MODALS-SIGN -->

	<!--  =========================./MODALS========================= -->
	
	<!-- jQuery  -->
	<script src="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/js/jquery-2.0.0.min.js" type="text/javascript"></script>
	<!--Bootstrap-->
	<script src="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/js/bootstrap.bundle.min.js" type="text/javascript"></script>
	<!-- plugin: fancybox  -->
	<script src="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/plugins/fancybox/fancybox.min.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/plugins/fancybox/fancybox.min.css" type="text/css" rel="stylesheet">
	<!-- plugin: owl carousel  -->
	<link href="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/plugins/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/plugins/owlcarousel/assets/owl.theme.default.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/plugins/owlcarousel/owl.carousel.min.js"></script>
	
	<!-- plugin: slickslider -->
	<link href="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/plugins/slickslider/slick.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/plugins/slickslider/slick-theme.css" rel="stylesheet" type="text/css" />
	<script src="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/plugins/slickslider/slick.min.js"></script>
	<!--custom-->
	<script src="${pageContext.request.contextPath}/assets/uikit/ui-ecommerce/js/script.js" type="text/javascript"></script>

	<!-- <script src="js/jquery-3.2.1.min.js"></script> -->
	<script>
	$(document).ready(function(){

		if("${dnJS}"=="1"){
			$("#connectForm").hide();
			//snippetCompte='<div class="widgets-wrap float-right"><a href="#" class="widget-header mr-3"><div class="icontext"><div class="icon-wrap"><i class="icon-sm round border fa fa-heart"></i></div><div class="text-wrap"><span class="small badge badge-danger">0</span><small style="color:#000;">Favoris</small></div></div></a><div class="widget-header dropdown"><a href="#" data-toggle="dropdown" data-offset="20,10"><div class="icontext"><div class="icon-wrap"><i class="icon-sm round border fa fa-user"></i></div><div class="text-wrap"><div style="color:#000;">Mon compte <i class="fa fa-caret-down"></i> </div></div></a><div class="dropdown-menu dropdown-menu-right"><form class="px-4 py-3"><a class="dropdown-item" href="#" >Mes informations</a><hr class="dropdown-divider"><a href="wheeludrive?logout=1">Se déconnecter</a><hr class="dropdown-divider"><a class="dropdown-item btn btn-primary btn-block" href="#" data-toggle="modal" data-target="#modal-annonce">Vendre</a></div></div></div>';
			$('#moncompteForm').append(snippetCompte);
		}else{
			$("#connectForm").show();
			$('#moncompteForm').children("div").remove();
		}
	  	$(".owl-carousel").owlCarousel();
	  	
		$( ".showInfos" ).click(function() {
			if( $(".showInfos").hasClass( 'infosActives' )){
				$(".infosItem").css( 'height','0px' );
				$(".infosItem").css( 'opacity','0' );
				$(".showInfos").css( 'transform','rotate(45deg)' );
				$(".showInfos").addClass( 'infosActives' );
			}else{
				$(".infosItem").css( 'height','100px' );
				$(".infosItem").css( 'opacity','1' );
				$(".showInfos").css( 'transform','rotate(90deg)' );
				$(".showInfos").addClass( 'infosActives' );
			}
		}); 
	
		// type abonnement check inscription modal
		val ='<div class="form-group input-group"><div class="input-group-prepend"><span class="input-group-text"> <i class="fa fa-envelope"></i> </span></div><input name="professionnelTVA" class="form-control" placeholder="Numéro de TVA" type="text" required></div> <!-- form-group// -->';

		$('#professionnel').css('display','none');
		
		if($('#select-pro').val()=="2"){
			$('#professionnelTVA').append(val);
		}else{
			
			$('#select-pro').change(function() {
				if($('#select-pro').val()=="2"){
					$('#professionnelTVA').append(val);
				}else{
					$('#professionnelTVA').remove();
				}
			});
		}
		
		$('.checkbox-inscription').change(function() {

			if($('#check-prem').prop('checked')){//premium
				$('#particulier').css('display','none');
				$('#professionnel').css('display','block');
				$('#professionnel').prop('selected', true);
				$('#particulier').prop('selected', false);
				
			}else{
				$('#professionnel').css('display','none');
				$('#particulier').css('display','block');
				$('#particulier').prop('selected', true);
				$('#professionnel').prop('selected', false);
			}
			

			if($('#select-pro').val()=="2"){
				$('#professionnelTVA').append(val);
			}else{
				$('#professionnelTVA').remove();
			}
		});
			
		//docready
		});
		
	</script>
  </body>
</html>