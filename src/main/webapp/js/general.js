$(function() {
	$('#vini').click(function(event) {
		alert('chamou')
		$.ajax({
			url: "/filmes/testeajax",
			success: function() {
				alert('carregou')
			}
		})
		event.preventDefault();
	})
})