package dao;

import model.Statistics;


public interface StatisticsDao {
	int StatisticsList(Statistics stat);
	long StatisticsInYearSum(Statistics stat);
	long StatisticsExYearSum(Statistics stat);
	
}
