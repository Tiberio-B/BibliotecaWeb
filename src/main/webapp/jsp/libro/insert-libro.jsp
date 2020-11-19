<!doctype html>
<html lang="it">
<head>
<jsp:include page="../header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Inserisci nuovo Libro</title>

<!-- style per le pagine diverse dalla index -->
<link href="./assets/css/global.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../navbar.jsp" />

	<main role="main" class="container">
	
	<jsp:include page="../error-message.jsp" />

		<div class='card'>
			<div class='card-header'>
				<h5>Inserisci nuovo Libro</h5>
			</div>
			<div class='card-body'>

				<h6 class="card-title">
					I campi con <span class="text-danger">*</span> sono obbligatori
				</h6>

				<form name="myForm" method="post" action="ExecuteInsertLibroServlet"
					novalidate="novalidate">

					<div class="form-row">
						<div class="form-group col-md-6">
							<label>Titolo <span class="text-danger">*</span></label> <input
								type="text" name="titolo" id="titolo" class="form-control"
								placeholder="Inserire il titolo" required>
						</div>

						<div class="form-group col-md-6">
							<label>Trama <span class="text-danger">*</span></label> <input
								type="text" name="trama" id="trama"
								class="form-control" placeholder="Inserire la descrizione"
								required>
						</div>
					</div>

					<div class="form-row">

						<div class="form-group col-md-6">
							<label>Genere <span class="text-danger">*</span></label> <select
								class="browser-default custom-select" name="genere">

								<option value="-1">Seleziona un genere...</option>

								<c:forEach var="genere" items="${sessionScope.listaGeneri}">
									<option value="${genere.name()}">${genere.name()}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group col-md-6">

							<label>Autore <span class="text-danger">*</span></label> <select
								class="browser-default custom-select" name="idAut">

								<option value="-1">Seleziona un autore...</option>

								<c:forEach var="autore" items="${sessionScope.listaAutori}">
									<option value="${autore.id}">${autore.cognome}
										${autore.nome}</option>
								</c:forEach>
							</select>

						</div>

					</div>

					<button type="submit" name="submit" value="submit" id="submit"
						class="btn btn-primary">Conferma</button>
				</form>
				<!-- end card-body -->
			</div>

			<div class='card-footer'>
				<a href="ListLibriServlet" class='btn btn-outline-secondary'
					style='width: 100px'> <i class='fa fa-chevron-left'></i>
					Indietro
				</a>
			</div>
		</div>


		<!-- end container -->
	</main>
	<jsp:include page="../footer.jsp" />

</body>
</html>