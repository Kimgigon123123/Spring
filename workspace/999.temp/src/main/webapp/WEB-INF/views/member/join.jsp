<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입 화면</h3>
	<form action = "joinRequest" method = "post">
	<table border='1'>
	<tr>
		<th>성명</th><td><input type="text" name="name"></td>
	</tr>
	
	<tr>
		<th>성별</th><td><input type="radio" name="gender" value="남자" checked>남자
						<input type="radio" name="gender" value="여자">여자</td>
	
	</tr>
	
	<tr>
		<th>이메일</th><td><input type="text" name="email"></td>
	</tr>
	
	</table>
	<input type="submit" value="회원가입">
	
	
	</form>
</body>
</html>