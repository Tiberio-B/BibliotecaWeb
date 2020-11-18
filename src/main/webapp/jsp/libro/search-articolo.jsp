<!doctype html>
<html lang="it">
<head>
<jsp:include page="../header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Cerca un Libro</title>

<!-- style per le pagine diverse dalla index -->
<link href="./assets/css/global.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../navbar.jsp" />

	<main role="main" class="container">

		<jsp:include page="../error-message.jsp" />

		<div class='card'>
			<div class='card-header'>
				<h5>Cerca un Libro</h5>
			</div>
			<div class='card-body'>

				<form method="post" action="ExecuteSearchLibroServlet"
					novalidate="novalidate">

					<div class="form-row">
						<div class="form-group col-md-6">
							<label>Codice</label> <input
								type="text" name="codice" id="codice" class="form-control"
								placeholder="Inserire il codice" required>
						</div>

						<div class="form-group col-md-6">
							<label>Descrizione</label> <input
								type="text" name="descrizione" id="descrizione"
								class="form-control" placeholder="Inserire la descrizione"
								required>
						</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-3">
							<label>Prezzo</label> <input
								type="number" class="form-control" name="prezzo" id="prezzo"
								placeholder="Inserire prezzo" required>
						</div>

						<div class="form-group col-md-6">
							
								<label>Autore</label>
								<select class="browser-default custom-select" name="idAut">
								
									<option value="-1">Seleziona una autore...</option>
										
										<c:forEach var="autore" items="${requestScope.listaAutori}">
											<option value="${autore.id}">${autore.nome}</option>
										</c:forEach>
								</select>
							
						</div>
					</div>

					<button type="submit" name="submit" value="submit" id="submit"
						class="btn btn-primary">Conferma</button>
				</form>
				<!-- end card-body -->
			</div>
		</div>


		<!-- end container -->
	</main>
	<jsp:include page="../footer.jsp" />

</body>
</html>