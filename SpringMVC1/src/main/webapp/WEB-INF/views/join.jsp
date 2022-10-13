<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- id를 받아서 db로 넘겨주는 컨트롤러가 필요 -->
	<form action="/myapp/member/join" method="POST">
		ID : <input type="text" name="id"><br>
		PW : <input type="password" name="pw"><br>
		NICK : <input type="text" name="nick"><br>
		<input type="submit" value="JOIN">
	</form>
</body>
</html>