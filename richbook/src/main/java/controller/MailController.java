package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

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
			int mailChk = (int)(Math.random()*100000);			
			if(mailChk!=0){
				String mailCon = "<a href='http://211.183.2.70:8181/richbook/mailChk.do?mailChk="
					+mailChk+"'>이메일 본인 확인</a>";
				String mailAddr = mc.getId();
				
				FileOutputStream fos = new FileOutputStream(mailAddr);
				
				fos.write(mailAddr.length());
				
				fos.flush();
				fos.close();
				emailPublisherService.mailSe(mailCon,mailAddr);
		    	int addrcnt = mc.getId().indexOf("@");
		    	String addr = mc.getId().substring(addrcnt,mc.getId().length());
		    	model.addAttribute("addr", addr);
		    }else{
		    	return "redirect:memIn.do?mailChk=noChk";
		    }
			return "success";
		} catch (Exception e) {
			throw e;
		}
	}
}
