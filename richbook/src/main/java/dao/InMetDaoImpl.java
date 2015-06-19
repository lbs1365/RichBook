package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.InMet;
@Repository
public class InMetDaoImpl implements InMetDao{
	@Autowired
	SqlSession session;
	public List<InMet> imtList() {
		return session.selectList("InMetList");
	}

}
