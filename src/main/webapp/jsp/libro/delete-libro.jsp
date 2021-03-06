<%@page import="bibliotecaweb.model.Libro"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Elimina Libro</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Sei sicuro di voler eliminare il seguente libro?
		    </div>
		    
		    <c:set var="item" scope="request" value="${libro}"/>
		    
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Titolo:</dt>
				  <dd class="col-sm-9">${item.titolo}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Trama:</dt>
				  <dd class="col-sm-9">${item.trama}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Genere:</dt>
				  <dd class="col-sm-9">${item.genere.name()}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Autore:</dt>
				  <dd class="col-sm-9">${item.autore.cognome} ${item.autore.nome}</dd>
		    	</dl>
		    	
		    </div>
		    
		    <div class='card-footer'>
		        <a href="ListLibriServlet" class='btn btn-outline-secondary' style='width:100px'>
		            <i class='fa fa-chevron-left'></i> Indietro
		        </a>
		        
		        <a href="PrepareUpdateLibroServlet?idLib=${item.id}" class='btn btn-outline-primary ml-2 mr-2' style='width:100px'>
		            <i class='fa fa-chevron-left'></i> Modifica
		        </a>
		        
		        <a href="ExecuteDeleteLibroServlet?idLib=${item.id}" class='btn btn-outline-secondary btn-outline-danger' style='width:100px'>
		            <i class='fa fa-chevron-left'></i> Conferma
		        </a>
		    </div>
		</div>	
	
	
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>