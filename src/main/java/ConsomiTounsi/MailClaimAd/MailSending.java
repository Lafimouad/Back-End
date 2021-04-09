package ConsomiTounsi.MailClaimAd;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service
public class MailSending {
	 @Autowired
	    private JavaMailSender mailSender;

	    public MailSending(JavaMailSender mailSender) {
	        this.mailSender = mailSender;
	    }

	    public void sendEmail(String to , String body , String subject ) {
	        try {
	        MimeMessage mimeMessage = mailSender.createMimeMessage();
	        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "utf-8");
	                message.setFrom("tn.consomi.tounsi@gmail.com");
	                message.setTo(to);
	                message.setText(body, true);
	                message.setSubject(subject);
	        mailSender.send(mimeMessage);
	    } catch (MessagingException e) {
	        throw new IllegalStateException("failed to send email");
	    }
	}
	}



