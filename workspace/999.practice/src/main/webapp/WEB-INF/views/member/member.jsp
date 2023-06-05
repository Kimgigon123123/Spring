<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/signup.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    
</head>
<body>
    <header>
        <div class="heder_left">
            <p><span style="color: rgb(202, 146, 24);">우</span>리동네 <span style="color: rgb(202, 146, 24);">맛</span>집 <span style="color: rgb(202, 146, 24);">소</span>개</p>
        </div>

        <div class="header_right">
            <a href="<c:url value='/login'/>">로그인</a> ｜ <a href="<c:url value='/member'/>">회원가입</a>
        </div>
    </header>
    <aside>
        <ul>
            <li><a href="<c:url value='/'/>">홈</a></li>
            <li><a href="#">공지사항</a></li>
            <li><a href="#">맛집리뷰</a></li>
            <li><a href="#">맛집홍보</a></li>
        </ul>
        

    </aside>


    <div class="signup">
        <h1>회원가입</h1>
        <form>
            <div>
                <label>이름</label>
                <input type="text" name="name">
            </div>
            <div>
                <label>ID</label>
                <input type="text" name="ID">
            </div>
            <div>
                <label>비밀번호</label>
                <input type="password" name="password">
            </div>
            <div>
                <label>비밀번호 확인</label>
                <input type="password" name="confirm_password">
            </div>
            <input type="submit" value="가입하기">
        </form>
    </div>

	<c:forEach items="${ list}" var="vo">	
		
			${vo.name }
			
		
		</c:forEach>





    <footer>
        <div class="footer1_right">
            <a href="#"><img src="resources/image/인스타.png" alt="인스타"></a>
            <a href="#"><img src="resources/image/유튜브.png" alt="유튜브"></a>
            <a href="#"><img src="resources/image/카톡.png" alt="카톡"></a>
    
        </div>
    
    
    
    <div class="footer2">
    
        <p>광주광역시 서구 농성동 010-xxxx-xxxx</p>
        <p>&copy 우리동네맛집소개 ｜ <a href="#">http://www.xxxx.xxxx</a></p>
        <p>tel.062-xxxx-xxxx</p>
    
    </footer>
    </body>
    </html>