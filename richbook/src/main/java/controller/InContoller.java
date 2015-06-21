package controller;

import java.util.List;

import model.In;
import model.InMet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.InMetService;
import service.InService;

@Controller
public class InContoller {
	@Autowired
	InService ins;
	@Autowired
	InMetService imts;
	@RequestMapping(value="In")
	public String inList(Model model){
		int memNo = 1;
		List<In> inlist = ins.inList(memNo);
		List<InMet> imtlist = imts.imtList();		
		model.addAttribute("inlist",inlist);
		model.addAttribute("imtlist",imtlist);
		return "in";		
	}
	@RequestMapping(value="InUp")
	public String inUp(In in, Model model){		
		in.setMemNo(1);
		ins.inUp(in);
		return "redirect:In.do";
	}
}
