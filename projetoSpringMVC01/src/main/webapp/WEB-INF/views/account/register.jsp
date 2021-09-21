<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	
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
						<h3>Criar Conta de Usuário</h3>
						<hr />
					</div>
					
					<jsp:include page="/WEB-INF/views/components/mensagens.jsp"/>
					
					<form id="form-register" action="cadastrar-usuario" method="post" autocomplete="off">
					
						<label>Nome do Usuário:</label>
						<form:input path="register-dto.nome" type="text" id="nome" name="nome" 
							   class="form-control" placeholder="Digite aqui"/>
						<br/>
					
						<label>Email:</label>
						<form:input path="register-dto.email" type="text" id="email" name="email" 
							   class="form-control" placeholder="Digite aqui"/>
						<br/>
						
						<label>Senha:</label>
						<form:input path="register-dto.senha" type="password" id="senha" name="senha" 
							   class="form-control" placeholder="Digite aqui"/>
						<br/>
						
						<label>Confirme sua senha:</label>
						<form:input path="register-dto.senhaConfirmacao" type="password" 
								id="senhaConfirmacao" name="senhaConfirmacao" 
							   	class="form-control" placeholder="Digite aqui"/>
						<br/>
						
						<div class="d-grid">
							<input type="submit" value="Realizar Cadastro"
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
				<small>Sistema de Agenda de Tarefas - COTI Informática v1.0</small>
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
		//quando a página abrir, faça..
		$(document).ready(function(){ //page_load

			//validação do formulário
			$("#form-register").validate(
				{
					//regras de validação
					rules : {
						"nome" : { required : true, minlength: 8, maxlength: 150 },
						"email" : { required : true, email: true },
						"senha" : { required : true, minlength: 8, maxlength: 20 },
						"senhaConfirmacao" : { required : true, equalTo: "#senha" }
					}
				}			
			);
			
		});
	
	</script>

</body>
</html>