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
			in.setInYearMonth_year(0);
			in.setInYearMonth_month(0);
		}else if(in.getInListPrint().equals("YearMonth")){
			in.setInListPrintCal("null");
			in.setInYearMonth(in.getInListPrint());
			int year = cs.inYearMonthListPrintCal(in.getInListPrint());
			List<String> YearMonth_yearList = new ArrayList<String>();
			for(int i=year ; i>1900 ; i--){
				in.setInYear(i);				
				int result = ins.inYearMonth_year(in);				
				if(result != 0){
					if(in.getInYearMonth_year()==0){
						in.setInYearMonth_year(i);						
					}
					String yearList = i +"";
					YearMonth_yearList.add(yearList);
				}								
			}			
			model.addAttribute("year",YearMonth_yearList);			
			if(in.getInYearMonth_year()!=0){				
				List<String> YearMonth_monthList = new ArrayList<String>();				
				for(int i=1;i<=12;i++){
					if(i<10){
						in.setInMonth("0"+i);						
					}else{
						in.setInMonth(i+"");
					}
					if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12){
						in.setInDay("31");
					}else if(i==2){
						if(in.getInYearMonth_year()%4!=0 || in.getInYearMonth_year()%100==0 
								&& in.getInYearMonth_year()%400!=0){
							in.setInDay("28");							
						}else{
							in.setInDay("29");
						}
					}else{
						in.setInDay("30");
					}
					int result = ins.inYearMonth_month(in);					
					if(result > 0){						
						in.setInMonth(i+"");
						YearMonth_monthList.add(in.getInMonth());
					}
				}
				model.addAttribute("month",YearMonth_monthList);				
			}
			if(in.getInYearMonth_month() != 0){
				int i = in.getInYearMonth_month();
				if(i < 10){
					in.setInMonth("0"+i);						
				}else{
					in.setInMonth(i+"");
				}
				if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12){
					in.setInDay("31");
				}else if(i==2){
					if(in.getInYearMonth_year()%4!=0 || in.getInYearMonth_year()%100==0 
							&& in.getInYearMonth_year()%400!=0){
						in.setInDay("28");							
					}else{
						in.setInDay("29");
					}
				}else{
					in.setInDay("30");
				}
			}
		}else{
			in.setInListPrintCal(cs.inListPrintCal(in.getInListPrint()));
		}
		if(in.getInSearchCho()==null || in.getInSearchCho().equals("")){
			in.setInSearchCho(null);
		}else if(in.getInSearchCho().equals("imtName")){
			InMet imtchk = new InMet();
			imtchk.setMemNo(1);
			imtchk.setImtName(in.getInSearch());
			imtchk = imts.imtChk(imtchk);
			if(imtchk == null){
				in.setInSearchChoNum(0);
			}else{
				in.setInSearchChoNum(imtchk.getImtNo());	
			}
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
