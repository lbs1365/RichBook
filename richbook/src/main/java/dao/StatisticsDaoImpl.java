package dao;

import java.util.List;

import model.Statistics;
import model.StatisticsList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticsDaoImpl implements StatisticsDao{
	@Autowired
	private SqlSession session;
	public List<Statistics> InStatisticsYearList(Statistics stat){			
		return session.selectList("InStatisticsYear",stat);
	}
	public List<Statistics> ExStatisticsYearList(Statistics stat){		
		return session.selectList("ExStatisticsYear",stat);
	}	
	public long StatisticsInYearSum(Statistics stat) {		
		return session.selectOne("InStatisticsYearSum",stat);
	}
	public long StatisticsExYearSum(Statistics stat) {
		return session.selectOne("ExStatisticsYearSum",stat);
	}
	public List<Statistics> InStatisticsMonthList(Statistics stat) {		
		return session.selectList("InStatisticsMonth",stat);
	}
	public List<Statistics> ExStatisticsMonhtList(Statistics stat) {	
		return session.selectList("ExStatisticsMonth",stat);
	}
	public long StatisticsInMonthSum(Statistics stat) {
		return session.selectOne("InStatisticsMonthSum",stat);
	}
	public long StatisticsExMonthSum(Statistics stat) {
		return session.selectOne("ExStatisticsMonthSum",stat);
	}
	public List<Statistics> InStatisticsDayList(Statistics stat) {		
		return session.selectList("InStatisticsDay",stat);
	}
	public List<Statistics> ExStatisticsDayList(Statistics stat) {		
		return session.selectList("ExStatisticsDay",stat);
	}
	public long StatisticsInDaySum(Statistics stat) {		
		return session.selectOne("InStatisticsDaySum",stat);
	}
	public long StatisticsExDaySum(Statistics stat) {
		return session.selectOne("ExStatisticsDaySum",stat);
	}
	public List<Statistics> InStatisticsList(Statistics stat) {		
		return session.selectList("InStatisticsList",stat);
	}
	public List<Statistics> ExStatisticsList(Statistics stat) {	
		return session.selectList("ExStatisticsList",stat);
	}
	public String StatisticsImtNoChk(Statistics stat) {		
		return session.selectOne("StatisticsImtNoChk",stat);
	}
	public String StatisticsEmtNoChk(Statistics stat) {	
		return session.selectOne("StatisticsEmtNoChk",stat);
	}
	
}
