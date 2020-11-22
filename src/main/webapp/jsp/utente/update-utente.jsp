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

		<jsp:include page="../error-message.jsp" />

		<div class='card'>
			<div class='card-header'>
				<h5>Modifica Utente</h5>
			</div>
			<div class='card-body'>

				<h6 class="card-title">
					I campi con <span class="text-danger">*</span> sono obbligatori
				</h6>

				<form method="post" action="ConfirmUpdateUtenteServlet"
					novalidate="novalidate">

					<c:set var="old" scope="request" value="${utenteOld}" />

					<input type="hidden" name="idUt" id="idUt" class="form-control"
						value="${old.id}">

					<div class="form-row">
						<div class="form-group col-md-3">
							<label>Nome <span class="text-danger">*</span></label> <input
								type="text" name="nome" id="nome" class="form-control"
								placeholder="Inserire il nome" value="${old.nome}" required>
						</div>

						<div class="form-group col-md-3">
							<label>Cognome <span class="text-danger">*</span></label> <input
								type="text" name="cognome" id="cognome" class="form-control"
								placeholder="Inserire il cognome" value="${old.cognome}" required>
						</div>
						
						<div class="form-group col-md-3">
							<label>Username <span class="text-danger">*</span></label> <input
								type="text" name="username" id="username" class="form-control"
								placeholder="Inserire lo username" value="${old.username}" required>
						</div>
					</div>

					<div class="form-row">

						<div class="form-group col-md-6">
							<label>Stato <span class="text-danger">*</span></label> <select
								class="browser-default custom-select" name="stato">

								<option value="${old.stato}">${old.stato.name()}</option>

								<c:forEach var="stato" items="${sessionScope.listaStati}">
									<option value="${stato.name()}">${stato.name()}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="form-group col-md-6">
							<label>Ruolo Utente</label> 

								<c:forEach var="ruolo" items="${sessionScope.listaRuoli}">
									<br/>
									<input type="checkbox" id="ruoliId" name="ruoliId" value="${ruolo.id}">
									<label for="ruoliId"> ${ruolo.codice.name()}</label>
								</c:forEach>
						</div>

					</div>

					<button type="submit" name="submit" value="submit" id="submit"
						class="btn btn-primary">Conferma</button>

				</form>
				<!-- end card-body -->
			</div>

			<div class='card-footer'>
				<a href="ListUtentiServlet" class='btn btn-outline-secondary'
					style='width: 100px'> <i class='fa fa-chevron-left'></i>
					Indietro
				</a> <a href="PrepareDeleteUtenteServlet?idUt=${old.id}"
					class='btn btn-outline-secondary btn-outline-danger'
					style='width: 100px'> <i class='fa fa-chevron-left'></i>
					Rimuovi
				</a>
			</div>

		</div>


		<!-- end container -->
	</main>
	<jsp:include page="../footer.jsp" />

</body>
</html>