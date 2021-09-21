<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

<!-- adicionando referencia para as bibliotecas de CSS (folha de estilo) -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

</head>

<body>


	<jsp:include page="/WEB-INF/views/components/menu.jsp" />
	<jsp:include page="/WEB-INF/views/components/mensagens.jsp" />

	<div class="container mt-3">
		
		<div class="row">
			<div class="col-md-6">
				<h2>Seja bem vindo ao projeto</h2>
				Sistema desenvolvido em Spring MVC com MySQL e JDBC Template - Curso JavaWebDeveloper COTI Informática.
				
				<p>
					<a href="http://www.cotiinformatica.com.br" target="_blank">COTI Informática</a>
				</p>
				
				Versão do sistema: 1.0
				
				<hr/>
				
				Usuário autenticado: <strong>${user_auth.nome}</strong>
				<br/>
				Email: <strong>${user_auth.email}</strong>
				
			</div>
			<div class="col-md-6">
				<div id="grafico"></div>
			</div>
		</div>
		
	</div>
	
	<!-- adicionando referencia para as bibliotecas de JS (javascript) -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-3.6.0.min.js"></script>
	
	<!-- Referencias das bibliotecas do HIGHCHARTS -->
	<script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/highcharts-3d.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
	
	<script>
	
		$(document).ready(function(){
			
			var dados = [
				<c:forEach items="${dados_grafico}" var="item">
					{ data : [${item.quantidade}], name : '${item.prioridade}' },
				</c:forEach>
			];
			
			var array = [];
			for(var i = 0; i < dados.length; i++){
				array.push([dados[i].name, dados[i].data[0]]);
			}
			
			new Highcharts.Chart({
				chart: {
					type : 'pie',
					renderTo: 'grafico'
				},
				title: {
					text: 'Gráfico de tarefas por prioridade'
				},
				subtitle: {
					text: 'Total de tarefas por prioridade cadastrada'
				},
				exporting: { enabled : false },
				credits: { enabled : false },
				plotOptions : {
					pie : {
						innerSize: '60%'
					}
				},
				series: [
					{ data : array }
				]
			})
			
		});
	
	</script>

</body>

</html>




