<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>수입</h2>
<form action="InUp.do" method="post">
<table border="1">
	<tr>
		<th>날짜</th><th>분류</th><th>금액</th><th>내역</th><th>기타</th>
	</tr>
	<c:forEach var="inlist" items="${inlist }">
		<tr>
			<td><fmt:formatDate value="${inlist.inDate }" pattern="yyyy-MM-dd"/></td>
			<td>${inlist.imtNo }</td>
			<td>${inlist.inSum }</td>
			<td>${inlist.inCon }</td>
			<td>${inlist.inEtc }</td>
		</tr>
	</c:forEach>
	<tr>
		<td><input type="date" name="inDate" required="required"></td>
		<td>
			<select name="imtNo">
				<c:forEach var="imtlist" items="${imtlist }">
					<option value="${imtlist.imtNo }">${imtlist.imtName }</option>
				</c:forEach>
			</select>
		</td>
		<td><input type="number" name="inSum" required="required"></td>
		<td><input type="text" name="inCon"></td>
		<td><input type="text" name="inEtc"></td>
	</tr>
	<tr>
		<td colspan="5"><input type="submit" value="추가"></td>
	</tr>
</table>
</form>
</body>
</html>