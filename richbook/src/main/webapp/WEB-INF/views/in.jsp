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
		$('.inDel').css('cursor', 'pointer');
		$('.inDel').click(function() {
			var inNo = $(this).attr('id');			
			location.href='InDel.do?inNo='+inNo;
		});
		$('.inDate').css('cursor', 'pointer');
		$('.inDate').click(function() {
			var inSort = $(this).attr('class');
			var inArr = $(this).attr('id');			
			var inListPrint = $(':radio[name="inListPrint"]:checked').val();
			var inYearMonth_year = $('#inYearMonth_year').val();
			var inYearMonth_month = $('#inYearMonth_month').val();
			var inSearchCho = $('#inSearchCho').val();
			var inSearch = $('#inSearch').val();	
			if(inListPrint != 'YearMonth'){
				location.href='In.do?inArr='+inArr+'&inSort='+inSort+'&inListPrint='+inListPrint;				
			}else if(inSearch != null){
				location.href='In.do?inArr='+inArr+'&inSort='+inSort+'&inListPrint='
						+inListPrint+'&inYearMonth_year='+inYearMonth_year+'&inYearMonth_month='+inYearMonth_month
						+'&inSearch='+inSearch+'&inSearchCho='+inSearchCho;
			}else{
				location.href='In.do?inArr='+inArr+'&inSort='+inSort+'&inListPrint='
				+inListPrint+'&inYearMonth_year='+inYearMonth_year+'&inYearMonth_month='+inYearMonth_month;				
			}
		});
		$('.imtNo').css('cursor', 'pointer');
		$('.imtNo').click(function() {
			var inSort = $(this).attr('class');
			var inArr = $(this).attr('id');
			var inListPrint = $(':radio[name="inListPrint"]:checked').val();
			var inYearMonth_year = $('#inYearMonth_year').val();
			var inYearMonth_month = $('#inYearMonth_month').val();
			var inSearchCho = $('#inSearchCho').val();
			var inSearch = $('#inSearch').val();	
			if(inListPrint != 'YearMonth'){
				location.href='In.do?inArr='+inArr+'&inSort='+inSort+'&inListPrint='+inListPrint;				
			}else if(inSearch != null){
				location.href='In.do?inArr='+inArr+'&inSort='+inSort+'&inListPrint='
				+inListPrint+'&inYearMonth_year='+inYearMonth_year+'&inYearMonth_month='+inYearMonth_month
				+'&inSearch='+inSearch+'&inSearchCho='+inSearchCho;
			}else{
				location.href='In.do?inArr='+inArr+'&inSort='+inSort+'&inListPrint='
						+inListPrint+'&inYearMonth_year='+inYearMonth_year+'&inYearMonth_month='+inYearMonth_month;
			}
		});	
		$('.inSum').css('cursor', 'pointer');
		$('.inSum').click(function() {
			var inSort = $(this).attr('class');
			var inArr = $(this).attr('id');
			var inListPrint = $(':radio[name="inListPrint"]:checked').val();
			var inYearMonth_year = $('#inYearMonth_year').val();
			var inYearMonth_month = $('#inYearMonth_month').val();
			var inSearchCho = $('#inSearchCho').val();
			var inSearch = $('#inSearch').val();	
			if(inListPrint != 'YearMonth'){
				location.href='In.do?inArr='+inArr+'&inSort='+inSort+'&inListPrint='+inListPrint;				
			}else if(inSearch != null){
				location.href='In.do?inArr='+inArr+'&inSort='+inSort+'&inListPrint='
				+inListPrint+'&inYearMonth_year='+inYearMonth_year+'&inYearMonth_month='+inYearMonth_month
				+'&inSearch='+inSearch+'&inSearchCho='+inSearchCho;
			}else{
				location.href='In.do?inArr='+inArr+'&inSort='+inSort+'&inListPrint='
						+inListPrint+'&inYearMonth_year='+inYearMonth_year+'&inYearMonth_month='+inYearMonth_month;
			}
		});	
		$('.inCon').css('cursor', 'pointer');
		$('.inCon').click(function() {
			var inSort = $(this).attr('class');
			var inArr = $(this).attr('id');	
			var inListPrint = $(':radio[name="inListPrint"]:checked').val();
			var inYearMonth_year = $('#inYearMonth_year').val();
			var inYearMonth_month = $('#inYearMonth_month').val();
			var inSearchCho = $('#inSearchCho').val();
			var inSearch = $('#inSearch').val();	
			if(inListPrint != 'YearMonth'){
				location.href='In.do?inArr='+inArr+'&inSort='+inSort+'&inListPrint='+inListPrint;				
			}else if(inSearch != null){
				location.href='In.do?inArr='+inArr+'&inSort='+inSort+'&inListPrint='
				+inListPrint+'&inYearMonth_year='+inYearMonth_year+'&inYearMonth_month='+inYearMonth_month
				+'&inSearch='+inSearch+'&inSearchCho='+inSearchCho;
			}else{
				location.href='In.do?inArr='+inArr+'&inSort='+inSort+'&inListPrint='
						+inListPrint+'&inYearMonth_year='+inYearMonth_year+'&inYearMonth_month='+inYearMonth_month;
			}
		});
		$(':radio[name="inListPrint"]').click(function() {
			var inListPrint = $(this).val();
			location.href='In.do?inListPrint='+inListPrint;
		});
		$('#inYearMonth_year').change(function() {
			var inYearMonth_year = $(this).val();
			var inListPrint = $(':radio[name="inListPrint"]:checked').val();
			location.href='In.do?inListPrint='+inListPrint+'&inYearMonth_year='+inYearMonth_year;
		});		
		$('#inYearMonth_month').change(function() {
			var inYearMonth_month = $(this).val();
			var inYearMonth_year = $('#inYearMonth_year').val();
			var inListPrint = $(':radio[name="inListPrint"]:checked').val();
			location.href='In.do?inListPrint='+inListPrint+'&inYearMonth_year='+inYearMonth_year+'&inYearMonth_month='+inYearMonth_month;
		});
		$('#inSearch').keydown(function(e) {
			var inSearchCho = $('#inSearchCho').val();
			var inSearch = $('#inSearch').val();
			var inListPrint = $(':radio[name="inListPrint"]:checked').val();
			var inYearMonth_year = $('#inYearMonth_year').val();
			var inYearMonth_month = $('#inYearMonth_month').val();
			if(inListPrint != 'YearMonth'){
				if(e.keyCode===13){
					location.href='In.do?inSearch='+inSearch+'&inSearch='+inSearch
							+'&inSearchCho='+inSearchCho;	
				}
			}else{
				if(inYearMonth_month != null){
					if(e.keyCode===13){
						location.href='In.do?inSearch='+inSearch+'&inSearchCho='+inSearchCho
							+'&inListPrint='+inListPrint+'&inYearMonth_year='+inYearMonth_year
							+'&inYearMonth_month='+inYearMonth_month;							
					}				
				}else{
					if(e.keyCode===13){
						location.href='In.do?inSearch='+inSearch+'&inSearchCho='+inSearchCho
						+'&inListPrint='+inListPrint+'&inYearMonth_year='+inYearMonth_year;							
					}
				}
			}
		});
	});	
</script>
</head>
<body>
	<h2>수입</h2>	
	<input type="radio" name="inListPrint" value="All" 
		<c:if test="${in.inListPrint == null || in.inListPrint.equals('All')}">
		checked="checked"</c:if>>전체
	<input type="radio" name="inListPrint" value="Week"
		<c:if test="${in.inListPrint.equals('Week')}">
		checked="checked"</c:if>>7일
	<input type="radio" name="inListPrint" value="Month" 
		<c:if test="${in.inListPrint.equals('Month')}">
		checked="checked"</c:if>>30일
	<input type="radio" name="inListPrint" value="ThreeMonth" 
		<c:if test="${in.inListPrint.equals('ThreeMonth')}">
		checked="checked"</c:if>>90일
	<input type="radio" name="inListPrint" value="YearMonth" 
		<c:if test="${in.inListPrint.equals('YearMonth')}">
		checked="checked"</c:if>>년&amp;월
	<c:if test="${in.inListPrint.equals('YearMonth')}">	
		<select name="inYearMonth_year" id="inYearMonth_year">		
			<c:forEach var="year" items="${year }">
				<option value="${year}" 
				<c:if test="${in.inYearMonth_year == year}">selected="selected"</c:if>
				>${year}</option>
			</c:forEach>
		</select>
		<select name="inYearMonth_month" id="inYearMonth_month">
			<option value="0">월 선택</option>
			<c:forEach var="month" items="${month }">
				<option value="${month}"
				<c:if test="${in.inYearMonth_month == month}">selected="selected"</c:if>
				>${month}월</option>
			</c:forEach>
		</select>
	</c:if>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<select id="inSearchCho">
		<option value="imtName" 
			<c:if test="${in.inSearchCho.equals('imtName')}"> selected="selected"</c:if>
		>분류</option>		
		<option value="inCon"
			<c:if test="${in.inSearchCho.equals('inCon')}"> selected="selected"</c:if>
		>내역</option>
	</select>
	<input type="search" id="inSearch" value="${in.Search}">
	<a href="#"	onclick="window.open('ImtUpList.do','분류 설정','width=800,height=800')">분류 설정</a>
	<br>			
	<form action="InInsert.do" method="post">
		<table border="1">
			<tr>
				<th>No</th>				
				<c:if test="${in.inSort == null || in.inSort.equals('inDate')}">
					<th>
						<c:if test="${in.inArr == null}">
							<div class="inDate" id="Asc">날짜 ▼</div>
						</c:if>
						<c:if test="${in.inArr.equals('Desc')}">
							<div class="inDate" id="Asc">날짜 ▼</div>
						</c:if>
						<c:if test="${in.inArr.equals('Asc')}">
							<div class="inDate" id="Desc">날짜 ▲</div>
						</c:if>						
					</th>
					<th><div class="imtNo" id="Desc">분류</div></th>
					<th><div class="inSum" id="Desc">금액</div></th>
					<th><div class="inCon" id="Desc">내역</div></th>			
				</c:if>								
				<c:if test="${in.inSort.equals('imtNo')}">
					<th><div class="inDate" id="Desc">날짜</div></th>
					<th>
						<c:if test="${in.inArr.equals('Desc')}">
							<div class="imtNo" id="Asc">분류 ▼</div>
						</c:if>
						<c:if test="${in.inArr.equals('Asc')}">
							<div class="imtNo" id="Desc">분류 ▲</div>
						</c:if>
					</th>
					<th><div class="inSum" id="Desc">금액</div></th>
					<th><div class="inCon" id="Desc">내역</div></th>			
				</c:if>
				<c:if test="${in.inSort.equals('inSum')}">
					<th><div class="inDate" id="Desc">날짜</div></th>	
					<th><div class="imtNo" id="Desc">분류</div></th>		
					<th>
						<c:if test="${in.inArr.equals('Desc')}">
							<div class="inSum" id="Asc">금액 ▼</div>
						</c:if>
						<c:if test="${in.inArr.equals('Asc')}">
							<div class="inSum" id="Desc">금액 ▲</div>
						</c:if>
					</th>
					<th><div class="inCon" id="Desc">내역</div></th>
				</c:if>
				<c:if test="${in.inSort.equals('inCon')}">
					<th><div class="inDate" id="Desc">날짜</div></th>
					<th><div class="imtNo" id="Desc">분류</div></th>
					<th><div class="inSum" id="Desc">금액</div></th>
					<th>
						<c:if test="${in.inArr.equals('Desc')}">
							<div class="inCon" id="Asc">내역 ▼</div>
						</c:if>
						<c:if test="${in.inArr.equals('Asc')}">
							<div class="inCon" id="Desc">내역 ▲</div>
						</c:if>
					</th>
				</c:if>
				<th>기타</th>				
				<th>삭제</th>
			</tr>
			<c:set var="i" value="${inlist.size() }" />			
			<c:forEach var="inlist" items="${inlist }">
				<tr>
					<td>${i }</td>
					<td>
						<fmt:parseDate value="${inlist.inDate }" pattern ="yyyy-MM-dd" var="date"/>						
						<fmt:formatDate value="${date}" pattern="yyyy-MM-dd" />
					</td>
					<td><c:forEach var="imtlist" items="${imtlist }">
							<c:if test="${inlist.imtNo == imtlist.imtNo }">${imtlist.imtName }</c:if>
						</c:forEach></td>
					<td><fmt:formatNumber pattern="#,###">${inlist.inSum }</fmt:formatNumber>원</td>
					<td>${inlist.inCon }</td>
					<td>${inlist.inEtc }</td>					
					<td align="center"><div class="inDel" id="${inlist.inNo}">x</div></td>
				</tr>
				<c:set var="i" value="${i-1 }" />				
			</c:forEach>
			<tr>
				<td>입력</td>
				<td><input type="date" name="inDate" required="required"></td>
				<td><select name="imtNo">
						<c:forEach var="imtlist" items="${imtlist }">
							<option value="${imtlist.imtNo }">${imtlist.imtName }</option>
						</c:forEach>
				</select></td>
				<td><input type="number" name="inSum" min="0" required="required"></td>
				<td><input type="text" name="inCon" required="required"></td>
				<td><input type="text" name="inEtc"></td>
				<td><input type="submit" value="추가"></td>
			</tr>			
		</table>		
	</form>		
</body>
</html>