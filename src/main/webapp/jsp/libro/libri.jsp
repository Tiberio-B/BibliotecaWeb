<%@page import="bibliotecaweb.model.Libro"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it">
<head>
<jsp:include page="../header.jsp" />
<title>Libri</title>

<!-- style per le pagine diverse dalla index -->
<link href="${pageContext.request.contextPath}/assets/css/global.css"
	rel="stylesheet">

</head>
<body>


<jsp:include page="../navbar.jsp" />

<main role="main" class="container">

	<jsp:include page="../error-message.jsp" />

	<jsp:include page="../success-message.jsp" />

<div class='card'>
	<div class='card-header'>
		<h5>Tutti i Libri${filtered==true? ' di ': ''} ${autore}
			${searched==true? ' che soddisfano i parametri della ricerca': ''}</h5>
	</div>
	<div class='card-body'>
		<a class="btn btn-primary ${sessionScope.cannotInsert?'disabled':''}"
			href="PrepareInsertLibroServlet"
			aria-disabled="${sessionScope.cannotInsert}">Inserisci nuovo
			Libro</a>

		<div class='table-responsive'>
			<table class='table table-striped '>
				<thead>
					<tr>
						<th>Id</th>
						<th>Autore</th>
						<th>Titolo</th>
						<th>Genere</th>
						<th>Trama</th>
						<th>Azioni</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${sessionScope.listaLibri}">
						<tr>
							<td><c:out value="${item.id}" /></td>
							<td><c:out value="${item.autore.cognome} ${item.autore.nome}" /></td>
							<td><c:out value="${item.titolo}" /></td>
							<td><c:out value="${item.genere}" /></td>
							<td><c:out value="${item.trama}" /></td>
							
							<td><a class="btn  btn-sm btn-outline-secondary"
								href="VisualizzaLibroServlet?idParam=${item.id}">Visualizza</a>
								<a
								class="btn  btn-sm btn-outline-primary ml-2 mr-2 ${sessionScope.cannotUpdate?'disabled':''}"
								href="PrepareUpdateLibroServlet?idParam=${item.id}"
								aria-disabled="${sessionScope.cannotUpdate}">Modifica</a> <a
								class="btn btn-outline-danger btn-sm ${sessionScope.cannotDelete?'disabled':''}"
								href="PrepareDeleteLibroServlet?idParam=${item.id}"
								aria-disabled="${sessionScope.cannotDelete}">Rimuovi</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- end card-body -->
	</div>
</div>

<!-- end container -->
</main>
<jsp:include page="../footer.jsp" />

</body>
</html>