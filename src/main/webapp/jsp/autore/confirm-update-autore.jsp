<%@page import="bibliotecaweb.model.Autore"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it">
<head>
<jsp:include page="../header.jsp" />
<title>Modifica Autore</title>

<!-- style per le pagine diverse dalla index -->
<link href="./assets/css/global.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../navbar.jsp" />

	<main role="main" class="container">

		<form method="post" action="ExecuteUpdateAutoreServlet"
			novalidate="novalidate">

			<div class='card'>
				<div class='card-header'>
					Sei sicuro di voler modificare in questo modo l'autore?
				</div>
				
				<!--  autore originale -->
				<c:set var="itemOld" scope="request" value="${autoreOld}" />
				<!--  attuali valori dell'autore originale -->
				<c:set var="idVar" value="${itemOld.id}" />
				<c:set var="nomeOld" value="${itemOld.nome}" />
				<c:set var="cognomeOld" value="${itemOld.cognome}" />

				<!--  autore da aggiornare -->
				<c:set var="itemNew" scope="request" value="${autoreNew}" />
				<!--  valori input utente per l'libro da aggiornare -->
				<c:set var="nomeNew" value="${itemNew.nome}" />
				<c:set var="cognomeNew" value="${itemNew.cognome}" />
				
				<input type="hidden" name="idAut" id="idAut" value="${idVar}">
				<input type="hidden" name="nomeNew" id="nomeNew" value="${nomeNew}">
				<input type="hidden" name="cognomeNew" id="cognomeNew" value="${cognomeNew}">

					<div class='card-body'>

						<dl class="row">
							<div class="col md-6">
								<dt class="col-sm-3 text-center">Vecchio Nome:</dt>
								<dd class="col-sm-9">${nomeOld}</dd>
							</div>

							<div class="col md-6">
								<dt class="col-sm-3 text-center">Nuovo Nome:</dt>
								<dd class="col-sm-9">${nomeNew}</dd>
							</div>
						</dl>
						
						<dl class="row">
							<div class="col md-6">
								<dt class="col-sm-3 text-center">Vecchio Cogome:</dt>
								<dd class="col-sm-9">${cognomeOld}</dd>
							</div>

							<div class="col md-6">
								<dt class="col-sm-3 text-center">Nuovo Cogome:</dt>
								<dd class="col-sm-9">${cognomeNew}</dd>
							</div>
						</dl>
						
					</div>

					<div class='card-footer'>
						<a href="PrepareUpdateAutoreServlet?idAut=${idVar}"
							class='btn btn-outline-secondary' style='width: 100px'> <i
							class='fa fa-chevron-left'></i> Indietro
						</a>

						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">
							Conferma
						</button>

						<a href="PrepareDeleteAutoreServlet?idAut=${idVar}"
							class='btn btn-outline-secondary btn-outline-danger'
							style='width: 100px'> <i class='fa fa-chevron-left'></i>
							Rimuovi
						</a>
					</div>
					
				</div>
		</form>
		<!-- end main container -->
	</main>
	<jsp:include page="../footer.jsp" />

</body>
</html>