<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Inserisci Autore</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
    
    <script>
    $(document).ready(function() {
        $("#submit").validate({
            rules : {
                nome : {
                  required : true
                },
                cognome : {
                    required : true,
                },
                ddn : {
                	required : true
                }
            },
            messages: {
                nome: "Nome non valido",
                cognome: "Cognome non valido",
                ddn: "Data di nascita non valida"
            },
            submitHandler: function(form) {
                form.submit();
            }
        });
    });
    </script>
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<jsp:include page="../error-message.jsp" />
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Inserisci nuovo Autore</h5> 
		    </div>
		    <div class='card-body'>

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form name="form" id="form" method="post" action="ExecuteInsertAutoreServlet" novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-4">
								<label>Nome <span class="text-danger">*</span></label>
								<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome" value="${param.nome}" required>
							</div>
							
							<div class="form-group col-md-4">
								<label>Cognome <span class="text-danger">*</span></label>
								<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Inserire il cognome" value="${param.cognome}" required>
							</div>
							
							<div class="form-group col-md-4">
								<label>Data di Nascita (gg-mm-aaaa)<span class="text-danger">*</span></label>
								<input type="date" name="ddn" id="ddn" class="form-control" placeholder="Inserire la data di nascita" value="${param.ddn}" required>
							</div>
							
						</div>
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>

					</form>
			<!-- end card-body -->			   
		    </div>
		    
		    <div class='card-footer'>
		        <a href="ListAutoriServlet" class='btn btn-outline-secondary' style='width:100px'>
		            <i class='fa fa-chevron-left'></i> Indietro
		        </a>
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>