<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>

<!-- adicionando referencia para as bibliotecas de CSS (folha de estilo) -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

<!-- Folha de estilos CSS -->
<style>
label.error {
	color: #d9534f;
}

input.error, textarea.error, select.error {
	border: 1px solid #d9534f;
}
</style>

</head>

<body>

	<jsp:include page="/WEB-INF/views/components/menu.jsp" />
	<jsp:include page="/WEB-INF/views/components/mensagens.jsp"/>

	<div class="container mt-3">
		<h5>Cadastrar tarefas</h5>
		<br />

		<form id="form-cadastro" action="cadastrar-tarefa" method="post"
			autocomplete="off">

			<!-- LINHA -->
			<div class="row">

				<!-- COLUNA -->
				<div class="col-md-6">
					<label>Nome da tarefa:</label>
					<form:input path="tarefas-dto.nome" type="text" id="nome"
						name="nome" class="form-control" />
				</div>

				<!-- COLUNA -->
				<div class="col-md-3">
					<label>Data da tarefa:</label>
					<form:input path="tarefas-dto.data" type="date" id="data"
						name="data" class="form-control" />
				</div>

				<!-- COLUNA -->
				<div class="col-md-3">
					<label>Hora da tarefa:</label>
					<form:input path="tarefas-dto.hora" type="time" id="hora"
						name="hora" class="form-control" />
				</div>
			</div>

			<!-- LINHA -->
			<div class="row mt-3">

				<!-- COLUNA -->
				<div class="col-md-6">
					<label>Descrição da tarefa:</label>
					<form:textarea path="tarefas-dto.descricao" id="descricao"
						name="descricao" class="form-control"></form:textarea>
				</div>

				<!-- COLUNA -->
				<div class="col-md-3">
					<label>Prioridade da tarefa:</label>
					<form:select path="tarefas-dto.prioridade" id="prioridade"
						name="prioridade" class="form-select">
						<option value="">Escolha uma opção</option>
						<option value="BAIXA">Prioridade Baixa</option>
						<option value="MEDIA">Prioridade Média</option>
						<option value="ALTA">Prioridade Alta</option>
					</form:select>
				</div>
			</div>

			<div class="row mt-3">
				<div class="col-md-6">

					<!-- BOTÃO PARA ENVIAR OS DADOS DO FORMULARIO PARA O SERVIDOR -->
					<input type="submit" value="Realizar Cadastro"
						class="btn btn-success" />

					<!-- BOTÃO PARA LIMPAR O FORMULARIO -->
					<input type="reset" value="Cancelar" class="btn btn-light" />

				</div>
			</div>

		</form>

		<div>${mensagem_sucesso}</div>

		<div>${mensagem_erro}</div>


	</div>

	<!-- adicionando referencia para as bibliotecas de JS (javascript) -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-3.6.0.min.js"></script>
	<script src="resources/js/jquery.validate.min.js"></script>
	<script src="resources/js/messages_pt_BR.min.js"></script>

	<script>
		//iniciando o jquery..
		//quando a página abrir, faça..
		$(document).ready(function() { //page_load

			//validação do formulário
			$("#form-cadastro").validate({
				//regras de validação
				rules : {
					"nome" : {
						required : true,
						minlength : 6,
						maxlength : 150
					},
					"data" : {
						required : true
					},
					"hora" : {
						required : true
					},
					"descricao" : {
						required : true,
						minlength : 10,
						maxlength : 500
					},
					"prioridade" : {
						required : true
					}
				}
			});

		});
	</script>

</body>

</html>