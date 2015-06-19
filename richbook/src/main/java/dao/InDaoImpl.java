package dao;

import java.util.List;

import model.In;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InDaoImpl implements InDao{
	@Autowired
	private SqlSession session;
	public List<In> inList (int memNo) {		
		return session.selectList("inList", memNo);	
	}	
	public void inUp(In in) {
		session.insert("inUp", in);
	}
}
