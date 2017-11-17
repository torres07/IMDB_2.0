<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form method="post" action="${url_base}/efetuar_login">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<label for="login">Login:</label> <input type="text"
			class="form-control" name="login">
	</div>

	<div class="form-group ${status.error ? 'has-error' : ''}">
		<label for="password">Password:</label> <input type="password"
			class="form-control" name="password">
	</div>

	<button type="submit" class="btn btn-default">Login</button>
</form>
