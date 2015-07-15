package dao;

import model.Statistics;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticsDaoImpl implements StatisticsDao{
	@Autowired
	private SqlSession session;
	public int StatisticsList(Statistics stat) {
		int StatisticsYear = 0;
		int InStatisticsYear = session.selectOne("InStatisticsYear",stat);
		int ExStatisticsYear = session.selectOne("ExStatisticsYear",stat);
		if(InStatisticsYear != 0 && ExStatisticsYear != 0){
			StatisticsYear = 3;
		}else if(ExStatisticsYear != 0 ){
			StatisticsYear = 2;
		}else if(InStatisticsYear != 0 ){
			StatisticsYear = 1;
		}
		return StatisticsYear;
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
