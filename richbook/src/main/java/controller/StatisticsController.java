package controller;

import java.util.ArrayList;
import java.util.List;

import model.Statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CalService;
import service.ExService;
import service.InMetService;
import service.InService;
import service.StatisticsService;

@Controller
public class StatisticsController {
	@Autowired
	CalService cs;
	@Autowired
	StatisticsService stats;
	@RequestMapping(value="StatisticsList")
	public String  statisticsList(Model model){
		Statistics stat = new Statistics();
		int year = cs.inYearMonthListPrintCal("현재 년도");
		stat.setMemNo(1);
		stat.setStatisticsYear(year);		
		List<String> StatisticsYear = new ArrayList<String>();
		for(int i=year ; i>1900 ; i--){
			int result = stats.StatisticsList(i);				
			if(result != 0){
				String yearList = i +"";
				StatisticsYear.add(yearList);
			}								
		}
		System.out.println(StatisticsYear);
		model.addAttribute("year",StatisticsYear);	
		return "statistics";
	}
}
