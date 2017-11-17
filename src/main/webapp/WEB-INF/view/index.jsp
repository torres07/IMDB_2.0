<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="url_base" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página inicial - IMDB</title>
<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
<link rel="stylesheet" href="${url_base}css/general.css" />
</head>
<body>
	<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>
	<div class="container">
		<div class="jumbotron">
			<div>
				<h1>IMDb 2.0 - Internet Movie Database</h1>
				<p>Desenvolvido baseado no <a href="http://www.imdb.com/">IMDb</a>, a diferença? Este é melhor!</p>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-6">
						<div class="embed-responsive embed-responsive-16by9">
							<iframe width="560" height="315" src="https://www.youtube.com/embed/mK-LlTwt4Os"></iframe>
						</div>
					</div>
					<div class="col-md-6">
						<div class="embed-responsive embed-responsive-16by9">
							<iframe width="560" height="315" src="https://www.youtube.com/embed/Div0iP65aZo"></iframe>
						</div>
					</div>
				</div>
				
			</div>
			<div class="panel-footer">
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