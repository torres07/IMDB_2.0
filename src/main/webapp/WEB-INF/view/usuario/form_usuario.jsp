<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="post" modelAttribute="usuario" action="${url_base}/finalizar_cadastro">
	<form:input path="id" type="hidden"  />
	
	<spring:bind path="login">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="login">Login</form:label>
		<form:input path="login" type="text" cssClass="form-control" />
		<form:errors path="login" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="email">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="email">Email</form:label>
		<form:input path="email" type="text" cssClass="form-control" />
		<form:errors path="email" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="password">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="password">Senha</form:label>
		<form:input path="password" type="password" cssClass="form-control" />
		<form:errors path="password" class="control-label" />
	</div>
	</spring:bind>
	
	<button type="submit" class="btn btn-primary">Salvar</button>
	
</form:form>