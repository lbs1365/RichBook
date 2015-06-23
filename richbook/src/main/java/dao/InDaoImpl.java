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
	public List<In> inList (In in) {		
		return session.selectList("InList", in);	
	}	
	public void inInsert(In in) {
		session.insert("InInsert", in);
	}
	public void inDel(int inNo) {
		session.delete("InDel", inNo);
	}
}
