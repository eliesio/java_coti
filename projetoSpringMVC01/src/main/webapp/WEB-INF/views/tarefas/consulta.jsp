<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- TAGLIB do JSP (JSTL) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consulta</title>

<!-- adicionando referencia para as bibliotecas de CSS (folha de estilo) -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

</head>

<body>

	<jsp:include page="/WEB-INF/views/components/menu.jsp" />
	<jsp:include page="/WEB-INF/views/components/mensagens.jsp"></jsp:include>
	
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
			
				<c:forEach items="${tarefas}" var="item">
					<tr>
						<td>${item.nome}</td>
						<td>${item.data}</td>
						<td>${item.hora}</td>
						<td>${item.descricao}</td>
						<td>
							<c:if test="${item.prioridade == 'ALTA'}">
								<span class="badge bg-danger">ALTA</span>
							</c:if>
							
							<c:if test="${item.prioridade == 'MEDIA'}">
								<span class="badge bg-warning">MÉDIA</span>
							</c:if>
							
							<c:if test="${item.prioridade == 'BAIXA'}">
								<span class="badge bg-success">BAIXA</span>
							</c:if>
						</td>
						<td>
							<a href="/projetoSpringMVC01/tarefas-edicao" class="btn btn-primary btn-sm">Editar</a>
							<a href="#" class="btn btn-danger btn-sm">Excluir</a>
						</td>
					</tr>
				</c:forEach>			
				
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">Quantidade de tarefas: ${tarefas.size()}</td>
				</tr>
			</tfoot>
		</table>

	</div>

	<!-- adicionando referencia para as bibliotecas de JS (javascript) -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-3.6.0.min.js"></script>

</body>

</html>

