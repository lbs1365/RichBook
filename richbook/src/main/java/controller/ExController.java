package controller;

import java.util.ArrayList;
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
			ex.setExYearMonth_year(0);
			ex.setExYearMonth_month(0);
		}else if(ex.getExListPrint().equals("YearMonth")){
			ex.setExListPrintCal("null");
			ex.setExYearMonth(ex.getExListPrint());
			int year = cs.exYearMonthListPrintCal(ex.getExListPrint());
			List<String> YearMonth_yearList = new ArrayList<String>();
			for(int i=year ; i>1000 ; i--){
				ex.setExYear(i);				
				int result = exs.exYearMonth_year(ex);				
				if(result != 0){
					if(ex.getExYearMonth_year()==0){
						ex.setExYearMonth_year(i);						
					}
					String yearList = i +"";
					YearMonth_yearList.add(yearList);
				}								
			}			
			model.addAttribute("year",YearMonth_yearList);			
			if(ex.getExYearMonth_year()!=0){				
				List<String> YearMonth_monthList = new ArrayList<String>();				
				for(int i=1;i<=12;i++){
					if(i<10){
						ex.setExMonth("0"+i);						
					}else{
						ex.setExMonth(i+"");
					}
					if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12){
						ex.setExDay("31");
					}else if(i==2){
						if(ex.getExYearMonth_year()%4!=0 || ex.getExYearMonth_year()%100==0 
								&& ex.getExYearMonth_year()%400!=0){
							ex.setExDay("28");							
						}else{
							ex.setExDay("29");
						}
					}else{
						ex.setExDay("30");
					}
					int result = exs.exYearMonth_month(ex);					
					if(result > 0){						
						ex.setExMonth(i+"");
						YearMonth_monthList.add(ex.getExMonth());
					}
				}
			}
			if(ex.getExYearMonth_month() != 0){
				int i = ex.getExYearMonth_month();
				if(i < 10){
					ex.setExMonth("0"+i);						
				}else{
					ex.setExMonth(i+"");
				}
				if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12){
					ex.setExDay("31");
				}else if(i==2){
					if(ex.getExYearMonth_year()%4!=0 || ex.getExYearMonth_year()%100==0 
							&& ex.getExYearMonth_year()%400!=0){
						ex.setExDay("28");							
					}else{
						ex.setExDay("29");
					}
				}else{
					ex.setExDay("30");
				}
			}
		}else{
			ex.setExListPrintCal(cs.exListPrintCal(ex.getExListPrint()));
		}
		if(ex.getExSearchCho()==null || ex.getExSearchCho().equals("")){
			ex.setExSearchCho(null);
		}else if(ex.getExSearchCho().equals("emtName")){
			ExMet emtchk = new ExMet();
			emtchk.setMemNo(1);
			emtchk.setEmtName(ex.getExSearch());
			emtchk = emts.emtChk(emtchk);
			ex.setExSearchChoNum(emtchk.getEmtNo());			
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
