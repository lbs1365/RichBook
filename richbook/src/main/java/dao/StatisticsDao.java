package dao;

import java.util.List;

import model.Statistics;


public interface StatisticsDao {
	List<Statistics> InStatisticsYearList(Statistics stat);
	List<Statistics> ExStatisticsYearList(Statistics stat);
	
	long StatisticsInYearSum(Statistics stat);
	long StatisticsExYearSum(Statistics stat);
	
	int InStatisticsMonth(Statistics stat);
	int ExStatisticsMonth(Statistics stat);
	
	long StatisticsInMonthSum(Statistics stat);
	long StatisticsExMonthSum(Statistics stat);
}
