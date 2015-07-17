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
		$('.statisticsMonth').css('cursor', 'pointer');
		$('.statisticsDay').css('cursor', 'pointer');
		$('.statisticsYear').click(function() {			
			var MonthIndex = $(this).attr('id');
			var MonthIndex2 = parseInt(MonthIndex)-1;
			var MonthEnd =	$('.statisticsYearEnd').eq(MonthIndex2).attr('id');			
			var MonthStart = $('.statisticsYearStart').eq(MonthIndex2).attr('id');			
			var MonthTotal = parseInt(MonthEnd) - parseInt(MonthStart);
			var thisIndex = $(this).index();
			alert(thisIndex);
			var startIndex = parseInt(thisIndex)+1;
			alert(startIndex);
			var nextIndex = $('.statisticsYear').eq(startIndex).index();
			alert(nextIndex);
			var dayStart = 0;
			var dayEnd = 31;
			var dayListStart = 0;
			var dayListEnd = 30;						 
			for(var i=MonthTotal; i<MonthEnd; i++){
				if($('.statisticsMonth:eq('+i+')').is(':hidden')){
					$('.statisticsMonth').eq(i).show();					
				}else{
					$('.statisticsMonth').eq(i).hide();					
					if(nextIndex == null){
						$(this).nextAll().hide();
					}else{
						for(var j=startIndex; j<nextIndex; j++){
							$('tr').eq(j).hide();						
						};	
					}											
				}
			};
		});
		$('.statisticsMonth').click(function() {			
			var thisIndex = $(this).index();
			var dayStartIndex = parseInt(thisIndex)+1;
			var dayStart =$(this).attr('title');						
			var dayTotal = parseInt(thisIndex) + parseInt(dayStart)*4;			
			var dayListStart = 0;
			var dayListEnd = 30;													
				for(var j=dayStartIndex; j<=dayTotal; j++){
					if($('tr:eq('+j+')').is(':hidden')){
						$('tr').eq(j).show();
					}else{
						$('tr').eq(j).hide();
					}
					for(var z=dayListStart; z<dayListEnd; z++){
						$('.statisticsDayListSub1').eq(z).hide();
						$('.statisticsDayListSub2').eq(z).hide();
						$('.statisticsDayListCon').eq(z).hide();						
					};
				};			
		});
		$('.statisticsDay').click(function() {			
			var dayListIndex = $(this).index();
			var dayListStart = parseInt(dayListIndex) + 1;
			var dayListEnd = parseInt(dayListIndex) + 3 ;		
			for(var z=dayListStart; z<=dayListEnd; z++){					
				if($('tr:eq('+z+')').is(':hidden')){
					$('tr').eq(z).show();					
				}else{
					$('tr').eq(z).hide();					
				}
			};						
		});
	});	
</script>
</head>
<body>
<table style="width: 100%" border="1">
	<tr>
		<td colspan="2">날 짜</td><td colspan="2">총 수입</td><td colspan="2">총 지출</td><td colspan="2">합 계</td>
	</tr>	
	<c:set var="TotalSum" value="0"/>	
	<c:forEach var="statsList"  items="${statsList }">		
		<tr class="statisticsYear" id="${statsList.yearIndex}">
			<td colspan="2">
				<div class="statisticsYearStart" id="${statsList.monthStart}"></div>
				<div class="statisticsYearEnd" id="${statsList.monthEnd}"></div>
				${statsList.statisticsYear}년도 ▼</td>
			<td colspan="2"><fmt:formatNumber pattern="#,###">${statsList.statisticsInYearSum}</fmt:formatNumber> 원</td>
			<td colspan="2"><fmt:formatNumber pattern="#,###">${statsList.statisticsExYearSum}</fmt:formatNumber> 원</td>
			<td colspan="2">
			  	<fmt:formatNumber pattern="#,###">${statsList.statisticsTotalYearSum}</fmt:formatNumber> 원
			  	<c:set var="TotalSum"  value="${TotalSum + statsList.statisticsTotalYearSum}"/>
			</td>					    		   	 
		</tr>							
		<c:forEach var="MonthList"  items="${statsList.statisticsMonthPrint }">
			<tr class = "statisticsMonth" id="${MonthList.dayIndex}" title="${MonthList.dayStart}" tabindex="${MonthList.dayEnd}">
				<td align="center" colspan="2">
					<div class="statisticsMonthStart" id="${MonthList.dayStart}"></div>
					<div class="statisticsMonthEnd" id="${MonthList.dayEnd}"></div>
					${MonthList.statisticsMonthList } 월 ▼
				</td>
				<td colspan="2"><fmt:formatNumber pattern="#,###">${MonthList.statisticsInMonthSum }</fmt:formatNumber> 원</td>
				<td colspan="2"><fmt:formatNumber pattern="#,###">${MonthList.statisticsExMonthSum }</fmt:formatNumber> 원</td>
				<td colspan="2"><fmt:formatNumber pattern="#,###">${MonthList.statisticsTotalMonthSum }</fmt:formatNumber> 원</td>				
			</tr>			
			<c:forEach var="DayList"  items="${MonthList.statisticsDayPrint }">
				<tr class = "statisticsDay" id="${DayList.listIndex}" title="${DayList.listStart}" tabindex="${DayList.listEnd}">
					<td align="right" colspan="2">${DayList.statisticsDayList} 일 ▼</td>
					<td colspan="2"><fmt:formatNumber pattern="#,###">${DayList.statisticsInDaySum }</fmt:formatNumber> 원</td>
					<td colspan="2"><fmt:formatNumber pattern="#,###">${DayList.statisticsExDaySum }</fmt:formatNumber> 원</td>
					<td colspan="2"><fmt:formatNumber pattern="#,###">${DayList.statisticsTotalDaySum }</fmt:formatNumber> 원</td>					
				</tr>
				
				<c:forEach var="statisticsList"  items="${DayList.statisticsList }">
					<tr class = "statisticsDayListSub1">
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
					<tr class = "statisticsDayListSub2">
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
					<tr class = "statisticsDayListCon">
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