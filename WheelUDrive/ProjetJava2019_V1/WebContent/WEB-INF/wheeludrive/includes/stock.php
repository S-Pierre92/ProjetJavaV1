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

			<h4 class="skewxTxt ">NOS VEHICULES</h4>
		</div>
		<div class="titleH1-right">
		</div>
		<div class="titleH1-right2">
		</div>
		<hr>
		<!--row cards -->
	  	<div class="row text-center">
		  	<!--card-->
			<div class="col-md-4 pb-1 pb-md-0">
			  <div class="card slide-tl ">
				  <div class="imgCard">
					  <div class=" backgroundImgHover ">
						  <div class="hoverItem ">
							  <div class=" displayNone hoverMenu">
								  
								  <div class="dropdown-item-fav-left">
								  </div>
								  <div class="dropdown-item-fav">
							  		<a class="btn "><i class="fas fa-heart"></i> </a>
									<a class="btn " href="fiche-veh.php"><i class="fas fa-search-plus"></i> Voir détails</a>
							  		</div>
								  <div class="dropdown-item-fav-right">
								  </div>
							  </div>
							  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
						  </div>
					  </div>			
					  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
				  </div>
				    	<div class="card-title">
						<span class="makeModel">Mini Cooper </span><br>
						<span class="version">Countryman </span>
	<!--				  <span class="showInfos"> <i class="fas fa-times "></i></span>-->
			  		</div>
				<div class="card-body">
					<div class="row">
			 			<div class="col-5 text-left warranty">
							Garantie
							<br>
							<span class="monthWarranty">12 mois</span>
							<span class="labelWarranty"> Mini Next </span>
						</div>
			 			<div class="col-7 price">
							 <div class="priceNew"> <del class="oldprice">15.600 €</del>15.600 €</div>
							  <span class="tvacSpan">Tva récupérable</span>
						</div>
					</div>
					<hr>
				  	<div class="card-text">
					  	<div class="row  infosItem">
							<div class="col-1"><i class="fas fa-gas-pump"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">Essence</div>	
							<div class="col-1"><i class="fas fa-road"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">150 000km</div>
							<div class="col-1"><i class="fas fa-tachometer-alt"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">140kw</div>	
							<div class="col-1"><i class="fas fa-calendar-alt"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">09-2011</div>	
						</div>
					</div>
				</div>
			  </div>
			</div>
			<!--end card-->
				<!--card-->
			<div class="col-md-4 pb-1 pb-md-0">
			  <div class="card slide-tl ">
				  <div class="imgCard">
					  <div class=" backgroundImgHover ">
						  <div class="hoverItem ">
							  <div class=" displayNone hoverMenu">
								  
								  <div class="dropdown-item-fav-left">
								  </div>
								  <div class="dropdown-item-fav">
							  		<a class="btn "><i class="fas fa-heart"></i> </a>
									<a class="btn " href="fiche-veh.php"><i class="fas fa-search-plus"></i> Voir détails</a>
							  		</div>
								  <div class="dropdown-item-fav-right">
								  </div>
							  </div>
							  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
						  </div>
					  </div>			
					  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
				  </div>
				    	<div class="card-title">
						<span class="makeModel">Mini Cooper </span><br>
						<span class="version">Countryman </span>
	<!--				  <span class="showInfos"> <i class="fas fa-times "></i></span>-->
			  		</div>
				<div class="card-body">
					<div class="row">
			 			<div class="col-5 text-left warranty">
							Garantie
							<br>
							<span class="monthWarranty">12 mois</span>
							<span class="labelWarranty"> Mini Next </span>
						</div>
			 			<div class="col-7 price">
							 <div class="priceNew"> <del class="oldprice">15.600 €</del>15.600 €</div>
							  <span class="tvacSpan">Tva récupérable</span>
						</div>
					</div>
					<hr>
				  	<div class="card-text">
					  	<div class="row  infosItem">
							<div class="col-1"><i class="fas fa-gas-pump"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">Essence</div>	
							<div class="col-1"><i class="fas fa-road"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">150 000km</div>
							<div class="col-1"><i class="fas fa-tachometer-alt"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">140kw</div>	
							<div class="col-1"><i class="fas fa-calendar-alt"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">09-2011</div>	
						</div>
					</div>
				</div>
			  </div>
			</div>
			<!--end card-->
				<!--card-->
			<div class="col-md-4 pb-1 pb-md-0">
			  <div class="card slide-tl ">
				  <div class="imgCard">
					  <div class=" backgroundImgHover ">
						  <div class="hoverItem ">
							  <div class=" displayNone hoverMenu">
								  
								  <div class="dropdown-item-fav-left">
								  </div>
								  <div class="dropdown-item-fav">
							  		<a class="btn "><i class="fas fa-heart"></i> </a>
									<a class="btn " href="fiche-veh.php"><i class="fas fa-search-plus"></i> Voir détails</a>
							  		</div>
								  <div class="dropdown-item-fav-right">
								  </div>
							  </div>
							  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
						  </div>
					  </div>			
					  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
				  </div>
				    	<div class="card-title">
						<span class="makeModel">Mini Cooper </span><br>
						<span class="version">Countryman </span>
	<!--				  <span class="showInfos"> <i class="fas fa-times "></i></span>-->
			  		</div>
				<div class="card-body">
					<div class="row">
			 			<div class="col-5 text-left warranty">
							Garantie
							<br>
							<span class="monthWarranty">12 mois</span>
							<span class="labelWarranty"> Mini Next </span>
						</div>
			 			<div class="col-7 price">
							 <div class="priceNew"> <del class="oldprice">15.600 €</del>15.600 €</div>
							  <span class="tvacSpan">Tva récupérable</span>
						</div>
					</div>
					<hr>
				  	<div class="card-text">
					  	<div class="row  infosItem">
							<div class="col-1"><i class="fas fa-gas-pump"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">Essence</div>	
							<div class="col-1"><i class="fas fa-road"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">150 000km</div>
							<div class="col-1"><i class="fas fa-tachometer-alt"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">140kw</div>	
							<div class="col-1"><i class="fas fa-calendar-alt"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">09-2011</div>	
						</div>
					</div>
				</div>
			  </div>
			</div>
			<!--end card-->
		</div>
		<!--row cards -->
	  	<div class="row text-center">
		  	<!--card-->
			<div class="col-md-4 pb-1 pb-md-0">
			  <div class="card slide-tl ">
				  <div class="imgCard">
					  <div class=" backgroundImgHover ">
						  <div class="hoverItem ">
							  <div class=" displayNone hoverMenu">
								  
								  <div class="dropdown-item-fav-left">
								  </div>
								  <div class="dropdown-item-fav">
							  		<a class="btn "><i class="fas fa-heart"></i> </a>
									<a class="btn " href="fiche-veh.php"><i class="fas fa-search-plus"></i> Voir détails</a>
							  		</div>
								  <div class="dropdown-item-fav-right">
								  </div>
							  </div>
							  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
						  </div>
					  </div>			
					  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
				  </div>
				    	<div class="card-title">
						<span class="makeModel">Mini Cooper </span><br>
						<span class="version">Countryman </span>
	<!--				  <span class="showInfos"> <i class="fas fa-times "></i></span>-->
			  		</div>
				<div class="card-body">
					<div class="row">
			 			<div class="col-5 text-left warranty">
							Garantie
							<br>
							<span class="monthWarranty">12 mois</span>
							<span class="labelWarranty"> Mini Next </span>
						</div>
			 			<div class="col-7 price">
							 <div class="priceNew"> <del class="oldprice">15.600 €</del>15.600 €</div>
							  <span class="tvacSpan">Tva récupérable</span>
						</div>
					</div>
					<hr>
				  	<div class="card-text">
					  	<div class="row  infosItem">
							<div class="col-1"><i class="fas fa-gas-pump"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">Essence</div>	
							<div class="col-1"><i class="fas fa-road"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">150 000km</div>
							<div class="col-1"><i class="fas fa-tachometer-alt"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">140kw</div>	
							<div class="col-1"><i class="fas fa-calendar-alt"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">09-2011</div>	
						</div>
					</div>
				</div>
			  </div>
			</div>
			<!--end card-->
				<!--card-->
			<div class="col-md-4 pb-1 pb-md-0">
			  <div class="card slide-tl ">
				  <div class="imgCard">
					  <div class=" backgroundImgHover ">
						  <div class="hoverItem ">
							  <div class=" displayNone hoverMenu">
								  
								  <div class="dropdown-item-fav-left">
								  </div>
								  <div class="dropdown-item-fav">
							  		<a class="btn "><i class="fas fa-heart"></i> </a>
									<a class="btn " href="fiche-veh.php"><i class="fas fa-search-plus"></i> Voir détails</a>
							  		</div>
								  <div class="dropdown-item-fav-right">
								  </div>
							  </div>
							  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
						  </div>
					  </div>			
					  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
				  </div>
				    	<div class="card-title">
						<span class="makeModel">Mini Cooper </span><br>
						<span class="version">Countryman </span>
	<!--				  <span class="showInfos"> <i class="fas fa-times "></i></span>-->
			  		</div>
				<div class="card-body">
					<div class="row">
			 			<div class="col-5 text-left warranty">
							Garantie
							<br>
							<span class="monthWarranty">12 mois</span>
							<span class="labelWarranty"> Mini Next </span>
						</div>
			 			<div class="col-7 price">
							 <div class="priceNew"> <del class="oldprice">15.600 €</del>15.600 €</div>
							  <span class="tvacSpan">Tva récupérable</span>
						</div>
					</div>
					<hr>
				  	<div class="card-text">
					  	<div class="row  infosItem">
							<div class="col-1"><i class="fas fa-gas-pump"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">Essence</div>	
							<div class="col-1"><i class="fas fa-road"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">150 000km</div>
							<div class="col-1"><i class="fas fa-tachometer-alt"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">140kw</div>	
							<div class="col-1"><i class="fas fa-calendar-alt"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">09-2011</div>	
						</div>
					</div>
				</div>
			  </div>
			</div>
			<!--end card-->
				<!--card-->
			<div class="col-md-4 pb-1 pb-md-0">
			  <div class="card slide-tl ">
				  <div class="imgCard">
					  <div class=" backgroundImgHover ">
						  <div class="hoverItem ">
							  <div class=" displayNone hoverMenu">
								  
								  <div class="dropdown-item-fav-left">
								  </div>
								  <div class="dropdown-item-fav">
							  		<a class="btn "><i class="fas fa-heart"></i> </a>
									<a class="btn " href="fiche-veh.php"><i class="fas fa-search-plus"></i> Voir détails</a>
							  		</div>
								  <div class="dropdown-item-fav-right">
								  </div>
							  </div>
							  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
						  </div>
					  </div>			
					  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
				  </div>
				    	<div class="card-title">
						<span class="makeModel">Mini Cooper </span><br>
						<span class="version">Countryman </span>
	<!--				  <span class="showInfos"> <i class="fas fa-times "></i></span>-->
			  		</div>
				<div class="card-body">
					<div class="row">
			 			<div class="col-5 text-left warranty">
							Garantie
							<br>
							<span class="monthWarranty">12 mois</span>
							<span class="labelWarranty"> Mini Next </span>
						</div>
			 			<div class="col-7 price">
							 <div class="priceNew"> <del class="oldprice">15.600 €</del>15.600 €</div>
							  <span class="tvacSpan">Tva récupérable</span>
						</div>
					</div>
					<hr>
				  	<div class="card-text">
					  	<div class="row  infosItem">
							<div class="col-1"><i class="fas fa-gas-pump"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">Essence</div>	
							<div class="col-1"><i class="fas fa-road"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">150 000km</div>
							<div class="col-1"><i class="fas fa-tachometer-alt"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">140kw</div>	
							<div class="col-1"><i class="fas fa-calendar-alt"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">09-2011</div>	
						</div>
					</div>
				</div>
			  </div>
			</div>
			<!--end card-->
		</div>
		<!--row cards -->
	  	<div class="row text-center">
		  	<!--card-->
			<div class="col-md-4 pb-1 pb-md-0">
			  <div class="card slide-tl ">
				  <div class="imgCard">
					  <div class=" backgroundImgHover ">
						  <div class="hoverItem ">
							  <div class=" displayNone hoverMenu">
								  
								  <div class="dropdown-item-fav-left">
								  </div>
								  <div class="dropdown-item-fav">
							  		<a class="btn "><i class="fas fa-heart"></i> </a>
									<a class="btn " href="fiche-veh.php"><i class="fas fa-search-plus"></i> Voir détails</a>
							  		</div>
								  <div class="dropdown-item-fav-right">
								  </div>
							  </div>
							  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
						  </div>
					  </div>			
					  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
				  </div>
				    	<div class="card-title">
						<span class="makeModel">Mini Cooper </span><br>
						<span class="version">Countryman </span>
	<!--				  <span class="showInfos"> <i class="fas fa-times "></i></span>-->
			  		</div>
				<div class="card-body">
					<div class="row">
			 			<div class="col-5 text-left warranty">
							Garantie
							<br>
							<span class="monthWarranty">12 mois</span>
							<span class="labelWarranty"> Mini Next </span>
						</div>
			 			<div class="col-7 price">
							 <div class="priceNew"> <del class="oldprice">15.600 €</del>15.600 €</div>
							  <span class="tvacSpan">Tva récupérable</span>
						</div>
					</div>
					<hr>
				  	<div class="card-text">
					  	<div class="row  infosItem">
							<div class="col-1"><i class="fas fa-gas-pump"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">Essence</div>	
							<div class="col-1"><i class="fas fa-road"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">150 000km</div>
							<div class="col-1"><i class="fas fa-tachometer-alt"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">140kw</div>	
							<div class="col-1"><i class="fas fa-calendar-alt"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">09-2011</div>	
						</div>
					</div>
				</div>
			  </div>
			</div>
			<!--end card-->
				<!--card-->
			<div class="col-md-4 pb-1 pb-md-0">
			  <div class="card slide-tl ">
				  <div class="imgCard">
					  <div class=" backgroundImgHover ">
						  <div class="hoverItem ">
							  <div class=" displayNone hoverMenu">
								  
								  <div class="dropdown-item-fav-left">
								  </div>
								  <div class="dropdown-item-fav">
							  		<a class="btn "><i class="fas fa-heart"></i> </a>
									<a class="btn " href="fiche-veh.php"><i class="fas fa-search-plus"></i> Voir détails</a>
							  		</div>
								  <div class="dropdown-item-fav-right">
								  </div>
							  </div>
							  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
						  </div>
					  </div>			
					  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
				  </div>
				    	<div class="card-title">
						<span class="makeModel">Mini Cooper </span><br>
						<span class="version">Countryman </span>
	<!--				  <span class="showInfos"> <i class="fas fa-times "></i></span>-->
			  		</div>
				<div class="card-body">
					<div class="row">
			 			<div class="col-5 text-left warranty">
							Garantie
							<br>
							<span class="monthWarranty">12 mois</span>
							<span class="labelWarranty"> Mini Next </span>
						</div>
			 			<div class="col-7 price">
							 <div class="priceNew"> <del class="oldprice">15.600 €</del>15.600 €</div>
							  <span class="tvacSpan">Tva récupérable</span>
						</div>
					</div>
					<hr>
				  	<div class="card-text">
					  	<div class="row  infosItem">
							<div class="col-1"><i class="fas fa-gas-pump"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">Essence</div>	
							<div class="col-1"><i class="fas fa-road"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">150 000km</div>
							<div class="col-1"><i class="fas fa-tachometer-alt"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">140kw</div>	
							<div class="col-1"><i class="fas fa-calendar-alt"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">09-2011</div>	
						</div>
					</div>
				</div>
			  </div>
			</div>
			<!--end card-->
				<!--card-->
			<div class="col-md-4 pb-1 pb-md-0">
			  <div class="card slide-tl ">
				  <div class="imgCard">
					  <div class=" backgroundImgHover ">
						  <div class="hoverItem ">
							  <div class=" displayNone hoverMenu">
								  
								  <div class="dropdown-item-fav-left">
								  </div>
								  <div class="dropdown-item-fav">
							  		<a class="btn "><i class="fas fa-heart"></i> </a>
									<a class="btn " href="fiche-veh.php"><i class="fas fa-search-plus"></i> Voir détails</a>
							  		</div>
								  <div class="dropdown-item-fav-right">
								  </div>
							  </div>
							  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
						  </div>
					  </div>			
					  <img class="card-img-top" src="../images/noPhoto.jpg" alt="Card image cap">
				  </div>
				    	<div class="card-title">
						<span class="makeModel">Mini Cooper </span><br>
						<span class="version">Countryman </span>
	<!--				  <span class="showInfos"> <i class="fas fa-times "></i></span>-->
			  		</div>
				<div class="card-body">
					<div class="row">
			 			<div class="col-5 text-left warranty">
							Garantie
							<br>
							<span class="monthWarranty">12 mois</span>
							<span class="labelWarranty"> Mini Next </span>
						</div>
			 			<div class="col-7 price">
							 <div class="priceNew"> <del class="oldprice">15.600 €</del>15.600 €</div>
							  <span class="tvacSpan">Tva récupérable</span>
						</div>
					</div>
					<hr>
				  	<div class="card-text">
					  	<div class="row  infosItem">
							<div class="col-1"><i class="fas fa-gas-pump"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">Essence</div>	
							<div class="col-1"><i class="fas fa-road"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">150 000km</div>
							<div class="col-1"><i class="fas fa-tachometer-alt"></i></div>	
							<div class="col-10 col-md-5  col-lg-5 text-left">140kw</div>	
							<div class="col-1"><i class="fas fa-calendar-alt"></i></div>	
							<div class="col-10  col-md-4  col-lg-4  text-left">09-2011</div>	
						</div>
					</div>
				</div>
			  </div>
			</div>
			<!--end card-->
		</div>
		<!--end row cards-->
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