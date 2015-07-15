package service;



import java.util.ArrayList;
import java.util.List;

import model.Statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StatisticsDao;

@Service
public class StatisticsServiceImpl implements StatisticsService{
	@Autowired
	StatisticsDao statd;
	public List<Integer> StatisticsYearList(Statistics stat) {
		List<Statistics> inStatisticsYearList = statd.InStatisticsYearList(stat);
		List<Statistics> exStatisticsYearList = statd.ExStatisticsYearList(stat);
		List<Integer> statisticsYearList = new ArrayList<Integer>();
		int inStatisticsYear;
		int exStatisticsYear;		
		int i = 0;
		int j = 0;
		while(true){
			if(inStatisticsYearList.size() == i && exStatisticsYearList.size() == j){
				break;
			}else if(inStatisticsYearList.size() == i){				
				for(int z=j; z < exStatisticsYearList.size(); z++){
					exStatisticsYear = exStatisticsYearList.get(z).getStatisticsYear();	
					statisticsYearList.add(exStatisticsYear);					
				}
				break;
			}else if(exStatisticsYearList.size() == j){
				for(int z=i; z < inStatisticsYearList.size(); z++){		
					inStatisticsYear = inStatisticsYearList.get(z).getStatisticsYear();
					statisticsYearList.add(inStatisticsYear);					
				}
				break;
			}else{				
				inStatisticsYear = inStatisticsYearList.get(i).getStatisticsYear();
				exStatisticsYear = exStatisticsYearList.get(j).getStatisticsYear();			
				if(inStatisticsYear > exStatisticsYear){
					statisticsYearList.add(inStatisticsYear);
					i++;
				}else if(inStatisticsYear == exStatisticsYear){
					statisticsYearList.add(inStatisticsYear);
					i++;
					j++;
				}else if(inStatisticsYear < exStatisticsYear){
					statisticsYearList.add(exStatisticsYear);
					j++;
				}				
			}
		}		
		return statisticsYearList;
	}	
	public long StatisticsInYearSum(Statistics stat) {		
		return statd.StatisticsInYearSum(stat);
	}
	public long StatisticsExYearSum(Statistics stat) {		
		return statd.StatisticsExYearSum(stat);
	}
	public List<Integer> StatisticsMonthList(Statistics stat) {
		List<Statistics> inStatisticsMonthList = statd.InStatisticsMonthList(stat);
		List<Statistics> exStatisticsMonhtList = statd.ExStatisticsMonhtList(stat);
		List<Integer> statisticsMonthList = new ArrayList<Integer>();
		int inStatisticsMonth;
		int exStatisticsMonth;		
		int i = 0;
		int j = 0;
		while(true){
			if(inStatisticsMonthList.size() == i && exStatisticsMonhtList.size() == j){
				break;
			}else if(inStatisticsMonthList.size() == i){				
				for(int z=j; z < exStatisticsMonhtList.size(); z++){
					exStatisticsMonth = exStatisticsMonhtList.get(z).getStatisticsMonthList();	
					statisticsMonthList.add(exStatisticsMonth);					
				}
				break;
			}else if(exStatisticsMonhtList.size() == j){
				for(int z=i; z < inStatisticsMonthList.size(); z++){		
					inStatisticsMonth = inStatisticsMonthList.get(z).getStatisticsMonthList();
					statisticsMonthList.add(inStatisticsMonth);					
				}
				break;
			}else{				
				inStatisticsMonth = inStatisticsMonthList.get(i).getStatisticsMonthList();
				exStatisticsMonth = exStatisticsMonhtList.get(j).getStatisticsMonthList();		
				if(inStatisticsMonth > exStatisticsMonth){
					statisticsMonthList.add(inStatisticsMonth);
					i++;
				}else if(inStatisticsMonth == exStatisticsMonth){
					statisticsMonthList.add(inStatisticsMonth);
					i++;
					j++;
				}else if(inStatisticsMonth < exStatisticsMonth){
					statisticsMonthList.add(exStatisticsMonth);
					j++;
				}				
			}
		}		
		return statisticsMonthList;
	}	
	public long StatisticsInMonthSum(Statistics stat) {		
		return statd.StatisticsInMonthSum(stat);
	}
	public long StatisticsExMonthSum(Statistics stat) {		
		return statd.StatisticsExMonthSum(stat);
	}	
	public List<Integer> StatisticsDayList(Statistics stat) {		
		List<Statistics> inStatisticsDayList = statd.InStatisticsDayList(stat);
		List<Statistics> exStatisticsDayList = statd.ExStatisticsDayList(stat);
		List<Integer> statisticsDayList = new ArrayList<Integer>();
		int inStatisticsDay;
		int exStatisticsDay;		
		int i = 0;
		int j = 0;
		while(true){
			if(inStatisticsDayList.size() == i && exStatisticsDayList.size() == j){
				break;
			}else if(inStatisticsDayList.size() == i){				
				for(int z=j; z < exStatisticsDayList.size(); z++){
					exStatisticsDay = exStatisticsDayList.get(z).getStatisticsDay();	
					statisticsDayList.add(exStatisticsDay);					
				}
				break;
			}else if(exStatisticsDayList.size() == j){
				for(int z=i; z < inStatisticsDayList.size(); z++){		
					inStatisticsDay = inStatisticsDayList.get(z).getStatisticsDay();
					statisticsDayList.add(inStatisticsDay);					
				}
				break;
			}else{				
				inStatisticsDay = inStatisticsDayList.get(i).getStatisticsDay();
				exStatisticsDay = exStatisticsDayList.get(j).getStatisticsDay();		
				if(inStatisticsDay > exStatisticsDay){
					statisticsDayList.add(inStatisticsDay);
					i++;
				}else if(inStatisticsDay == exStatisticsDay){
					statisticsDayList.add(inStatisticsDay);
					i++;
					j++;
				}else if(inStatisticsDay < exStatisticsDay){
					statisticsDayList.add(exStatisticsDay);
					j++;
				}				
			}
		}		
		System.out.println(statisticsDayList);
		return statisticsDayList;
	}	
	
}
