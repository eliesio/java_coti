   <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Sistema de Controle de Tarefas</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/projetoSpringMVC01/home">P�gina inicial</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Gerenciar Tarefas </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="/projetoSpringMVC01/tarefas-cadastro">Cadastrar Tarefas</a></li>
							<li><a class="dropdown-item" href="/projetoSpringMVC01/tarefas-consulta">Consultar Tarefas</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="/projetoSpringMVC01/tarefas-relatorio">Relat�rio de Tarefas</a></li>
						</ul>
					</li>
				</ul>
				
				<!-- exibindo os dados do usuario autenticado -->
				<form class="d-flex">
					<span class="text-white mt-3" style="margin-right: 20px;">
						${user_auth.nome} | ${user_auth.email}
					</span>
					<a href="/projetoSpringMVC01/logout" class="btn btn-secondary mt-2"
						onclick="return confirm('Deseja realmente sair do sistema');">
						Sair
					</a>		
				</form>
				
			</div>
		</div>
	</nav>