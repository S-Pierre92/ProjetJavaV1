<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Template</title>
    <!-- Bootstrap -->
  	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link href="../css/bootstrap-4.0.0.css" rel="stylesheet">
	<!--OWL Carousel slider-->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.css" rel="stylesheet"  type="text/css">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.theme.min.css" rel="stylesheet"  type="text/css">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.transitions.css" rel="stylesheet"  type="text/css">
	  
    <link href="../css/style.css" rel="stylesheet">
  </head>
  <body>
	 <div class="nav-group">
		  <!-- Nav bar #1 -->
		<nav class="navbar navbar-dark bg-dark">
		  <div class="container text-center">
			  <div class="fa-pull-left FFF">xx-xxxx-xxx</div>
				<a class="navbar-brand" style="    padding: 0px;" href="#"> <img class="imgLogo" src="../images/logo.png"></a>	
			  <div class="fa-pull-right FFF">xxx-xxx-xx</div>

		  </div>
		</nav>
		  <!-- Nav bar #2 -->
		<div class="nav-left-custom" ></div>
		<nav class="navbar navbar-expand-lg navbar-dark navbarCustom">
		  <div class="container">

			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
			  <ul class="navbar-nav mr-auto ml-auto skewxNav">
				<li class="nav-item  active">
				  <a class="nav-link" href="../index.php">Accueil <span class="sr-only"></span></a>
				</li>
				<li class="nav-item ">
				  <a class="nav-link" href="fiche-veh.php">Notre stock</a>
				</li>
				<li class="nav-item  dropdown">
				  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Contact</a>
				  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Nous contacter</a><div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Demande d'un essai</a><div class="dropdown-divider"></div>
				   <!-- <div class="dropdown-divider"></div>-->
					<a class="dropdown-item" href="#">Demande de reprise</a>
				  </div>
				</li>
			   <li class="nav-item  noBorder" >
				  <a class="nav-link" href="#">A propos de nous</a>
				</li>
			  <!--  <li class="nav-item">
				  <a class="nav-link disabled" href="#">Disabled</a>
				</li>-->
			  </ul> 
			 <!-- <form class="form-inline my-2 my-lg-0 ">
				<input class="form-control mr-sm-2" type="search" placeholder="" aria-label="Search">
				<button class="btn btn-oblique my-2 my-sm-0" type="submit"><span class=""> Search</span></button>
			  </form>-->
			</div>
		  </div>
		</nav>
		<div class="nav-right-custom" ></div> 
	  </div>
	  		<!-- slider -->
		<div id="sliders" class="owl-carousel owl-theme">
		  <div class="item"><img src="https://www.fastbackdev.be/devdeb/data/cars/2777/resized_8781560515c2cd58d09595.jpg" class="img-responsive" alt="image"> </div>
		  <div class="item"><img src="https://www.fastbackdev.be/devdeb/data/cars/2777/resized_14277353665c2cd58d86651.jpg" class="img-responsive" alt="image"> </div>
		  <div class="item"><img src="https://www.fastbackdev.be/devdeb/data/cars/2777/resized_3029754725c2cd58d9ace5.jpg" class="img-responsive" alt="image"></div>
		  <div class="item"><img src="https://www.fastbackdev.be/devdeb/data/cars/2777/resized_3983960995c2cd58d710ab.jpg" class="img-responsive" alt="image"> </div>
		  <div class="item"><img src="https://fastbackdev.be/devdeb/data/cars/2777/resized_9447077655c2cd58d5c958.jpg" class="img-responsive" alt="image"></div>
		  <div class="item"><img src="https://fastbackdev.be/devdeb/data/cars/2777/resized_14783694725c2cd58dae3d0.jpg" class="img-responsive" alt="image"></div>
		</div>

	  
		<!-- end slider -->
	
	    <nav class="navCustom">
			<div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
			  <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">
				  <i class="fas fa-car"></i> Aperçu du véhicule</a>
			  <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false"><i class="fas fa-wrench"></i> Spécifications techniques</a>
			  <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false"><i class="fas fa-clipboard-list"></i> Equipements</a>
			  </div>
		  </nav>
		  
    <div class="container-fluid">
		
	<div class="container mt-5">
		<div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
			<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
			  	<div class="row">
					<div class="col-sm-7">
						<h1 class="fontPrix">Mini Cooper </h1>
						<h2 class="">Countryman </h2>
					</div>
					<div class="col-sm-5 ">
						<div class="blockPrice  text-right">
						 	<h5 class="fontAncienPrix"><s>39.999 &euro;</s></h5>
							 <h1 class="fontPrix">33.999 &euro;</h1><br>
							<h5 class="fontTva">TVA deductible</h5>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
					<hr></div>
					<div class="col-sm-6">
						
					<div class="blockGarantie">
						
					  <h4 class="fontGarantie">
						  12 mois 
						  de garantie<br>
						  <img class="garantieLabelImg" src="../images/cartouche-bmw-fr.jpg" style="    width: 100%;max-width: 260px;">
						</h4>
					</div>
					</div>
					<div class="col-sm-6">
						
					<div class="blockGarantie">
						
					  <p class="fontGarantie text-right"><br>
						Référence : VO2387
						</p>
					</div>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
					<hr></div>
					 <div class="row" >
					  <div class="col-md-6 maps" >


						 <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2540.3577627004897!2d4.762630415726784!3d50.45306227947575!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47c19ade88a96be9%3A0x9a5928c37bf5717e!2sRue+Emer%C3%A9e+6%2C+5150+Floreffe!5e0!3m2!1sfr!2sbe!4v1548282987022" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>


					  </div>
					  <div class="col-md-6">
						<h2 class="text-uppercase mt-3 font-weight-bold">Contact</h2>
						<form action="">
						  <div class="row">
							<div class="col-lg-6">
							  <div class="form-group">
								<input type="text" class="form-control mt-2" placeholder="Nom/Société" required>
							  </div>
							</div>
							<div class="col-lg-6">
							  <div class="form-group">
								<input type="text" class="form-control mt-2" placeholder="Référence véhicule" required>
							  </div>
							</div>
							<div class="col-lg-6">
							  <div class="form-group">
								<input type="email" class="form-control mt-2" placeholder="Email" required>
							  </div>
							</div>
							<div class="col-lg-6">
							  <div class="form-group">
								<input type="number" class="form-control mt-2" placeholder="Téléphone" required>
							  </div>
							</div>
							<div class="col-12">
							  <div class="form-group">
								<textarea class="form-control" id="exampleFormControlTextarea1" placeholder="Remarques" rows="3" required></textarea>
							  </div>
							</div>
					  <!--      <div class="col-12">
							<div class="form-group">
							  <div class="form-check">
								<input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
								<label class="form-check-label" for="invalidCheck2">
								  Accetta le condizioni
								</label>
							  </div>
							</div>
							</div>-->
							<div class="col-12">
							  <button class="btn btn-danger" type="submit">Envoyer</button>
							</div>
						  </div>
						</form>

					  </div>

					</div>	
				</div>
			</div>
			<div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
				<div class="row background">
				<div class="col-sm-4 listTech">
					<h5>
						<i class="fas fa-road"></i>  132 800 km
					</h5>
					<h5>
						<i class="fas fa-user"></i>  4/5-Portes (4x4)
					</h5>
					<h5 >
						<img src="../images/levier.png" width="20px">  Autom. 6 vit.
					</h5>
					<h5 >
						<img src="../images/co2.png" width="30px">  30gr/km
					</h5>
				</div>
				<div class="col-sm-4 listTech">
					<h5>
						<i class="fas fa-calendar-alt"></i> 08/2017
					</h5>
					<h5 >
						<i class="fas fa-gas-pump"></i>  Diesel
					</h5>
					<h5 >
						<i class="fas fa-tachometer-alt-fast"></i>  110kw / 149cv
					</h5>
					<h5 >
						<i class="fas fa-paint-roller"></i>  Ext&eacute;rieur blanc
					</h5>
					
				</div>
				<div class="col-sm-4 listTech">
					<h5>
						<i class="fas fa-bolt"></i> 1995cc
					</h5>
					
					<h5>
						<i class="fas fa-leaf"></i> Euro 5
					</h5>
					
					<h5>
						<i class="fas fa-users"></i> 2 propri&eacute;taires
					</h5>
					
					<h5>
						<i class="fas fa-palette"></i> Int&eacute;rieur noir 
					</h5>
					
				</div>
				</div>
			</div>
			<div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
			 <div class="row ">
					<div class=" col-sm-4 background ">
						<ul class="list-unstyled listEquipement">
							<li class="">
								<i class="fas fa-check"></i> Auto Park Assist
							</li>
							<li class="">
								<i class="fas fa-check"></i> Banquette arri&egrave;re rabattable
							</li>
							<li class="">
								<i class="fas fa-check"></i> Avertisseur de collision
							</li>
							<li class="">
								<i class="fas fa-check"></i> L&egrave;ve-vitres avant &eacute;lectrique
							</li>
							<li class="">
								<i class="fas fa-check"></i> Syst&egrave;me de navigation (GPS)

							</li>
							<li class="">
								<i class="fas fa-check"></i> Phares au x&eacute;non


							</li>
						</ul>
					</div>
					<div class=" col-sm-4 background ">
						<ul class="list-unstyled listEquipement">
							<li class="">
								<i class="fas fa-check"></i> Auto Park Assist
							</li>
							<li class="">
								<i class="fas fa-check"></i> Banquette arri&egrave;re rabattable
							</li>
							<li class="">
								<i class="fas fa-check"></i> Avertisseur de collision
							</li>
							<li class="">
								<i class="fas fa-check"></i> L&egrave;ve-vitres avant &eacute;lectrique
							</li>
							<li class="">
								<i class="fas fa-check"></i> Syst&egrave;me de navigation (GPS)

							</li>
							<li class="">
								<i class="fas fa-check"></i> Phares au x&eacute;non


							</li>
						</ul>
					</div>
					<div class=" col-sm-4 background ">
						<ul class="list-unstyled listEquipement">
							<li class="">
								<i class="fas fa-check"></i> Auto Park Assist
							</li>
							<li class="">
								<i class="fas fa-check"></i> Banquette arri&egrave;re rabattable
							</li>
							<li class="">
								<i class="fas fa-check"></i> Avertisseur de collision
							</li>
							<li class="">
								<i class="fas fa-check"></i> L&egrave;ve-vitres avant &eacute;lectrique
							</li>
							<li class="">
								<i class="fas fa-check"></i> Syst&egrave;me de navigation (GPS)

							</li>
							<li class="">
								<i class="fas fa-check"></i> Phares au x&eacute;non


							</li>
						</ul>
					</div>
					
				</div>
			</div>
			
		  </div>
		
		<hr>
		<!-- col left -->
		<div class="row">
		<div class="col-md-6">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="block"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- col right -->

		<div class="col-md-7">
			<div class="container">
				<div class="row">
					<div class="col-12">
						

					</div>
				</div>
			</div>
		</div>
		<!-- col right -->
		</div>

	
	
		<hr>
		
	</div><!-- end container top deal -->

	</div><!--container fluid-->

	  <div class=" text-white bg-dark p-4">
		  <div class="row">
			<div class="col-6 col-md-8 col-lg-7">
			  <div class="row text-center">
				<div class="col-sm-6 col-md-4 col-lg-4 col-12">
				  <ul class="list-unstyled">
					<li class="btn-link"> <a>Link anchor</a> </li>
					<li class="btn-link"> <a>Link anchor</a> </li>
					<li class="btn-link"> <a>Link anchor</a> </li>
					<li class="btn-link"> <a>Link anchor</a> </li>
					<li class="btn-link"> <a>Link anchor</a> </li>
				  </ul>
				</div>
				<div class="col-sm-6 col-md-4 col-lg-4 col-12">
				  <ul class="list-unstyled">
					<li class="btn-link"> <a>Link anchor</a> </li>
					<li class="btn-link"> <a>Link anchor</a> </li>
					<li class="btn-link"> <a>Link anchor</a> </li>
					<li class="btn-link"> <a>Link anchor</a> </li>
					<li class="btn-link"> <a>Link anchor</a> </li>
				  </ul>
				</div>
				<div class="col-sm-6 col-md-4 col-lg-4 col-12">
				  <ul class="list-unstyled">
					<li class="btn-link"> <a>Link anchor</a> </li>
					<li class="btn-link"> <a>Link anchor</a> </li>
					<li class="btn-link"> <a>Link anchor</a> </li>
					<li class="btn-link"> <a>Link anchor</a> </li>
					<li class="btn-link"> <a>Link anchor</a> </li>
				  </ul>
				</div>
			  </div>
			</div>
			<div class="col-md-4 col-lg-5 col-6">
			   <div class="text-white">
				<h2 class="text-uppercase mt-4 font-weight-bold">Concession Name</h2>

				<i class="fas fa-phone mt-3"></i> <a href="tel:+">(+39) 123456</a><br>
				<i class="fa fa-envelope mt-3"></i> <a href="">info@test.it</a><br>
				<i class="fas fa-map-marker-alt  mt-3"></i> Rue Emerée 6, 5040 Floriffoux<br>
				<div class="my-4">
				<a href=""><i class="fab fa-facebook  pr-4"></i></a>
				<a href=""><i class="fab fa-linkedin "></i></a>
				</div>
				</div>
			</div>
		  </div>
		</div>
    <footer class="text-center">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <p>Copyright © MyWebsite. All rights reserved.</p>
          </div>
        </div>
      </div>
    </footer>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	
    <script src="../js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap-4.0.0.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.js" ></script>
	<script>
	$(document).ready(function(){

		
		 $("#sliders").owlCarousel({
			    // Owl features
				itemsCustom : [
						[0, 1],
						[450, 1],
						[700, 1],
						[1024, 3],
						[1200, 3],
					  ],
					  loop: true,
					  navigation : false,
					  navText: ["<i class='fas fa-3x fa-chevron-left'></i>test", "<i class='fas fa-3x fa-chevron-right'></i>test"],
					  pagination: false,
					  autoPlay  : 5000
						  });
		
		
	//docready
	});
	
	</script>
  </body>
</html>