package service;



import javax.mail.internet.MimeMessage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service("MailServiceImpl")
public class MailServiceImpl implements MailService{
	private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public <T> boolean mailSe(T report) {
        logger.debug("Sending report by email...");
        boolean retVal = false;
        try {
            final String emailTo = "dkts7@naver.com";         
            final String subject = "test subject";
            final String message = (String) report;

            mailSender.send(new MimeMessagePreparator() {

                @Override
                public void prepare(MimeMessage paramMimeMessage) throws Exception {
                    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(paramMimeMessage, true, "UTF-8");

                    mimeMessageHelper.setTo(emailTo);                   
                    mimeMessageHelper.setSubject(subject);
                    mimeMessageHelper.setText(message);         
                };
            });

            retVal = true;
        } catch (Exception e) {
            logger.error("Can't send email... " + e.getMessage(), e);
        }
        return retVal;
    }
}
