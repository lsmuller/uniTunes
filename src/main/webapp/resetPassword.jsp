<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>...:: UniTunes - Software de Gerenciamento de Mídias ::...</title>
  <link rel="stylesheet" href="css/style.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
  <section class="container">
    <div class="login">
      <h1>Recuperar Senha</h1>
      <form method="post" action="newPassword.jsp">
        <p><input type="text" name="login" value="" placeholder="Email"></p>
        <p class="submit"><input type="submit" name="commit" value="Enviar"></p>
      </form>
    </div>
  </section>
</body>
</html>