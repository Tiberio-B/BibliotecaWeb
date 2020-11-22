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

		<jsp:include page="../error-message.jsp" />

		<div class='card'>
			<div class='card-header'>
				<h5>Modifica Libro</h5>
			</div>
			<div class='card-body'>

				<h6 class="card-title">
					I campi con <span class="text-danger">*</span> sono obbligatori
				</h6>

				<form method="post" action="ConfirmUpdateLibroServlet"
					novalidate="novalidate">

					<c:set var="old" scope="request" value="${libroOld}" />

					<input type="hidden" name="idOld" id="idOld" class="form-control"
						value="${old.id}">

					<div class="form-row">
						<div class="form-group col-md-6">
							<label>Titolo <span class="text-danger">*</span></label> <input
								type="text" name="titolo" id="titolo" class="form-control"
								placeholder="Inserire il titolo" value="${old.titolo}" required>
						</div>

						<div class="form-group col-md-6">
							<label>Trama <span class="text-danger">*</span></label> <input
								type="text" name="trama" id="trama" class="form-control"
								placeholder="Inserire la trama" value="${old.trama}" required>
						</div>
					</div>

					<div class="form-row">

						<div class="form-group col-md-6">
							<label>Genere <span class="text-danger">*</span></label> <select
								class="browser-default custom-select" name="genere">

								<option value="${old.genere}">${old.genere.name()}</option>

								<c:forEach var="genere" items="${requestScope.generi}">
									<c:if test="${genere != old.genere }">
									<option value="${genere}">${genere}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>

						<!--  
							<div class="form-group col-md-3">
								<label>Genere <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="genere" id="genere" placeholder="Inserire il genere"
								value="${old.genere}"required>
							</div>
							-->

						<div class="form-group col-md-6">

							<label>Autore <span class="text-danger">*</span></label> <select
								class="browser-default custom-select" name="idAut">

								<option value="${old.autore.id}">${old.autore.cognome}
									${old.autore.nome}</option>

								<c:forEach var="autore" items="${sessionScope.listaAutori}">
									<c:if test="${autore != old.autore }">
									<option value="${autore.id}">${autore.cognome} ${autore.nome}</option>
									</c:if>
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
				</a> <a href="PrepareDeleteLibroServlet?idLib=${old.id}"
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