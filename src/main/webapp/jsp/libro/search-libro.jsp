<!doctype html>
<html lang="it">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp" />
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
							<label>Titolo</label> <input
								type="text" name="titolo" id="titolo" class="form-control"
								placeholder="Inserire il titolo" required>
						</div>

						<div class="form-group col-md-6">
							<label>Trama</label> <input
								type="text" name="trama" id="trama"
								class="form-control" placeholder="Inserire la trama"
								required>
						</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-6">
							
								<label>Genere</label>
								<select class="browser-default custom-select" name="genere">
								
									<option value="-1">Seleziona un genere...</option>
										
										<c:forEach var="genere" items="${requestScope.generi}">
											<option value="${genere.name()}">${genere.name()}</option>
										</c:forEach>
								</select>
							
						</div>

						<div class="form-group col-md-6">
							
								<label>Autore</label>
								<select class="browser-default custom-select" name="autore">
								
									<option value="-1">Seleziona un autore...</option>
										
										<c:forEach var="autore" items="${requestScope.autori}">
											<option value="${autore.id}">${autore.cognome} ${autore.nome}</option>
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