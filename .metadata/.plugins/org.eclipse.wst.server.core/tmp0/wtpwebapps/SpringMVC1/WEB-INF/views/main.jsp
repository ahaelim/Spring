<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty loginM}">
			<a href="/myapp/join"><button>회원가입</button></a>
			<a href="/myapp/login"><button>로그인</button></a>			
		</c:when>
		<c:otherwise>
			${loginM.nick} 님 환영합니다!	
			
			<a href="/myapp/update"><button>회원정보수정</button></a>
			
			<c:if test="${loginM.id eq 'admin'}">
				<a href="/myapp/member/select"><button>전체회원조회</button></a>		
			</c:if>	
			
			<a href="/myapp/member/logout"><button>로그아웃</button></a>	
		</c:otherwise>
	</c:choose>


</body>
</html>