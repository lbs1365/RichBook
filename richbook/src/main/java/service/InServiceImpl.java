package service;

import java.util.List;

import model.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.InDao;

@Service
public class InServiceImpl implements InService{
	@Autowired
	InDao ind;
	public List<In> inList(int memNo) {		
		return ind.inList(memNo);
	}
	public void inUp(In in) {
		ind.inUp(in);
	}
}
