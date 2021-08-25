<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edição</title>

<!-- adicionando referencia para as bibliotecas de CSS (folha de estilo) -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

</head>

<body>

	<jsp:include page="/WEB-INF/views/components/menu.jsp" />

	<div class="container mt-3">
		<h5>Atualizar dados da tarefa</h5>
		<br />
		
		<form>
		
			<!-- LINHA -->
			<div class="row">
			
				<!-- COLUNA -->
				<div class="col-md-6">
					<label>Nome da tarefa:</label>
					<input type="text" class="form-control"/>
				</div>
				
				<!-- COLUNA -->
				<div class="col-md-3">
					<label>Data da tarefa:</label>
					<input type="date" class="form-control"/>
				</div>
				
				<!-- COLUNA -->
				<div class="col-md-3">
					<label>Hora da tarefa:</label>
					<input type="time" class="form-control"/>
				</div>			
			</div>
			
			<!-- LINHA -->
			<div class="row mt-3">
			
				<!-- COLUNA -->
				<div class="col-md-6">
					<label>Descrição da tarefa:</label>
					<textarea class="form-control"></textarea>
				</div>
				
				<!-- COLUNA -->
				<div class="col-md-3">
					<label>Prioridade da tarefa:</label>
					<select class="form-select">
						<option value="">Escolha uma opção</option>
						<option value="BAIXA">Prioridade Baixa</option>
						<option value="MEDIA">Prioridade Média</option>
						<option value="ALTA">Prioridade Alta</option>
					</select>
				</div>
			</div>
			
			<div class="row mt-3">
				<div class="col-md-6">
				
					<!-- BOTÃO PARA ENVIAR OS DADOS DO FORMULARIO PARA O SERVIDOR -->
					<input type="submit" value="Salvar Alterações" class="btn btn-primary"/>
					
					<!-- BOTÃO PARA LIMPAR O FORMULARIO -->
					<a href="/projetoSpringMVC01/tarefas-consulta" class="btn btn-light">Cancelar</a>
				
				</div>
			</div>
		
		</form>
		

	</div>

	<!-- adicionando referencia para as bibliotecas de JS (javascript) -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-3.6.0.min.js"></script>

</body>

</html>

