<!doctype html>
<html lang="it">
  <head>
    
    <jsp:include page="./header.jsp" />
    
    <!-- Custom styles for this template -->
    <link href="./assets/css/global.css" rel="stylesheet">
    <style type="text/css">
    	body {
		  padding-top: 3.5rem;
		}	
    </style>
    
    <title>BibliotecaWeb</title>
  </head>
  <body>
  
	<jsp:include page="./navbar.jsp"></jsp:include>
  
  
	<main role="main">

	  <!-- Main jumbotron for a primary marketing message or call to action -->
	  <div class="jumbotron" >
	    <div class="container">
	      <h1 class="display-3">Benvenuto/a ${sessionScope.utente.nome}</h1>
	      <br/><br/>
	    <p><a class="btn btn-primary btn-lg" href="PrepareSearchLibroServlet" role="button">Cerca un Libro &raquo;</a></p>
	    <p><a class="btn btn-primary btn-lg" href="PrepareSearchAutoreServlet" role="button">Cerca un Autore &raquo;</a></p>
	    </div>    
	  </div>
	
	</main>
	
	<jsp:include page="./footer.jsp" />
  </body>
</html>