<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url_base" value="/" />
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">IMDb 2.0</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="${url_base}">Home</a></li>
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Filmes
        		<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li class="dropdown-header">Geral</li>
					<li><a href="${url_base}filmes">Listar todos</a></li>
					<li class="divider"></li>
					<li class="dropdown-header">Categorias</li>
					<li><a href="${url_base }filmes/acao">Ação</a></li>
					<li><a href="${url_base }filmes/drama">Drama</a></li>
					<li><a href="${url_base }filmes/comedia">Comédia</a></li>
					<li><a href="${url_base }filmes/terror">Terror</a></li>
					<li><a href="${url_base }filmes/romance">Romance</a></li>
					<li><a href="${url_base }filmes/ficcao">Ficção</a></li>
				</ul>
			</li>
			<li><a href="${url_base}celebridades">Celebridades</a></li>
			<li><a href="${url_base}about">Contate-nos</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${not empty usuario_logado}">
				<li><a href="#"><span
						class="glyphicon glyphicon-user"></span> ${login}</a></li>
				<li><a href="${url_base}logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>					
			</c:if>
			<c:if test="${empty usuario_logado}">
				<li><a href="${url_base}cadastro_usuario"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="${url_base}login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</c:if>
		</ul>
	</div>
</nav>