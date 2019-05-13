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

			<h4 class="skewxTxt ">Demande de testdrive </h4>
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
		<form method="post">
	                           
			<div><input type="hidden" name="contactToken" value="aded972fba15dfb5a157019c105ce831"></div>
			<div><input type="hidden" name="concessionId" value=""></div>
  <div class="row">


		  <!--company-->

		  <div class="form-group col-xs-12 col-sm-6">
			  <label for="garage-company"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Société </font></font></label>
			  <input type="text" class="form-control" id="garage-company" name="company">
		  </div>

		  <!--Titre-->

		  <div class="form-group col-xs-12 col-sm-6">
			  <label for="garage-title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Salutation</font></font></label>

			  <select class="form-control" id="garage-title" name="title">
				  <option value="" selected="" disabled=""><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Salutation </font></font></option>
				  <option value="Dhr"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Monsieur </font></font></option>
				  <option value="Mev"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Madame </font></font></option>
				  <option value="Dr"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Dr </font></font></option>
			  </select>
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

			 <option value="Spanje"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">l'Espagne</font></font></option>
				<option value="Zweden"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Suède</font></font></option>
				<option value="Zwitserland"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">La suisse</font></font></option>
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
			  <input type="email" class="form-control" id="garage-email" name="req_email_mail" required="">
		  </div>
	

				  <div class="form-group col-xs-12 col-sm-12">


						  <a id="datePick"></a>
						  <h4 class="titleForm"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Choisissez une date *</font></font></h4>



						  <div id="datepicker"></div>

						  <input type="hidden" id="selectedDate" name="req_date">

				  </div>

	                                   
			 </div>

	           <!--Etape 2-->

				 <!--Heures-->
							


			<div class="row">
		
	  <!--Concession-->

				<div class="form-group  col-sm-6">
					<!--<label for="testrit-location">Verkooppunt</label>-->
					<select class="form-control" id="req-location" name="req-location" required="">
						<option value="" selected="" disabled=""><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Point de vente *</font></font></option>
						<option value="1"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Test de l'application Dilsen</font></font></option>
						<option value="2"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Test de l'application MidLim</font></font></option>
						<option value="3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Test de l'application Maasland</font></font></option>
						<option value="4"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Test de l'application de conduite Genk </font></font></option>

					</select>

				</div>
				
					<div class="form-group col-sm-6">
					<select class="form-control" id="req-time" name="req-time" required="">

						<option value="" selected="" disabled=""><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Heures de l'essai</font></font></option>
						<option value="08h30"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> 8h30 </font></font></option>
						<option value="09h00"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> 09h00 </font></font></option>
						<option value="09h30"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> 09h30 </font></font></option>
						<option value="10h00"> 10:00 </option>
						<option value="10h30"> 10:30 </option>
						<option value="11h00"> 11:00 </option>
						<option value="11h30"> 11:30 </option>
						<option value="12h00"> 12:00 </option>
						<option value="12h30"> 12:30 </option>
						<option value="13h00"> 13:00 </option>
						<option value="13h30"> 13:30 </option>
						<option value="14h00"> 14:00 </option>
						<option value="14h30"> 14:30 </option>
						<option value="15h00"> 15:00 </option>
						<option value="15h30"> 15:30 </option>
						<option value="16h00"> 16:00 </option>
						<option value="16h30"> 16:30 </option>


					</select>
					</div>
					</div>
				<div class="row">
					<!--Marque-->


					  <div class="form-group col-sm-6">
					  <p>Je souhaite faire mon testdrive avec :<br></p>
						<!--<label for="testrit-make2">Merk</label>-->
						  <select class="form-control" id="req-make2" name="req-make2" required="">
							  <option value="" selected="" disabled="">Merk *</option>
							  <option value="49"> Hyundai </option>
							  <option value="59"> Kia </option>
							  <option value="94"> Nissan </option>
							  <option value="79"> Mazda </option>
							  <option value="88"> Mitsubishi </option>
						   </select>



					<!--Modèle-->

						  <select class="form-control" id="req-form-model2" name="req-model2" required="">
							  <option value="" selected="" disabled="">Model *</option>
							</select>
					  </div>


<script type="text/javascript">


    $(document).ready(function(){
        $('#req-make2').change(function(){
            if($('#req-make2').val() == "94")
            {
                $('#req-form-model2').html(
                    '<option value="Micra"> Micra </option>' +
                    '<option value="Pulsar"> Pulsar</option>' +
                    '<option value="Juke"> Juke </option> ' +
                    '<option value="Qashqai"> Qashqai</option>' +
                    '<option value="X-trail"> X-trail</option>' +
                    '<option value="Evalia"> Evalia </option>' +
                    '<option value="E-NV200 Evalia">E-NV200 Evalia </option>' +
                    '<option value="Leaf"> Leaf</option> ' +
                    '<option value="370Z Coupé">370Z Coupé </option> ' +
                    
                    '<option value="370Z Roadster"> 370Z Roadster</option>'+
                    '<option value="GT-R"> GT-R</option>'+
                    '<option value="NV400"> NV400</option>'+
                    '<option value="Navara"> Navara</option>'+
                    '<option value="E-NV200"> E-NV200</option>');
            }
            if($('#req-make2').val() == "49")
            {
                $('#req-form-model2').html(
                    '<option value="New i10">New i10</option>' +
                    '<option value="i20 coupé">i20 coupé</option>' +
                    '<option value="New i20 5P">New i20 5P</option>' +
                    '<option value="i20 Active">i20 Active</option>' +
                    '<option value="ix20">ix20</option>' +
                    '<option value="i30 Wagon">i30 Wagon</option>' +
                    '<option value="All New i30">All New i30 </option>' +
                    '<option value="All New i30 Wagon">All New i30 Wagon</option>' +
                    '<option value="IONIQ hybrid">IONIQ hybrid</option>' +
                    '<option value="IONIQ plug-in hybrid">IONIQ plug-in hybrid</option>' +
                    '<option value="IONIQ electric">IONIQ electric</option>' +
                    '<option value="i40 Sedan">i40 Sedan</option>' +
                    '<option value="i40 Wagon">i40 Wagon</option>' +
                    '<option value="Fuel Cell">Fuel Cell</option>' +
                    '<option value="Kona">Kona</option>' +
                    '<option value="Tucson">Tucson</option>' +
                    '<option value="Santa Fe">Santa Fe </option>' +
                    '<option value="Grand Santa Fe">Grand Santa Fe </option>' +
                    '<option value="H1">H1 </option>' +
                    '<option value="H1 People">H1 People</option>' +
                    '<option value="H350 Van"> H350 Van</option>');
            }
            if($('#req-make2').val() == "59")
            {
                $('#req-form-model2').html(
                '<option value="Picanto"> Picanto </option>' +
                '<option value="Rio Cee\'d"> Rio Cee\'d</option>' +
                '<option value="Optima"> Optima </option>' +
                '<option value="Optima SW"> Optima SW</option>' +
                '<option value="Optima PHEV"> Optima PHEV </option>' +
                '<option value="Optima GT"> Optima GT</option>' +
                '<option value="Venga"> Venga</option>' +
                '<option value="Pro Cee\'d"> Pro Cee\'d</option>' +
                '<option value="Pro Cee\'d GT"> Pro Cee\'d GT</option>' +
                '<option value="Cee\'d "> Cee\'d </option>' +
                '<option value="Cee\'d GT"> Cee\'d GT</option>' +
                '<option value="Cee\'d Sportswagon"> Cee\'d Sportswagen</option>' +
                '<option value="Soul"> Soul</option>' +
                '<option value="Soul EV"> Soul EV</option>' +
                '<option value="Carens"> Carens</option>' +
                '<option value="Niro"> Niro</option>' +
                '<option value="Stonic"> Stonic</option>' +
                '<option value="Stinger"> Stinger</option>' +
                '<option value="Sportage"> Sportage</option>' +
                '<option value="Cee\'d Sportage">Cee\'d Sportage</option>' +
                '<option value="Sorento"> Sorento</option>');
            }
            if($('#req-make2').val() == "79")
            {
                $('#req-form-model2').html(
                '<option value="2"> 2 </option>'+
                '<option value="3"> 3</option>'+
                '<option value="6"> 6 </option>'+
                '<option value="CX-3"> CX-3</option>'+
                '<option value="CX-5"> CX-5</option>'+
                '<option value="MX-5"> MX-5</option>'+
                '<option value="MX-5 RF"> MX-5 RF</option>');
            }
            if($('#req-make2').val() == "88")
            {
                $('#req-form-model2').html(

                    '<option value="Space Star"> Space Star </option>'+
                    '<option value="Attrage"> Attrage</option>'+
                    '<option value="Asx"> Asx </option>'+
                    '<option value="Eclipse Cross"> Eclipse Cross</option>'+
                    '<option value="Outlander"> Outlander</option>'+
                    '<option value="Outlander PHEV"> Outlander PHEV</option>'+
                    '<option value="Pajero 3D"> Pajero 3D</option>' +
                    '<option value="Pajero 5D"> Pajero 5D</option>' +
                    '<option value="L200 Club CAB"> L200 Club CAB</option>'+
                    '<option value="L200 Double CAB"> L200 Double CAB</option>');
            }
            if($('#req-make2').val() == "52")
            {
                $('#req-form-model2').html(
						
					  '<option value="Single CAB"> Single CAB</option>'+
					  '<option value="Extended Cabine"> Extended Cabine</option>'+
					  '<option value="Double Cabine"> Double Cabine</option>'+
					  '<option value="Urban">Urban</option>'+
					  '<option value="AT35">AT35</option>'+
					  '<option value="Life">Life</option>'+
					  '<option value="Force">Force</option>'+
					  '<option value="Epérience">Expérience</option>'+
                    '<option value="D-Max">D-Max</option>');
            }





        });
		
		
		   $('#req-location').change(function(){
			   
				if($('#req-location').val() == "2")
				{
					$('#req-make').html(
						 '<option value="49"> Hyundai</option>'+
						  '<option value="59"> Kia</option>'+
						  '<option value="94"> Nissan </option>'+
						  '<option value="79"> Mazda</option>'+
						  '<option value="88">Mitsubishi</option>');
				}
			   
			   if($('#req-location').val() == "1")
				{
					$('#req-make').html(

						  
						  '<option value="59"> Kia</option>'+
						  '<option value="94"> Nissan </option>'+
						  '<option value="79"> Mazda</option>'+
						  '<option value="88">Mitsubishi</option>');
				}
			   
			    if($('#req-location').val() == "3")
				{
					$('#req-make').html(

						
						  '<option value="59"> Kia</option>'+
						  '<option value="94"> Nissan </option>'+
						  '<option value="79"> Mazda</option>'+
						  '<option value="88">Mitsubishi</option>');
				}
			    if($('#req-location').val() == "4")
				{
					$('#req-make').html(

						  
						  '<option value="59"> Kia</option>'+
						  '<option value="94"> Nissan </option>'+
						  '<option value="79"> Mazda</option>'+
						  '<option value="88">Mitsubishi</option>');
				}

			});
		
	});

</script>
       
						  
			<!--Voiture actuelle-->

				  <!--Make car-->

				<div class="form-group col-sm-6">
				<p>Mon véhicule est:</p>   
					<!--<<label for="garage-make">Merk</label>-->
					<select class="form-control" id="make3" name="make3">
						<option value="" selected="" disabled="">Marque *</option>

					   <option value="140">Wiesmann</option>
						<option value="141">Xedos</option>
						<option value="142">Yue Loong</option>
						<option value="143">Yugo</option>
						<option value="144">Zastava</option>
						<option value="145">Zelensis</option>
				</select>
	                            	

			   <!--Model car-->


					<!--<<label for="garage-model">Model</label>-->
					<select class="form-control" id="model3" name="model3">
					<option value="" selected="" disabled="">Modèle *</option>
					</select>
				</div>
				</div>

			 <!--Info supp-->

				<div class="form-group col-xs-12">
					<label for="message">Informations supplémentaires </label>
					<textarea id="message" class="form-control" rows="6" name="message"></textarea>
				</div>


  				<!--Etape 3-->
 
				 <div class="form-group col-xs-12 col-sm-12">
					<h4 class="titleForm">Me tenir informé via *</h4>

				 </div>
				<div class="form-group col-xs-12 col-sm-6">


					<input type="radio" name="type-contact" value="Email" id="type-contact1" required="">
					<label for="type-contact1">Email</label><br>

					<input type="radio" name="type-contact" value="Phone" id="type-contact2" required="">
					<label for="type-contact2">Téléphone</label><br>
				</div>

					<!--button submit-->
				<div class="form-group col-xs-12">
					<button id="submitGeneralForm" type="submit" name="submitTestdrive" class="btn btn-danger btn-md">Envoyer ma demande  </button>
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