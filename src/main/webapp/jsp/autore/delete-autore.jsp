<%@page import="bibliotecaweb.model.Autore"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Elimina Autore</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Sei sicuro di voler eliminare il seguente autore?
		    </div>
		    
		    <!-- 
		    <c:set var="listaAutori" scope="request" value="${requestScope.listaAutori}" />
		     -->
		     
		    
		    <c:set var="item" scope="request" value="${autore}"/>
		    
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Nome:</dt>
				  <dd class="col-sm-9">${item.nome}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Cognome:</dt>
				  <dd class="col-sm-9">${item.cognome}</dd>
		    	</dl>
		    	
		    </div>
		    
		    <div class='card-footer'>
		        <a href="ListAutoriServlet" class='btn btn-outline-secondary' style='width:100px'>
		            <i class='fa fa-chevron-left'></i> Indietro
		        </a>
		        
		        <a href="PrepareUpdateAutoreServlet?idAut=${item.id}" class='btn btn-outline-primary ml-2 mr-2' style='width:100px'>
		            <i class='fa fa-chevron-left'></i> Modifica
		        </a>
		        
		        <a href="ExecuteDeleteAutoreServlet?idAut=${item.id}" class='btn btn-outline-secondary btn-outline-danger' style='width:100px'>
		            <i class='fa fa-chevron-left'></i> Conferma
		        </a>
		    </div>
		</div>	
	
	
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>