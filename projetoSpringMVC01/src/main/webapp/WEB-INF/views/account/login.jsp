<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acesso ao Sistema</title>

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
						<img
							src="https://www.cotiinformatica.com.br/imagens/logo-coti-informatica.png"
							class="img-fluid" />
						<h5>Acesso ao Sistema</h5>
						<hr />
					</div>
					
					<jsp:include page="/WEB-INF/views/components/mensagens.jsp"/>
					
					<form id="form-login" action="autenticar-usuario" method="post" autocomplete="off">
					
						<label>Email de acesso:</label>
						<form:input path="login-dto.email" type="text" id="email" name="email" 
							   class="form-control" placeholder="Digite aqui"/>
						<br/>
						
						<label>Senha de acesso:</label>
						<form:input path="login-dto.senha" type="password" id="senha" name="senha" 
							   class="form-control" placeholder="Digite aqui"/>
						<div class="text-end">
							<a href="/projetoSpringMVC01/password-recover">Esqueci minha senha?</a>
						</div>
						<br/>
						
						<div class="d-grid">
							<input type="submit" value="Acessar Sistema"
								class="btn btn-primary"/>
						</div>
					
					</form>
					
					<div class="d-grid">
						<a href="/projetoSpringMVC01/register" class="btn btn-light">
							Criar conta de usu?rio
						</a>
					</div>

				</div>
			</div>
			
			<div class="text-center text-white mt-2">
				<small>Sistema de Agenda de Tarefas - COTI Inform?tica v1.0</small>
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
		//quando a p?gina abrir, fa?a..
		$(document).ready(function(){ //page_load

			//valida??o do formul?rio
			$("#form-login").validate(
				{
					//regras de valida??o
					rules : {
						"email" : { required : true, email: true },
						"senha" : { required : true, minlength: 8, maxlength: 20 }
					}
				}			
			);
			
		});
	
	</script>

</body>
</html>