package service;

import java.util.List;

import model.Statistics;

public interface StatisticsService {
	List<Integer> StatisticsYearList(Statistics stat);
	
	long StatisticsInYearSum(Statistics stat);
	long StatisticsExYearSum(Statistics stat);

	List<Integer> StatisticsMonthList(Statistics stat);
	
	long StatisticsInMonthSum(Statistics stat);
	long StatisticsExMonthSum(Statistics stat);	
	
	List<Integer> StatisticsDayList(Statistics stat);
}
