package dao;

import java.util.List;

import model.In;

public interface InDao {
	List<In> inList (int memNo);
	void inUp (In in);
}
