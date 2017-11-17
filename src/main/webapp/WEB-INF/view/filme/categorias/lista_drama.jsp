<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="url_base" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Filmes</title>
<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
<link rel="stylesheet" href="${url_base}css/general.css" />
</head>
<body>
	<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2>
					<span>Lista de filmes</span>
				</h2>
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
				
				<c:if test="${not empty filmes}">
					<table id="tabela_filmes" class="table table-hover">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Gênero</th>
								<th>Ano</th>
								<th>Estrelas</th>
								<th>Ação</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${filmes}" varStatus="vs">
								<tr>
									<td>${c.nome}</td>
									<td>${c.genero}</td>
									<td>${c.ano}</td>
									<td>${c.estrelas}</td>
									
									<td>
										<div class="btn-toolbar">
											<a href="${url_base}filmes/${c.id}/detalhes"
												class="btn btn-primary">Detalhes</a>
											
											<a href="${url_base}filmes/${c.id}/update"
												class="btn btn-primary">Altera</a>
											
											<button type="button" class="btn btn-success"
												data-toggle="modal" data-target="#myModal${vs.index}">Inserir
												participante(s)</button>
											<div class="modal fade" id="myModal${vs.index}" role="dialog">
												<div class="modal-dialog">
													<!-- Modal content-->
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal">&times;</button>
															<h4 class="modal-title">Lista de celebridades</h4>
														</div>
														<div class="modal-body">
															<div class="panel panel-default">
																<div class="panel-body">
																	<c:if test="${not empty celebridades}">
																		<form:form modelAttribute="check" method="get"
																		action="${url_base}filmes/${c.id}/inserir_participantes">
																			<c:forEach var="p" items="${celebridades}">
																				<ul class="list-group">
																					<li class="list-group-item">
																						<label class="labelb"><form:checkbox
																							path="selectedCelebridades" value="${p.id}" />${p.nome}
																						</label>
																					</li>
																				</ul>
																					
																			</c:forEach>
																			<button type="submit" class="btn btn-default">Inserir</button>
																		</form:form>
																	</c:if>
																	<c:if test="${empty celebridades}">
																		<p>Não há celebridades disponiveis</p>
																	</c:if>
																</div>
															</div>
															
														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Close</button>
														</div>
													</div>
			
												</div>
											</div>
											
											<a href="${url_base}filmes/${c.id}/delete"
												class="btn btn-danger"
												onclick="return confirm('Confirma remoção?')">Deleta</a>
										</div>
										
									</td>
		
									
		
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
			
			<div class="panel-footer">
				<a href="/filmes/add" class="btn btn-primary">Novo filme</a>
			</div>
		</div>
		
	</div>
	<script src="${url_base}js/jquery-3.2.1.min.js"></script>
	<script src="${url_base}js/bootstrap.min.js"></script>
	<script src="${url_base}js/general.js"></script>
	<script>
		
	</script>
</body>
</html>