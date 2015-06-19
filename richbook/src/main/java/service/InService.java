package service;

import java.util.List;

import model.In;

public interface InService {
	List<In> inList(int memNo);
	void inUp(In in);
}
