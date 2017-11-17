<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url_base" value="/" />
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Lista Celebridades</title>
	<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
</head>
<body>
<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>
<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h2>Lista de celebridades</h2>
		</div>
		<div class="panel-body">
			<c:if test="${not empty msg}">
				<div class="alert alert-success alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<p>${msg}</p>
				</div>
			</c:if>
			
			<c:if test="${not empty celebridades}">
				<table id="tabela_celebridades" class="table table-hover">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Descrição</th>
							<th>Curiosidade</th>
							<th>Ação</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="c" items="${celebridades}">
							<tr>
								<td>${c.nome}</td>
								<td>${c.descricao}</td>
								<td>${c.curiosidade}</td>
								<td>
									<div class="btn-toolbar">
										<a href="${url_base}celebridades/${c.id}/detalhes" 
											class="btn btn-primary">Detalhes</a>
										
										<c:if test="${usuario_logado.login eq 'admin'}">
											<a href="${url_base}celebridades/${c.id}/update"
												class="btn btn-primary">Altera
											</a>
											<a href="${url_base}celebridades/${c.id}/delete"
												class="btn btn-danger"
												onclick="return confirm('Confirma remoção?')">Deleta
											</a>
										</c:if>
										
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<div class="panel-footer">
			<a href="/celebridades/add" class="btn btn-primary">Nova celebridade</a>
		</div>
	</div>
	
</div>
<jsp:include page="${url_base}WEB-INF/view/footer.jsp"></jsp:include>
<script src="${url_base}js/jquery-3.2.1.min.js"></script>
<script src="${url_base}js/bootstrap.min.js"></script>
<script>
</script>
</body>
</html>