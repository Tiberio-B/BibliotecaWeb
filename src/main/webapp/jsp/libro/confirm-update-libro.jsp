<%@page import="bibliotecaweb.model.Libro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it">
<head>
<jsp:include page="../header.jsp" />
<title>Modifica Libro</title>

<!-- style per le pagine diverse dalla index -->
<link href="./assets/css/global.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../navbar.jsp" />

	<main role="main" class="container">

		<form method="post" action="ExecuteUpdateLibroServlet"
			novalidate="novalidate">

			<div class='card'>
				<div class='card-header'>
					Sei sicuro di voler modificare in questo modo il libro?
				</div>
				
				<!--  libro originale -->
				<c:set var="itemOld" scope="request" value="${libroOld}" />
				<!--  gli attuali valori del libro originale -->
				<c:set var="idOld" value="${itemOld.id}" />
				<c:set var="titoloOld" value="${itemOld.titolo}" />
				<c:set var="tramaOld" value="${itemOld.trama}" />
				<c:set var="genereOld" value="${itemOld.genere}" />
				<c:set var="autoreOld" value="${itemOld.autore}" />

				<!--  libro da aggiornare -->
				<c:set var="itemNew" scope="request" value="${libroNew}" />
				<!--  valori input utente per il libro da aggiornare -->
				<c:set var="titoloNew" value="${itemNew.titolo}" />
				<c:set var="tramaNew" value="${itemNew.trama}" />
				<c:set var="genereNew" value="${itemNew.genere}" />
				<c:set var="autoreNew" value="${itemNew.autore}" />
				
				<input type="hidden" name="idLib" id="idLib" value="${idOld}">
				<input type="hidden" name="titolo" id="titolo" value="${titoloNew}">
				<input type="hidden" name="trama" id="trama" value="${tramaNew}">
				<input type="hidden" name="genere" id="genere" value="${genereNew}">
				<input type="hidden" name="idAut" id="idAut" value="${autoreNew.id}">

					<div class='card-body'>

						<dl class="row">
							<div class="col md-6">
								<dt class="col-sm-10">Vecchio Titolo:</dt>
								<dd class="col-sm-9 text-center">${titoloOld}</dd>
							</div>

							<div class="col md-6">
								<dt class="col-sm-10">Nuovo Titolo:</dt>
								<dd class="col-sm-9 text-center">${titoloNew}</dd>
							</div>
						</dl>

						<dl class="row">
							<div class="col">
								<dt class="col-sm-10">Vecchia Trama:</dt>
								<dd class="col-sm-9 text-center">${tramaOld}</dd>
							</div>

							<div class="col">
								<dt class="col-sm-10">Nuova Trama:</dt>
								<dd class="col-sm-9 text-center">${tramaNew}</dd>
							</div>
						</dl>

						<dl class="row">
							<div class="col">
								<dt class="col-sm-10">Vecchio Genere:</dt>
								<dd class="col-sm-9 text-center">${genereOld}</dd>
							</div>

							<div class="col">
								<dt class="col-sm-10">Nuovo Genere:</dt>
								<dd class="col-sm-9 text-center">${genereNew}</dd>
							</div>
						</dl>
						
						<dl class="row">
							<div class="col">
								<dt class="col-sm-10">Vecchio Autore:</dt>
								<dd class="col-sm-9 text-center">${autoreOld.cognome} ${autoreOld.nome}</dd>
							</div>

							<div class="col">
								<dt class="col-sm-10">Nuovo Autore:</dt>
								<dd class="col-sm-9 text-center">${autoreNew.cognome} ${autoreNew.nome}</dd>
							</div>
						</dl>
						
					</div>

					<div class='card-footer'>
						<a href="PrepareUpdateLibroServlet?idLib=${idOld}"
							class='btn btn-outline-secondary' style='width: 100px'> <i
							class='fa fa-chevron-left'></i> Indietro
						</a>

						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">
							Conferma
						</button>

						<a href="PrepareDeleteLibroServlet?idLib=${idOld}"
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