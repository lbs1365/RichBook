package service;



import java.util.ArrayList;
import java.util.List;

import model.Statistics;
import model.StatisticsList;

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
		return statisticsDayList;
	}
	public long StatisticsInDaySum(Statistics stat) {		
		return statd.StatisticsInDaySum(stat);
	}
	public long StatisticsExDaySum(Statistics stat) {		
		return statd.StatisticsExDaySum(stat);
	}
	public List<StatisticsList> StatisticsList(Statistics stat) {		
		List<Statistics> inStatisticsList = statd.InStatisticsList(stat);
		List<Statistics> exStatisticsList = statd.ExStatisticsList(stat);
		List<StatisticsList> StatisticsList = new ArrayList<StatisticsList>();
		int i = 0;
		int j = 0;
		while(true){
			if(inStatisticsList.size() == i && exStatisticsList.size() == j){				
				break;
			}else if(inStatisticsList.size() == i){
				for(int z=j; z < exStatisticsList.size(); z++){
					StatisticsList statList = new StatisticsList();
					stat.setMemNo(exStatisticsList.get(z).getMemNo());
					stat.setEmtNo(exStatisticsList.get(z).getEmtNo());
					statList.setEmtName(statd.StatisticsEmtNoChk(stat));
					statList.setExCon(exStatisticsList.get(z).getExCon());
					statList.setExSum(exStatisticsList.get(z).getExSum());
					statList.setExEtc(exStatisticsList.get(z).getExEtc());
					StatisticsList.add(statList);					
				}
				break;
			}else if(exStatisticsList.size() == j){
				for(int z=i; z < inStatisticsList.size(); z++){
					StatisticsList statList = new StatisticsList();
					stat.setMemNo(inStatisticsList.get(z).getMemNo());
					stat.setImtNo(inStatisticsList.get(z).getImtNo());					
					statList.setImtName(statd.StatisticsImtNoChk(stat));
					statList.setInCon(inStatisticsList.get(z).getInCon());
					statList.setInSum(inStatisticsList.get(z).getInSum());
					statList.setInEtc(inStatisticsList.get(z).getInEtc());
					StatisticsList.add(statList);					
				}
				break;
			}else{
				StatisticsList statList = new StatisticsList();
				stat.setEmtNo(exStatisticsList.get(j).getEmtNo());
				stat.setMemNo(exStatisticsList.get(j).getMemNo());			
				statList.setEmtName(statd.StatisticsEmtNoChk(stat));
				statList.setExCon(exStatisticsList.get(j).getExCon());
				statList.setExSum(exStatisticsList.get(j).getExSum());
				statList.setExEtc(exStatisticsList.get(j).getExEtc());
				stat.setImtNo(inStatisticsList.get(i).getImtNo());
				stat.setMemNo(inStatisticsList.get(i).getMemNo());
				statList.setImtName(statd.StatisticsImtNoChk(stat));
				statList.setInCon(inStatisticsList.get(i).getInCon());
				statList.setInSum(inStatisticsList.get(i).getInSum());
				statList.setInEtc(inStatisticsList.get(i).getInEtc());
				StatisticsList.add(statList);				
				i++;
				j++;
			}			
		}		
		return StatisticsList;
	}	
	
}
