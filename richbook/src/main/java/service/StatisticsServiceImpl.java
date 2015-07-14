package service;



import model.Statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StatisticsDao;

@Service
public class StatisticsServiceImpl implements StatisticsService{
	@Autowired
	StatisticsDao statd;
	public int StatisticsList(Statistics stat) {
		return statd.StatisticsList(stat);
	}
	public long StatisticsInYearSum(Statistics stat) {		
		return statd.StatisticsInYearSum(stat);
	}
	public long StatisticsExYearSum(Statistics stat) {		
		return statd.StatisticsExYearSum(stat);
	}

}
