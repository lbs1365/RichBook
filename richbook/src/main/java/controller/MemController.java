package controller;


import model.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.MemService;

@Controller
public class MemController {
	@Autowired
	private MemService ms;
	@RequestMapping(value="memIn")	
	public String memIn(String mailChk, Model model) {
		if(mailChk.equals("noChk")){
			model.addAttribute("idChk","null");		
		}
		return "memIn";
	}
	@RequestMapping(value="mailChk")	
	public String mailChk(String mailChk, Model model) {
		Member mem = ms.login(mailChk);
		if(mem ==null || mem.equals("")){
			model.addAttribute("idChk","인증완료");
			model.addAttribute("id",mailChk);			
			return "forward:memIn.do";
		}else{
			model.addAttribute("msg","잘못된 접근입니다");
			model.addAttribute("idChk","null");	
			return "memIn";
		}
	}
	@RequestMapping(value="loginform")	
	public String memloginform(Model model) {
		return "login";
	}
	@RequestMapping(value="memInsert")
	public String insertMember(Member mem, Model model) {		
		int result = ms.insert(mem);
		if (result > 0) return "main";
		else {
			model.addAttribute("msg","입력 실패 확인해 보세요");
			return "forward:memIn.do";
		}
	}
	@RequestMapping(value="login")
	public String login(String id, String pw, Model model){
		Member mem = ms.login(id);
		if(mem ==null || mem.equals("")){ 
			model.addAttribute("msg","아디틀림 ㅋ");
			return "login";
		}else if (pw.equals(mem.getPw())){
			return "logmain";
		}
		else {
			model.addAttribute("msg","비번틀림 ㅋ");
			//return "forward:loginform.do";
			return "login";
		}
	}
	
}
