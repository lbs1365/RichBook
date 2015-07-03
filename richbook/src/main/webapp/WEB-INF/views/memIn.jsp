<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript">	
	$(function () {
		/* $('#idChk').click(function() {
			var mail = $('#id').val();
			if(mail.indexOf('@')!=-1){
				window.open('IdEmailChk.do?mailAddr='+mail,'분류 추가','width=1000,height=1000');
				
			}else{
				alert("올바른 e-mail 주소를 입력하세요");
			}
		}); */
		
		/* 	$('#cb').click(function() {
			if($(this).attr('class')!= 'cb'){
				$(this).addClass("cb");		
				window.open('IdEmailChk.do','분류 추가','width=1000,height=1000');
			}else{
				$(this).removeClass("cb");				
			}			
		}); */
	});	
</script>
</head>
<body>
<form action="IdEmailChk.do" method="post">
<h2>회원 가입</h2>
<table>
	<tr>
		<td>아이디(e-mail)</td>
		<td>
		<input type="email" id="id" name="id" value="${id }" required="required">
		<c:if test="${idChk.equals('null') }">
			<input type="submit" id="idChk" value="아이디(이메일확인)">			
		</c:if>				
		<c:if test="${idChk.equals('인증완료') }">
			${idChk}
		</c:if>		
		<!-- <input type="checkbox" id="cb"> -->		
		</td>
	</tr>
	<c:if test="${idChk.equals('인증완료') }">
		<tr>
			<td>비밀번호</td><td><input type="password" name="pw" required="required"></td>
		</tr>
		<tr>
			<td>이름</td><td><input type="text" name="name" required="required"></td>
		</tr>
		<tr>
			<td>생년월일</td><td><input type="date" name="birth" required="required"></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<input type="radio" name="gen" value="man" checked="checked">남
				<input type="radio" name="gen" value="woman">여
			</td>
		</tr>
		<tr>
			<td>직업</td>
			<td>
				<select name="job">
					<option value="worker" selected="selected">직장인</option>
					<option value="student">학생</option>
					<option value="player" selected="selected">백수</option>
					<option value="etc">기타</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="가입"></td>
		</tr>
	</c:if>	
</table>
${msg}
</form>
</body>
</html>