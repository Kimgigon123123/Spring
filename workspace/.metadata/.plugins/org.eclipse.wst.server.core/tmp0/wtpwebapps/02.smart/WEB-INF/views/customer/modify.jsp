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
	<h3 class="my-4">고객정보수정</h3>
	<form method="post" action="update.cu" autocomplete="off">
	<input type="hidden" name="id" value="${vo.id}" >
		<table class="tb-row">
			<colgroup>
				<col witdh="180px">
				<col>
			</colgroup>
			<tr>
				<th>고객명</th>
				<td><div class="row">
						<div class="col-auto">
							<input type="text" name="name" value="${vo.name }" class="form-control" required>
						</div>
					</div></td>
			</tr>

			<tr>
				<th>성별</th>
				<td><div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender"
							id="gender" value="남성" ${vo.gender eq "남성" ? "checked" : "" }> <label class="form-check-label"
							for="gender">남성</label>
					</div>
					<div class="form-check form-check-inline">
						<label> <input class="form-check-input" type="radio" ${vo.gender eq "여성" ? "checked" : "" }
							name="gender" value="여성">여성
						</label>
					</div></td>
			</tr>

			<tr>
				<th>이메일</th>
				<td><div class="row">
						<div class="col-auto">
							<input type="text" name="email" value="${vo.email }" class="form-control">
						</div>
					</div></td>
			</tr>

			<tr>
				<th>전화번호</th>
				<td><div class="row">
						<div class="col-auto">
							<input type="text" name="phone" value=" ${vo.phone }" class="form-control">
						</div>
					</div></td>
			</tr>
		</table>

		<div class="btn-toolbar gap-2 my-3 justify-content-center">
			<button class="btn btn-primary">저장</button>
			<button type="button" class="btn btn-outline-primary" onclick="location='info.cu?id=${vo.id}'">취소</button>
			<button type="button" class="btn btn-outline-primary" onclick="history.go(-1)">취소</button>
			</div>

	</form>



</body>
</html>