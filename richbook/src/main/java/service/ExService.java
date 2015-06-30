package service;

import java.util.List;

import model.Ex;

public interface ExService {
	List<Ex> exList(Ex ex);
	void exInsert(Ex ex);
	void exDel(int Exno);
	

}
