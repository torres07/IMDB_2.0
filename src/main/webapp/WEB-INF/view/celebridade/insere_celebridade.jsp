<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insere Celebridade</title>
	<c:url var="url_base" value="/" />
	<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
</head>
<body>
<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>
<div class="container">	
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4>Inserir celebridade</h4>
		</div>
		<div class="panel-body">
			<jsp:include page="form_celebridade.jsp" />
		</div>
	</div>
</div>
<jsp:include page="${url_base}WEB-INF/view/footer.jsp"></jsp:include>
<script src="${url_base}js/jquery-3.2.1.min.js"></script>
<script src="${url_base}js/bootstrap.min.js"></script>
</body>
</html>