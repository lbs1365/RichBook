package controller;

import java.util.ArrayList;
import java.util.List;

import model.Statistics;

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
		List<Statistics> YearList = new ArrayList<Statistics>();
		List<String> MonthList = new ArrayList<String>();
		List<Long> MonthSumList = new ArrayList<Long>();
		
		int year = cs.inYearMonthListPrintCal("현재 년도");

		for(int i=year ; i>1900 ; i--){
			Statistics stat = new Statistics();
			stat.setMemNo(1);
			stat.setStatisticsYear(i);		
			int YearResult = stats.StatisticsList(stat);				
			if(YearResult != 0){
				if(YearResult == 1){
					InYearSum = stats.StatisticsInYearSum(stat);
					for(int j=1;i<=12;i++){						
						if(j<10){
							stat.setStatisticsMonth("0"+j);						
						}else{
							stat.setStatisticsMonth(j+"");
						}
						if(j==1 || j==3 || j==5 || j==7 || j==8 || j==10 || j==12){
							stat.setStatisticsDay(31);
						}else if(j==2){
							if(i%4!=0 || i%100==0 
									&& i%400!=0){
								stat.setStatisticsDay(28);							
							}else{
								stat.setStatisticsDay(29);
							}
						}else{
							stat.setStatisticsDay(30);
						}
						int MonthResult = stats.InStatisticsMonth(stat);					
						if(MonthResult > 0){						
							MonthList.add(j+"");
							InMonthSum = stats.StatisticsInMonthSum(stat);
							MonthSumList.add(InMonthSum);
						}
					}										
				}else if(YearResult == 2){
					ExYearSum = stats.StatisticsExYearSum(stat);
					for(int j=1;i<=12;i++){						
						if(j<10){
							stat.setStatisticsMonth("0"+j);						
						}else{
							stat.setStatisticsMonth(j+"");
						}
						if(j==1 || j==3 || j==5 || j==7 || j==8 || j==10 || j==12){
							stat.setStatisticsDay(31);
						}else if(j==2){
							if(i%4!=0 || i%100==0 
									&& i%400!=0){
								stat.setStatisticsDay(28);							
							}else{
								stat.setStatisticsDay(29);
							}
						}else{
							stat.setStatisticsDay(30);
						}
						int MonthResult = stats.ExStatisticsMonth(stat);					
						if(MonthResult > 0){						
							MonthList.add(j+"");
							ExMonthSum = stats.StatisticsExMonthSum(stat);
							MonthSumList.add(ExMonthSum);
						}
					}
				}else if(YearResult == 3){
					InYearSum = stats.StatisticsInYearSum(stat);
					ExYearSum = stats.StatisticsExYearSum(stat);
					for(int j=1;j<=12;j++){						
						if(j<10){
							stat.setStatisticsMonth("0"+j);						
						}else{
							stat.setStatisticsMonth(j+"");
						}
						if(j==1 || j==3 || j==5 || j==7 || j==8 || j==10 || j==12){
							stat.setStatisticsDay(31);
						}else if(j==2){
							if(i%4!=0 || i%100==0 
									&& i%400!=0){
								stat.setStatisticsDay(28);							
							}else{
								stat.setStatisticsDay(29);
							}
						}else{
							stat.setStatisticsDay(30);
						}
						int MonthResultIn = stats.InStatisticsMonth(stat);
						int MonthResultEx = stats.ExStatisticsMonth(stat);						
						if(MonthResultIn > 0 && MonthResultEx > 0){						
							MonthList.add(j+"");
							InMonthSum = stats.StatisticsInMonthSum(stat);
							ExMonthSum = stats.StatisticsExMonthSum(stat);
							MonthSumList.add(InMonthSum);
							MonthSumList.add(ExMonthSum);
						}else if(MonthResultIn > 0){
							MonthList.add(j+"");
							InMonthSum = stats.StatisticsInMonthSum(stat);
							MonthSumList.add(InMonthSum);
						}else if(MonthResultEx > 0){
							MonthList.add(j+"");
							ExMonthSum = stats.StatisticsExMonthSum(stat);
							MonthSumList.add(ExMonthSum);
						}						
					}
				}				
				TotalYearSum = InYearSum - ExYearSum;
				stat.setStatisticsInYearSum(InYearSum);
				stat.setStatisticsExYearSum(ExYearSum);
				stat.setStatisticsTotalYearSum(TotalYearSum);
				stat.setStatisticsMonthPrint(MonthList);
				stat.setStatisticsMonthSum(MonthSumList);
				YearList.add(stat);
			}
		}		
		model.addAttribute("statisticsYearList",YearList);	
		return "statistics";
	}
}
