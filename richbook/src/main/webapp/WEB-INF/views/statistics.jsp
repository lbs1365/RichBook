<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript">
	$(function(){
		$('.statisticsYear').css('cursor', 'pointer');
		$('.statisticsYear').click(function() {
			var statisticsYearCho = $(this).attr('id');			
			location.href='StatisticsList.do?statisticsYearCho='+statisticsYearCho;
		});		
	});	
</script>
</head>
<body>
<table style="width: 60%">
	<tr>
		<td>날짜</td><td>총 수입</td><td>총 지출</td><td>total</td>
	</tr>	
	<c:set var="TotalSum" value="0"></c:set>
	<c:forEach var="YearList"  items="${statisticsYearList }">
		<tr class="statisticsYear" id="${YearList.statisticsYear}">				
			<td>${YearList.statisticsYear}년도 ▶</td>
			<td><fmt:formatNumber pattern="#,###">${YearList.statisticsInYearSum}</fmt:formatNumber> 원</td>
			<td><fmt:formatNumber pattern="#,###">${YearList.statisticsExYearSum}</fmt:formatNumber> 원</td>
			<td>
			  	<fmt:formatNumber pattern="#,###">${YearList.statisticsTotalYearSum}</fmt:formatNumber> 원
			  	<c:set var="TotalSum"  value="${TotalSum + YearList.statisticsTotalYearSum}"/>
			</td>		    		   	 
		</tr>
		<c:forEach var="MonthList"  items="${YearList.statisticsMonthPrint }">
			<tr>
				<td align="center">${MonthList } 월</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:forEach>
	</c:forEach>
	<tr>		
		<td colspan="3" align="right">총 자산 : </td>
		<td><fmt:formatNumber pattern="#,###">${TotalSum }</fmt:formatNumber> 원</td>
	</tr>	
</table>
</body>
</html>