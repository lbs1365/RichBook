package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CalService;
import service.ExService;
import service.InMetService;
import service.InService;

@Controller
public class StatisticsController {
	@Autowired
	InService ins;
	@Autowired
	ExService exs;
	@Autowired
	InMetService imts;
	@Autowired
	CalService cs;
	@RequestMapping(value="StatisticsList")
	public String  statisticsList(Model model){		
				
		return "statistics";
	}
}
