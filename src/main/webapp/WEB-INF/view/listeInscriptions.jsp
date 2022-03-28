<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Liste des inscriptions</title>

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
					<th scope="col">ID de l'inscription</th>
					<th scope="col">Candidat</th>
					<th scope="col">Formation</th>
					<th scope="col">Date de début</th>
					<th scope="col">Type</th>
					<th scope="col">Type de paiement</th>
					<th scope="col">Montant</th>
					<th scope="col" class="text-danger">Supprimer</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="element" items="${sessionScope.mapInscriptions}">
					<tr>
						<th scope="row">${element.value.id}</th>
						<td>${element.value.idCandidat}</td>
						<td>${element.value.formation}</td>
						<td>${element.value.dateDebut}</td>
						<td>${element.value.type}</td>
						<td>${element.value.typePaiement}</td>
						<td>${element.value.montant}</td>
						<td><a href="?delete=${element.value.id}"><i class="bi bi-trash-fill text-danger ms-3"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>