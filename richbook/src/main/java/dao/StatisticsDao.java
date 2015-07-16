package dao;

import java.util.List;

import model.Statistics;
import model.StatisticsList;


public interface StatisticsDao {
	List<Statistics> InStatisticsYearList(Statistics stat);
	List<Statistics> ExStatisticsYearList(Statistics stat);
	
	long StatisticsInYearSum(Statistics stat);
	long StatisticsExYearSum(Statistics stat);
	
	List<Statistics> InStatisticsMonthList(Statistics stat);
	List<Statistics> ExStatisticsMonhtList(Statistics stat);
	
	long StatisticsInMonthSum(Statistics stat);
	long StatisticsExMonthSum(Statistics stat);
	
	List<Statistics> InStatisticsDayList(Statistics stat);
	List<Statistics> ExStatisticsDayList(Statistics stat);
	
	long StatisticsInDaySum(Statistics stat);
	long StatisticsExDaySum(Statistics stat);
	
	List<Statistics> InStatisticsList(Statistics stat);
	List<Statistics> ExStatisticsList(Statistics stat);
	
	String StatisticsImtNoChk(Statistics stat);
	String StatisticsEmtNoChk(Statistics stat);
}
