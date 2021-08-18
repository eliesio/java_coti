<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

<!-- adicionando referencia para as bibliotecas de CSS (folha de estilo) -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Sistema de Controle de Tarefas</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Página inicial</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Gerenciar Tarefas </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">Cadastrar Tarefas</a></li>
							<li><a class="dropdown-item" href="#">Consultar Tarefas</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Relatório de
									Tarefas</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container mt-3">

		<h5>Seja bem vindo ao projeto</h5>
		Sistema desenvolvido em Spring MVC com MySQL e JDBC Template

	</div>

	<!-- adicionando referencia para as bibliotecas de JS (javascript) -->
	<script src="resources/js/bootstrap.min.js"></script>

</body>

</html>