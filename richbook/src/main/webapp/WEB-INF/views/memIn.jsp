<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memInsert.do" method="post">
<h2>회원 가입</h2>
<table>
	<tr>
		<td>아이디(e-mail)</td><td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>비밀번호</td><td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<td>이름</td><td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>생년월일</td><td><input type="date" name="birth"></td>
	</tr>
	<tr>
		<td>성별</td>
		<td>
			<input type="radio" name="gen" value="man">남
			<input type="radio" name="gen" value="woman">여
		</td>
	</tr>
	<tr>
		<td>직업</td>
		<td>
			<select name="job">
				<option value="worker">직장인</option>
				<option value="student">학생</option>
				<option value="player">백수</option>
				<option value="etc">기타</option>
			</select>
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="가입"></td>
	</tr>
</table>
${msg}
</form>
</body>
</html>