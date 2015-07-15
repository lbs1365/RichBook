package service;

import model.Statistics;

public interface StatisticsService {
	int StatisticsList(Statistics stat);
	
	long StatisticsInYearSum(Statistics stat);
	long StatisticsExYearSum(Statistics stat);
	
	int InStatisticsMonth(Statistics stat);
	int ExStatisticsMonth(Statistics stat);
	
	long StatisticsInMonthSum(Statistics stat);
	long StatisticsExMonthSum(Statistics stat);
}
