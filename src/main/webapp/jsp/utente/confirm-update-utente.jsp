<%@page import="bibliotecaweb.model.Libro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it">
<head>
<jsp:include page="../header.jsp" />
<title>Modifica Utente</title>

<!-- style per le pagine diverse dalla index -->
<link href="./assets/css/global.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../navbar.jsp" />

	<main role="main" class="container">

		<form method="post" action="ExecuteUpdateUtenteServlet"
			novalidate="novalidate">

			<div class='card'>
				<div class='card-header'>
					Sei sicuro di voler modificare in questo modo l'utente?
				</div>
				
				<!--  utente originale -->
				<c:set var="itemOld" scope="request" value="${utenteOld}" />
				<!--  gli attuali valori dell'utente originale -->
				<c:set var="idOld" value="${itemOld.id}" />
				<c:set var="nomeOld" value="${itemOld.nome}" />
				<c:set var="cognomeOld" value="${itemOld.cognome}" />
				<c:set var="statoOld" value="${itemOld.stato}" />
				<c:set var="ruoliOld" value="${itemOld.ruoli}" />

				<!--  utente da aggiornare -->
				<c:set var="itemNew" scope="request" value="${utenteNew}" />
				<!--  valori input utente per l'utente da aggiornare -->
				<c:set var="nomeNew" value="${itemNew.nome}" />
				<c:set var="cognomeNew" value="${itemNew.cognome}" />
				<c:set var="usernameNew" value="${itemNew.username}" />
				<c:set var="statoNew" value="${itemNew.stato}" />
				<c:set var="ruoliNew" value="${itemNew.ruoli}" />
				
				<input type="hidden" name="idUt" id="idLib" value="${idOld}">
				<input type="hidden" name="nome" id="titolo" value="${nomeNew}">
				<input type="hidden" name="cognome" id="trama" value="${cognomeNew}">
				<input type="hidden" name="username" id="genere" value="${usernameNew}">
				<input type="hidden" name="stato" id="genere" value="${statoNew}">
				<c:forEach var="ruoloNew" items="${ruoliNew}">
					<input type="hidden" name="ruoliId[]" value="${ruoloNew.id}">
				</c:forEach>

					<div class='card-body'>

						<dl class="row">
							<div class="col md-6">
								<dt class="col-sm-10">Vecchio Nome:</dt>
								<dd class="col-sm-9 text-center">${nomeOld}</dd>
							</div>

							<div class="col md-6">
								<dt class="col-sm-10">Nuovo Nome:</dt>
								<dd class="col-sm-9 text-center">${nomeNew}</dd>
							</div>
						</dl>

						<dl class="row">
							<div class="col">
								<dt class="col-sm-10">Vecchio Cognome:</dt>
								<dd class="col-sm-9 text-center">${cognomeOld}</dd>
							</div>

							<div class="col">
								<dt class="col-sm-10">Nuovo Cognome:</dt>
								<dd class="col-sm-9 text-center">${cognomeNew}</dd>
							</div>
						</dl>
						
						<dl class="row">
							<div class="col">
								<dt class="col-sm-10">Vecchio Username:</dt>
								<dd class="col-sm-9 text-center">${usernameOld}</dd>
							</div>

							<div class="col">
								<dt class="col-sm-10">Nuovo Username:</dt>
								<dd class="col-sm-9 text-center">${usernameNew}</dd>
							</div>
						</dl>

						<dl class="row">
							<div class="col">
								<dt class="col-sm-10">Vecchio Stato:</dt>
								<dd class="col-sm-9 text-center">${statoOld}</dd>
							</div>

							<div class="col">
								<dt class="col-sm-10">Nuovo Stato:</dt>
								<dd class="col-sm-9 text-center">${statoNew}</dd>
							</div>
						</dl>
						
						<dl class="row">
							<div class="col">
								<dt class="col-sm-10">Vecchi Ruoli:</dt>
								<c:forEach var="ruoloOld" items="${ruoliOld}">
									<dd class="col-sm-9 text-center">${ruoloOld.codice.name()}</dd>
								</c:forEach>
								
							</div>

							<div class="col">
								<dt class="col-sm-10">Nuovi Ruoli:</dt>
								<c:forEach var="ruoloNew" items="${ruoliNew}">
									<dd class="col-sm-9 text-center">${ruoloNew.codice.name()}</dd>
								</c:forEach>
								
							</div>
						</dl>
						
					</div>

					<div class='card-footer'>
						<a href="PrepareUpdateUtenteServlet?idUt=${idOld}"
							class='btn btn-outline-secondary' style='width: 100px'> <i
							class='fa fa-chevron-left'></i> Indietro
						</a>

						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">
							Conferma
						</button>

						<a href="PrepareDeleteUtenteServlet?idUt=${idOld}"
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