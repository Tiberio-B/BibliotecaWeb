<%@page import="bibliotecaweb.model.Libro"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ConfirmUpdateLibroServlet" novalidate="novalidate">
					
					<c:set var="old" scope="request" value="${libroOld}"/>
					
					<input type="hidden" name="idOld" id="idOld" class="form-control" value="${old.id}">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Codice <span class="text-danger">*</span></label>
								<input type="text" name="codice" id="codice" class="form-control" placeholder="Inserire il codice"
								value="${old.codice}" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>Descrizione <span class="text-danger">*</span></label>
								<input type="text" name="descrizione" id="descrizione" class="form-control" placeholder="Inserire la descrizione"
								value="${old.descrizione}" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-3">
								<label>Prezzo <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="prezzo" id="prezzo" placeholder="Inserire prezzo"
								value="${old.prezzo}"required>
							</div>
							
							<div class="form-group col-md-6">
							
								<label>Autore <span class="text-danger">*</span></label>
								<select class="browser-default custom-select" name="idAut">
								
									<option value="${old.autore.id}">${old.autore.nome}</option>
										
									<c:forEach var="newAutore" items="${requestScope.listaAutori}">
											<option value="${newAutore.id}">${newAutore.nome}</option>
									</c:forEach>
								</select>
							
						</div>
							
						</div>
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">
								Conferma
						</button>

					</form>
			<!-- end card-body -->			   
		    </div>
		    
		    <div class='card-footer'>
		        <a href="ListLibriServlet" class='btn btn-outline-secondary' style='width:100px'>
		            <i class='fa fa-chevron-left'></i> Indietro
		        </a>
		        
		        <a href="PrepareDeleteLibroServlet?idParam=${old.id}" class='btn btn-outline-secondary btn-outline-danger' style='width:100px'>
		            <i class='fa fa-chevron-left'></i> Rimuovi
		        </a>
		    </div>
		    
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>