<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- ========================= SECTION INTRO ========================= -->
<section class="section-intro bg-home pt-4"
	style="background-image: url('${pageContext.request.contextPath}/assets/images/slide2.jpg?v1');">
	<div class="container">
		<main class="">
		<div class="row text-light text-center">
			<div class="col-md-8 col-sm-12 mx-auto">
				<!-- <h1 class="display-4 mb-3">How it works</h1>
									<p class="lead mb-5">Good sub heading this sounded nonsense to Alice </p> -->
			</div>
		</div>
		<!-- row.// -->

		<div class="row mb-5">
			<div class="mx-auto col-12">
				<!-- ========================= SECTION FEATURES ========================= -->
				<div class="row pt-5">
					<aside class="col-sm-12">
						<figure class="itembox  text-center  p-5">
							<span class="icon-wrap icon-lg circle white pt-4"> <i
								class="fa fa-car"></i>
							</span>
							<figcaption class="text-wrap">
								<h1 class="title-xl white">Véhicules</h1>
							</figcaption>
						</figure>
						<!-- iconbox // -->
					</aside>
					<!-- col.// -->


				</div>
				<!-- row.// -->
			</div>
			<!-- col.// -->
		</div>
		<!-- row.// --> <br>

		</main>
	</div>
	<!-- container.// -->
</section>
<!-- ========================= ./SECTION INTRO ========================= -->

<!-- ========================= SECTION CARS ========================= -->
<section class="section-content bg padding-y">
	<div class="container">
		<div class="row">
			<!-- ==============COL LEFT============== -->
			<aside class="col-sm-3">
				<!--FILTRES-->
				<div class="card card-filter shadow">
					<!--CATEGORIE-->
					<article class="card-group-item">
						<header class="card-header">
							<a class="" aria-expanded="true" href="#" data-toggle="collapse"
								data-target="#cat"> <i
								class="icon-action fa fa-chevron-down"></i>
								<h6 class="title">Catégorie</h6>
							</a>
						</header>
						<div style="" class="filter-content collapse " id="cat">
							<div class="card-body">
								<form class="pb-3">
									<label>Mots-clés</label>
									<div class="input-group">
										<input class="form-control" placeholder=" BMW, Golf, ..."
											type="text">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
								</form>

								<ul class="list-unstyled list-lg">
									<li><a href="#">Location<span
											class="float-right badge badge-light round">142</span>
									</a></li>
									<li><a href="#">Vente <span
											class="float-right badge badge-light round">1293</span>
									</a></li>
								</ul>
							</div>
							<!-- card-body.// -->
						</div>
						<!-- collapse .// -->
					</article>
					<!--./CATEGORIE-->
					<!-- MARQUES MODELE -->
					<article class="card-group-item">
						<header class="card-header">
							<a href="#" data-toggle="collapse" data-target="#marque"> <i
								class="icon-action fa fa-chevron-down"></i>
								<h6 class="title">Véhicule</h6>
							</a>
						</header>
						<div class="filter-content collapse " id="marque">
							<div class="card-body">
								<form>
									<select class="custom-select mb-3">
										<option selected disabled>Marques</option>
										<option value="1">Audi</option>
										<option value="2">Bmw</option>
										<option value="3">VW</option>
									</select> <select class="custom-select mb-3">
										<option selected disabled>Modèle</option>
										<option value="1">Audi</option>
									</select>
								</form>
							</div>
							<!-- card-body.// -->
						</div>
						<!-- collapse .// -->
					</article>
					<!-- ./MARQUES MODELE -->
					<!-- PRIX -->
					<article class="card-group-item">
						<header class="card-header">
							<a href="#" data-toggle="collapse" data-target="#prix"> <i
								class="icon-action fa fa-chevron-down"></i>
								<h6 class="title">Prix</h6>
							</a>
						</header>
						<div class="filter-content collapse " id="prix">
							<div class="card-body">
								<div class="form-group"></div>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label>Min</label> <input class="form-control"
											placeholder="0€" type="number">
									</div>
									<div class="form-group text-right col-md-6">
										<label>Max</label> <input class="form-control"
											placeholder="1,0000€" type="number">
									</div>
								</div>
								<!-- form-row.// -->
							</div>
							<!-- card-body.// -->
						</div>
						<!-- collapse .// -->
					</article>
					<!-- ./PRIX -->
					<!-- KM -->
					<article class="card-group-item">
						<header class="card-header">
							<a href="#" data-toggle="collapse" data-target="#km"> <i
								class="icon-action fa fa-chevron-down"></i>
								<h6 class="title">Kilomètres</h6>
							</a>
						</header>
						<div class="filter-content collapse " id="km">
							<div class="card-body">
								<div class="form-group"></div>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label>Min</label> <input class="form-control"
											placeholder="0km" type="number">
									</div>
									<div class="form-group text-right col-md-6">
										<label>Max</label> <input class="form-control"
											placeholder="300.000km" type="number">
									</div>
								</div>
								<!-- form-row.// -->

							</div>
							<!-- card-body.// -->
						</div>
						<!-- collapse .// -->
					</article>
					<!-- ./KM -->
					<!-- ANNEE -->
					<article class="card-group-item">
						<header class="card-header">
							<a href="#" data-toggle="collapse" data-target="#annee"> <i
								class="icon-action fa fa-chevron-down"></i>
								<h6 class="title">Années</h6>
							</a>
						</header>
						<div class="filter-content collapse " id="annee">
							<div class="card-body">
								<div class="form-group"></div>
								<div class="form-row">
									<div class="form-group col-md-6">

										<input class="form-control" placeholder="1983" type="number">
									</div>
									<div class="form-group text-right col-md-6">

										<input class="form-control" placeholder="2019" type="number">
									</div>
								</div>
								<!-- form-row.// -->

							</div>
							<!-- card-body.// -->
						</div>
						<!-- collapse .// -->
					</article>
					<!-- ./ANNEE -->
					<!-- DETAILS -->
					<article class="card-group-item">
						<header class="card-header">
							<a href="#" data-toggle="collapse" data-target="#DETAILS"> <i
								class="icon-action fa fa-chevron-down"></i>
								<h6 class="title">Détails</h6>
							</a>
						</header>
						<div class="filter-content collapse " id="DETAILS">
							<div class="card-body">
								<form>
									<select class="custom-select mb-3">
										<option selected disabled>Carburant</option>
										<option value="1">Diesel</option>
										<option value="2">Essence</option>
										<option value="3">Electric</option>
									</select> <select class="custom-select mb-3">
										<option selected disabled>Transmission</option>
										<option value="1">Automatique</option>
										<option value="2">Manuelle</option>
									</select> <select class="custom-select mb-3">
										<option selected disabled>Portes</option>
										<option value="1">5 portes</option>
									</select>
								</form>
							</div>
							<!-- card-body.// -->
						</div>
						<!-- collapse .// -->
					</article>
					<!-- COULEURS -->
					<article class="card-group-item">
						<header class="card-header">
							<a href="#" data-toggle="collapse" data-target="#couleurs"> <i
								class="icon-action fa fa-chevron-down"></i>
								<h6 class="title">Couleurs</h6>
							</a>
						</header>
						<div class="filter-content collapse " id="couleurs">
							<div class="card-body">
								<form>
									<label class="form-check"> <input
										class="form-check-input" value="" type="checkbox"> <span
										class="form-check-label"> <span
											class="float-right badge badge-light round">5</span> Noir
									</span>
									</label>
									<!-- form-check.// -->
									<label class="form-check"> <input
										class="form-check-input" value="" type="checkbox"> <span
										class="form-check-label"> <span
											class="float-right badge badge-light round">13</span> Gris
									</span>
									</label>
									<!-- form-check.// -->
									<label class="form-check"> <input
										class="form-check-input" value="" type="checkbox"> <span
										class="form-check-label"> <span
											class="float-right badge badge-light round">12</span> Blanc
									</span>
									</label>
									<!-- form-check.// -->
									<label class="form-check"> <input
										class="form-check-input" value="" type="checkbox"> <span
										class="form-check-label"> <span
											class="float-right badge badge-light round">32</span> Rouge
									</span>
									</label>
									<!-- form-check.// -->
								</form>
							</div>
							<!-- card-body.// -->
						</div>
						<!-- collapse .// -->
					</article>
					<!-- ./COULEURS -->
					<button class="btn btn-block btn-primary">Rechercher</button>
				</div>
				<!-- ./ FILTRES -->
			</aside>
			<!-- ============== ./COL LEFT============== -->
			<!-- ============== COL RIGHT============== -->

			<main class="col-sm-9"> 
			<c:forEach items="${annonces}" var="annonce">
				<article class="card card-product">
					<div class="card-body">
						<div class="row">
							<!-- IMG -->
							<aside class="col-md-5">
								<div class="img-wrap">
									<div class="owl-carousel owl-init slider-main" data-items="1"
										data-dots="false" data-nav="true">
										<div class="item-slide">
											<img src="${annonce.image}">
										</div>
										<div class="item-slide">
											<img src="${annonce.image}">
										</div>
										<div class="item-slide">
											<img src="${annonce.image}">
										</div>
									</div>
								</div>
							</aside>
							<!--./IMG -->
							<!-- DETAILS -->
							<article class="col-md-5">
								<h4 class="title">${annonce.marque} ${annonce.modele}</h4>
								<h6 class="title">${annonce.version}</h6>
								<div class="container">
									<hr>
									<div class="row">
										<div class="col-1 col-sm-1 p-0">
											<i class="fas fa-road "></i>
										</div>
										<div class="col-11 col-sm-5 p-0">${annonce.km} km</div>

										<div class="col-1 col-sm-1 p-0">
											<i class="fas fa-calendar-alt "></i>
										</div>
										<div class="col-11 col-sm-5 p-0">${annonce.annee}</div>
									</div>
									<div class="row">
										<div class="col-1 col-sm-1 p-0">
											<i class="fas fa-gas-pump "></i>
										</div>
										<div class="col-11 col-sm-5 p-0">${annonce.carburant}</div>

										<div class="col-1 col-sm-1 p-0">
											<image
												src="${pageContext.request.contextPath}/assets/images/levier.png"
												width="15"></image>
										</div>
										<div class="col-11 col-sm-5 p-0">${annonce.boite}</div>
									</div>
								</div>
								<hr>
								<dl class="dlist-align">
									<dt>Dealer</dt>
									<dd>${annonce.nom} ${annonce.prenom}, ${annonce.adresse}</dd>
								</dl>
								<dl class="dlist-align">
									<dt></dt>
									<dd>
<!-- 										<div class="rating-wrap  mb-2"> -->
<!-- 											<ul class="rating-stars"> -->
<!-- 												<li style="width: 80%" class="stars-active"><i -->
<!-- 													class="fa fa-star"></i> <i class="fa fa-star"></i> <i -->
<!-- 													class="fa fa-star"></i> <i class="fa fa-star"></i> <i -->
<!-- 													class="fa fa-star"></i></li> -->
<!-- 												<li><i class="fa fa-star"></i> <i class="fa fa-star"></i> -->
<!-- 													<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i -->
<!-- 													class="fa fa-star"></i></li> -->
<!-- 											</ul> -->
<!-- 											<div class="label-rating">132 reviews</div> -->
<!-- 										</div> -->
									</dd>
								</dl>
							</article>
							<!-- ./DETAILS -->
							<!-- PRIX  -->
							<aside class="col-md-2 border-left">
								<div class="action-wrap">
									<div class="price-wrap h4 m-0">
										<span class="price"> ${annonce.prix} € </span>
									</div>
<!-- 									<p class="text-red m-0 mb-4">TVA déductible</p> -->
									<p>
										<a href="#" class="btn btn-outline-primary btn-block mb-1">
										    <i class="fa fa-heart"></i> Favori </a>
<!-- 										<a href="#" class="btn btn-outline-secondary btn-block mb-1"> -->
<!-- 										    <i class="fas fa-clone"></i> Comparer </a>  -->
										<a  id ="submitDetail" href="${pageContext.request.contextPath}/wheeludrive/vehicule?id=${annonce.id}" class="btn btn-primary btn-block  m-0">
										    <i class="fas fa-plus"></i> Details </a>
								   </p>
								</div>
							</aside>
							<!-- ./PRIX -->
						</div>
						<!-- ./row -->
					</div>
					<!-- ./card-body -->
				</article>
				<!-- ./article -->
			</c:forEach>
			</main>
			<!-- ./main -->


			<!-- ============== ./COL RIGHT============== -->
		</div>
		<!-- ./ row  -->
	</div>
	<!-- ./ container  -->
</section>
<!-- ========================= ./SECTION CARS ========================= -->

