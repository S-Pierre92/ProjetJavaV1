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
					${invoiceDate}
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
						<b>Référence de la commande</b>
					</th>
					<th valign="middle" style="border: 1px solid black">
						<b>Date de la commande</b>
					</th>
					<th valign="middle" style="border: 1px solid black">
						<b>Numéro de tva</b>
					</th>
				</tr>
				<tr>
					<td style="border: 1px solid black">
						${commande.getId()}
					</td>
					<td style="border: 1px solid black">
						${orderDate}
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
			<th><b>Type contrat</b></th>
			<th><b>Montant HT</b></th>
			<th><b>Montant TTC</b></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${contrats}" var="contrat" varStatus="status">
		<tr>
			<td>
				<c:out value="${contrat.getTypesContrat().getIntitule()}"/>
			</td>
			<td>
				<c:out value="${contrat.getMontantHT()}"/>
			</td>
			<td>
				<c:out value="${contrat.getMontantTTC()}"/>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<br/>
<br/>


<table>
	<tr>
		<td colspan="7"></td>
		<td colspan="5" rowspan="5">
			
			<table width="100%" cellpadding="4" cellspacing="0">
				<tr>
					<td>
						<b>Total HT</b>
					</td>
					<td>
						${montantHT}
					</td>
				</tr>
				<tr>
					<td>
						<b>Taxes</b>
					</td>
					<td>
						${totalTaxes}
					</td>
				</tr>
				<tr>
					<td>
						<b>Total TVAC</b>
					</td>
					<td>
						${montantTTC}
					</td>
				</tr>
			</table>
		
		</td>
	</tr>
</table>