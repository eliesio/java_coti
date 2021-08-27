<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Relatório</title>

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
		<h5>Relatório de tarefas</h5>
		<br />

		<form id="form-relatorio" autocomplete="off">

			<div class="row">

				<div class="col-md-3">
					<label>Data de início:</label> <input type="date" id="dataMin"
						name="dataMin" class="form-control" />
				</div>

				<div class="col-md-3">
					<label>Data de término:</label> <input type="date" id="dataMax"
						name="dataMax" class="form-control" />
				</div>

			</div>

			<div class="row mt-3">
				<div class="col-md-12">
					<input type="submit" value="Gerar Relatório"
						class="btn btn-success" />
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
			$("#form-relatorio").validate({
				//regras de validação
				rules : {
					"dataMin" : {
						required : true
					},
					"dataMax" : {
						required : true
					}
				}
			});

		});
	</script>

</body>

</html>