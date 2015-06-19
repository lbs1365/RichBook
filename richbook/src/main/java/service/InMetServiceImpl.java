package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.InMetDao;
import model.InMet;
@Service
public class InMetServiceImpl implements InMetService{
	@Autowired
	InMetDao imd;
	public List<InMet> imtList() {		
		return imd.imtList();
	}

}
