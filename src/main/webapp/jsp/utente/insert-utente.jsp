<!doctype html>
<html lang="it">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp" />
<title>Inserisci Utente</title>

<!-- style per le pagine diverse dalla index -->
<link href="./assets/css/global.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
    <script>
    $().ready(function() {
          $("#form").validate({
            rules: {
                nome: {
                    required: true
            },
               cognome {
                    required: true
            },
               username: {
                    required: true
            },
                stato: {
                    required: true
            },
                ruoli: {
                    requried: true
            }
            messages: {
                nome: "Inserire il nome",
                cognome: "Inserire il cognome",
                username: "Inserire lo username",
                stato: "Inserire lo stato",
                ruoli: "Inserire i ruoli"
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
				<h5>Inserisci un Utente</h5>
			</div>
			<div class='card-body'>

				<form method="post" action="ExecuteInsertUtenteServlet"
					novalidate="novalidate">

					<div class="form-row">
						<div class="form-group col-md-4">
							<label>Cognome</label> <input type="text" name="cognome"
								id="cognome" class="form-control"
								placeholder="Inserire il cognome" required>
						</div>

						<div class="form-group col-md-4">
							<label>Nome</label> <input type="text" name="nome" id="nome"
								class="form-control" placeholder="Inserire il nome" required>
						</div>

						<div class="form-group col-md-4">
							<label>Username</label> <input type="text" name="username"
								id="username" class="form-control"
								placeholder="Inserire lo username" required>
						</div>

					</div>

					<div class="form-row">
						<div class="form-group col-md-6">
							<label>Stato Utente</label> <select
								class="browser-default custom-select" name="stato">

								<option value="">Seleziona uno stato utente...</option>

								<c:forEach var="stato" items="${sessionScope.listaStati}">
									<option value="${stato.name()}">${stato.name()}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group col-md-6">
							<label>Ruolo Utente</label> 

								<c:forEach var="ruolo" items="${requestScope.ruoli}">
									<br/>
									<input type="checkbox" id="ruoliId" name="ruoliId" value="${ruolo.id}">
									<label for="ruoliId"> ${ruolo.codice.name()}</label>
								</c:forEach>
								
						</div>

					</div>

					<button type="submit" name="submit" value="submit" id="submit"
						class="btn btn-primary">Conferma</button>


				</form>
				<!-- end card-body -->
			</div>

			<div class='card-footer'>
				<a href="ListAutoriServlet" class='btn btn-outline-secondary'
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