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


     <section id="section1">
        <a href="#" class="material-symbols-outlined prev">
            arrow_back_ios
        </a>
        <img src="resources/image/치킨.jpg" alt="캐러셀" class="carousel-image">
        <img src="resources/image/피자.jpg" alt="캐러셀" class="carousel-image">
        <img src="resources/image/짜장면.jpg" alt="캐러셀" class="carousel-image">
        <img src="resources/image/돈까스.webp" alt="캐러셀" class="carousel-image">
        <img src="resources/image/떡볶이.jpg" alt="캐러셀" class="carousel-image">
    
        <a href="#" class="material-symbols-outlined next">
            arrow_forward_ios
        </a>
    
        <div class="carousel_btn">
            <a data-index="0">1</a>
            <a data-index="1">2</a>
            <a data-index="2">3</a>
            <a data-index="3">4</a>
            <a data-index="4">5</a>
        </div>
    </section>

    <section id ="section2">
        <ul>
            <li><h1>공지사항</h1><a href="#">MORE</a><div class="notice">DB연동해야댐</div></li>
            <li><h1>맛집리뷰</h1><a href="#">MORE</a><div class="notice">DB연동해야댐</div></li>
            <li><h1>맛집홍보</h1><a href="#">MORE</a><div class="notice">DB연동해야댐</div></li>
        </ul>
    </section>




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
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            var currentIndex = 0;
            var items = $('.carousel-image');
            var itemAmount = items.length;
    
            function showImage(index) {
                items.hide();
                items.eq(index).show();
            }
    
            function setActiveIndicator(index) {
                $('.carousel_btn a').removeClass('active');
                $('.carousel_btn a[data-index="' + index + '"]').addClass('active');
            }
    
            $('.next').click(function() {
                currentIndex++;
                if (currentIndex >= itemAmount) {
                    currentIndex = 0;
                }
                showImage(currentIndex);
                setActiveIndicator(currentIndex);
            });
    
            $('.prev').click(function() {
                currentIndex--;
                if (currentIndex < 0) {
                    currentIndex = itemAmount - 1;
                }
                showImage(currentIndex);
                setActiveIndicator(currentIndex);
            });
    
            $('.carousel_btn a').click(function() {
                var index = $(this).data('index');
                currentIndex = index;
                showImage(currentIndex);
                setActiveIndicator(currentIndex);
            });
    
            showImage(currentIndex);
            setActiveIndicator(currentIndex);
        });
    </script>

</body>


</html>