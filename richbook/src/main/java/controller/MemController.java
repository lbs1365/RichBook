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
	public String memIn(Model model) {
		return "memIn";
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
}
