<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Altera Filme - ${filme.nome}</title>
<c:url var="url_base" value="/" />
	<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
	<link rel="stylesheet" href="${url_base}css/bootstrap-select.min.css" />
	<link rel="stylesheet" href="${url_base}css/general.css" />
</head>
<body>
	<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4>Alterar filme</h4>
			</div>
			<div class="panel-body">
				<jsp:include page="form_filme.jsp" />
			</div>
		</div>
		
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4>Remover participantes</h4>
			</div>
			<div class="panel-body">
				<c:if test="${not empty filme.celebridades}">
					<form:form modelAttribute="check_celebridades" method="get"
						action="${url_base}filmes/${filme.id}/remover_participantes">
							<c:forEach var="p" items="${filme.celebridades}">
								<ul class="list-group">
									<li class="list-group-item">
										<label class="labelb">
											<form:checkbox path="selectedCelebridades" value="${p.id}"/> ${p.nome}
										</label>
									</li>
								</ul>
							</c:forEach>
							<button type="submit" class="btn btn-danger">Remover</button>
					</form:form>
				</c:if>
				
				<c:if test="${empty filme.celebridades}">
					<p>Ainda não há celebridades neste filme.</p>
				</c:if>	
			</div>
		</div>

	</div>
	<jsp:include page="${url_base}WEB-INF/view/footer.jsp"></jsp:include>
	<script src="${url_base}js/jquery-3.2.1.min.js"></script>
	<script src="${url_base}js/bootstrap.min.js"></script>
	<script src="${url_base}js/bootstrap-select.js"></script>
	<script src="${url_base}js/general.js"></script>
</body>
</html>