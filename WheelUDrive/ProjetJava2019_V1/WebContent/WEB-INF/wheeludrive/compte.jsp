<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	
	
		<!-- ========================= SECTION INTRO ========================= -->
		<section 	class="section-intro bg-compte pt-4" style="background-image: url('${pageContext.request.contextPath}/assets/images/slide3.jpg');">
			<div class="container">	
				<main class="">
					<div class="row text-light text-center">
							<div class="col-md-8 col-sm-12 mx-auto">
									<!-- <h1 class="display-4 mb-3">How it works</h1>
									<p class="lead mb-5">Good sub heading this sounded nonsense to Alice </p> -->
							</div>
					</div> <!-- row.// -->
				
					<div class="row mb-5">
						<div class="mx-auto col-12">
							<!-- ========================= SECTION FEATURES ========================= -->
							<div class="row pt-5">
								<aside class="col-sm-12">
									<figure class="itembox  text-center  p-5">
										<span class="icon-wrap icon-lg circle white pt-3">
											<i class="fa fa-user"></i> 
										</span>
										<figcaption class="text-wrap">
											<h1 class="title-xl white">Mon compte</h1>	
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
							<!-- ========================= SECTION FEATURES END// ========================= -->
							<!--	<div class="card">
								<div class="card-body">
								 <form>
									<div class="form-row">
											<div class="col-md-3 col-sm-12">
													<select class="form-control">
															<option>Marque</option>
													</select>
											</div>
											<div class="col-md-3 col-sm-12">
													<select class="form-control">
															<option>Modèle</option>
													</select>
											</div>
											<div class="col-md-3 col-sm-12">
													<select class="form-control">
															<option>Prix min</option>
													</select>
											<div class="col-md-3 col-sm-12">
													<button class="btn btn-primary btn-block h-100" type="submit">Search</button>
											</div>
									</div>
									</form>
								 
								</div> <-- card-body.// --
							</div> <-- card.// ---->
						</div> <!-- col.// -->
					</div> <!-- row.// -->
				
				<br>
				
				</main>
			</div> <!-- container.// -->
		</section>
		<!-- ========================= ./SECTION INTRO ========================= -->

		<!-- ========================= SECTION CARS ========================= -->
		<section class="section-content bg padding-y">
			
			<div class="container">
				<div class="row">
					<aside>
					<ul class="nav nav-tabs shadow" id="myTab" role="tablist">
						<li class="nav-item">
							<a class="nav-link active" data-toggle="tab" href="#infosPerso" role="tab" aria-controls="infosPerso">Informations personnelles</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="tab" href="#abonnements" role="tab" aria-controls="abonnements">Mes abonnements</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="tab" href="#commandes" role="tab" aria-controls="commandes">Mes commandes</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="tab" href="#annonces" role="tab" aria-controls="annonces">Mes annonces</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="tab" href="#favoris" role="tab" aria-controls="favoris">Mes favoris</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="tab" href="#newsletters" role="tab" aria-controls="newsletters">Mes newsletters</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="tab" href="#stats" role="tab" aria-controls="stats">Mes statistiques</a>
						</li>
					</ul>
				</aside>
					<!--tab content-->
					<div class="tab-content shadow">
						<!--tab#1-->
						<div class="tab-pane active" id="infosPerso" role="tabpanel">
							
							<div class="container pt-3">
								<form >
									<div class="row">
										<div class="col-md-6">
											<div class="form-group input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i class="fa fa-user"></i> </span>
												</div>
												<input  id="nom" name="nom" value="${usrvalues['nom']}" class="form-control" placeholder="Nom" type="text" >
											</div> <!-- form-group// -->
										</div>
										<div class="col-md-6">
											<div class="form-group input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i class="fa fa-user"></i> </span>
												</div>
												<input name="prenom" class="form-control" placeholder="Prénom" value="${usrvalues['prenom']}" type="text" >
											</div> <!-- form-group// -->
										</div>
										<div class="col-md-6">
											<div class="form-group input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i class="fa fa-birthday-cake"></i> </span>
												</div>
												<input type="date" name="dateNaissance" placeholder="Date de naissance" max="3000-12-31"  min="1000-01-01"  value="${usrvalues['birth']}" class="form-control">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
												</div>
												<input name="email" class="form-control" placeholder="Email" type="email" value="${usrvalues['email']}" required readonly="readonly">
											</div> <!-- form-group// -->
										</div>
										<div class="col-md-6">
											<div class="form-group input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i class="fa fa-phone"></i> </span>
												</div>
												<input name="telFixe" class="form-control" placeholder="téléphone fixe" type="tel" value="${usrvalues['tel']}" >
											</div> <!-- form-group// -->
										</div>
										<div class="col-md-6">
											<div class="form-group input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"><i class="fas fa-mobile-alt"></i> </span>
												</div>
												<input name="telMobile" class="form-control" placeholder="téléphone mobile" type="tel" value="${usrvalues['gsm']}">
											</div> <!-- form-group// -->
										</div>
										<div class="col-md-6">
										<div class="form-group input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i class="fas fa-map-marker-alt"></i> </span>
											</div>
											<input name="rue" class="form-control" placeholder="Adresse" type="text" value="${usrvalues['rue']}">
										</div> <!-- form-group// -->
									</div>
										<div class="col-md-3">
											<div class="form-group input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i class="fas fa-map-marker-alt"></i></span>
												</div>
												<input name="num" class="form-control" placeholder="Numéro" type="text" value="${usrvalues['numero']}">
											</div> <!-- form-group// -->
										</div>
										<div class="col-md-3">
											<div class="form-group input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i class="fas fa-map-marker-alt"></i> </span>
												</div>
												<input name="boite" class="form-control" placeholder="Boite" type="text" value="${usrvalues['boite']}" >
												
											</div> <!-- form-group end.// -->
										</div>																	
										<div class="col-md-6">
											<div class="form-group input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"><i class="fas fa-map-marker-alt"></i> </span>
												</div>
												<select class="form-control custom-select" name="CPville">
													<option selected="" disabled aria-required="true" required> Code postal - Ville</option>
													<c:forEach items="${CpVilles}" var="CpVille">
														<option value="${CpVille.id}">${CpVille.code}- ${CpVille.intitule}</option>
													</c:forEach>
												</select>
											</div> <!-- form-group end.// -->
										</div>
										<div class="col-md-6">
											<div class="form-group input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i class="fas fa-globe-europe"></i></span>
											</div>
											<select class="form-control custom-select" name="pays">
												<option selected="selected" aria-required="true" required value="Belgique">Belgique</option>
											</select>
											</div> <!-- form-group end.// -->
										</div>
										
										<!-- professionnel -->
										<div class="col-md-6" id="professionnelTVA" ></div>
										<!-- ./professionnel -->
										<hr>
										<div class="col-md-6">
											<div class="form-group input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i class="fa fa-lock"></i> </span>
											</div>
													<input class="form-control" name="motdepasse" placeholder="Entrez un mot de passe" type="password">
											</div> <!-- form-group// -->
										</div>
										<div class="col-md-6">
										<div class="form-group input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i class="fa fa-lock"></i> </span>
											</div>
											<input class="form-control" name="confirmation" placeholder="Répétez le mot de passe" type="password">
										</div> <!-- form-group// -->   
									</div>
									</div>
								 
								<!--btn valid-->
								<div class="col-12 mt-4">
									<div class="form-group text-center">
										<button type="submit" class="btn btn-primary "> Enregistrer les modifications  </button>
									</div> <!-- form-group// -->      
								</div>
						<!-- ./form-inscription -->
								
							</form>
						</div>
							
						</div>
						<!--./tab#1-->
						<!--tab#2-->
						<div class="tab-pane" id="infosConcess" role="tabpanel">
							<form class="row" action="">
								<div class="col-md-6">
									<div class="form-group input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-user"></i> </span>
										</div>
										<input name="" class="form-control" placeholder="Nom du garage" type="text" required>
									</div> <!-- form-group// -->
								</div>
								<div class="col-md-6">
									<div class="form-group input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-user"></i> </span>
										</div>
										<input name="" class="form-control" placeholder="Numéro de TVA" type="text" required>
									</div> <!-- form-group// -->
								</div> 
								<div class="col-12"><hr></div>
								<div class="col-md-6">
									<div class="form-group input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-lock"></i> </span>
										</div>
										<input class="form-control" placeholder="Entrez le password" type="password">
									</div> <!-- form-group// -->
								</div> 
								<div class="col-md-6">
									<div class="form-group input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-lock"></i> </span>
										</div>
										<input class="form-control" placeholder="Valider le password" type="password">
									</div> <!-- form-group// -->  
								</div>   
								<div class="col-12 mt-4">
									<div class="form-group text-center">
										<button type="submit" class="btn btn-primary "> Enregistrer les modifications  </button>
									</div> <!-- form-group// -->      
								</div>
							</form>
						</div>
						<!--./tab#2-->
						<!--tab#3-->
						<div class="tab-pane" id="abonnements" role="tabpanel">
							<form class="row">

								<div class="col-md-12 text-center">
									<h5 >Votre abonnement actuel est</h5>
									<hr>
									<h3 class="title"> CLASSIQUE LIMITE</h3>
								</div>
								
								<div class="col-12 mt-4">
									<div class="form-group text-center white">
										<a class="btn btn-primary " data-target="#modal-abo" data-toggle="modal"> Modifier mon abonnement  </a>
									</div> <!-- form-group// -->      
								</div>
							</form>
						</div>
						<!--./tab#3-->
						
						<!--tab#4-->
						<div class="tab-pane" id="commandes" role="tabpanel">
							<table class="table table-striped table-hover">
								<tr>
									<th>ID </th>
									<th>Marque Modèle </th>
									<th>Date d'achat </th>
									<th>Document </th>
								</tr>
								<c:forEach items="${commandes}" var="commande" varStatus="status">
									<tr>
										<td><a href="#">${commande['idCommande']}</a></td>
										<td>${commande['marqueModele']}</td>
										<td>${commande['dateCommande']}</td>
										<td><a href="${commande['lienPdf']}" ><i class="fa fa-file-pdf" aria-hidden="true"></i></a></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<!--./tab#4-->
						<!--tab#5-->
						<div class="tab-pane" id="annonces" role="tabpanel">
							<div class="col-12">
								<button class="btn btn-primary btn-block " data-target="#modal-annonce" data-toggle="modal">Créer une nouvelle annonce</button><br>
							</div>
							<!-- ========================= SECTION CARS ========================= -->
							<section class="section-content bg padding-y">
							
										
									<!-- ============== LIST ============== -->
									<main class="col-sm-12">
										<div class="text-center title-l mb-4">
											<span class="circle white py-1 px-4" >1</span> annonce
											<hr>
										</div>
										<article class="card card-product">
											<div class="card-body">
												<div class="row">
													<!-- IMG -->
													<aside class="col-sm-6 col-md-5">
														<div class="img-wrap"> 
															<img src="assets/images/noPhoto.jpg">
														</div>
													</aside> 
													<!--./IMG -->
													<!-- DETAILS -->
													<article class="col-sm-4 col-md-5	">
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
															<dd>Nom vendeur, adresse</dd>
														</dl> 
														
														<dl class="dlist-align">
															<dt>Nbre de vues</dt>
															<dd>23</dd>
														</dl>
														<dl class="dlist-align">
															<dt>Date de publication</dt>
															<dd>23/05/19</dd>
														</dl>
														
													</article> 
													<!-- ./DETAILS -->
													<!-- PRIX  -->
													<aside class="col-md-2 border-left">
														<div class="action-wrap">
															<div class="price-wrap h4 m-0">
																<span class="price"> 12.000€ </span>	
															</div> 
															<p class="text-red m-0 mb-4">TVA déductible</p>
															<p>
															
															<a href="#" class="btn btn-primary btn-block  m-0"><i class="fas fa-plus"></i> Details</a>
															<a href="#"  class="btn btn-primary btn-block"><i class="fas fa-edit    "></i></a>
														<a href="#"  class="btn btn-primary btn-block"><i class="fas fa-trash    "></i></a>
														<a href="#" data-toggle="modal" data-target="#modal-validate" class="btn btn-primary btn-block"><i class="fas fa-handshake"></i></a>
														</div> 
													</aside> 
													<!-- ./PRIX -->
												</div> <!-- ./row -->
											</div> <!-- ./card-body -->
										</article> <!-- ./article -->
									</main> <!-- ./main -->
									<!-- ============== ./LIST============== -->
						</section>
						<!-- ========================= ./SECTION CARS ========================= -->
						</div>
						<!--./tab#5-->
						<!--tab#6-->
						<div class="tab-pane" id="favoris" role="tabpanel">
							<!-- ========================= SECTION CARS ========================= -->
							<section class="section-content bg padding-y">
							
										
										<!-- ============== LIST ============== -->
										<main class="col-sm-12">
											<div class="text-center title-l mb-4">
												<span class="circle white py-1 px-4" >1</span> favori
												<hr>
											</div>
											<article class="card card-product">
												<div class="card-body">
													<div class="row">
														<!-- IMG -->
														<aside class="col-sm-6 col-md-5">
															<div class="img-wrap"> 
																<img src="assets/images/noPhoto.jpg">
															</div>
														</aside> 
														<!--./IMG -->
														<!-- DETAILS -->
														<article class="col-sm-4 col-md-5	">
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
																<dt>Dealer</dt>
																<dd>Nom concession, adresse</dd>
															</dl> 
															<dl class="dlist-align">
																<dt></dt>
																<dd>
																	<div class="rating-wrap  mb-2">
																		<ul class="rating-stars">
																			<li style="width:80%" class="stars-active"> 
																				<i class="fa fa-star"></i> <i class="fa fa-star"></i> 
																				<i class="fa fa-star"></i> <i class="fa fa-star"></i> 
																				<i class="fa fa-star"></i> 
																			</li>
																			<li>
																				<i class="fa fa-star"></i> <i class="fa fa-star"></i> 
																				<i class="fa fa-star"></i> <i class="fa fa-star"></i> 
																				<i class="fa fa-star"></i> 
																			</li>
																		</ul>
																		<!-- <div class="label-rating">132 reviews</div> -->
																	</div> 
																</dd>
															</dl>  
														</article> 
														<!-- ./DETAILS -->
														<!-- PRIX  -->
														<aside class="col-md-2 border-left">
															<div class="action-wrap">
																<div class="price-wrap h4 m-0">
																	<span class="price"> 12.000€ </span>	
																</div> 
																<p>
																	<a href="#" class="btn btn-outline-primary btn-block mb-1"><i class="fa fa-heart"></i><br>Retirer des favoris </a>
																	<a href="#" class="btn btn-primary btn-block  m-0"><i class="fas fa-plus"></i> <br>Details   </a>
															</div> 
														</aside> 
														<!-- ./PRIX -->
													</div> <!-- ./row -->
												</div> <!-- ./card-body -->
											</article> <!-- ./article -->
										</main> <!-- ./main -->
										<!-- ============== ./LIST============== -->
							</section>
							<!-- ========================= ./SECTION CARS ========================= -->
						</div>
						<!--./tab#6-->
						<!--tab#7-->
						<div class="tab-pane" id="newsletters" role="tabpanel">
							Coming soon ! 
						</div>
						<!--./tab#7-->
						<!--tab#8-->
						<div class="tab-pane" id="stats" role="tabpanel">
							Coming soon ! 
						</div>
						<!--./tab#8-->
					</div>
					
				</div><!-- ./ row  -->
			</div> <!-- ./ container  -->
		</section>
			<!-- ========================= ./SECTION CARS ========================= -->
	
	