<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form method="post" modelAttribute="filme" action="${url_base}/filmes" acceptCharset="UTF-8" enctype="multipart/form-data">
	<form:input path="id" type="hidden"  />
	
	<spring:bind path="nome">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="nome">Nome</form:label>
		<form:input path="nome" type="text" cssClass="form-control" />
		<form:errors path="nome" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="sinopse">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="sinopse">Sinopse</form:label>
			<form:textarea rows="5" path="sinopse" cssClass="form-control"/>
			<form:errors path="sinopse" class="control-label" />
		</div>
	</spring:bind>

	<spring:bind path="genero">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="genero">Genero</form:label>
			<br>
			<form:select path="genero" cssClass="selectpicker">
				<form:option value="Ação">Ação</form:option>
				<form:option value="Drama">Drama</form:option>
				<form:option value="Comedia">Comédia</form:option>
				<form:option value="Terror">Terror</form:option>
				<form:option value="Romance">Romance</form:option>
				<form:option value="Ficção">Ficção</form:option>
			</form:select>
		</div>
	</spring:bind>

	<spring:bind path="ano">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="ano">Ano</form:label>
		<form:input path="ano" type="text" cssClass="form-control" />
		<form:errors path="ano" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="estrelas">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="estrelas">Estrelas</form:label>
		<form:input path="estrelas" type="text" cssClass="form-control" />
		<form:errors path="estrelas" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="diretor">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="diretor">Diretor</form:label>
		<br>
		<form:select path="diretor" cssClass="selectpicker">
			<form:options itemLabel="nome" itemValue="id" items="${celebridades}" />
		</form:select>
	</div>
	</spring:bind>

	<div class="input-field col s12">
		<label>Capa</label>
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

