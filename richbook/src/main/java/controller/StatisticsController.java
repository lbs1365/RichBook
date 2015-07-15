package controller;

import java.util.ArrayList;
import java.util.List;

import model.Statistics;
import model.StatisticsDay;
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
		int CalstatisticsDay = 0;
		List<Integer> YearList = new ArrayList<Integer>();
		List<Integer> MonthList = new ArrayList<Integer>();
		List<Integer> DayList = new ArrayList<Integer>();
		List<StatisticsMonth> statsMonthList = new ArrayList<StatisticsMonth>();
		List<StatisticsDay> statsDayList = new ArrayList<StatisticsDay>();
		
		int year = cs.inYearMonthListPrintCal("현재 년도");
		
		Statistics stat = new Statistics();
		StatisticsMonth statMonth = new StatisticsMonth();
		StatisticsDay statDay = new StatisticsDay();
		stat.setMemNo(1);
		YearList = stats.StatisticsYearList(stat);
		for(int i=0 ; i<YearList.size(); i++){
			stat.setStatisticsYear(YearList.get(i));
			InYearSum = stats.StatisticsInYearSum(stat);
			ExYearSum = stats.StatisticsExYearSum(stat);
			TotalYearSum = InYearSum - ExYearSum;
			stat.setStatisticsInYearSum(InYearSum);
			stat.setStatisticsExYearSum(ExYearSum);
			stat.setStatisticsTotalYearSum(TotalYearSum);
			MonthList = stats.StatisticsMonthList(stat);			
			for(int j=0 ; j<MonthList.size(); j++){
				if(MonthList.get(j)<10){
					stat.setStatisticsMonth("0"+MonthList.get(j));						
				}else{
					stat.setStatisticsMonth(MonthList.get(j)+"");
				}				
				CalstatisticsDay = cs.statisticsDay(MonthList.get(j), YearList.get(i));
				stat.setStatisticsDay(CalstatisticsDay);
				InMonthSum = stats.StatisticsInMonthSum(stat);
				ExMonthSum = stats.StatisticsExMonthSum(stat);				
				TotalMonthSum = InMonthSum - ExMonthSum;
				statMonth.setStatisticsInMonthSum(InMonthSum);
				statMonth.setStatisticsExMonthSum(ExMonthSum);
				statMonth.setStatisticsTotalMonthSum(TotalMonthSum);
				statMonth.setStatisticsMonthList(MonthList.get(j));								
				statsMonthList.add(statMonth);
				DayList = stats.StatisticsDayList(stat);				
				for(int z=0 ; z<MonthList.size(); z++){
					statDay.setStatisticsDayList(DayList.get(z));
					statsDayList.add(statDay);
				}
				statMonth.setStatisticsDayPrint(statsDayList);
			}
			stat.setStatisticsMonthPrint(statsMonthList);			
		}
		
		
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
