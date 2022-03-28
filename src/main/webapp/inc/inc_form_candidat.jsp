<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


			<div class="mb-1 col-md-6">
				<label for="cin" class="form-label">CIN</label>
				<input type="text" class="form-control" id="cin" name="cin" value="<c:if test="${radioNouveauAncien!='ancien'}">${candidat.cin}</c:if>" aria-describedby="cinErreur">
				<div id="cinErreur" class="text-danger form-text">${form.erreurs.cin}</div>
			</div>
			<div class="mb-1 col-md-6">
				<label for="nom" class="form-label">Nom</label>
				<input type="text" class="form-control" id="nom" name="nom" value="<c:if test="${radioNouveauAncien!='ancien'}">${candidat.nom}</c:if>" aria-describedby="nomErreur">
				<div id="nomErreur" class="text-danger form-text">${form.erreurs.nom}</div>
			</div>
			<div class="mb-1 col-md-6">
				<label for="prenom" class="form-label">Prénom</label>
				<input type="text" class="form-control" id="prenom" name="prenom" value="<c:if test="${radioNouveauAncien!='ancien'}">${candidat.prenom}</c:if>" aria-describedby="prenomErreur">
				<div id="prenomErreur" class="text-danger form-text">${form.erreurs.prenom}</div>
			</div>
			<div class="mb-1 col-md-6">
				<label for="adresse" class="form-label">Adresse</label>
				<input type="text" class="form-control" id="adresse" name="adresse" value="<c:if test="${radioNouveauAncien!='ancien'}">${candidat.adresse}</c:if>" aria-describedby="adresseErreur">
				<div id="adresseErreur" class="text-danger form-text">${form.erreurs.adresse}</div>
			</div>
			<div class="mb-1 col-md-6">
				<label for="tel" class="form-label">Numéro de téléphone</label>
				<input type="text" class="form-control" id="tel" name="tel" value="<c:if test="${radioNouveauAncien!='ancien'}">${candidat.tel}</c:if>" aria-describedby="telErreur">
				<div id="telErreur" class="text-danger form-text">${form.erreurs.tel}</div>
			</div>
			<div class="mb-1 col-md-6">
				<label for="email" class="form-label">Adresse email</label>
				<input type="email" class="form-control" id="email" name="email" value="<c:if test="${radioNouveauAncien!='ancien'}">${candidat.email}</c:if>" aria-describedby="emailErreur">
				<div id="emailErreur" class="text-danger form-text">${form.erreurs.email}</div>
			</div>
			<div class="mb-1 col-md-6">
				<label for="niveau" class="form-label">Niveau</label>
				<select class="form-control" id="niveau" name="niveau" aria-describedby="niveauErreur">
					<option value="" <c:if test="${candidat.niveau==''}">selected</c:if>></option>
					<option value="Bac+1" <c:if test="${candidat.niveau=='Bac+1' and radioNouveauAncien!='ancien'}">selected</c:if>>Bac+1</option>
					<option value="Bac+2" <c:if test="${candidat.niveau=='Bac+2' and radioNouveauAncien!='ancien'}">selected</c:if>>Bac+2</option>
					<option value="Bac+3" <c:if test="${candidat.niveau=='Bac+3' and radioNouveauAncien!='ancien'}">selected</c:if>>Bac+3</option>
					<option value="Bac+4" <c:if test="${candidat.niveau=='Bac+4' and radioNouveauAncien!='ancien'}">selected</c:if>>Bac+4</option>
					<option value="Bac+5" <c:if test="${candidat.niveau=='Bac+5' and radioNouveauAncien!='ancien'}">selected</c:if>>Bac+5</option>
				</select>
				<div id="niveauErreur" class="text-danger form-text">${form.erreurs.niveau}</div>
			</div>