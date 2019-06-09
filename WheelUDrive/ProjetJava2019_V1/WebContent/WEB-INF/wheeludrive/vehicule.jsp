<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	



		<!-- ========================= SECTION INFOS ========================= -->
		<section class="section-intro bg mt-5 ">
			<div class="container box shadow p-5">
				<h1 class="title mb-5">Mis en vente par ${vendeur}</h1>
				<div class="owl-carousel owl-theme owl-loaded ">
						<div class="owl-stage-outer">
							<div class="owl-stage">
								<div class="owl-item"><img src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg"  ></div>
								<div class="owl-item"><img src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg"  ></div>
								<div class="owl-item"><img src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg"  ></div>
								<div class="owl-item"><img src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg"  ></div>
								<div class="owl-item"><img src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg"  ></div>
							</div>
						</div>
					</div>
				<div class="row">
					<div class="col-md-6">
						<h1 class="title">${marque} ${modele}</h1>
						<h2 class="title-s"><i>Version</i></h2>
						<hr>
					</div>
					<div class="col-md-6 text-right">
						<h1 class="title">12.999 €</h1>
						<h2 class="title-s"><i>TVA déductible</i></h2>
						<hr>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<table class="table table-bordered table-striped table-hover">
							<tr>
								<td>Carrosserie</td>
								<td>Coupé</td>
								<td>Date 1ere circulation</td>
								<td>10/02/2019</td>
							</tr>
							<tr>
								<td>Kilomètres</td>
								<td>12.000</td>
								<td>Carburant</td>
								<td>Diesel</td>
							</tr>
							<tr>
								<td>Transmission</td>
								<td>Manuelle</td>
								<td>Vitesses</td>
								<td>6</td>
							</tr>
							<tr>
								<td>KW</td>
								<td>93</td>
								<td>CV</td>
								<td>123</td>
								
							</tr>
							<tr>
								<td>Cylindrée</td>
								<td>1.895 cm³</td>
								<td>Motorisation </td>
								<td>1.2</td>
								
							</tr>
							<tr>
								<td>Emission CO2 </td>
								<td>3g/km</td>
								<td>Couleur intérieure </td>
								<td>Rouge</td>
								
							</tr>
							<tr>
								<td>Couleur extérieure</td>
								<td>Gris</td>
								<td>Type de peinture </td>
								<td>Métalisée</td>
								
							</tr>
							<tr>
								<td>Type de siège</td>
								<td>Cuir</td>
								<td>Nombre de clés </td>
								<td>2</td>
								
							</tr>
							<tr>
								<td>Nombre de portes</td>
								<td>4</td>
								<td>Norme Euro </td>
								<td>Euro 5</td>
							</tr>
							<tr>
								<td>Carnet d'entretien </td>
								<td>Oui</td>
								<td>Car Pass</td>
								<td>Ok</td>
							</tr>
							<tr>
								<td>Description </td>
								<td colspan="3">Lorem Ipsum blablabla</td>
							</tr>
						</table>
					</div>
				</div>
			</div>

			<div class="container  my-5 pb-5">
				<div class="row shadow">
					<div class="col-md-3 col-md-3-custom">
						<div class="contact-info">
							<img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
							<h2 class="title">Contactez le vendeur!</h2>
							<hr class="bg-white">
							<h4>Nom du vendeur</h4>
							<p>Adresse, num</p>
							<p>Ville, CP</p>
							<p>Pays</p>
							<p>Tel</p>
						</div>
					</div>
					<div class="col-md-9 col-md-9-custom">
						<div class="contact-form">
							<div class="form-group">
							<label class="control-label col-sm-2" for="fname">Nom:</label>
							<div class="col-sm-10">          
								<input type="text" class="form-control" id="fname" placeholder="Nom" name="fname">
							</div>
							</div>
							<div class="form-group">
							<label class="control-label col-sm-2" for="lname">Prénom:</label>
							<div class="col-sm-10">          
								<input type="text" class="form-control" id="lname" placeholder="Prénom" name="lname">
							</div>
							</div>
							<div class="form-group">
							<label class="control-label col-sm-2" for="email">Email:</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="email" placeholder="Email" name="email">
							</div>
							</div>
							<div class="form-group">
							<label class="control-label col-sm-2" for="comment">Message:</label>
							<div class="col-sm-10">
								<textarea class="form-control" rows="5" id="comment"></textarea>
							</div>
							</div>
							<div class="form-group">        
							<div class="col-sm-offset-2 col-sm-10">
								<button class="btn btn-secondary" data-target="#sendMailContact" data-toggle="modal" >Envoyer</button>
							</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- ========================= ./SECTION INFOS ========================= -->

	
