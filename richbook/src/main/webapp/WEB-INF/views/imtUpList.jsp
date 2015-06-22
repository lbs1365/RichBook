<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">	
	opener.location.reload();
</script>
</head>
<body>
<h2>분류 설정</h2>
${msg }
<form action="ImtUp.do" method="post">
<table border="1">
	<tr>
		<th>No</th><th>분류명</th>
	</tr>
	<c:set var="i" value="1"/>
	<c:forEach items="${imtlist }" var="imtlist">
		<tr>
			<td>${i }</td>				
			<td>${imtlist.imtName }</td>
		</tr>
		<c:set var="i" value="${i+1 }"/>
	</c:forEach>
	<tr>
		<td>${imtlist.size()+1 }</td>
		<td>
			<input type="hidden" name="memNo" value="1">
			<input type="text" name="imtName" required="required">
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="추가"></td>
	</tr>
</table>
</form>
</body>
</html>