<%
/* IMPLEMENTAR O ENVIO DE E-MAIL COM O request.getParameter("email"); */ 
%>
<script>
	alert(<% request.getParameter("email"); %>);
	alert('E-mail enviado com sucesso!');
	location.href="/index.jsp";
</script>