package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemDao;
import model.Member;
@Service
public class MemServiceImpl implements MemService{
	@Autowired
	private MemDao md;
	public int insert(Member mem) {		
		return md.insert(mem);
	}

}
