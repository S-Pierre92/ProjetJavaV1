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
		<div class="container">
		<div class="titleH1-left"></div>
		<div class="titleH1">

			<h4 class="skewxTxt ">CONTACT</h4>
		</div>
		<div class="titleH1-right">
		</div>
		<div class="titleH1-right2">
		</div>
		<hr>
		<!--row cards -->
	  	<div class="row ">
			<form method="post">

					<div><input type="hidden" name="contactToken" value="f74c9dce5dedfef8a194bfb4fc99581a"></div>
					<div><input type="hidden" name="concessionId" value=""></div>
					<div class="row">


						<!--company-->

						<div class="form-group col-xs-12 col-sm-6">
							<label for="garage-company"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Société </font></font></label>
							<input type="text" class="form-control" id="garage-company" name="company">
						</div>

						<!--Family Name-->

						<div class="form-group col-xs-12 col-sm-6">
							<label for="garage-fname"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Prénom *</font></font></label>
							<input type="text" class="form-control" id="garage-fname" name="req_firstname" required="">
						</div>

						<!--Name-->

						<div class="form-group col-xs-12 col-sm-6">
							<label for="garage-name"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Nom *</font></font></label>
							<input type="text" class="form-control" id="garage-name" name="req_lastname" required="">
						</div>

						<!--Adress-->

						<div class="form-group col-xs-12 col-sm-6">
							<label for="garage-address"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Adresse et numéro de maison</font></font></label>
							<input type="text" class="form-control" id="garage-address" name="address">
						</div>

						<!--Postcode-->

						<div class="form-group col-xs-12 col-sm-6">
							<label for="garage-postcode"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Code postal *</font></font></label>
							<input type="number" class="form-control" id="garage-postcode" name="req_postcode" required="">
						</div>

						<!--City-->

						<div class="form-group col-xs-12 col-sm-6">
							<label for="garage-town"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Ville</font></font></label>
							<input type="text" class="form-control" id="garage-town" name="city">
						</div>


						<!--Country-->

						<div class="form-group col-xs-12 col-sm-6">
							<label for="garage-country"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Pays</font></font></label>
							<select class="form-control" id="garage-country" name="country">

					<option selected="selected" value="België"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Belgique</font></font></option>
						<option value="Denemarken"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Danemark</font></font></option>
						<option value="Duitsland"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Allemagne</font></font></option>
						<option value="Finland"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">La finlande</font></font></option>
						<option value="Frankrijk"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">France</font></font></option>
						<option value="Griekenland"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Grèce</font></font></option>
					
				</select>
						</div>


						<!--Phone-->

						<div class="form-group col-xs-12 col-sm-6">
							<label for="garage-phone"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Téléphone</font></font></label>
							<input type="tel" class="form-control" id="garage-phone" name="tel_phone">
						</div>
						<!--Adress Mail-->
						<div class="form-group col-xs-12 col-sm-6">
							<label for="garage-email"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Adresse email *</font></font></label>
							<input type="text" class="form-control" id="garage-email" name="req_email_mail" required="">
						</div>


						<!--Concession-->

						<div class="form-group col-xs-12 col-sm-6">
							<label for="garage-concessions"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Point de vente</font></font></label>

							<select class="form-control" id="garage-concessions" name="concessions">

								<option value="" selected="" disabled=""><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Point de vente *</font></font></option>
								<option value="1"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Contactez Dilsen</font></font></option>
								<option value="2"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Contactez MidLim</font></font></option>
								<option value="3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Contactez Maasland</font></font></option>
								<option value="4"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Contactez Genk </font></font></option>

							</select>
						</div>

						<!--would -->

						<div class="form-group col-xs-12 col-sm-12">
							<br>
							<h4 class="margin-bottom-sm"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Je voudrais ...</font></font></h4>

							<input type="radio" name="wouldlike" value="Informatie aanvragen" id="garage-wouldlike1">
							<label for="garage-wouldlike1"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Demande d'information</font></font></label><br>

							<input type="radio" name="wouldlike" value="Offerte aanvragen" id="garage-wouldlike2">
							<label for="garage-wouldlike2"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Demander un devis</font></font></label><br>

							<input type="radio" name="wouldlike" value="Opmerking plaatsen" id="garage-wouldlike3">
							<label for="garage-wouldlike3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Publier un commentaire</font></font></label><br>

							<input type="radio" name="wouldlike" value="Klacht plaatsen" id="garage-wouldlike4">
							<label for="garage-wouldlike4"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Déposer une plainte</font></font></label><br>

						</div>


						<!--Message-->

						<div class="form-group col-12">
							<label for="garage-message"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Votre message *</font></font></label>
							<textarea id="garage-message" class="form-control" rows="6" name="req_content" required=""></textarea>
						</div>
						<!--button submit-->
						<div class="form-group col-12">
							<button type="submit" name="submitContact" class="btn btn-danger btn-md"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Envoyer immédiatement</font></font></button>

						<p><i><br><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Vos données ne seront utilisées que pour suivre cette demande et ne seront pas transmises à des tiers </font></font></i></p>
						</div>




					</div>
				</form>
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