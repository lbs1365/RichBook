package controller;

import java.util.List;

import model.Ex;
import model.ExMet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CalService;
import service.ExMetService;
import service.ExService;

@Controller
public class ExController {
	@Autowired
	ExService exs;
	@Autowired
	ExMetService emts;
	@Autowired
	CalService cs;
	@RequestMapping(value="Ex")
	public String exList(Ex ex, Model model){
		ex.setMemNo(1);
		if(ex.getExListPrint()==null || ex.getExListPrint().equals("") || ex.getExListPrint().equals("All")){
			ex.setExListPrintCal("null");
		}else{
			ex.setExListPrintCal(cs.exListPrintCal(ex.getExListPrint()));
		}			
		List<Ex> exlist = exs.exList(ex);
		List<ExMet> emtlist = emts.emtList(ex.getMemNo());
		model.addAttribute("ex",ex);
		model.addAttribute("exlist",exlist);
		model.addAttribute("emtlist",emtlist);
		return "ex";		
	}
	@RequestMapping(value="ExInsert")
	public String exInsert(Ex ex, Model model){		
		ex.setMemNo(1);
		exs.exInsert(ex);
		return "redirect:Ex.do";
	}
	@RequestMapping(value="EmtUpList")
	public String emtUpList(Model model){		
		int memNo = 1;		
		List<ExMet> emtlist = emts.emtList(memNo);
		model.addAttribute("emtlist",emtlist);
		return "emtUpList";
	}
	@RequestMapping(value="EmtUp")
	public String emtUp(ExMet emt, Model model){		
		ExMet emtchk = new ExMet();
		emtchk = emts.emtChk(emt);
		if(emtchk ==null || emtchk.equals("")){ 
			emts.emtUp(emt);
			return "redirect:EmtUpList.do";
		}else{
			String msg = "사용 중인 항목입니다";
			model.addAttribute("msg",msg);
			return "forward:EmtUpList.do";			
		}		
	}
	@RequestMapping(value="ExDel")
	public String exDel(int exNo, Model model){		
		exs.exDel(exNo);
		return "redirect:Ex.do";
	}
	@RequestMapping(value="EmtDel")
	public String imtDel(int emtNo, Model model){		
		emts.emtDel(emtNo);
		return "forward:EmtUpList.do";
	}
}
