<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:url var="url_base" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Celebridade - ${celebridade.nome}</title>
<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
<link rel="stylesheet" href="${url_base}css/general.css" />
</head>
<body>
	<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong><a class="post-title" href="#">${celebridade.nome}</a></strong>
			</div>
			<div class="panel-body">
				<div class="col-md-2">
					<img src="${url_base }resources/img/${celebridade.imgpath}" alt="example" class="img-thumbnail">
				</div>
				<div class="col-md-8">
					<h4>Descrição</h4>
					<p>${celebridade.descricao}</p>
					<h4>Curiosidade</h4>
					<p>${celebridade.curiosidade}</p>
				</div>
			</div>
			<div class="panel-footer">
				<c:if test="${fn:length(celebridade.dirige) gt 0}">
					<span>Respect! We have a director here</span>
					<span class="glyphicon glyphicon-star"></span>
				</c:if>
			</div>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
					<span class="post-title glyphicon glyphicon-film"></span> 
					<span class="post-title">Participações</span>
			</div>
			<div class="panel-body">
				<div class="col-md-6">
					<ul class="list-group">
						<c:forEach var="filme" items="${celebridade.filmes}">
							<li class="list-group-item"><a href="${url_base}filmes/${filme.id}/detalhes">${filme.nome} - ${filme.ano}</a></li>							
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		
		<c:if test="${not empty celebridade.dirige}">
			<div class="panel panel-default">
				<div class="panel-heading">
						<span class="post-title glyphicon glyphicon-king"></span> 
						<span class="post-title">Direções</span>
				</div>
				<div class="panel-body">
					<div class="col-md-6">
						<ul class="list-group">
							<c:forEach var="direcao" items="${celebridade.dirige}">
								<li class="list-group-item"><a href="${url_base}filmes/${direcao.id}/detalhes">${direcao.nome} - ${direcao.ano}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</c:if>
		
	</div>
	<jsp:include page="${url_base}WEB-INF/view/footer.jsp"></jsp:include>
	<script src="${url_base}js/jquery-3.2.1.min.js"></script>
	<script src="${url_base}js/bootstrap.min.js"></script>
	<script src="${url_base}js/general.js"></script>
	<script>
		
	</script>
</body>
</html>