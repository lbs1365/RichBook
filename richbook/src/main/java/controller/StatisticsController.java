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
	public String  statisticsList(int statisticsYearCho,Model model){
		int year = cs.inYearMonthListPrintCal("현재 년도");
		List<Statistics> YearList = new ArrayList<Statistics>();
		for(int i=year ; i>1900 ; i--){
			long InYearSum = 0;
			long ExYearSum = 0;
			long TotalYearSum = 0;
			Statistics stat = new Statistics();
			stat.setMemNo(1);
			stat.setStatisticsYear(i);		
			int result = stats.StatisticsList(stat);				
			if(result != 0){				
				if(result == 1){
					InYearSum = stats.StatisticsInYearSum(stat);										
				}else if(result == 2){
					ExYearSum = stats.StatisticsExYearSum(stat);				
				}else if(result == 3){
					InYearSum = stats.StatisticsInYearSum(stat);
					ExYearSum = stats.StatisticsExYearSum(stat);
				}				
				TotalYearSum = InYearSum - ExYearSum;
				stat.setStatisticsInYearSum(InYearSum);
				stat.setStatisticsExYearSum(ExYearSum);
				stat.setStatisticsTotalYearSum(TotalYearSum);
				YearList.add(stat);
			}
		}		
		model.addAttribute("YearList",YearList);	
		return "statistics";
	}
}
