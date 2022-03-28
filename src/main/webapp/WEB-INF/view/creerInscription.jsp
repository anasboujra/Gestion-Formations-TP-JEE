<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Créer une inscription</title>

	<!--  Include CSS and Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
	
	<div class="container mt-3">
	<c:import url="/inc/inc_link.jsp"/>
		<form method="post" action="CreationInscription" class="row g-3 mt-2">
		<legend class="text-primary">Informations candidat</legend>
			<c:if test="${!empty sessionScope.mapCandidats}">
				<div class="mb-3 col-md-6">
					<input type="radio" class="form-check-input" id="optionNouveau" name="radioNouveauAncien" onchange="nouveau();" value="nouveau" <c:if test="${radioNouveauAncien!='ancien'}">checked</c:if>>
					<label for="optionNouveau" class="form-check-label">Nouveau candidat</label>
					<input type="radio" class="form-check-input" id="optionAncien" name="radioNouveauAncien" onchange="ancien();" value="ancien" <c:if test="${radioNouveauAncien=='ancien'}">checked</c:if>>
					<label for="optionAncien" class="form-check-label">Ancien candidat</label>
				</div>
			</c:if>
			
 			<div id="nouveau" class="row <c:if test="${radioNouveauAncien=='ancien'}">d-none</c:if>">
				<c:import url="/inc/inc_form_candidat.jsp"/>
	 		</div>
	
			<c:if test="${!empty sessionScope.mapCandidats}">
				<div id="ancien" class="<c:if test="${radioNouveauAncien!='ancien'}">d-none</c:if>">
					<select class="form-control" name="candidatSelectionne">
						<c:forEach var="element" items="${sessionScope.mapCandidats}">
							<option value="${element.value.cin}">${element.value.cin}</option>
						</c:forEach>
					</select>
				</div>
			</c:if>
			
 			<legend class="text-primary">Informations inscription</legend>
			<div class="mb-1 col-md-6">
				<label for="formation" class="form-label">Formation</label>
				<select class="form-control" id="formation" name="formation" aria-describedby="formationErreur" onchange="genererMontant();">
					<option value="" <c:if test="${inscription.formation==''}">selected</c:if>></option>
					<option value="JEE" <c:if test="${inscription.formation=='JEE'}">selected</c:if>>JEE</option>
					<option value="Spring" <c:if test="${inscription.formation=='Spring'}">selected</c:if>>Spring</option>
					<option value="Hibernate" <c:if test="${inscription.formation=='Hibernate'}">selected</c:if>>Hibernate</option>
					<option value="React" <c:if test="${inscription.formation=='React'}">selected</c:if>>React</option>
				</select>
				<div id="formationErreur" class="text-danger form-text">${form.erreurs.formation}</div>
			</div>
			<div class="mb-1 col-md-6">
				<label for="dateDebut" class="form-label">Date début</label>
				<select class="form-control" id="dateDebut" name="dateDebut" aria-describedby="dateDebutErreur" onchange="genererMontant();">
					<option value="" <c:if test="${inscription.dateDebut==''}">selected</c:if>></option>
					<option value="01-12-2021" <c:if test="${inscription.dateDebut=='01-12-2021'}">selected</c:if>>01-12-2021</option>
					<option value="01-01-2022" <c:if test="${inscription.dateDebut=='01-01-2022'}">selected</c:if>>01-01-2022</option>
					<option value="01-02-2022" <c:if test="${inscription.dateDebut=='01-02-2022'}">selected</c:if>>01-02-2022</option>
					<option value="01-03-2022" <c:if test="${inscription.dateDebut=='01-03-2022'}">selected</c:if>>01-03-2022</option>
				</select>
				<div id="dateDebutErreur" class="text-danger form-text">${form.erreurs.dateDebut}</div>
			</div>
			<div class="mb-1 col-md-6">
				<label for="type" class="form-label">Type</label>
				<select class="form-control" id="type" name="type" aria-describedby="typeErreur" onchange="genererMontant();">
					<option value="" <c:if test="${inscription.type==''}">selected</c:if>></option>
					<option value="Facile" <c:if test="${inscription.type=='Facile'}">selected</c:if>>Facile</option>
					<option value="Normale" <c:if test="${inscription.type=='Normale'}">selected</c:if>>Normale</option>
					<option value="Difficile" <c:if test="${inscription.type=='Difficile'}">selected</c:if>>Difficile</option>
				</select>
				<div id="typeErreur" class="text-danger form-text">${form.erreurs.type}</div>
			</div>
			<div class="mb-1 col-md-6">
				<label for="typePaiement" class="form-label">Type de paiement</label>
				<select class="form-control" id="typePaiement" name="typePaiement" aria-describedby="typePaiementErreur" onchange="genererMontant();">
					<option value="" <c:if test="${inscription.typePaiement==''}">selected</c:if>></option>
					<option value="PayPal" <c:if test="${inscription.typePaiement=='PayPal'}">selected</c:if>>PayPal</option>
					<option value="MasterCard" <c:if test="${inscription.typePaiement=='MasterCard'}">selected</c:if>>MasterCard</option>
					<option value="VisaCard" <c:if test="${inscription.typePaiement=='VisaCard'}">selected</c:if>>VisaCard</option>
				</select>
				<div id="typePaiementErreur" class="text-danger form-text">${form.erreurs.typePaiement}</div>
			</div>
			<div class="mb-1 col-md-6">
				<label for="montant" class="form-label">Montant</label>
				<input type="text" name="montant" id="montant" value="${inscription.montant}" class="form-control" aria-describedby="montantErreur" readonly>
				<div id="montantErreur" class="text-danger form-text">${form.erreurs.montant}</div>
			</div>
			<div class="col-12 mb-3">
				<button type="submit" class="btn btn-primary">Valider</button>
				<a href="CreationInscription" class="btn btn-warning ms-4" role="button">Remettre à zéro</a>
			</div>
		</form>
		<c:if test="${!empty form.resultat}">
			<div class="alert alert-danger mt-3" role="alert">${form.resultat}</div>
		</c:if>
	</div>

	<!-- Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script>
		function nouveau(){
			document.getElementById("nouveau").classList.remove("d-none");
			document.getElementById("ancien").classList.add("d-none");
		}

		function ancien(){
			document.getElementById("nouveau").classList.add("d-none");
			document.getElementById("ancien").classList.remove("d-none");
		}
		function montant(formation, type){
			if(formation=="JEE" && type=="Facile"){
				return 2000;
			} else if(formation=="JEE" && type=="Normale"){
				return 3000;
			} else if(formation=="JEE" && type=="Difficile"){
				return 4000;
			} else if(formation=="Spring" && type=="Facile"){
				return 2500;
			} else if(formation=="Spring" && type=="Normale"){
				return 3500;
			} else if(formation=="Spring" && type=="Difficile"){
				return 4500;
			} else if(formation=="Hibernate" && type=="Facile"){
				return 1800;
			} else if(formation=="Hibernate" && type=="Normale"){
				return 2800;
			} else if(formation=="Hibernate" && type=="Difficile"){
				return 3800;
			} else if(formation=="React" && type=="Facile"){
				return 2400;
			} else if(formation=="React" && type=="Normale"){
				return 3400;
			} else if(formation=="React" && type=="Difficile"){
				return 4400;
			}
		}
		function genererMontant(){
			var formation = document.getElementById("formation").value;
			var dateDebut = document.getElementById("dateDebut").value;
			var type = document.getElementById("type").value;
			var typePaiement = document.getElementById("typePaiement").value;
			if(formation!="" && dateDebut!="" && type!="" && typePaiement!=""){
				document.getElementById("montant").value = montant(formation, type);
			}else{
				document.getElementById("montant").value ="";
			}
		}
	</script>
</body>
</html>