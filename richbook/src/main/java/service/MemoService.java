package service;

import java.util.List;

import model.Memo;

public interface MemoService {
	List<Memo> MemoList();
	void MemoInsert(Memo memo);
	void MemoDel(int MemoNo);
}
