package controller;

import java.util.ArrayList;
import java.util.List;

import model.In;
import model.InMet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CalService;
import service.InMetService;
import service.InService;

@Controller
public class InContoller {	
	@Autowired
	InService ins;
	@Autowired
	InMetService imts;
	@Autowired
	CalService cs;
	@RequestMapping(value="In")
	public String inList(In in, Model model){
		in.setMemNo(1);
		if(in.getInListPrint()==null || in.getInListPrint().equals("") || in.getInListPrint().equals("All")){
			in.setInListPrintCal("null");
		}else if(in.getInListPrint().equals("YearMonth")){
			in.setInListPrintCal("null");
			in.setInYearMonth(in.getInListPrint());
			if(in.getInYearMonth_year()!=0){				
				List<String> YearMonth_monthList = new ArrayList<String>();
				YearMonth_monthList.add("달 선택");
				for(int i=1;i<=12;i++){
					in.setInMonth(i);
					int result = ins.inYearMonth_month(in);
					if(result > 0){
						String monthList = i +"";
						YearMonth_monthList.add(monthList);
					}
				}
				model.addAttribute("month",YearMonth_monthList);
			}else{				
				int year = cs.inYearMonthListPrintCal(in.getInListPrint());
				List<String> YearMonth_yearList = new ArrayList<String>();
				while(true){
					in.setInYear(year);				
					int result = ins.inYearMonth_year(in);				
					if(result == 0)break;
					String yearList = year +"";
					YearMonth_yearList.add(yearList);
					year --;					
				}
				model.addAttribute("year",YearMonth_yearList);				
			}			
		}else{
			in.setInListPrintCal(cs.inListPrintCal(in.getInListPrint()));
		}			
		List<In> inlist = ins.inList(in);
		List<InMet> imtlist = imts.imtList(in.getMemNo());
		model.addAttribute("in",in);
		model.addAttribute("inlist",inlist);
		model.addAttribute("imtlist",imtlist);
		return "in";		
	}
	@RequestMapping(value="InInsert")
	public String inInsert(In in, Model model){		
		in.setMemNo(1);
		ins.inInsert(in);
		return "redirect:In.do";
	}
	@RequestMapping(value="ImtUpList")
	public String imtUpList(Model model){		
		int memNo = 1;		
		List<InMet> imtlist = imts.imtList(memNo);
		model.addAttribute("imtlist",imtlist);
		return "imtUpList";
	}
	@RequestMapping(value="ImtUp")
	public String imtUp(InMet imt, Model model){		
		InMet imtchk = new InMet();
		imtchk = imts.imtChk(imt);
		if(imtchk ==null || imtchk.equals("")){ 
			imts.imtUp(imt);
			return "redirect:ImtUpList.do";
		}else{
			String msg = "사용 중인 항목입니다";
			model.addAttribute("msg",msg);
			return "forward:ImtUpList.do";			
		}		
	}
	@RequestMapping(value="InDel")
	public String inDel(int inNo, Model model){		
		ins.inDel(inNo);
		return "redirect:In.do";
	}
	@RequestMapping(value="ImtDel")
	public String imtDel(int imtNo, Model model){		
		imts.imtDel(imtNo);
		return "forward:ImtUpList.do";
	}
}
