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
	public List<In> inList(In in) {		
		return ind.inList(in);
	}
	public void inInsert(In in) {
		ind.inInsert(in);
	}
	public void inDel(int inNo) {
		ind.inDel(inNo);
	}
}
