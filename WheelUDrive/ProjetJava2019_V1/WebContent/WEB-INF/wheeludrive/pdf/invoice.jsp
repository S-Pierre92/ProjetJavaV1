<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<table style="width: 100%">
<tr>
	<td style="width: 50%">
		<!-- <img src="${pageContext.request.contextPath}/assets/images/logo.png" alt="logo_wheeludrive"/> -->
	</td>
	<td style="width: 50%; text-align: right;">
		<table style="width: 100%">
			<tr>
				<td style="font-weight: bold; font-size: 14pt; color: #444; width: 100%;">
					Facture
				</td>
			</tr>
			<tr>
				<td style="font-size: 14pt; color: #9E9F9E">
					${facture.getDateFacture()}
				</td>
			</tr>
			<tr>
				<td style="font-size: 14pt; color: #9E9F9E">
					#${facture.getId()}
				</td>
			</tr>
		</table>
	</td>
</tr>
</table>

<table width="100%" id="body" border="0" cellpadding="0" cellspacing="0" style="margin:0;">
	<!-- Invoicing -->
	<tr>
		<td colspan="12">

			<table id="addresses-tab" cellspacing="0" cellpadding="0">
				<tr>
					<td width="33%"><span style="font-weight: bold">Adresse vendeur : </span><br/><br/>
						${vendeur.getNom()} ${vendeur.getPrenom()} <br/>
						${adresseVendeur.getRue()} ${adresseVendeur.getNumero()}, <br/>
						${adresseVendeur.getCodePostal().getCode()} ${adresseVendeur.getCodePostal().getIntitule()}
					</td>
					<td width="33%">
					</td>
					<td width="33%"><span style="font-weight: bold">Adresse de facturation : </span><br/><br/>
						${utilisateur.getNom()} ${utilisateur.getPrenom()} <br/>
						${adresse.getRue()} ${adresse.getNumero()}, <br/>
						${adresse.getCodePostal().getCode()} ${adresse.getCodePostal().getIntitule()}
					</td>
				</tr>
			</table>

		</td>
	</tr>

	<tr>
		<td colspan="12" height="30">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="12">
			<table id="summary-tab" width="100%" border="0" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
				<tr>
					<th valign="middle" style="border: 1px solid black">
						Référence de la commande
					</th>
					<th valign="middle" style="border: 1px solid black">
						Date de la commande
					</th>
					<th valign="middle" style="border: 1px solid black">
						Numéro de tva
					</th>
				</tr>
				<tr>
					<td style="border: 1px solid black">
						${commande.getId()}
					</td>
					<td style="border: 1px solid black">
						${commande.getDateCommande()}
					</td>
					<td style="border: 1px solid black">
						${utilisateur.getNumeroTVA()}
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td colspan="12" height="30">&nbsp;</td>
	</tr>
</table>

<table width="100%" cellpadding="4" cellspacing="0">
	<thead>
		<tr>
			<th>Type contrat</th>
			<th>Montant</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${contrats}" var="contrat" varStatus="status">
		<tr>
			<td>
				<c:out value="${contrat.getTypeContrat().getIntitule()}"/>
			</td>
			<td>
				<c:out value="${contrat.getMontant()}"/>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>