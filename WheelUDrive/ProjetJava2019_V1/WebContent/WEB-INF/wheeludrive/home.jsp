<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<!-- ========================= SECTION INTRO ========================= -->
		<section 	class="section-intro bg-home pt-4" style="background-image: url('${pageContext.request.contextPath}/assets/images/slide1.jpg');">
			<div class="container">	
				<main class="">
					<div class="row text-light text-center">
							<div class="col-md-8 col-sm-12 mx-auto">
									<!-- <h1 class="display-4 mb-3">How it works</h1>
									<p class="lead mb-5">Good sub heading this sounded nonsense to Alice </p> -->
							</div>
					</div> <!-- row.// -->
				
					<div class="row mb-5">
						<div class="col-12 text-center mt-5">
							<h1 class="title-xl text-shadow white">Bienvenue sur notre site !</h1>
						</div>
					</div>
						<div class="mx-auto col-12">
							<!-- ========================= SECTION FEATURES ========================= -->
							<div class="row pt-5">
								<aside class="col-sm-6">
									<figure class="itembox shadow text-center bg-white p-5">
										<span class="icon-wrap icon-lg circle white pt-3"><i class="fas fa-circle fa-hand-holding-usd"></i></span>
										<figcaption class="text-wrap">
											<h4 class="title">Vendez votre <br>voiture d'occasion</h4>	
											<p>Gratuit, rapide et au meilleur prix.*</p>
										</figcaption>
									</figure> <!-- iconbox // -->
								</aside> <!-- col.// -->
								<aside class="col-sm-6">
									<figure class="itembox shadow text-center bg-white p-5">
										<span class="icon-wrap icon-lg circle white pt-4"><i class="fas fa-cart-arrow-down"></i></span>
										<figcaption class="text-wrap">
										<h4 class="title">Acheter la voiture <br>de vos rêves</h4>
										<p>Nous avons plus d'un millier de voitures qui n'attendent que vous.</p>
										</figcaption>
									</figure> <!-- iconbox // -->
								</aside> <!-- col.// -->
								<!-- <aside class="col-sm-4">
									<figure class="itembox shadow text-center bg-white p-5">
										<span class="icon-wrap icon-lg circle white"><i class="fas  fa-retweet"></i></span>
										<figcaption class="text-wrap">
										<h4 class="title">Louer la voiture idéale</h4>
										<p>Réserver votre voiture pour un séjour ou une journée, vous décidez!</p>
										</figcaption> --
									</figure> !-- iconbox // 
								</aside> col.//-->
							</div> <!-- row.// -->
						</div> <!-- col.// -->
					</div> <!-- row.// -->
				
					<br>
				
				</main>
			</div> <!-- container.// -->
		</section>
		<!-- ========================= ./SECTION INTRO ========================= -->




		<!-- ========================= SECTION TITLE ========================= -->
		<section class="section-content bg padding-y">
			<div class="container">
				<div class="row">
					<div class="col-12 text-center mt-5">
						<h1 class="title-xl  ">${titleHomeCountAnnonce} </h1>
					</div>
				</div>
			</div>
		</section>
		<!-- ========================= ./SECTION TITLE ========================= -->
		<!-- ========================= SECTION CARS ========================= -->
		<section class="section-content bg padding-y">
		 <form method="post" action="${pageContext.request.contextPath}/wheeludrive/vehicules">
			<div class="container">
				<div class="row">
					<!-- ==============COL LEFT============== -->
					<aside class="col-sm-3">
						<!--FILTRES-->
						<div class="card card-filter shadow">
							<!--CATEGORIE-->
							<article class="card-group-item">
								<header class="card-header">
									<a class="" aria-expanded="true" href="#" data-toggle="collapse" data-target="#cat">
										<i class="icon-action fa fa-chevron-down"></i>
										<h6 class="title">Categorie</h6>
									</a>
								</header>
								<div style="" class="filter-content collapse " id="cat">
									<div class="card-body">
										
						
										<ul class="list-unstyled list-lg">
											<li><a href="#">Encheres<span class="float-right badge badge-light round">0</span> </a></li>
											<li><a href="#">Ventes direct  <span class="float-right badge badge-light round">${totalVente}</span>  </a></li>
										</ul>  
									</div> <!-- card-body.// -->
								</div> <!-- collapse .// -->
							</article> 
							<!--./CATEGORIE-->
							<!-- MARQUES MODELE -->
							<article class="card-group-item">
									<header class="card-header">
										<a href="#" data-toggle="collapse" data-target="#marque">
											<i class="icon-action fa fa-chevron-down"></i>
											<h6 class="title">Vehicule </h6>
										</a>
									</header>
									<div class="filter-content collapse " id="marque">
										<div class="card-body">
											<select class="custom-select mb-3">
												<option selected disabled>Marque</option>
												<c:forEach items="${marques}" var="marque">
												    <option value="${marque.id}">${marque.nom}</option>
									            </c:forEach>
											</select> 
											<select class="custom-select mb-3">
												<option selected disabled>Modele</option>
												<option value="1">Audi</option>
											</select> 
										</div> <!-- card-body.// -->
									</div> <!-- collapse .// -->
							</article> 
							<!-- ./MARQUES MODELE -->
							<!-- PRIX -->
							<article class="card-group-item">
								<header class="card-header">
									<a href="#" data-toggle="collapse" data-target="#prix">
										<i class="icon-action fa fa-chevron-down"></i>
										<h6 class="title">Prix </h6>
									</a>
								</header>
								<div class="filter-content collapse " id="prix">
									<div class="card-body">
											<div class="form-group">
													
												</div>
										<div class="form-row">
										<div class="form-group col-md-6">
											<label>Min</label>
											<input class="form-control" name="prixMin" placeholder="0€" type="number" value="">
										</div>
										<div class="form-group text-right col-md-6">
											<label>Max</label>
											<input class="form-control" name="prixMax" placeholder="1,0000€" type="number" value="">
										</div>
										</div> <!-- form-row.// -->
									</div> <!-- card-body.// -->
								</div> <!-- collapse .// -->
							</article> 
							<!-- ./PRIX -->
							<!-- KM -->
							<article class="card-group-item">
									<header class="card-header">
										<a href="#" data-toggle="collapse" data-target="#km">
											<i class="icon-action fa fa-chevron-down"></i>
											<h6 class="title">Kilometres  </h6>
										</a>
									</header>
									<div class="filter-content collapse " id="km">
										<div class="card-body">
												<div class="form-group">
														
													</div>
											<div class="form-row">
											<div class="form-group col-md-6">
												<label>Min</label>
												<input class="form-control" name="kilMin" placeholder="0km" type="number">
											</div>
											<div class="form-group text-right col-md-6">
												<label>Max</label>
												<input class="form-control" name="kilMax" placeholder="300.000km" type="number">
											</div>
											</div> <!-- form-row.// -->
										
										</div> <!-- card-body.// -->
									</div> <!-- collapse .// -->
							</article> 
							<!-- ./KM -->
							<!-- ANNEE -->
							<article class="card-group-item">
									<header class="card-header">
										<a href="#" data-toggle="collapse" data-target="#annee">
											<i class="icon-action fa fa-chevron-down"></i>
											<h6 class="title">Années  </h6>
										</a>
									</header>
									<div class="filter-content collapse " id="annee">
										<div class="card-body">
												<div class="form-group">
														
													</div>
											<div class="form-row">
											<div class="form-group col-md-6">
												<input class="form-control" name="anneeMin" placeholder="1983" type="number">
											</div>
											<div class="form-group text-right col-md-6">
											
												<input class="form-control" name="anneeMax" placeholder="2019" type="number">
											</div>
											</div> <!-- form-row.// -->
										
										</div> <!-- card-body.// -->
									</div> <!-- collapse .// -->
							</article> 
							<!-- ./ANNEE -->
							<!-- DETAILS -->
							<article class="card-group-item">
									<header class="card-header">
										<a href="#" data-toggle="collapse" data-target="#DETAILS">
											<i class="icon-action fa fa-chevron-down"></i>
											<h6 class="title">Détails </h6>
										</a>
									</header>
									<div class="filter-content collapse " id="DETAILS">
										<div class="card-body">
											<select name="carburant" class="custom-select mb-3">
												<option selected disabled>Carburant</option>
												<c:forEach items="${carburants}" var="carburant">
												    <option value="${carburant}">${carburant}</option>
									            </c:forEach>
											</select> 
											<select name="transmission" class="custom-select mb-3">
												<option selected disabled>Transmission</option>
												<c:forEach items="${transmissions}" var="transmission">
												    <option value="${transmission}">${transmission}</option>
									            </c:forEach>
											</select> 
											<select name="porte" class="custom-select mb-3">
												<option selected disabled>Portes</option>
												<option value="2">2 portes</option>
												<option value="3">3 portes</option>
												<option value="4">4 portes</option>
												<option value="5">5 portes</option>
											</select> 
										</div> <!-- card-body.// -->
									</div> <!-- collapse .// -->
							</article> 
							<!-- COULEURS -->
							<article class="card-group-item">
								<header class="card-header">
									<a href="#" data-toggle="collapse" data-target="#couleursInt">
										<i class="icon-action fa fa-chevron-down"></i>
										<h6 class="title">Couleurs Interieures </h6>
									</a>
								</header>
								<div class="filter-content collapse " id="couleursInt">
									<div class="card-body">
										<select name="couleurInt" class="custom-select mb-3">
												<option selected disabled>couleur</option>
												<c:forEach items="${couleurs}" var="couleur" >
												    <option value="${couleur.id}" >${couleur.nom}</option>
									            </c:forEach>
											</select> 
									</div> <!-- card-body.// --> 
								</div> <!-- collapse .// -->
							</article> 
							<!-- ./COULEURS -->
							<!-- COULEURS -->
							<article class="card-group-item">
								<header class="card-header">
									<a href="#" data-toggle="collapse" data-target="#couleursExt">
										<i class="icon-action fa fa-chevron-down"></i>
										<h6 class="title">Couleurs Exterieures </h6>
									</a>
								</header>
								<div class="filter-content collapse " id="couleursExt">
									<div class="card-body">
										<select name="couleurExt" class="custom-select mb-3">
												<option selected disabled>couleur</option>
												<c:forEach items="${couleurs}" var="couleur" >
												    <option value="${couleur.id}" >${couleur.nom}</option>
									            </c:forEach>
											</select> 
									</div> <!-- card-body.// --> 
								</div> <!-- collapse .// -->
							</article> 
							<!-- ./COULEURS -->
							<input type="submit" class="btn btn-block btn-primary">
						</div> 
						<!-- ./ FILTRES -->
					</aside> 
					<!-- ============== ./COL LEFT============== -->
					<!-- ============== COL RIGHT============== -->
					<main class="col-sm-9">
						<article class="card card-product">
							<div class="card-body">
								<div class="row">
									<!-- IMG -->
									<aside class="col-md-5">
										<div class="img-wrap">
											<div class="owl-carousel owl-init slider-main" data-items="1" data-dots="false" data-nav="true">
												<div class="item-slide">
													<img src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg">
												</div>
												<div class="item-slide">
													<img src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg">
												</div>
												<div class="item-slide">
													<img src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg">
												</div>
											</div>
										</div>
									</aside> 
									<!--./IMG -->
									<!-- DETAILS -->
									<article class="col-md-5">
										<h4 class="title"> Marque modèle  </h4>
										<h6 class="title"> Version  </h6>
										<div class="container">
											<hr>
											<div class="row">
												<div class="col-1 col-sm-1 p-0"><i class="fas fa-road "></i></div>
												<div class="col-11 col-sm-5 p-0">120.000km</div>

												<div class="col-1 col-sm-1 p-0"><i class="fas fa-calendar-alt "></i></div>
												<div class="col-11 col-sm-5 p-0">2013</div>
											</div>
											<div class="row">
												<div class="col-1 col-sm-1 p-0"><i class="fas fa-gas-pump "></i></div>
												<div class="col-11 col-sm-5 p-0">Diesel</div>
										
												<div class="col-1 col-sm-1 p-0"><image src="assets/images/levier.png" width="15"></image></div>
												<div class="col-11 col-sm-5 p-0">manuel 5 vit.</div>
											</div>
										</div>
										<hr>
										<dl class="dlist-align">
											<dt>Vendeur</dt>
											<dd>Nom concession, adresse</dd>
										</dl> 
									</article> 
									<!-- ./DETAILS -->
									<!-- PRIX  -->
									<aside class="col-md-2 border-left">
										<div class="action-wrap">
											<div class="price-wrap h4 m-0 mb-5">
<!-- 												<del class="price-old"><small>13.000€</small>  </del> -->
												<span class="price	"> 12.000€ </span>	<br>
											</div> 
<!-- 											<p class="text-red m-0 mb-4">TVA déductible</p> -->
											<p class="mt-5 pt-5"><br>
												<a href="#" class="btn btn-outline-primary btn-block mb-1"><i class="fa fa-heart"></i> Favori </a>
<!-- 												<a href="#" class="btn btn-outline-secondary btn-block mb-1"><i class="fas fa-clone"></i> Comparer </a> -->
												<a href="wheeludrive?page=voiture" class="btn btn-primary btn-block  m-0"><i class="fas fa-plus"></i> Details   </a>
										</div>
									</aside> 
									<!-- ./PRIX -->
								</div> <!-- ./row -->
							</div> <!-- ./card-body -->
						</article> <!-- ./article -->
					</main> <!-- ./main -->
					<!-- ============== ./COL RIGHT============== -->
				</div><!-- ./ row  -->
			</div> <!-- ./ container  -->
		  </form>
		</section>
			<!-- ========================= ./SECTION CARS ========================= -->
	