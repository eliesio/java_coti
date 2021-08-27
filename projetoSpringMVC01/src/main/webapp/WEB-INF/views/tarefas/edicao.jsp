<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edição</title>

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

	<div class="container mt-3">
		<h5>Atualizar dados da tarefa</h5>
		<br />

		<form id="form-edicao" autocomplete="off">

			<!-- LINHA -->
			<div class="row">

				<!-- COLUNA -->
				<div class="col-md-6">
					<label>Nome da tarefa:</label> <input type="text" id="nome"
						name="nome" class="form-control" />
				</div>

				<!-- COLUNA -->
				<div class="col-md-3">
					<label>Data da tarefa:</label> <input type="date" id="data"
						name="data" class="form-control" />
				</div>

				<!-- COLUNA -->
				<div class="col-md-3">
					<label>Hora da tarefa:</label> <input type="time" id="hora"
						name="hora" class="form-control" />
				</div>
			</div>

			<!-- LINHA -->
			<div class="row mt-3">

				<!-- COLUNA -->
				<div class="col-md-6">
					<label>Descrição da tarefa:</label>
					<textarea id="descricao" name="descricao" class="form-control"></textarea>
				</div>

				<!-- COLUNA -->
				<div class="col-md-3">
					<label>Prioridade da tarefa:</label> <select class="form-select"
						id="prioridade" name="prioridade">
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
					<input type="submit" value="Salvar Alterações"
						class="btn btn-primary" />

					<!-- BOTÃO PARA LIMPAR O FORMULARIO -->
					<a href="/projetoSpringMVC01/tarefas-consulta"
						class="btn btn-light">Cancelar</a>

				</div>
			</div>

		</form>


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
			$("#form-edicao").validate({
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



