<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




<!-- ========================= SECTION INFOS ========================= -->
<section class="section-intro bg mt-5 ">
<div class="container box shadow p-5">
	<h1 class="title mb-5">Mis en vente par ${vendeur.nom}
		${vendeur.prenom}</h1><a class="btn btn-primary"  data-toggle="modal" data-target="#modal-annonce"> Créer une
	annonce</a>
	<div class="owl-carousel owl-theme owl-loaded ">
		<div class="owl-stage-outer">
			<div class="owl-stage">
				<div class="owl-item">
					<img
						src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg">
				</div>
				<div class="owl-item">
					<img
						src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg">
				</div>
				<div class="owl-item">
					<img
						src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg">
				</div>
				<div class="owl-item">
					<img
						src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg">
				</div>
				<div class="owl-item">
					<img
						src="${pageContext.request.contextPath}/assets/images/noPhoto.jpg">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<h1 class="title">${voiture.marque}${voiture.modele}</h1>
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

<div class="container  my-5 pb-5">
	<div class="row shadow">
		<div class="col-md-3 col-md-3-custom">
			<div class="contact-info">
				<img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image" />
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
				<div class="form-group">
					<label class="control-label col-sm-2" for="fname">Nom:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="fname"
							placeholder="Nom" name="fname">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="lname">Prénom:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="lname"
							placeholder="Prénom" name="lname">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="email">Email:</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="email"
							placeholder="Email" name="email">
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
						<input type="submit" class="btn btn-secondary"
							data-target="#sendMailContact" data-toggle="modal"
							value="Envoyer">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</section>
<!-- ========================= ./SECTION INFOS ========================= -->

<!-- MODALS-ANNONCE -->
<div class="modal fade text-left" id="modal-annonce">
	<div class="modal-dialog annonce">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Publier une annonce</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<!-- Modal body -->
			<div class="modal-body">
				<article class=""> <!--formulaire vente-->
				<form>
					<main class="col-sm-12"> <article class="form ">
					<h1 class="title-m">1. Informations du véhicule</h1>
					<hr>
					<!-- form  -->
					<div class="form-row mt-4">
						<!--Row1-->
						<div class="col-md-3 pb-3">
							<label for="marque">Marque</label> <select id="marque"
								class="form-control custom-select" size="0">
								<option value="Hawaii">Audi</option>
							</select>
						</div>
						<div class="col-md-3 pb-3">
							<label for="modele">Modèle</label> <select id="modele"
								class="form-control custom-select" size="0">
								<option value="Hawaii">A1</option>
							</select>
						</div>
						<div class="col-md-6 pb-3">
							<label for="version">Version</label> <input type="text"
								class="form-control" id="version">
						</div>
						<!--Row2-->
						<div class="col-md-3 pb-3">
							<div class="form-group">
								<label>Date immatrictulation</label> <input type="date"
									name="bday" max="3000-12-31" min="1000-01-01"
									class="form-control">
							</div>
						</div>
						<div class="col-md-3 pb-3">
							<label for="modele">Carburant</label> <select id="modele"
								class="form-control custom-select" size="0">
								<option value="Essence">Essence</option>
								<option value="Diesel">Diesel</option>
							</select>
						</div>

						<div class="col-md-3 pb-3">
							<label for="puissance">Puissance</label> <input type="text"
								name="puissance" class="form-control">
						</div>
						<div class="col-md-3 pb-3">
							<div class="form-group ">
								<label for="boite">Boite à vitesses <sup> </sup></label> <select
									name="boite" id="boite" class="form-control boite" data-base="">
									<option value="0">Choisissez le type de boite à
										vitesse</option>
									<option value="manuelle">Manuelle</option>
									<option value="automatique">Automatique</option>
									<option value="semi-automatique">Semi-automatique</option>
								</select>
							</div>
						</div>
						<!--row3-->
						<div class="col-md-3 pb-3">
							<label for="couleurInt">Couleur intérieur</label> <select
								id="couleurInt" class="form-control custom-select" size="0">
								<option value="Rouge">Rouge</option>
							</select>
						</div>
						<div class="col-md-3 pb-3">
							<label for="couleurExt">Couleur Extérieur</label> <select
								id="couleurExt" class="form-control custom-select" size="0">
								<option value="Rouge">Rouge</option>
							</select>
						</div>
						<div class="col-md-3 pb-3">
							<label for="typePeinture">Type de peinture</label> <select
								id="typePeinture" class="form-control custom-select" size="0">
								<option value="Rouge">Rouge</option>
							</select>
						</div>
						<div class="col-md-3 pb-3">
							<label for="typeSiege">Type de sièges</label> <select
								id="typeSiege" class="form-control custom-select" size="0">
								<option value="Rouge">Rouge</option>
							</select>
						</div>
						<!--row4-->
						<div class="col-md-3 pb-3">
							<label for="kilometre">Kilomètres</label> <select id="kilometre"
								class="form-control custom-select" size="0">
								<option value="Rouge">3</option>
							</select>
						</div>
						<div class="col-md-3 pb-3">
							<div class="form-group ">
								<label for="cylindree">Cylindrée <sup> </sup></label> <input
									type="text" required="required" name="cylindree" id="cylindree"
									class="form-control" value="">
							</div>
						</div>
						<div class="col-md-3 pb-3">
							<div class="form-group ">
								<label for="cylindree">CV <sup></sup></label> <input type="text"
									required="required" name="cylindree" id="cylindree"
									class="form-control" value="">
							</div>
						</div>
						<div class="col-md-3 pb-3">
							<div class="form-group ">
								<label for="cylindree">KW <sup></sup></label> <input type="text"
									required="required" name="cylindree" id="cylindree"
									class="form-control" value="">
							</div>
						</div>
						<!--row5-->
						<div class="col-md-3 pb-3">
							<div class="form-group ">
								<label for="type">Carrosserie <sup> </sup></label> <select
									name="carrosserie" id="carrosserie" class="form-control"
									data-base="">
									<option disable value="0">Choisissez le type de
										véhicule</option>
								</select>
							</div>
						</div>
						<div class="col-md-3 pb-3">
							<div class="form-group ">
								<label for="type">Transmission <sup></sup></label> <select
									name="transmission" id="transmission" class="form-control"
									data-base="">
									<option disable value="0">Transmission</option>
								</select>
							</div>
						</div>
						<div class="col-md-3 pb-3">
							<label for="nombrePortes">Nombre de portes</label> <select
								id="nombrePortes" class="form-control custom-select" size="0">
								<option value="Rouge">3</option>
							</select>
						</div>
						<div class="col-md-3 pb-3">
							<div class="form-group ">
								<label for="motorisation">Motorisation <sup></sup></label> <input
									type="text" required="required" name="cylindree"
									id="motorisation" class="form-control" value="">
							</div>
						</div>

						<!--row6-->
						<div class="col-md-3 pb-3">
							<div class="form-group ">
								<label for="emissionCO2">emissionCO2 <sup></sup></label> <input
									type="text" required="required" name="cylindree"
									id="emissionCO2" class="form-control" value="">
							</div>
						</div>
						<div class="col-md-2 pb-3">
							<div class="form-group ">
								<label for="carpassEstOk">Car pass <sup></sup></label> <select
									name="carpassEstOk" id="carpassEstOk" class="form-control"
									data-base="">
									<option disable value="0">Non</option>
									<option disable value="1">Oui</option>
								</select>
							</div>
						</div>
						<div class="col-md-2 pb-3">
							<div class="form-group ">
								<label for="normeEuropeene">Norme Euro <sup></sup></label> <select
									name="normeEuropeene" id="normeEuropeene" class="form-control"
									data-base="">
									<option disable value="0">Euro 1</option>
									<option disable value="1">Euro 2</option>
								</select>
							</div>
						</div>
						<div class="col-md-2 pb-3">
							<div class="form-group ">
								<label for="nombreClefs">Nombre de clés <sup></sup></label> <select
									name="nombreClefs" id="nombreClefs" class="form-control"
									data-base="">
									<option disable value="1">1</option>
									<option disable value="2">2</option>
								</select>
							</div>
						</div>
						<div class="col-md-3 pb-3">
							<div class="form-group ">
								<div class="form-group ">
									<label for="numeroChassis">Numéro de châssis <sup></sup></label>
									<input type="text" required="required" name="numeroChassis"
										id="numeroChassis" class="form-control" value="">
								</div>
							</div>
						</div>
						<!--row6-->
						<div class="col-md-6 ">
							<form>
								<div class="form-group">
									<label for="exampleFormControlFile1">Importer des
										photos</label> <input type="file" class="form-control-file"
										id="exampleFormControlFile1">
								</div>
							</form>
						</div>
						<div class="col-md-6 ">
							<form>
								<div class="form-group">
									<label for="carnetEntretien">Importer le carnet
										d'entretien</label> <input type="file" class="form-control-file"
										id="carnetEntretien">
								</div>
							</form>
						</div>

					</div>
					</article> <!-- ./article --> <article class="form  mt-5">
					<h1 class="title-M">2. Détails de l'annonce</h1>
					<hr>
					<!-- form  -->
					<div class="form-row mt-4">
						<!--Row1-->
						<div class="col-md-3">
							<div class="">
								<label for="description">Prix de vente</label> <input
									type="text" name="prixVente" class="form-control"
									id="prixVente">
							</div>
						</div>
						<!-- à afficher uniquement si compte professionnel-->
						<div class="col-md-3">
							<div class="form-group ">
								<label for="nombreClefs">Tva déductible <sup></sup></label> <select
									name="nombreClefs" id="nombreClefs" class="form-control"
									data-base="">
									<option disable value="1">Non</option>
									<option disable value="2">Oui</option>
								</select>
							</div>
						</div>
						<!-- ./à afficher uniquement si compte professionnel-->
					</div>
					<div class="form-row mt-4">
						<div class="col-md-6 pb-4">
							<div class="">
								<label for="description">Titre de l'annonce</label> <input
									type="text" name="prixVente" class="form-control"
									id="prixVente">
							</div>
						</div>
						<div class="col-md-12 ">
							<div class="form-row">
								<label for="description">Description</label>
								<textarea class="form-control" id="description" rows="6"></textarea>
								<small class="text-info"> </small>
							</div>
						</div>
					</div>
					</article> <!-- ./article -->

					<div class="form-row">
						<div class="col-12 text-center p-5">
							<button class="btn btn-primary mr-3">Sauvegarder mon
								annonce</button>

							<button class="btn btn-outline-primary">Publier mon
								annonce</button>
						</div>
					</div>
					</main>
					<!-- ./main -->
					<!-- ============== ./COL RIGHT============== -->
				</form>
				<!-- ./formulaire evente--> </article>
				<!--  card-body end .//
					<div class="border-top card-body text-center">
							Déjà un compte? <a href="">Se connecter</a>
					</div> -->
			</div>

		</div>
	</div>
</div>
<!-- ./MODALS-ANNONCE -->


