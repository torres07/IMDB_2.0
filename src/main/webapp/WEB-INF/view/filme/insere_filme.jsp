<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insere Filme</title>
	<c:url var="url_base" value="/" />
	<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
	<link rel="stylesheet" href="${url_base}css/bootstrap-select.min.css" />
</head>
<body>
<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>
<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4>Insere filme</h4>
		</div>
		<div class="panel-body">
			<jsp:include page="form_filme.jsp" />
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