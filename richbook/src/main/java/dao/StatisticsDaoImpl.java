package dao;

import java.util.List;

import model.Statistics;

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
		return session.selectOne("StatisticsInYearSum",stat);
	}
	public long StatisticsExYearSum(Statistics stat) {
		return session.selectOne("StatisticsExYearSum",stat);
	}
	public int InStatisticsMonth(Statistics stat) {
		return session.selectOne("InStatisticsMonth",stat);
	}
	public int ExStatisticsMonth(Statistics stat) {
		return session.selectOne("ExStatisticsMonth",stat);
	}
	public long StatisticsInMonthSum(Statistics stat) {
		return session.selectOne("InStatisticsMonthSum",stat);
	}
	public long StatisticsExMonthSum(Statistics stat) {
		return session.selectOne("ExStatisticsMonthSum",stat);
	}

}
