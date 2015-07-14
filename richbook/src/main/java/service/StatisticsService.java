package service;

import model.Statistics;

public interface StatisticsService {
	int StatisticsList(Statistics stat);
	long StatisticsInYearSum(Statistics stat);
	long StatisticsExYearSum(Statistics stat);
}
