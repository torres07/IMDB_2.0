<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url_base" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contate-nos - IMDB</title>
<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
<link rel="stylesheet" href="${url_base}css/general.css" />
</head>
<body>
	<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>
	<div class="container">
		<h2>Restou alguma d�vida?</h2>
		<p>Espero que esta aplica��o tenha proporcionado a voc� a melhor experi�ncia, mas caso tenha alguma d�vida
		, ou deseja passar o seu feedback, basta nos enviar um email.</p>
		<p>Sinta-se � vontade para entrar em contato quando bem desejar, a nossa maior preocupa��o � voc�!</p>
		<p>Email: cs.pedrotorres@gmail.com</p>
		<h2>Desenvolvimento de Software para Web</h2>
		<p>Esta aplica��o foi desenvolvida espeficamente como trabalho final da disciplina de DSWEB 2017.1.
		<p>Universidade Federal do Cear�</p>
		<p>Prof. Regis Pires</p>
	</div>
	<jsp:include page="${url_base}WEB-INF/view/footer.jsp"></jsp:include>
	<script src="${url_base}js/jquery-3.2.1.min.js"></script>
	<script src="${url_base}js/bootstrap.min.js"></script>
	<script src="${url_base}js/general.js"></script>
	<script>
		
	</script>
</body>
</html>