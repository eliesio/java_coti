<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crie sua Conta</title>

<!-- adicionando referencia para as bibliotecas de CSS (folha de estilo) -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

<!-- Folha de estilos CSS -->
<style>
	body { overflow-x: hidden; }
	label.error { color: #d9534f; }
	input.error, textarea.error, select.error { border: 1px solid #d9534f; }
</style>

</head>
<body class="bg-primary">

	<div class="row">
		<div class="col-md-4 offset-md-4">

			<div class="card mt-5">
				<div class="card-body">

					<div class="text-center">						
						<h3>Esqueci minha senha</h3>
						<hr />
					</div>
					
					<form id="form-passwordrecover" method="post" autocomplete="off">
					
						<label>Informe seu email de acesso:</label>
						<input type="text" id="email" name="email" 
							   class="form-control" placeholder="Digite aqui"/>
						<br/>
						
						<div class="d-grid">
							<input type="submit" value="Recuperar Senha"
								class="btn btn-success"/>
						</div>
					
					</form>
					
					<div class="d-grid">
						<a href="/projetoSpringMVC01/" class="btn btn-light">
							Acessar Sistema
						</a>
					</div>

				</div>
			</div>
			
			<div class="text-center text-white mt-2">
				<small>Sistema de Agenda de Tarefas - COTI Inform�tica v1.0</small>
			</div>

		</div>
	</div>


	<!-- adicionando referencia para as bibliotecas de JS (javascript) -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-3.6.0.min.js"></script>
	<script src="resources/js/jquery.validate.min.js"></script>
	<script src="resources/js/messages_pt_BR.min.js"></script>
	
	<script>
	
		//iniciando o jquery..
		//quando a p�gina abrir, fa�a..
		$(document).ready(function(){ //page_load

			//valida��o do formul�rio
			$("#form-passwordrecover").validate(
				{
					//regras de valida��o
					rules : {
						"email" : { required : true, email: true }
					}
				}			
			);
			
		});
	
	</script>

</body>
</html>




