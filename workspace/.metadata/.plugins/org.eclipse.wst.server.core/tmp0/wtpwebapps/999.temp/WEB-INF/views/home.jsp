<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div><a href="<c:url value='/first'/>">안녕</a></div>
<div><a href="<c:url value='/table'/>">테이블테스트</a></div>
<div><a href="<c:url value='/member'/>">회원가입</a></div>
</body>
</html>
