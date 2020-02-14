<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연성대학교 수강신청 설정</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

<STYLE TYPE="text/css">
<!--
.bgcolor1 {
	background-color: #BBDEFB;
}
-->
</STYLE>
</head>
<body>
	<h1 class="bgcolor1">
		<body onresize="parent.resizeTo(1920,1080)"
			onload="parent.resizeTo(1920,1080)">
			<IMG
				SRC="${pageContext.request.contextPath}/resources/images/YSUicon.ico"
				WIDTH="120" ALIGN="MIDDLE">
			<FONT SIZE="8" FACE="Malgun Gothic"> 연성대학교 수강신청 관리</FONT>
	</h1>
	<form action="subreg" method="post">
		<span style="float: right"><input name="logout" type="submit"
			value="로그아웃"> </span>
	</form>
	<form action="admin" method="post">
		<input type="radio" name="setting" value="장바구니"
			<%if ("${setting}" == "장바구니") {%> checked="checked" <%}%> />장바구니</br> <input
			type="radio" name="setting" value="수강신청"
			<%if ("${setting}" == "장바구니") {%> checked="checked" <%}%> />수강신청</br> <input
			type="submit" value="확인">
	</form>
</body>
</html>