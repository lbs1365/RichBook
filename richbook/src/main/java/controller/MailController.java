package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MailServiceImpl;

@Controller
public class MailController {
	@Resource(name = "MailServiceImpl")
	private MailServiceImpl emailPublisherService;

	@RequestMapping(value = "send")
	public @ResponseBody String send() throws Exception {
		try {
			emailPublisherService.mailSe("테스트 입니다.");
			return "success";
		} catch (Exception e) {
			throw e;
		}
	}
}
