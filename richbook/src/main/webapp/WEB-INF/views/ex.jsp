<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript">
	$(function(){
		$('.exDel').css('cursor', 'pointer');
		$('.exDel').click(function() {
			var exNo = $(this).attr('id');
			location.href='ExDel.do?exNo='+exNo;
		});
		$('.exDate').css('cursor', 'pointer');
		$('.exDate').click(function() {
			var exSort = $(this).attr('class');
			var exArr = $(this).attr('id');			
			var exListPrint = $(':radio[name="exListPrint"]:checked').val();		
			location.href='Ex.do?exArr='+exArr+'&exSort='+exSort+'&exListPrint='+exListPrint;
		});
		$('.emtNo').css('cursor', 'pointer');
		$('.emtNo').click(function() {
			var exSort = $(this).attr('class');
			var exArr = $(this).attr('id');
			var exListPrint = $(':radio[name="exListPrint"]:checked').val();
			location.href='Ex.do?exArr='+exArr+'&exSort='+exSort+'&exListPrint='+exListPrint;
		});	
		$('.exSum').css('cursor', 'pointer');
		$('.exSum').click(function() {
			var exSort = $(this).attr('class');
			var exArr = $(this).attr('id');
			var exListPrint = $(':radio[name="exListPrint"]:checked').val();
			location.href='Ex.do?exArr='+exArr+'&exSort='+exSort+'&exListPrint='+exListPrint;
		});	
		$('.exCon').css('cursor', 'pointer');
		$('.exCon').click(function() {
			var exSort = $(this).attr('class');
			var exArr = $(this).attr('id');	
			var exListPrint = $(':radio[name="exListPrint"]:checked').val();
			location.href='Ex.do?exArr='+exArr+'&exSort='+exSort+'&exListPrint='+exListPrint;
		});
		$(':radio[name="exListPrint"]').click(function() {
			var exListPrint = $(this).val();
			location.href='Ex.do?exListPrint='+exListPrint;
		});
	});	
</script>
</head>
<body>
	<h2>지출</h2>	
	<input type="radio" name="exListPrint" value="All" 
		<c:if test="${ex.exListPrint == null || ex.exListPrint.equals('All')}">
		checked="checked"</c:if>>전체
	<input type="radio" name="exListPrint" value="Week"
		<c:if test="${ex.exListPrint.equals('Week')}">
		checked="checked"</c:if>>7일
	<input type="radio" name="exListPrint" value="Month" 
		<c:if test="${ex.exListPrint.equals('Month')}">
		checked="checked"</c:if>>30일
	<input type="radio" name="exListPrint" value="ThreeMonth" 
		<c:if test="${ex.exListPrint.equals('ThreeMonth')}">
		checked="checked"</c:if>>90일
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
	<a href="#"	onclick="window.open('EmtUpList.do','분류 설정','width=800,height=800')">분류 설정</a>
	<br>			  
	<form action="ExInsert.do" method="post">
		<table border="1">
			<tr>
				<th>No</th>				
				<c:if test="${ex.exSort == null || ex.exSort.equals('exDate')}">
					<th>
						<c:if test="${ex.exArr == null}">
							<div class="exDate" id="Asc">날짜 ▼</div>
						</c:if>
						<c:if test="${ex.exArr.equals('Desc')}">
							<div class="exDate" id="Asc">날짜 ▼</div>
						</c:if>
						<c:if test="${ex.exArr.equals('Asc')}">
							<div class="exDate" id="Desc">날짜 ▲</div>
						</c:if>						
					</th>
					<th><div class="emtNo" id="Desc">분류</div></th>
					<th><div class="exSum" id="Desc">금액</div></th>
					<th><div class="exCon" id="Desc">내역</div></th>			
				</c:if>								
				<c:if test="${ex.exSort.equals('emtNo')}">
					<th><div class="exDate" id="Desc">날짜</div></th>
					<th>
						<c:if test="${ex.exArr.equals('Desc')}">
							<div class="emtNo" id="Asc">분류 ▼</div>
						</c:if>
						<c:if test="${ex.exArr.equals('Asc')}">
							<div class="emtNo" id="Desc">분류 ▲</div>
						</c:if>
					</th>
					<th><div class="exSum" id="Desc">금액</div></th>
					<th><div class="exCon" id="Desc">내역</div></th>			
				</c:if>
				<c:if test="${ex.exSort.equals('exSum')}">
					<th><div class="exDate" id="Desc">날짜</div></th>	
					<th><div class="emtNo" id="Desc">분류</div></th>		
					<th>
						<c:if test="${ex.exArr.equals('Desc')}">
							<div class="exSum" id="Asc">금액 ▼</div>
						</c:if>
						<c:if test="${ex.exArr.equals('Asc')}">
							<div class="exSum" id="Desc">금액 ▲</div>
						</c:if>
					</th>
					<th><div class="exCon" id="Desc">내역</div></th>
				</c:if>
				<c:if test="${ex.exSort.equals('exCon')}">
					<th><div class="exDate" id="Desc">날짜</div></th>
					<th><div class="emtNo" id="Desc">분류</div></th>
					<th><div class="exSum" id="Desc">금액</div></th>
					<th>
						<c:if test="${ex.exArr.equals('Desc')}">
							<div class="exCon" id="Asc">내역 ▼</div>
						</c:if>
						<c:if test="${ex.exArr.equals('Asc')}">
							<div class="exCon" id="Desc">내역 ▲</div>
						</c:if>
					</th>
				</c:if>
				<th>기타</th>				
				<th>삭제</th>
			</tr>
			<c:set var="i" value="${exlist.size() }" />			
			<c:forEach var="exlist" items="${exlist }">
				<tr>
					<td>${i }</td>
					<td>
						<fmt:parseDate value="${exlist.exDate }" pattern ="yyyy-MM-dd" var="date"/>						
						<fmt:formatDate value="${date}" pattern="yyyy-MM-dd" />
					</td>
					<td><c:forEach var="emtlist" items="${emtlist }">
							<c:if test="${exlist.emtNo == emtlist.emtNo }">${emtlist.emtName }</c:if>
						</c:forEach></td>
					<td><fmt:formatNumber pattern="#,###">${exlist.exSum }</fmt:formatNumber>원</td>
					<td>${exlist.exCon }</td>
					<td>${exlist.exEtc }</td>					
					<td align="center"><div class="exDel" id="${exlist.exNo}">x</div></td>
				</tr>
				<c:set var="i" value="${i-1 }" />				
			</c:forEach>
			<tr>
				<td>입력</td>
				<td><input type="date" name="exDate" required="required"></td>
				<td><select name="emtNo">
						<c:forEach var="emtlist" items="${emtlist }">
							<option value="${emtlist.emtNo }">${emtlist.emtName }</option>
						</c:forEach>
				</select></td>
				<td><input type="number" name="exSum" min="0" required="required"></td>
				<td><input type="text" name="exCon" required="required"></td>
				<td><input type="text" name="exEtc"></td>
				<td><input type="submit" value="추가"></td>
			</tr>			
		</table>		
	</form>	
</body>
</html>