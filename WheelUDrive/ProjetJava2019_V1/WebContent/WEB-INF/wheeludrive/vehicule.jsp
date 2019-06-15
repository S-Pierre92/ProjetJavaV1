<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->

<!-- ========================= MODALS ========================= -->

<c:if test="${sendMailError != null}">
	<div class="modal fade text-left show"
		style="display: block; background: rgba(0, 0, 0, 0.7);"
		id="sendMailErrorModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title"></h4>
					<button type="button" class="close closeModal white"
						data-target="sendMailErrorModal" data-dismiss="modal">
						<i class="fas fa-times"></i>
					</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body text-center">
					<article class="p-5">
						<h4>${sendMailError}</h4>
						<p></p>
					</article>
				</div>
			</div>
		</div>
	</div>
</c:if>
<c:if test="${sendMailSuccess != null}">
	<div class="modal fade text-left show"
		style="display: block; background: rgba(0, 0, 0, 0.7);"
		id="sendMailSuccessModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title"></h4>
					<button type="button" class="close closeModal white"
						data-target="sendMailSuccessModal" data-dismiss="modal">
						<i class="fas fa-times"></i>
					</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body text-center">
					<article class="p-5">
						<h4>${sendMailSuccess}</h4>
						<p></p>
					</article>
				</div>
			</div>
		</div>
	</div>
</c:if>
<!-- ========================= ./ MODALS ========================= -->

<!-- ========================= SECTION INFOS ========================= -->
<section class="section-intro bg mt-5 ">
	<div class="container box shadow p-5">
		<h1 class="title mb-5">Mis en vente par ${vendeur.nom} ${vendeur.prenom}</h1>
		<div class="owl-carousel owl-theme owl-loaded ">
			<div class="owl-stage-outer">
				<div class="owl-stage">
					<div class="owl-item">
						<img src="${photo}">
					</div>
					<div class="owl-item">
						<img src="${photo}">
					</div>
					<div class="owl-item">
						<img src="${photo}">
					</div>
					<div class="owl-item">
						<img src="${photo}">
					</div>
					<div class="owl-item">
						<img src="${photo}">
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<h1 class="title">${voiture.marque} ${voiture.modele}</h1>
				<h2 class="title-s">
					<i>${version}</i>
				</h2>
				<hr>
			</div>
			<div class="col-md-6 text-right">
				<h1 class="title">${voiture.prix}€</h1>
				<!-- 						<h2 class="title-s"><i>TVA déductible</i></h2> -->
				<hr>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered table-striped table-hover">
					<tr>
						<td>Carrosserie</td>
						<td>${voiture.carrosserie}</td>
						<td>Date 1ere circulation</td>
						<td>${voiture.date}</td>
					</tr>
					<tr>
						<td>Kilomètres</td>
						<td>${voiture.kilometre}</td>
						<td>Carburant</td>
						<td>${voiture.carburant}</td>
					</tr>
					<tr>
						<td>Transmission</td>
						<td>${voiture.transmission}</td>
						<td>Vitesses</td>
						<td>${voiture.vitesse}</td>
					</tr>
					<tr>
						<td>KW</td>
						<td>${voiture.kw}</td>
						<td>CV</td>
						<td>${voiture.cv}</td>

					</tr>
					<tr>
						<td>Cylindrée</td>
						<td>${voiture.cylindree}cm³</td>
						<td>Motorisation</td>
						<td>${voiture.motorisation}</td>

					</tr>
					<tr>
						<td>Emission CO2</td>
						<td>${voiture.emissionCO2}g/km</td>
						<td>Couleur intérieure</td>
						<td>${voiture.couleurInt}</td>

					</tr>
					<tr>
						<td>Couleur extérieure</td>
						<td>${voiture.couleurExt}</td>
						<td>Type de peinture</td>
						<td>${voiture.typePeinture}</td>

					</tr>
					<tr>
						<td>Type de siège</td>
						<td>${voiture.typeSiege}</td>
						<td>Nombre de clés</td>
						<td>${voiture.nombreClef}</td>

					</tr>
					<tr>
						<td>Nombre de portes</td>
						<td>${voiture.nombrePortes}</td>
						<td>Norme Euro</td>
						<td>Euro ${voiture.normeEuropeene}</td>
					</tr>
					<tr>
						<td>Carnet d'entretien</td>
						<td>${voiture.carnet}</td>
						<td>Car Pass</td>
						<td>${voiture.carpass}</td>
					</tr>
					<tr>
						<td>Description</td>
						<td colspan="3">${voiture.description}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<form action="${pageContext.request.contextPath}/wheeludrive/vehicule"
		method="post">
		<input type="hidden" name="id_voiture" value="${id_voiture}" /> <input
			type="hidden" name="id_vendeur" value="${id_vendeur}" />
		<div class="container  my-5 pb-5">
			<div class="row shadow">
				<div class="col-md-3 col-md-3-custom">
					<div class="contact-info">
						<img src="https://image.ibb.co/kUASdV/contact-image.png"
							alt="image" />
						<h2 class="title">Contactez le vendeur!</h2>
						<hr class="bg-white">
						<h4>${vendeur.nom}${vendeur.prenom}</h4>
						<p>${vendeur.adresse}</p>
						<p>${vendeur.codePostal}</p>
						<p>Belgique</p>
						<p>${vendeur.tel}</p>
					</div>
				</div>

				<div class="col-md-9 col-md-9-custom">
					<div class="contact-form">
						<!-- a priopri pas besoin de ces champs la -->
						<!-- 
						<div class="form-group">
							<label class="control-label col-sm-2" for="fname">Nom:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="fname"
									placeholder="Nom" name="email_firstname">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="lname">Prénom:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="lname"
									placeholder="Prénom" name="email_lastname">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="email">Email:</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="email"
									placeholder="Email" name="email_email">
							</div>
						</div>
						-->
						<div class="form-group">
							<label class="control-label col-sm-2" for="comment">Message:</label>
							<div class="col-sm-10">
								<textarea class="form-control" rows="5" id="email_message"
									name="email_message"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" class="btn btn-secondary" name="sendMail"
									value="Envoyer">
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</form>
</section>
<!-- ========================= ./SECTION INFOS ========================= -->




