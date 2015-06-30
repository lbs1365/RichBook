package controller;

import java.util.ArrayList;
import java.util.List;

import model.Ex;
import model.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;





import service.CalService;
import service.ExMetService;
import service.ExService;
import service.InMetService;
import service.InService;

@Controller
public class ChartController {
	@Autowired
	InService ins;
	@Autowired
	CalService cs;
	@Autowired
	ExService exs;
	
	@RequestMapping(value="Chart")
	public String ChartIn(In in,Ex ex, Model model){
		in.setMemNo(1);
		String indate=null;
		int insal=0;
		if(in.getInListPrint()==null || in.getInListPrint().equals("") || in.getInListPrint().equals("All")){
			in.setInListPrintCal("null");
		}else{
			in.setInListPrintCal(cs.inListPrintCal(in.getInListPrint()));
		}
		List<String> indatelist = new ArrayList<String>();
		List<Integer> insallist = new ArrayList<Integer>();
		List<In> inlist = ins.inList(in);
		for(int i=0;i<inlist.size();i++){
			indate = inlist.get(i).getInDate().substring(2,10);
			//System.out.println("하하"+inlist.get(i).getInDate().substring(2,7));
			indatelist.add(indate);
		}
		for(int i=0;i<inlist.size();i++){
			insal = (int)inlist.get(i).getInSum();
			insallist.add(insal);
		}
		model.addAttribute("inlist",inlist);
		model.addAttribute("indate",indatelist);
		model.addAttribute("insal",insallist);
		//---------------------------------------------
		ex.setMemNo(1);
		String exdate = null;
		if(ex.getExListPrint()==null || ex.getExListPrint().equals("") || ex.getExListPrint().equals("All")){
			ex.setExListPrintCal("null");
		}else{
			ex.setExListPrintCal(cs.exListPrintCal(ex.getExListPrint()));
		}			
		List<String> exdatelist = new ArrayList<String>();
		List<Ex> exlist = exs.exList(ex);
		for(int i=0;i<exlist.size();i++){
			exdate = exlist.get(i).getExDate().substring(2,10);
//			System.out.println("하하"+exlist.get(i).getExDate().substring(2,7));
			exdatelist.add(exdate);
		}
		model.addAttribute("exlist",exlist);
		model.addAttribute("exdate",exdatelist);
		return "chart_";
	}
	
}
