<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login.do" method="post">
<h2>로그인</h2>
<table>
	<tr>
		<td>아이디(e-mail)</td><td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>비밀번호</td><td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<td><input type="submit" value="확인"></td>
	</tr>
</table>
${msg}
</form>
</body>
</html>