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
				  <a class="nav-link" href="stock.php">Notre stock</a>
				</li>
				<li class="nav-item  dropdown">
				  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Contact</a>
				  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="contact.php">Nous contacter</a><div class="dropdown-divider"></div>
					<a class="dropdown-item" href="testdrive.php">Demande d'un essai</a><div class="dropdown-divider"></div>
				   <!-- <div class="dropdown-divider"></div>-->
					<a class="dropdown-item" href="reprise.php">Demande de reprise</a>
				  </div>
				</li>
			   <li class="nav-item  noBorder" >
				  <a class="nav-link" href="about.php">A propos de nous</a>
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
    <div class="container-fluid">
		<!--carousel-->
		<div class="">
		  <div class="row">
			<div class="carouselStock">
			  <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
		
				<div class="carousel-inner carouselStockHeight">
				  <div class="carousel-item active">
					<img class="d-block w-100" src="../images/slide1.jpg" alt="First slide">
					<div class="carousel-caption d-none d-md-block">
					  <h5></h5>
					  <p></p>
					</div>
				  </div>
				  <div class="carousel-item">
					<img class="d-block w-100" src="../images/slide2.jpg" alt="Second slide">
					<div class="carousel-caption d-none d-md-block">
					  <h5></h5>
					  <p> </p>
					</div>
				  </div>
				  <div class="carousel-item">
					<img class="d-block w-100" src="../images/slide3.jpg" alt="Third slide">
					<div class="carousel-caption d-none d-md-block">
					  <h5></h5>
					  <p></p>
					</div>
				  </div>
				</div>
				
				</a>
			  </div>
			</div>
		  </div>
		 
		</div>
		
	<hr>
		<!-- top deal -->
		<div class="container"><br>
		<div class="titleH1-left"></div>
		<div class="titleH1">

			<h4 class="skewxTxt ">Demande de reprise </h4>
		</div>
		<div class="titleH1-right">
		</div>
		<div class="titleH1-right2">
		</div><br><br>
	  </div>
		<!--row cards -->
	  <div class="container">
	  	<div class="row ">
	  	<div class="col-12 ">
			<form id="form-reprise" method="post" action="">
				<div><input type="hidden" name="repriseToken" value="5c20011273d6ff9fd4de77f45b18b7f4"></div>
                                
                                <!-- Part 1 -->
						<fieldset class="row margin-bottom-sm part1">
						<div class="row">
							<div class="col-12">
								<h4 class="titleForm">Informations</h4><br>
							</div>
						</div>
						<div class="row">
						<div class="col-sm-6 ">
							<div class="form-group ">
								<label>Civilité</label>
								<select class="form-control" name="req_civility">
									<option value="0" selected="" disabled="">Choisissez</option>
									<option value="Monsieur">Monsieur</option>
									<option value="Madame">Madame</option>
									<option value="Mademoiselle">Mademoiselle</option>                             
								</select>
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
								<label>Nom *</label>
								<input type="text" class="form-control" name="req_lastname" value="" required="">
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
								<label>Prénom *</label>
								<input type="text" class="form-control" name="req_firstname" value="" required="">
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
								<label>E-mail *</label>
								<input type="email" class="form-control" name="req_email_mail" value="" required="">
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
								<label>Code postal *</label>
								<input type="text" class="form-control" name="req_postcode" value="" required="">
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
								<label>Téléphone *</label>
								<input type="tel" class="form-control" name="req_phone_phone" value="" required="">
							</div>
						</div>
					
						<div class=" col-sm-6">
							<div class="form-group ">
								Premier/ère propriétaire ? *
								<ul class="list-unstyled list-inline">
									<li class="main-search-form-radio list-inline-item">
										<input type="radio" class="hidden" name="req_owner" id="req-owner-yes" value="Oui">
										<label for="req-owner-yes" class="radio-inline">
											Oui
										</label>
									</li>
									<li class="main-search-form-radio list-inline-item">
										<input type="radio" class="hidden" name="req_owner" id="req-owner-no" value="Non">
										<label for="req-owner-no" class="radio-inline">
											Non
										</label>
									</li>
								</ul>
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
							<label>Date 1<sup>ère</sup> mise en circulation *</label>
							<div class="form-inline">
							<select class="form-control" name="req_day" required="">
								<option value="" selected="" disabled="">00</option>
								<option value="01">01</option>         
								<option value="02">02</option>         
								<option value="03">03</option>         
								<option value="04">04</option>         
								<option value="05">05</option>         
								<option value="06">06</option>         
								<option value="07">07</option>         
								<option value="08">08</option>         
								<option value="09">09</option>         
								<option value="10">10</option>         

							</select>
							<select class="form-control" name="req_month" required="">
								<option value="" selected="" disabled="">00</option>
								<option value="01">01</option>         
								<option value="02">02</option>         
								<option value="03">03</option>         
								<option value="04">04</option>         
								<option value="05">05</option>         
								<option value="06">06</option>         
								<option value="07">07</option>         
								<option value="08">08</option>         
								<option value="09">09</option>         
								<option value="10">10</option>         
								<option value="11">11</option>         
								<option value="12">12</option>
							</select>
								<select class="form-control" name="req_year" required="">
									<option value="" selected="" disabled="">0000</option>
									<option value="1993<">1993</option> 
									<option value="1992<">1992</option> 
									<option value="1991<">1991</option> 
									<option value="1990<">1990</option> 
								</select>
								</div>
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
								<label>Kilométrage actuel *</label>
								<input type="number" class="form-control" name="req_km_int" value="" required="">
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
								<label>Marque *</label>
								<select class="form-control" name="req_brandId" id="brand">
									<option value="0" selected="" disabled="">Choisissez</option>
									<option value="126">Tata</option>
									<option value="150">Tesla</option>
									<option value="127">Thunderbird</option>
									<option value="128">Toyota</option>
									<option value="129">Trabant</option>
									<option value="130">Triumph</option>
									<option value="131">TVR</option>
									<option value="132">Ultima</option>
									<option value="133">UMM</option>
									<option value="134">Vauxhall</option>
									<option value="135">Venturi</option>
									<option value="136">Volga</option>
								</select>
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group ">
								<label>Modèle *</label>
								<select class="form-control" name="req_modelId" id="model">
									<option value="0" selected="" disabled="">Choisissez</option> 

								</select>
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
								<label>Version</label>
								<input type="text" class="form-control" name="version" value="">
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
								<label>Sièges *</label>
								<select class="form-control" name="req_seats" required="">
									<option value="0" selected="" disabled="">Choisissez</option>
									<option value="cuir">Cuir</option>
									<option value="semi-cuir">Semi-cuir</option>
									<option value="tissu">Tissu</option>       
								</select>
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
								<label>Motorisation *</label>
								<input type="text" class="form-control" name="req_motorisation" value="" required="">
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
								<label>Boîte vitesse *</label>
								<select class="form-control" name="req_speeds" required="">
									<option value="0" selected="" disabled="">Choisissez</option>
									<option value="automatique">Automatique</option>
									<option value="manuelle">Manuelle</option>      
								</select>
							</div>
						</div>
						<div class="col-sm-6 ">
							<div class="form-group">
								<label>Carburant *</label>
								<select class="form-control" name="req_fuel" required="">
									<option value="0" selected="" disabled="">Choisissez</option>
									<option value="Autre">Autre</option>
									<option value="Diesel">Diesel</option>
									<option value="Electrique">Électrique</option>
									<option value="Essence">Essence</option>

								</select>
							</div>
						</div>
						 </div>  
						</fieldset>

						<!-- Part 2 -->
						<fieldset class="row margin-bottom-sm part2">
							<div class=" col-12 "><br>
								<h4  class="titleForm">Options spécifiques</h4><br>
								<div class="row">
									<div class="col-sm-6">
										<ul class="list-unstyled margin-bottom-sm">
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions18" value="7 places">
												<label for="carOptions18" class="checkbox-inline">
													7 places
												</label>
											</li>
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions4" value="climatisation manuelle">
												<label for="carOptions4" class="checkbox-inline">
													Climatisation manuelle
												</label>
											</li>
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions5" value="climatisation automatique">
												<label for="carOptions5" class="checkbox-inline">
													Climatisation automatique
												</label>
											</li>
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions16" value="lève-vitres arrière électrique">
												<label for="carOptions16" class="checkbox-inline">
													Lève-vitres arrière électrique
												</label>
											</li>
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions17" value="lève-vitres avant électrique">
												<label for="carOptions17" class="checkbox-inline">
													Lève-vitres avant électrique
												</label>
											</li>
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions25" value="régulateur de vitesse">
												<label for="carOptions25" class="checkbox-inline">
													Régulateur de vitesse
												</label>
											</li>
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions27" value="rétroviseurs électriques">
												<label for="carOptions27" class="checkbox-inline">
													Rétroviseurs électriques
												</label>
											</li>
										</ul>
									</div>
									<div class="col-sm-6">
										<ul class="list-unstyled margin-bottom-sm">
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions28" value="sièges AV à réglage électrique">
												<label for="carOptions28" class="checkbox-inline">
													Sièges AV à réglage électrique
												</label>
											</li>
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions29" value="sièges avant chauffants">
												<label for="carOptions29" class="checkbox-inline">
													Sièges avant chauffants
												</label>
											</li>
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions48" value="Connexion bluetooth">
												<label for="carOptions48" class="checkbox-inline">
													Connexion Bluetooth
												</label>
											</li>
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions47" value="GPS">
												<label for="carOptions47" class="checkbox-inline">
													GPS
												</label>
											</li>
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions23" value="Radio/CD">
												<label for="carOptions23" class="checkbox-inline">
													Radio/CD
												</label>
											</li>
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions15" value="Jantes en alliage">
												<label for="carOptions15" class="checkbox-inline">
													Jantes en alliage
												</label>
											</li>
											<li class="main-search-form-checkbox">
												<input type="checkbox" class="hidden" name="carOptions[]" id="carOptions33" value="Toit ouvrant">
												<label for="carOptions33" class="checkbox-inline">
													Toit ouvrant
												</label>
											</li>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-12 col-sm-12">
								<br><h4  class="titleForm">Commentaire</h4><br>
								<div class="form-group">
									<label>Dégâts constatés ? / Des remarques ?</label>
									<textarea class="form-control" rows="12" name="req_content"></textarea>
								</div>
							</div>
						</fieldset>

						<!-- Submit -->
						<div class="row">
							<div class="form-group col-12">
								<input type="submit" class="btn btn-danger btn-lg margin-bottom-sm" name="submit-reprise" value="Envoyer ma demande">
							</div>
						</div>
					</form>
		</div>
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
			  <address>
				<strong>MyStoreFront, Inc.</strong><br>
				Indian Treasure Link<br>
				Quitman, WA, 99110-0219<br>
				<abbr title="Phone">P:</abbr> (123) 456-7890
			  </address>
			  <address>
				<strong>Full Name</strong><br>
				<a href="mailto:#">first.last@example.com</a>
			  </address>
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
	<script>
	$(document).ready(function(){
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