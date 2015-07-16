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
			var index = $(this).attr('id');
			for(var i = 0; i<=index; i++){
				alert($(this).attr('id'));
				$(this).next().css('display', 'none');		
			};			
		});
	});	
</script>
</head>
<body>
<table style="width: 100%" border="1">
	<tr>
		<td>날 짜</td><td>총 수입</td><td>총 지출</td><td>합 계</td><td colspan="4"></td>
	</tr>	
	<c:set var="TotalSum" value="0"/>
	<c:set var="index" value="${statsList.size() }"/>
	<c:forEach var="statsList"  items="${statsList }">		
		<tr class="statisticsYear" id="${index }">				
			<td>${statsList.statisticsYear}년도 ▼</td>
			<td><fmt:formatNumber pattern="#,###">${statsList.statisticsInYearSum}</fmt:formatNumber> 원</td>
			<td><fmt:formatNumber pattern="#,###">${statsList.statisticsExYearSum}</fmt:formatNumber> 원</td>
			<td>
			  	<fmt:formatNumber pattern="#,###">${statsList.statisticsTotalYearSum}</fmt:formatNumber> 원
			  	<c:set var="TotalSum"  value="${TotalSum + statsList.statisticsTotalYearSum}"/>
			</td>
			<td colspan="4" width="50%"></td>		    		   	 
		</tr>							
		<c:forEach var="MonthList"  items="${statsList.statisticsMonthPrint }">
			<tr class = "statisticsMonth">
				<td align="center">${MonthList.statisticsMonthList } 월 ▼</td>
				<td><fmt:formatNumber pattern="#,###">${MonthList.statisticsInMonthSum }</fmt:formatNumber> 원</td>
				<td><fmt:formatNumber pattern="#,###">${MonthList.statisticsExMonthSum }</fmt:formatNumber> 원</td>
				<td><fmt:formatNumber pattern="#,###">${MonthList.statisticsTotalMonthSum }</fmt:formatNumber> 원</td>
				<td colspan="4" width="50%"></td>
			</tr>			
			<c:forEach var="DayList"  items="${MonthList.statisticsDayPrint }">
				<tr>
					<td align="right">${DayList.statisticsDayList} 일 ▼</td>
					<td><fmt:formatNumber pattern="#,###">${DayList.statisticsInDaySum }</fmt:formatNumber> 원</td>
					<td><fmt:formatNumber pattern="#,###">${DayList.statisticsExDaySum }</fmt:formatNumber> 원</td>
					<td><fmt:formatNumber pattern="#,###">${DayList.statisticsTotalDaySum }</fmt:formatNumber> 원</td>
					<td colspan="4" width="50%"></td>
				</tr>
				
				<c:forEach var="statisticsList"  items="${DayList.statisticsList }">
					<tr>
					<c:if test="${statisticsList.inSum != 0}">
						<td colspan="4" align="center">상세 수입 ▼</td>
					</c:if>
					<c:if test="${statisticsList.inSum == 0}">
						<td colspan="4"></td>
					</c:if>	
					<c:if test="${statisticsList.exSum != 0}">
						<td colspan="4" align="center">상세 지출 ▼</td>
					</c:if>
					<c:if test="${statisticsList.exSum == 0}">
						<td colspan="4"></td>
					</c:if>	
					</tr>
					<tr>
					<c:if test="${statisticsList.inSum != 0}">
						<td>분 류</td>
						<td>금 액</td>
						<td>내 역</td>
						<td>기 타</td>
					</c:if>	
					<c:if test="${statisticsList.inSum == 0}">
						<td colspan="4" width="50%"></td>						
					</c:if>	
					<c:if test="${statisticsList.exSum != 0}">
						<td>분 류</td>
						<td>금 액</td>
						<td>내 역</td>
						<td>기 타</td>
					</c:if>
					<c:if test="${statisticsList.exSum == 0}">
						<td colspan="4" width="50%"></td>						
					</c:if>								
					</tr>
					<tr>
						<td>${statisticsList.imtName }</td>
						<td>
							<c:if test="${statisticsList.inSum != 0}">						
								<fmt:formatNumber pattern="#,###">${statisticsList.inSum }</fmt:formatNumber> 
							</c:if>
						</td>
						<td>${statisticsList.inCon }</td>
						<td>${statisticsList.inEtc }</td>
						<td>${statisticsList.emtName }</td>
						<td>
							<c:if test="${statisticsList.exSum != 0}">
								<fmt:formatNumber pattern="#,###">${statisticsList.exSum }</fmt:formatNumber> 원
							</c:if>
						</td>
						<td>${statisticsList.exCon }</td>
						<td>${statisticsList.exEtc }</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</c:forEach>	
	</c:forEach>
	<tr>
		<td colspan="4" width="50%"></td>			
		<td colspan="3" align="right">총 자산 : </td>
		<td><fmt:formatNumber pattern="#,###">${TotalSum }</fmt:formatNumber> 원</td>
	</tr>	
</table>		
</body>
</html>