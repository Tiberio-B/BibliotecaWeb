<%@page import="bibliotecaweb.model.Autore"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Autori</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
	<jsp:include page="../error-message.jsp" />
	
	<jsp:include page="../success-message.jsp" />
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Tutti gli Autori${searched==true? ' che soddisfano i parametri della ricerca': ''}</h5> 
		    </div>
		    <div class='card-body'>
		    	<a class="btn btn-primary ${sessionScope.cannotInsert?'disabled':''}" href="PrepareInsertAutoreServlet" aria-disabled="${sessionScope.cannotInsert}">Inserisci nuovo Autore</a>
		    
		        <div class='table-responsive'>
		            <table class='table table-striped ' >
		                <thead>
		                    <tr>
		                        <th>Id</th>
		                        <th>Nome</th>
		                        <th>Cognome</th>
		                        <th>Data di Nascita</th>
		                        <th>Azioni</th>
		                    </tr>
		                </thead>
		                <tbody>
		                	<c:forEach var = "item" items ="${requestScope.autori}">
		                    <tr >
		                        <td><c:out value = "${item.id}"/></td>
		                        <td><c:out value = "${item.nome}"/></td>
		                        <td><c:out value = "${item.cognome}"/></td>
		                        <td><c:out value = "${item.ddn}"/></td>
		                        <td>
									<a class="btn  btn-sm btn-outline-secondary" href="VisualizzaAutoreServlet?idAut=${item.id}">Visualizza Libri</a>
									<a class="btn  btn-sm btn-outline-primary ml-2 mr-2 ${sessionScope.cannotUpdate?'disabled':''}" href="PrepareUpdateAutoreServlet?idAut=${item.id}" aria-disabled="${sessionScope.cannotUpdate}">Modifica</a>
									<a class="btn btn-outline-danger btn-sm ${sessionScope.cannotDelete?'disabled':''}" href="PrepareDeleteAutoreServlet?idAut=${item.id}"  aria-disabled="${sessionScope.cannotDelete}">Rimuovi</a>
								</td>
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