package dao;

import java.util.List;

import model.Memo;

public interface MemoDao {
	List<Memo> MemoList();
	void MemoInsert(Memo memo);
	void MemoDel(int MemoNo);
}
