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
		System.out.println(statisticsYearList);
		return statisticsYearList;
	}
	public long StatisticsInYearSum(Statistics stat) {		
		return statd.StatisticsInYearSum(stat);
	}
	public long StatisticsExYearSum(Statistics stat) {		
		return statd.StatisticsExYearSum(stat);
	}
	public int InStatisticsMonth(Statistics stat) {
		return statd.InStatisticsMonth(stat);
	}
	public int ExStatisticsMonth(Statistics stat) {
		return statd.ExStatisticsMonth(stat);
	}
	public long StatisticsInMonthSum(Statistics stat) {		
		return statd.StatisticsInMonthSum(stat);
	}
	public long StatisticsExMonthSum(Statistics stat) {		
		return statd.StatisticsExMonthSum(stat);
	}

}
