<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Liste des candidats</title>

	<!--  Include CSS and Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<!-- Bootstrap icons  -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>

<body>
	
	<div class="container mt-3">
	<c:import url="/inc/inc_link.jsp"/>
		<table class="table mt-3">
			<thead class="table-secondary">
				<tr>
					<th scope="col">CIN</th>
					<th scope="col">Nom</th>
					<th scope="col">Prénom</th>
					<th scope="col">Adresse</th>
					<th scope="col">Numéro de téléphone</th>
					<th scope="col">Adresse email</th>
					<th scope="col">Niveau</th>
					<th scope="col">Inscriptions</th>
					<th scope="col" class="text-danger">Supprimer</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="element" items="${sessionScope.mapCandidats}">
					<tr>
						<th scope="row">${element.value.cin}</th>
						<td>${element.value.nom}</td>
						<td>${element.value.prenom}</td>
						<td>${element.value.adresse}</td>
						<td>${element.value.tel}</td>
						<td>${element.value.email}</td>
						<td>${element.value.niveau}</td>
						<td>${element.value.nbInscriptions}</td>
						<td>
							<c:if test="${element.value.nbInscriptions == 0}">
								<a href="?delete=${element.value.cin}"><i class="bi bi-trash-fill text-danger ms-3"></i></a>
							</c:if>
							<c:if test="${element.value.nbInscriptions != 0}">
								<!-- Button trigger modal -->
								  <i class="bi bi-exclamation-triangle-fill text-warning ms-3" data-bs-toggle="modal" data-bs-target="#alertModal"  style="cursor:pointer;"></i>
								
								<!-- Modal -->
								<div class="modal fade" id="alertModal" tabindex="-1" aria-labelledby="alertModalLabel" aria-hidden="true">
								  <div class="modal-dialog">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h5 class="modal-title" id="alertModalLabel">Avertissement</h5>
								        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
								      </div>
								      <div class="modal-body">
								      	Attention vous ne pouvez pas supprimer ce candidat parce qu'il a des inscriptions
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
								      </div>
								    </div>
								  </div>
								</div>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<!-- Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>