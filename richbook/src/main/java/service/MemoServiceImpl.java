package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemoDao;
import model.Memo;
@Service
public class MemoServiceImpl implements MemoService{
	@Autowired
	MemoDao Memod;
	public List<Memo> MemoList() {
		return Memod.MemoList();
	}

	public void MemoInsert(Memo memo) {
		Memod.MemoInsert(memo);
	}

	public void MemoDel(int MemoNo) {
		Memod.MemoDel(MemoNo);
	}

}
