<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
<div class="col-10">
	<a href="CreationCandidat" class="btn btn-success btn-sm mt-2 " role="button">Créer un candidat</a>
	<a href="CreationInscription" class="btn btn-success btn-sm mt-2" role="button">Créer une inscription</a>
	<a href="ListeCandidats" class="btn btn-secondary btn-sm mt-2 ms-4" role="button">Liste des candidats</a>
	<a href="ListeInscriptions" class="btn btn-secondary btn-sm mt-2" role="button">Liste des inscriptions</a>
	<c:if test="${empty sessionScope.mapCandidats and empty sesssionScope.mapInscriptions }">
		<a href="DB" class="btn btn-warning btn-sm mt-2 ms-4" role="button">Importer 3 candidats et 3 inscriptions</a>
	</c:if>
</div>
<div class="col-auto">
	<a href="Deconnexion" class="btn btn-danger btn-sm mt-2 ms-5" role="button">Se Déconnecter</a>
</div>
</div>