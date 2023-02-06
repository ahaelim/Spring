<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Spring Book</h2>
  <div class="panel panel-default">
    <div class="panel-heading">
    	SMHRD 도서관
    </div>
    <div class="panel-body">
    	<table class="table table-hover table-bordered">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작가</td>
				<td>출판사</td>
				<td>ISBN</td>
				<td>보유도서</td>
			</tr>
			
			<!-- 반복문으로 보유한 도서만큼 출력 -->
			<tr>
				<td>책 번호(시퀀스)</td>
				<td>책 제목</td>
				<td>작가</td>
				<td>출판사</td>
				<td>isbn</td>
				<td>보유도서 수</td>
				<td><button type="button" class="btn btn-success btn-sm" onclick="삭제링크">삭제</button></td>
			</tr>

			<tr>
				<td colspan="5">
					<button class="btn btn-info btn-sm" onclick="loadList()">Ajax로 리스트 불러오기</button>
				</td>
			</tr>
		</table> 
    </div>
    <div class="panel-body" id="list"></div>
    <div class="panel-footer">SMHRD 도서관</div>
  </div>
</div>

<script>
	function loadList(){

	}
	function htmlView(data){
		var result = "<table class='table table-boarded taber-hover'>";
		result += "<tr>";
		result += "<td>번호</td>";
		result += "<td>제목</td>";
		result += "<td>작가</td>";
		result += "<td>출판사</td>";
		result += "<td>ISBN</td>";
		result += "<td>보유도서</td>";
		result += "</tr>";
		
		result += "</table>";
		
		
		
	} 
</script>
</body>
</html>





