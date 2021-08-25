<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consulta</title>

<!-- adicionando referencia para as bibliotecas de CSS (folha de estilo) -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

</head>

<body>

	<jsp:include page="/WEB-INF/views/components/menu.jsp" />

	<div class="container mt-3">
		<h5>Consultar tarefas</h5>
		<br />
		
		<table class="table table-hover table-striped table-sm">
			<thead>
				<tr>
					<th>Nome da tarefa</th>
					<th>Data</th>
					<th>Hora</th>
					<th>Descrição</th>
					<th>Prioridade</th>
					<th>Operações</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<a href="/projetoSpringMVC01/tarefas-edicao" class="btn btn-primary btn-sm">Editar</a>
						<a href="#" class="btn btn-danger btn-sm">Excluir</a>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">Quantidade de tarefas: 0</td>
				</tr>
			</tfoot>
		</table>

	</div>

	<!-- adicionando referencia para as bibliotecas de JS (javascript) -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-3.6.0.min.js"></script>

</body>

</html>