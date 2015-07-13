package service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StatisticsDao;

@Service
public class StatisticsServiceImpl implements StatisticsService{
	@Autowired
	StatisticsDao statd;
	public int StatisticsList(int StatisticsYear) {
		return statd.StatisticsList(StatisticsYear);
	}

}
