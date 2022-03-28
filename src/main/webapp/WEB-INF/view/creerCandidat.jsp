<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Créer un candidat</title>

	<!--  Include CSS and Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
	
	<div class="container mt-3">
	<c:import url="/inc/inc_link.jsp"/>
		<form method="post" action="CreationCandidat" class="row g-3 mt-2">
			<legend class="text-primary">Informations candidat</legend>
			<div id="nouveau" class="row">
				<c:import url="/inc/inc_form_candidat.jsp"/>
	 		</div>
			<div class="col-12 mb-3">
				<button type="submit" class="btn btn-primary">Valider</button>
				<a href="CreationCandidat" class="btn btn-warning ms-4" role="button">Remettre à zéro</a>
			</div>
		</form>
		<c:if test="${!empty form.resultat}">
			<div class="alert alert-danger mt-3" role="alert">${form.resultat}</div>
		</c:if>
	</div>

	<!-- Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>