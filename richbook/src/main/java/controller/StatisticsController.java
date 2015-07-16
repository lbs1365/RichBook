package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Statistics;
import model.StatisticsDay;
import model.StatisticsList;
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
	public String statisticsList(Statistics statisticsPageing, Model model){
		long InYearSum = 0;
		long ExYearSum = 0;
		long TotalYearSum = 0;			
		long InMonthSum = 0;
		long ExMonthSum = 0;
		long TotalMonthSum = 0;
		long InDaySum = 0;
		long ExDaySum = 0;
		long TotalDaySum = 0;
		int CalstatisticsDay = 0;
		List<Integer> YearList = new ArrayList<Integer>();
		List<Integer> MonthList = new ArrayList<Integer>();
		List<Integer> DayList = new ArrayList<Integer>();
		List<Statistics> statisticsList = new ArrayList<Statistics>();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DATE);
		Statistics stat = new Statistics();		
		stat.setMemNo(1);
		YearList = stats.StatisticsYearList(stat);
		
		for(int i=0 ; i<YearList.size(); i++){
			Statistics statList = new Statistics();
			statList.setMemNo(1);
			statList.setStatisticsYear(YearList.get(i));
			InYearSum = stats.StatisticsInYearSum(statList);
			ExYearSum = stats.StatisticsExYearSum(statList);
			TotalYearSum = InYearSum - ExYearSum;
			statList.setStatisticsInYearSum(InYearSum);
			statList.setStatisticsExYearSum(ExYearSum);
			statList.setStatisticsTotalYearSum(TotalYearSum);			
			MonthList = stats.StatisticsMonthList(statList);			
			List<StatisticsMonth> statsMonthList = new ArrayList<StatisticsMonth>();					
				for(int j=0 ; j<MonthList.size(); j++){
					StatisticsMonth statMonth = new StatisticsMonth();
					if(MonthList.get(j)<10){
						statList.setStatisticsMonth("0"+MonthList.get(j));						
					}else{
						statList.setStatisticsMonth(MonthList.get(j)+"");
					}				
					CalstatisticsDay = cs.statisticsDay(MonthList.get(j), YearList.get(i));
					statList.setStatisticsDay(CalstatisticsDay);
					InMonthSum = stats.StatisticsInMonthSum(statList);
					ExMonthSum = stats.StatisticsExMonthSum(statList);				
					TotalMonthSum = InMonthSum - ExMonthSum;
					statMonth.setStatisticsInMonthSum(InMonthSum);
					statMonth.setStatisticsExMonthSum(ExMonthSum);
					statMonth.setStatisticsTotalMonthSum(TotalMonthSum);
					statMonth.setStatisticsMonthList(MonthList.get(j));			
					DayList = stats.StatisticsDayList(statList);				
					List<StatisticsDay> statsDayList = new ArrayList<StatisticsDay>();
					for(int z=0 ; z<DayList.size(); z++){
						StatisticsDay statDay = new StatisticsDay();
						List<StatisticsList> statisticsDayList = new ArrayList<StatisticsList>();					
						statList.setStatisticsDay(DayList.get(z));					
						InDaySum = stats.StatisticsInDaySum(statList);
						ExDaySum = stats.StatisticsExDaySum(statList);				
						TotalDaySum = InDaySum - ExDaySum;
						statDay.setStatisticsDayList(DayList.get(z));
						statDay.setStatisticsInDaySum(InDaySum);
						statDay.setStatisticsExDaySum(ExDaySum);
						statDay.setStatisticsTotalDaySum(TotalDaySum);
						statisticsDayList = stats.StatisticsList(statList);
						statDay.setStatisticsList(statisticsDayList);					
						statsDayList.add(statDay);					
					}
					statMonth.setStatisticsDayPrint(statsDayList);
					statsMonthList.add(statMonth);
				}			
				statList.setStatisticsMonthPrint(statsMonthList);			
				statisticsList.add(statList);		
		}	
		model.addAttribute("statsList",statisticsList);		
		return "statistics";
	}
}
