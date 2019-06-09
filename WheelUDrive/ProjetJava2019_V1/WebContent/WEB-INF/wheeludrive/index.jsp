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
		
		<link rel="shortcut icon" type="image/x-icon" href="assets/uikit/ui-ecommerce/images/favicon.ico">

		<!-- Bootstrap -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

		<!-- Font awesome 5 -->
		<link href="assets/uikit/ui-ecommerce/fonts/fontawesome/css/fontawesome-all.css" type="text/css" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

		
		<link href="https://fonts.googleapis.com/css?family=Catamaran:400,800" rel="stylesheet">
		<!-- Material-icons -->
		<link href="assets/uikit/ui-ecommerce/fonts/material-icons/material-icons.css" type="text/css" rel="stylesheet">
		<!-- UI KIT -->
		<link href="assets/uikit/ui-ecommerce/css/responsive.css"  rel="stylesheet">
		<link href="assets/uikit/ui-ecommerce/css/ui.css"  rel="stylesheet">
		<!-- custom styles -->
    <link href="assets/css/style.css" rel="stylesheet">
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
									<img  src="assets/images/fr.png"> 
								</a>
								<ul class="dropdown-menu dropdown-menu-right" style="min-width: 70px;">
									<li><a class="dropdown-item" href="#"><img  src="assets/images/en.png"></a></li>
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
							<a href="wheeludrive" ><img class="logo" src="assets/images/logoV3.png" width="auto"></a>
						</div> <!-- brand-wrap.// -->
						</div>
						<div class="col-lg-4 col-xl-6 col-sm-8">
								<form action="#" class="search-wrap">
									<div class="input-group ">
									<span class="nav-wish">Je souhaite acheter</span>	 
											<!-- <select class="custom-select-lg custom-select"  name="category_name">
													<option value="">Acheter</option>
													<option value="codex">Louer</option>
											</select> -->
											<input type="text" class="form-control-lg w-input-wish" placeholder="BMW, Volkswagen, 308, ...">
											
											<div class="input-group-append">
												<button class="btn btn-primary" type="submit">
													<i class="fa fa-search"></i>
												</button>
											</div>
										</div>
								</form> <!-- search-wrap .end// -->
						</div> <!-- col.// -->
						<div class="col-lg-5 col-xl-3 col-sm-12">
							<div class="widgets-wrap float-right">
								<!-- <a href="#" class="widget-header mr-3">
									<div class="icontext">
										<div class="icon-wrap"><i class="icon-sm round border fa fa-heart"></i></div>
										<div class="text-wrap">
												<span class="small badge badge-danger">0</span>
											<small style="color:#000;">Favoris</small>
										</div>
									</div>
								</a> -->
								<div class="widget-header dropdown">
									<a href="#" data-toggle="dropdown" data-offset="20,10">
										<div class="icontext">
											<div class="icon-wrap"><i class="icon-sm round border fa fa-user"></i></div>
											<div class="text-wrap">
												<small style="color:#000;">Se connecter | S'incrire</small>
											</div>
										</div>
									</a>
									<div class="dropdown-menu dropdown-menu-right">
										<form class="px-4 py-3">
											<div class="form-group">
												<label>Email</label>
												<input type="email" class="form-control" placeholder="email@exemple.com">
											</div>
											<div class="form-group">
												<label>Mot de passe</label>
												<input type="password" class="form-control" placeholder="Mot de passe">
											</div>
											<button type="submit" class="btn btn-primary">Se connecter</button>
											</form>
											<hr class="dropdown-divider">
											<a class="dropdown-item" href="#" data-toggle="modal" data-target="#modal-sign">S'inscrire</a>
											<a class="dropdown-item" href="#" data-toggle="modal" data-target="#modal-pswd-lost">Mot de passe oublié?</a>
									</div> <!--  dropdown-menu .// -->
								</div>  <!-- widget-header .// -->
							</div> <!-- widgets-wrap.// -->
						</div> <!-- col.// -->
					</div> <!-- row.// -->
				</div> <!-- container.// -->
			</section> <!-- header-main .// -->
		</header> <!-- section-header.// -->
		
	

	
	
	
	    <footer class="text-center">
	      <div class="container">
	        <div class="row">
	          <div class="col-12">
	            <p>Copyright © MyWebsite. All rights reserved.</p>
						</div>
						
	
				<!-- =========================MODALS========================= -->
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
						<div class="modal-dialog">
							<div class="modal-content">
	
							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">Inscription</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<!-- Modal body -->
							<div class="modal-body">
								<article class="">
										<form action="">
												<div class="form-group input-group">
													<div class="input-group-prepend">
															<span class="input-group-text"> <i class="fa fa-user"></i> </span>
													</div>
															<input name="" class="form-control" placeholder="Nom" type="text" required>
												</div> <!-- form-group// -->
												<div class="form-group input-group">
													<div class="input-group-prepend">
															<span class="input-group-text"> <i class="fa fa-user"></i> </span>
													</div>
															<input name="" class="form-control" placeholder="Prénom" type="text" required>
												</div> <!-- form-group// -->
													<div class="form-group input-group">
														<div class="input-group-prepend">
															<span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
													</div>
															<input name="" class="form-control" placeholder="Email" type="email" required>
													</div> <!-- form-group// -->
													<div class="form-group input-group">
														<div class="input-group-prepend">
															<span class="input-group-text"> <i class="fa fa-phone"></i> </span>
													</div>
													<select class="custom-select" style="max-width: 120px;">
															<option selected="">+32</option>
													</select>
														<input name="" class="form-control" placeholder="téléphone" type="tel" required>
													</div> <!-- form-group// -->
													<div class="form-group input-group">
														<div class="input-group-prepend">
															<span class="input-group-text"> <i class="fa fa-building"></i> </span>
													</div>
													<select class="form-control custom-select">
														<option selected="" disabled aria-required="true" required> Créer un compte en tant que...</option>
														<option>Particulier</option>
														<option>Professionnel</option>
													</select>
												</div> <!-- form-group end.// -->
													<div class="form-group input-group">
														<div class="input-group-prepend">
															<span class="input-group-text"> <i class="fa fa-lock"></i> </span>
													</div>
															<input class="form-control" placeholder="Create password" type="password">
													</div> <!-- form-group// -->
													<div class="form-group input-group">
														<div class="input-group-prepend">
															<span class="input-group-text"> <i class="fa fa-lock"></i> </span>
													</div>
															<input class="form-control" placeholder="Repeat password" type="password">
													</div> <!-- form-group// -->                                      
													<div class="form-group">
															<button type="submit" class="btn btn-primary btn-block"> Créer un compte  </button>
													</div> <!-- form-group// -->      
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
	
				<!-- ./MODALS -->
					</div>
				</div>
			</footer>
			


<!-- jQuery  -->
<script src="assets/uikit/ui-ecommerce/js/jquery-2.0.0.min.js" type="text/javascript"></script>
<!--Bootstrap-->
<script src="assets/uikit/ui-ecommerce/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<!-- plugin: fancybox  -->
<script src="assets/uikit/ui-ecommerce/plugins/fancybox/fancybox.min.js" type="text/javascript"></script>
<link href="assets/uikit/ui-ecommerce/plugins/fancybox/fancybox.min.css" type="text/css" rel="stylesheet">
<!-- plugin: owl carousel  -->
<link href="assets/uikit/ui-ecommerce/plugins/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
<link href="assets/uikit/ui-ecommerce/plugins/owlcarousel/assets/owl.theme.default.css" rel="stylesheet">
<script src="assets/uikit/ui-ecommerce/plugins/owlcarousel/owl.carousel.min.js"></script>

<!-- plugin: slickslider -->
<link href="assets/uikit/ui-ecommerce/plugins/slickslider/slick.css" rel="stylesheet" type="text/css" />
<link href="assets/uikit/ui-ecommerce/plugins/slickslider/slick-theme.css" rel="stylesheet" type="text/css" />
<script src="assets/uikit/ui-ecommerce/plugins/slickslider/slick.min.js"></script>
<!--custom-->
<script src="assets/uikit/ui-ecommerce/js/script.js" type="text/javascript"></script>

<!-- <script src="js/jquery-3.2.1.min.js"></script> -->
	<script>
	$(document).ready(function(){
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
	
		
		
	//docready
	});
	
	</script>
  </body>
</html>