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

		<jsp:include page="../error-message.jsp" />

		<div class='card'>
			<div class='card-header'>
				<h5>Modifica Autore</h5>
			</div>
			<div class='card-body'>

				<h6 class="card-title">
					I campi con <span class="text-danger">*</span> sono obbligatori
				</h6>

				<form method="post" action="ConfirmUpdateAutoreServlet"
					novalidate="novalidate">

					<c:set var="old" scope="request" value="${autoreOld}" />

					<input type="hidden" name="idAut" id="idAut" class="form-control"
						value="${old.id}">

					<div class="form-row">
						<div class="form-group col-md-4">
							<label>Nome <span class="text-danger">*</span></label> <input
								type="text" name="nome" id="nome" class="form-control"
								placeholder="Inserire il nome" value="${old.nome}" required>
						</div>
					
						<div class="form-group col-md-4">
							<label>Cogome <span class="text-danger">*</span></label> <input
								type="text" name="cognome" id="cognome" class="form-control"
								placeholder="Inserire il cognome" value="${old.cognome}" required>
						</div>
						
						<div class="form-group col-md-4">
							<label>Data di Nascita <span class="text-danger">*</span></label> <input
								type="text" name="ddn" id="ddn" class="form-control"
								placeholder="Inserire la data di nascita" value="${old.ddn}" required>
						</div>
					</div>

					<button type="submit" name="submit" value="submit" id="submit"
						class="btn btn-primary">Conferma</button>

				</form>
				<!-- end card-body -->
			</div>

			<div class='card-footer'>
				<a href="BackToAutoriServlet" class='btn btn-outline-secondary'
					style='width: 100px'> <i class='fa fa-chevron-left'></i>
					Indietro
				</a> <a href="PrepareDeleteAutoreServlet?idAut=${old.id}"
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