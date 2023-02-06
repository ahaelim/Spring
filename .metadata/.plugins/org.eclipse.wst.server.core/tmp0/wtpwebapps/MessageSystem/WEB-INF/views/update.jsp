<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="<c:url value='/resources/assets/css/main.css'/>" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		
	</head>
	<style>
	
	</style>
	<body style="text-align: center;">

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<ul class="actions vertical">
						<form action="/message/member/update" method="POST">
							<li><h5>회원정보수정</h5></li>
								<%--1. 현재 로그인 한 사람의 EMAIL를 아래에  li태그 안에 출력하시오.--%>
								
								<%--2. 입력한 정보를 UpdateCon으로 전송하시오.--%>
								<li>${loginM.email }</li>
								<li><input type="password" name="pw" placeholder="PW를 입력하세요" style="width: 500px; margin: 0 auto;"></li>
								<li><input type="text" name="tel"value=${loginM.tel } placeholder="전화번호를 입력하세요" style="width: 500px; margin: 0 auto;"></li>
								<li><input type="text" name="address" value=${loginM.address } placeholder="주소를 입력하세요" style="width: 500px; margin: 0 auto;"></li>
								<li><input type="submit" value="Update" class="button fit" style="width: 500px; margin: 0 auto;"></li>
						</form>
						</ul>
					</nav>			
			</div>
		<!-- Scripts -->
			<script src="<c:url value='/resources/assets/js/jquery.min.js'/>"></script>
			<script src="<c:url value='/resources/assets/js/jquery.scrolly.min.js'/>"></script>
			<script src="<c:url value='/resources/assets/js/jquery.scrollex.min.js'/>"></script>
			<script src="<c:url value='/resources/assets/js/skel.min.js'/>"></script>
			<script src="<c:url value='/resources/assets/js/util.js'/>"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="<c:url value='/resources/assets/js/main.js'/>"></script>
	</body>
</html>

