<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="post" modelAttribute="celebridade" action="${url_base}/celebridades" acceptCharset="UTF-8" enctype="multipart/form-data">
	<form:input path="id" type="hidden"  />
	
	<spring:bind path="nome">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="nome">Nome</form:label>
		<form:input path="nome" type="text" cssClass="form-control" />
		<form:errors path="nome" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="descricao">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="descricao">Descrição</form:label>
		<form:input path="descricao" type="text" cssClass="form-control" />
		<form:errors path="descricao" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="curiosidade">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="curiosidade">Curiosidade</form:label>
		<form:input path="curiosidade" type="text" cssClass="form-control" />
		<form:errors path="curiosidade" class="control-label" />
	</div>
	</spring:bind>
	
	<div class="input-field col s12">
		<label>Foto da celebridade</label>
		<div class="file-field input-field">
			<div>
				<label class="btn btn-default">
					Inserir imagem<input name="imagem" type="file" style="display: none;">
				</label>
			</div>
		</div>
	</div>
	<br>	
	<button type="submit" class="btn btn-primary">Salvar</button>
	
</form:form>