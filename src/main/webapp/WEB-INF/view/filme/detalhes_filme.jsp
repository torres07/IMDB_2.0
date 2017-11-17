<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="url_base" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filmes - ${filme.nome}</title>
<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
<link rel="stylesheet" href="${url_base}css/general.css" />
</head>
<body>
	<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
					<span class="post-title glyphicon glyphicon-film"></span> 
					<span class="post-title">${filme.nome}</span>
			</div>
			<div class="panel-body">
				<div class="col-md-2">
					<img src="${url_base}resources/img/${filme.imgpath}" alt="example" class="img-thumbnail">
				</div>
				<div class="col-md-10">
					<p>${filme.sinopse}</p>
				</div>
			</div>
			<div class="panel-footer">
				<span class="glyphicon glyphicon-king"></span> 
				Diretor - <a href="${url_base}celebridades/${filme.diretor.id}/detalhes">${filme.diretor.nome}</a> | 
				<span class="glyphicon glyphicon-star"></span>
				 - ${filme.estrelas} |  
				<span class="glyphicon glyphicon-book"></span>
				- ${filme.genero} | 
				<span class="glyphicon glyphicon-fire"></span>
				- <c:if test="${not empty usuario_logado}"><a href="#" data-toggle="modal" data-target="#rateModal">Classifique este filme</a></c:if>
					<c:if test="${empty usuario_logado}">Faça o login para classificar este filme</c:if> 
				<div class="modal fade" id="rateModal" role="dialog">
				  <div class="modal-dialog modal-md">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				        <h4 class="modal-title">Quantas estrela você daria à este filme?</h4>
				      </div>
				      <div class="modal-body">
				      	<form:form modelAttribute="estrelas" method="get" action="${url_base}filmes/${filme.id}/rate">
				      		<label class="radio-inline"><form:radiobutton path="estrelasN" value="5"/>5<span class="glyphicon glyphicon-star"></span></label>
				      		<label class="radio-inline"><form:radiobutton path="estrelasN" value="4"/>4<span class="glyphicon glyphicon-star"></span></label>
				      		<label class="radio-inline"><form:radiobutton path="estrelasN" value="3"/>3<span class="glyphicon glyphicon-star"></span></label>
				      		<label class="radio-inline"><form:radiobutton path="estrelasN" value="2"/>2<span class="glyphicon glyphicon-star"></span></label>
				      		<label class="radio-inline"><form:radiobutton path="estrelasN" value="1"/>1<span class="glyphicon glyphicon-star"></span></label>
				      		<br><br><button type="submit" class="btn btn-default">Votar</button>
				      	</form:form>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
					<span class="post-title glyphicon glyphicon-user"></span> 
					<span class="post-title">Participantes</span>
			</div>
			<div class="panel-body">
				<div class="col-md-6">
					<ul class="list-group">
						<c:forEach var="participante" items="${filme.celebridades}">
							
							<li class="list-group-item"><a href="${url_base}celebridades/${participante.id}/detalhes">${participante.nome}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="${url_base}WEB-INF/view/footer.jsp"></jsp:include>
	<script src="${url_base}js/jquery-3.2.1.min.js"></script>
	<script src="${url_base}js/bootstrap.min.js"></script>
	<script src="${url_base}js/general.js"></script>
	<script>
		
	</script>
</body>
</html>