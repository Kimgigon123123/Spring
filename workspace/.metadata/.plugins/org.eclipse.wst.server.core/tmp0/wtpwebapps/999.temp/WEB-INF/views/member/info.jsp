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
	<h3>인포화면이예요!</h3>
	<h4>${method }</h4>
	성명 ${name }<br>
	성별 ${gender }<br>
	이메일 ${email }
	<a href="<c:url value='/'/>">처음화면으로</a>
	<a href="<c:url value='/member'/>">회원가입화면으로</a>
	
	<h3>데이터 객체로 해보기</h3>
	
</body>
</html>