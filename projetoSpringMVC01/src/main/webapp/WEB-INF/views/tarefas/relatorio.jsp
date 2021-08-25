<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Relatório</title>

<!-- adicionando referencia para as bibliotecas de CSS (folha de estilo) -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

</head>

<body>

	<jsp:include page="/WEB-INF/views/components/menu.jsp" />

	<div class="container mt-3">
		<h5>Relatório de tarefas</h5>
		<br />
		
		<form>
		
			<div class="row">
			
				<div class="col-md-3">
					<label>Data de início:</label>
					<input type="date" class="form-control"/>
				</div>
				
				<div class="col-md-3">
					<label>Data de término:</label>
					<input type="date" class="form-control"/>
				</div>
			
			</div>
			
			<div class="row mt-3">
				<div class="col-md-12">
					<input type="submit" value="Gerar Relatório" class="btn btn-success"/>
				</div>
			</div>
		
		</form>

	</div>

	<!-- adicionando referencia para as bibliotecas de JS (javascript) -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-3.6.0.min.js"></script>

</body>

</html>

