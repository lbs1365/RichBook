package controller;

import java.util.ArrayList;
import java.util.List;

import model.Statistics;
import model.StatisticsMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CalService;
import service.StatisticsService;

@Controller
public class StatisticsController {
	@Autowired
	CalService cs;
	@Autowired
	StatisticsService stats;
	@RequestMapping(value="StatisticsList")
	public String  statisticsList(Model model){
		long InYearSum = 0;
		long ExYearSum = 0;
		long TotalYearSum = 0;			
		long InMonthSum = 0;
		long ExMonthSum = 0;
		long TotalMonthSum = 0;
		List<Integer> YearList = new ArrayList<Integer>();
		List<StatisticsMonth> MonthList = new ArrayList<StatisticsMonth>();		
		
		int year = cs.inYearMonthListPrintCal("현재 년도");
		
		Statistics stat = new Statistics();
		
		stat.setMemNo(1);
		YearList = stats.StatisticsYearList(stat);
		
		
		/*for(int i=year ; i>1900 ; i--){
			Statistics stat = new Statistics();
			stat.setMemNo(1);
			stat.setStatisticsYear(i);		
			int YearResult = stats.StatisticsList(stat);				
			if(YearResult != 0){
				if(YearResult == 1){
					InYearSum = stats.StatisticsInYearSum(stat);
					for(int j=1;i<=12;i++){
						StatisticsMonth statmonth = new StatisticsMonth();
						if(j<10){
							stat.setStatisticsMonth("0"+j);						
						}else{
							stat.setStatisticsMonth(j+"");
						}
						int statisticsDay = cs.statisticsDay(j, i);
						stat.setStatisticsDay(statisticsDay);						
						int MonthResult = stats.InStatisticsMonth(stat);					
						if(MonthResult > 0){						
							statmonth.setStatisticsMonthList(j+"");
							InMonthSum = stats.StatisticsInMonthSum(stat);
							TotalMonthSum = InMonthSum - ExMonthSum;
							statmonth.setStatisticsInMonthSum(InMonthSum);
							statmonth.setStatisticsTotalMonthSum(TotalMonthSum);
							MonthList.add(statmonth);
							
						}
					}										
				}else if(YearResult == 2){
					ExYearSum = stats.StatisticsExYearSum(stat);
					for(int j=1;i<=12;i++){
						StatisticsMonth statmonth = new StatisticsMonth();
						if(j<10){
							stat.setStatisticsMonth("0"+j);						
						}else{
							stat.setStatisticsMonth(j+"");
						}
						int statisticsDay = cs.statisticsDay(j, i);
						stat.setStatisticsDay(statisticsDay);		
						int MonthResult = stats.ExStatisticsMonth(stat);					
						if(MonthResult > 0){						
							statmonth.setStatisticsMonthList(j+"");
							ExMonthSum = stats.StatisticsExMonthSum(stat);
							TotalMonthSum = InMonthSum - ExMonthSum;
							statmonth.setStatisticsExMonthSum(ExMonthSum);
							statmonth.setStatisticsTotalMonthSum(TotalMonthSum);
							MonthList.add(statmonth);
						}
					}
				}else if(YearResult == 3){
					InYearSum = stats.StatisticsInYearSum(stat);
					ExYearSum = stats.StatisticsExYearSum(stat);
					for(int j=1;j<=12;j++){
						StatisticsMonth statmonth = new StatisticsMonth();
						if(j<10){
							stat.setStatisticsMonth("0"+j);						
						}else{
							stat.setStatisticsMonth(j+"");
						}
						int statisticsDay = cs.statisticsDay(j, i);
						stat.setStatisticsDay(statisticsDay);		
						int MonthResultIn = stats.InStatisticsMonth(stat);
						int MonthResultEx = stats.ExStatisticsMonth(stat);						
						if(MonthResultIn > 0 && MonthResultEx > 0){						
							statmonth.setStatisticsMonthList(j+"");
							InMonthSum = stats.StatisticsInMonthSum(stat);
							ExMonthSum = stats.StatisticsExMonthSum(stat);
							TotalMonthSum = InMonthSum - ExMonthSum;
							statmonth.setStatisticsInMonthSum(InMonthSum);
							statmonth.setStatisticsExMonthSum(ExMonthSum);
							statmonth.setStatisticsTotalMonthSum(TotalMonthSum);
							MonthList.add(statmonth);
						}else if(MonthResultIn > 0){
							statmonth.setStatisticsMonthList(j+"");
							InMonthSum = stats.StatisticsInMonthSum(stat);
							TotalMonthSum = InMonthSum - ExMonthSum;
							statmonth.setStatisticsInMonthSum(InMonthSum);
							statmonth.setStatisticsTotalMonthSum(TotalMonthSum);
							MonthList.add(statmonth);
						}else if(MonthResultEx > 0){
							statmonth.setStatisticsMonthList(j+"");
							ExMonthSum = stats.StatisticsExMonthSum(stat);
							TotalMonthSum = InMonthSum - ExMonthSum;
							statmonth.setStatisticsExMonthSum(ExMonthSum);
							statmonth.setStatisticsTotalMonthSum(TotalMonthSum);
							MonthList.add(statmonth);
						}						
					}
				}				
				TotalYearSum = InYearSum - ExYearSum;
				stat.setStatisticsInYearSum(InYearSum);
				stat.setStatisticsExYearSum(ExYearSum);
				stat.setStatisticsTotalYearSum(TotalYearSum);
				stat.setStatisticsMonthPrint(MonthList);			
				YearList.add(stat);
			}
		}		*/
		model.addAttribute("YearList",YearList);	
		return "statistics";
	}
}
