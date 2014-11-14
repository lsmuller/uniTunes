<%@page import="br.unisinos.unitunes.service.EmailService"%>
<%

	String emailAddress = request.getParameter("email");

	if (emailAddress.isEmpty() || emailAddress==null) {
		out.println("Ops...");
	} else { 	
		EmailService.sendPasswordRecoveryMail(emailAddress);
	}

%>

<script>
	alert(<% request.getParameter("email"); %>);
	alert('E-mail enviado com sucesso!');
	location.href="/index.jsp";
</script>

