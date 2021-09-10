<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

<!-- adicionando referencia para as bibliotecas de CSS (folha de estilo) -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

</head>

<body>


	<jsp:include page="/WEB-INF/views/components/menu.jsp" />
	<jsp:include page="/WEB-INF/views/components/mensagens.jsp" />

	<div class="container mt-3">
		<h5>Seja bem vindo ao projeto</h5>
		Sistema desenvolvido em Spring MVC com MySQL e JDBC Template
	</div>

	<!-- adicionando referencia para as bibliotecas de JS (javascript) -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-3.6.0.min.js"></script>

</body>

</html>




