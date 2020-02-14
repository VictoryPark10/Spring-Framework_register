<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<script type="text/javascript">
		window.history.forward();
		function noBack() {}
			window.history.forward();
		
</script> 
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/YSUicon.ico">
<title>연성대학교 수강신청 시스템에 오신것을 환영합니다.</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/signin.css"
	rel="stylesheet">
</head>
<body class="text-center"
	background="${pageContext.request.contextPath}/resources/images/YSU.jpg">
	<form:form commandName="loginCommand" class="form-signin">
		<center>
			<img class="mb-4"
				src="${pageContext.request.contextPath}/resources/images/YSUicon.ico"
				alt="" width="72" height="72">
		</center>
		<h1 class="h3 mb-3 font-weight-bold">
			연성대학교 <br>수강신청 시스템
		</h1>
		<label for="id" class="sr-only">ID</label> <form:input path="id" class="form-control" placeholder="학번"/>
		<label for="password" class="sr-only">Password</label> <form:input type="password"	path="password" class="form-control" placeholder="비밀번호"/>
		<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2018 By Springx3</p>
	</form:form>
</body>
</html>
