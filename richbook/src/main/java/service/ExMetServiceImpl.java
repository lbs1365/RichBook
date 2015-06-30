package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ExMetDao;
import model.ExMet;
@Service
public class ExMetServiceImpl implements ExMetService{
	
	@Autowired
	ExMetDao exd;
	
	public List<ExMet> emtList(int memNo) {
		
		return exd.emtList(memNo);
	}

	
	public int emtUp(ExMet emt) {
		
		return exd.emtUp(emt);
	}

	
	public ExMet emtChk(ExMet emt) {
		
		return exd.emtChk(emt);
	}

	
	public void emtDel(int emtNo) {
		exd.emtDel(emtNo);
		
	}
}

	