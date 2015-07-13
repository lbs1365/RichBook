package controller;

import javax.annotation.Resource;

import model.MailChk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.MailServiceImpl;

@Controller
public class MailController {
	@Resource(name = "MailServiceImpl")
	private MailServiceImpl emailPublisherService;

	@RequestMapping(value = "IdEmailChk")
	public String sendMail(MailChk mc, Model model) throws Exception {		
		try {
			String mailAddr = mc.getId();				
			String mailCon = "<a href='http://211.183.2.70:8181/richbook/mailChk.do?mailChk="
				+mailAddr+"'>이메일 본인 확인</a>";
			emailPublisherService.mailSe(mailCon,mailAddr);
		    int addrcnt = mc.getId().indexOf("@");
		    String addr = mc.getId().substring(addrcnt,mc.getId().length());
		    model.addAttribute("addr", addr);
		    return "success";		
		} catch (Exception e) {
			throw e;
		}
	}
}
