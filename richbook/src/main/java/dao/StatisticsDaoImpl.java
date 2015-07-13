package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticsDaoImpl implements StatisticsDao{
	@Autowired
	private SqlSession session;
	public int StatisticsList(int StatisticsYear) {
		return session.selectOne("StatisticsYear",StatisticsYear);
	}

}
